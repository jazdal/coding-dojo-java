package com.sternritter.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sternritter.mvc.models.Book;
import com.sternritter.mvc.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String reroute() {
		return "redirect:/books";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String showBook(
			Model model, 
			@PathVariable("id") Long id
			) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
	@GetMapping("/books/new")
	public String showForm() {
		return "new.jsp";
	}
	
	@PostMapping("/books/new")
	public String newBook(
			@RequestParam("title") String title, 
			@RequestParam("description") String description, 
			@RequestParam("language") String language, 
			@RequestParam("numberOfPages") Integer numberOfPages
			) {
		Book book = new Book(title, description, language, numberOfPages);
		bookService.createBook(book);
		return "redirect:/books";
	}
}
