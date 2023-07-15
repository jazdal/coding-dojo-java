package com.sternritter.bookbroker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sternritter.bookbroker.models.Book;
import com.sternritter.bookbroker.repositories.BookRepository;

@Service
public class BookService {
	// Adds the BookRepository as a dependency:
	@Autowired
	private BookRepository bookRepo;
	
	// Returns all the books (READ):
	public List<Book> getAll() {
		return bookRepo.findAll();
	}
	
	// Creates a new book (CREATE):
	public Book create(Book book) {
		return bookRepo.save(book);
	}
	
	// Retrieves a book (READ):
	public Book findBook(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	// Retrieves all books owned by a certain user (READ);
	public List<Book> getAllOwnedBooks(Long userId) {
		return bookRepo.findByUserIdIs(userId);
	}
	
	// Retrieves all books borrowed by a certain user (READ):
	public List<Book> getAllBorrowedBooks(Long borrowerId) {
		return bookRepo.findByBorrowerIdIs(borrowerId);
	}
	
	// Updates an existing user (UPDATE):
	public Book update(Book book) {
		return bookRepo.save(book);
	}
	
	// Deletes a book (DELETE):
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
