package com.sternritter.bookbroker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.bookbroker.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	// Gets all books from the database:
	List<Book> findAll();
	
	// Retrieves all books belonging to a user:
	List<Book> findByUserIdIs(Long userId);
	
	// Retrieves all books borrowed by a user:
	List<Book> findByBorrowerIdIs(Long borrowerId);
}
