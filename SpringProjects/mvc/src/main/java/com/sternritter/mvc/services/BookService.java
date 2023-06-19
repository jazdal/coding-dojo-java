package com.sternritter.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sternritter.mvc.models.Book;
import com.sternritter.mvc.repositories.BookRepository;

@Service
public class BookService {
	// Adds the BookRepository as a dependency:
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// Returns all the books (READ):
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	// Creates a book (CREATE):
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	// Retrieves a book (READ):
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	// Updates a book (UPDATE):
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	// Deletes a book (DELETE):
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			bookRepository.deleteById(id);
		}
	}
}
