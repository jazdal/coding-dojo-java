package com.sternritter.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sternritter.mvc.models.Book;
import com.sternritter.mvc.services.BookService;

import jakarta.validation.Valid;

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
	public String newBook(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	
	@PostMapping("/books/new")
	public String createBook(
			@Valid @ModelAttribute("book") Book book, 
			BindingResult result
			) {
		
		if (result.hasErrors()) {
			return "new.jsp";
		}
		bookService.createBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/books/{id}/edit")
	public String edit(
			@PathVariable("id") Long id, 
			Model model
			) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	
	@PutMapping("/books/{id}")
	public String update(
			@Valid @ModelAttribute("book") Book book, 
			BindingResult result, 
			Model model
			) {
		if (result.hasErrors()) {
			model.addAttribute("book", book);
			return "edit.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/books";
		}
	}
}
