package com.sternritter.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sternritter.bookclub.models.BookList;
import com.sternritter.bookclub.repositories.BookRepository;

@Service
public class BookService {
	// Adds the BookRepository as a dependency:
	@Autowired
	private BookRepository bookRepo;
	
	// Returns all the books (READ):
	public List<BookList> getAll() {
		return bookRepo.findAll();
	}
	
	// Creates a new book (CREATE):
	public BookList create(BookList book) {
		return bookRepo.save(book);
	}
	
	// Retrieves a book (READ):
	public BookList findBook(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	// Retrieves all books belonging to a certain user (READ):
	public List<BookList> findUsersBooks(Long userId) {
		return bookRepo.findByUserIdIs(userId);
	}
	
	// Updates an existing book (UPDATE):
	public BookList update(BookList book) {
		return bookRepo.save(book);
	}
	
	// Deletes a book (DELETE):
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
