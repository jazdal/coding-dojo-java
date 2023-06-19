package com.sternritter.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sternritter.mvc.models.Book;
import com.sternritter.mvc.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;
	
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}
	
	@PostMapping("/api/books")
	public Book create(
			@RequestParam(value="title") String title, 
			@RequestParam(value="description") String description, 
			@RequestParam(value="language") String language, 
			@RequestParam(value="numberOfPages") Integer numberOfPages
			) {
		Book book = new Book(title, description, language, numberOfPages);
		return bookService.createBook(book);
	}
	
	@GetMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	
	@PutMapping("/api/books/{id}")
	public Book update(
			@PathVariable("id") Long id, 
			@RequestParam(value="title") String title, 
			@RequestParam(value="description") String description, 
			@RequestParam(value="language") String language, 
			@RequestParam(value="numberOfPages") Integer numberOfPages
			) {
		Book book = new Book(title, description, language, numberOfPages);
		book.setId(id);
		return bookService.updateBook(book);
	}
	
	@DeleteMapping("/api/books/{id}")
	public void destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
}
