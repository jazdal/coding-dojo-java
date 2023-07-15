package com.sternritter.bookbroker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sternritter.bookbroker.models.Book;
import com.sternritter.bookbroker.models.LoginUser;
import com.sternritter.bookbroker.models.User;
import com.sternritter.bookbroker.services.BookService;
import com.sternritter.bookbroker.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	// Sets up automatic dependency injection for all the services:
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	// REGISTRATION & LOGIN PAGE:
	@GetMapping("/")
	public String index(
			Model model, 
			HttpSession session
			) {
		/* Bind empty User and LoginUser objects to the JSP 
		 * to capture the form input */
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		
		if (!(session.getAttribute("success") == null)) {
			model.addAttribute("success", session.getAttribute("success"));
		}
		if (!(session.getAttribute("unauthorized") == null)) {
			model.addAttribute("unauthorized", session.getAttribute("unauthorized"));
		}
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("user") User user, 
			BindingResult result, 
			Model model, 
			HttpSession session
			) {
		session.setAttribute("unauthorized", null);
		userService.register(user, result);
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			session.setAttribute("success", null);
			return "index.jsp";
		}
		session.setAttribute("success", "Registration successful!");
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("loginUser") LoginUser user, 
			BindingResult result, 
			Model model, 
			HttpSession session
			) {
		userService.login(user, result);
		if (result.hasErrors()) {
			session.setAttribute("success", null);
			session.setAttribute("unauthorized", null);
			model.addAttribute("user", new User());
			return "index.jsp";
		}
		User loginUser = userService.login(user, result);
		session.setAttribute("userId", loginUser.getId());
		return "redirect:/bookmarket";
	}
	
	// LANDING PAGE
	@GetMapping("/bookmarket")
	public String dashboard(
			Model model, 
			HttpSession session
			) {
		// Attempt to get the user ID from session:
		Long userId = (Long) session.getAttribute("userId");
		
		/* If there is no user ID stored in session (null), redirect 
		 * the unauthorized user back to the index page */
		if (userId == null) {
			session.setAttribute("unauthorized", "You are not authorized to access that page!");
			return "redirect:/";
		}
		
		// Attempt to get the user from the database by user ID:
		User currentUser = userService.findUser(userId);
		
		/* If user doesn't exist in the database (null), redirect 
		 * the user back to the index page */
		if (currentUser == null) {
			return "redirect:/";
		}
		
		// If user passes all checks:
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("books", bookService.getAll());
		return "dashboard.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/books/borrow/{bookId}")
	public String borrowBook(
			@PathVariable("bookId") Long id, 
			HttpSession session
			) {
		// Attempt to get the user ID from session:
		Long userId = (Long) session.getAttribute("userId");
		
		/* If there is no user ID stored in session (null), redirect 
		 * the unauthorized user back to the index page */
		if (userId == null) {
			session.setAttribute("unauthorized", "You are not authorized to access that page!");
			return "redirect:/";
		}
		
		// Attempt to get the user from the database by user ID:
		User currentUser = userService.findUser(userId);
		
		/* If user doesn't exist in the database (null), redirect 
		 * the user back to the index page */
		if (currentUser == null) {
			return "redirect:/";
		}
		
		// If user passes all checks:
		Book borrowedBook = bookService.findBook(id);
		borrowedBook.setBorrower(userService.findUser((Long) session.getAttribute("userId")));
		bookService.update(borrowedBook);
		return "redirect:/bookmarket";
	}
	
	@GetMapping("/return/books/{bookId}")
	public String returnBook(
			@PathVariable("bookId") Long bookId, 
			HttpSession session
			) {
		// Attempt to get the user ID from session:
		Long userId = (Long) session.getAttribute("userId");
		
		/* If there is no user ID stored in session (null), redirect 
		 * the unauthorized user back to the index page */
		if (userId == null) {
			session.setAttribute("unauthorized", "You are not authorized to access that page!");
			return "redirect:/";
		}
		
		// Attempt to get the user from the database by user ID:
		User currentUser = userService.findUser(userId);
		
		/* If user doesn't exist in the database (null), redirect 
		 * the user back to the index page */
		if (currentUser == null) {
			return "redirect:/";
		}
		
		// If user passes all checks:
		Book borrowedBook = bookService.findBook(bookId);
		borrowedBook.setBorrower(null);
		bookService.update(borrowedBook);
		return "redirect:/bookmarket";		
	}
	
	// CREATE PAGE
	@GetMapping("/books/new")
	public String addBookForm(
			@ModelAttribute("book") Book book, 
			HttpSession session, 
			Model model
			) {
		// Attempt to get the user ID from session:
		Long userId = (Long) session.getAttribute("userId");

		/* If there is no user ID stored in session (null), redirect 
		 * the unauthorized user back to the index page */
		if (userId == null) {
			session.setAttribute("unauthorized", "You are not authorized to access that page!");
			return "redirect:/";
		}
		
		// Attempt to get the user from the database by user ID:
		User currentUser = userService.findUser(userId);
		
		/* If user doesn't exist in the database (null), redirect 
		 * the user back to the index page */
		if (currentUser == null) {
			return "redirect:/";

		}
		model.addAttribute("currentUser", currentUser);
		return "newbook.jsp";
	}
	
	@PostMapping("/books/new")
	public String addBook(
			@Valid @ModelAttribute("book") Book book, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "newbook.jsp";
		}
		bookService.create(book);
		return "redirect:/bookmarket";
	}
	
	// SHOW PAGE
	@GetMapping("/books/{bookId}")
	public String showBook(
			@PathVariable("bookId") Long bookId, 
			Model model, 
			HttpSession session
			) {
		// Attempt to get the user ID from session:
		Long userId = (Long) session.getAttribute("userId");

		/* If there is no user ID stored in session (null), redirect 
		 * the unauthorized user back to the index page */
		if (userId == null) {
			session.setAttribute("unauthorized", "You are not authorized to access that page!");
			return "redirect:/";
		}
		
		// Attempt to get the user from the database by user ID:
		User currentUser = userService.findUser(userId);
		
		/* If user doesn't exist in the database (null), redirect 
		 * the user back to the index page */
		if (currentUser == null) {
			return "redirect:/";

		}
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("book", bookService.findBook(bookId));
		return "showbook.jsp";
	}
	
	// EDIT PAGE
	@GetMapping("/books/{bookId}/edit")
	public String editBookForm(
			@PathVariable("bookId") Long bookId, 
			Model model, 
			@ModelAttribute("book") Book book, 
			HttpSession session
			) {
		// Attempt to get the user ID from session:
		Long userId = (Long) session.getAttribute("userId");

		/* If there is no user ID stored in session (null), redirect 
		 * the unauthorized user back to the index page */
		if (userId == null) {
			session.setAttribute("unauthorized", "You are not authorized to access that page!");
			return "redirect:/";
		}
		
		// Attempt to get the user from the database by user ID:
		User currentUser = userService.findUser(userId);
		
		/* If user doesn't exist in the database (null), redirect 
		 * the user back to the index page */
		if (currentUser == null) {
			return "redirect:/";

		}
		model.addAttribute("book", bookService.findBook(bookId));
		return "editbook.jsp";
	}
	
	@PutMapping("/books/{bookId}/edit")
	public String editBook(
			@PathVariable("bookId") Long bookId, 
			@Valid @ModelAttribute("book") Book updatedBook, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "editbook.jsp";
		}
		// Load the existing book from the database:
		Book existingBook = bookService.findBook(bookId);
		
		// Update the fields of the existing book with the values from the updated book:
		existingBook.setTitle(updatedBook.getTitle());
		existingBook.setAuthor(updatedBook.getAuthor());
		existingBook.setThoughts(updatedBook.getThoughts());
		
		// Save the updated book:
		bookService.update(existingBook);
		return "redirect:/books/" + existingBook.getId();
	}
	
	// DELETE BOOK
	@GetMapping("/books/delete/{bookId}")
	public String deleteBook(
			@PathVariable("bookId") Long id
			) {
		bookService.deleteBook(id);
		return "redirect:/bookmarket";
	}
}
