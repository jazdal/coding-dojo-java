package com.sternritter.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.bookclub.models.BookList;

public interface BookRepository extends CrudRepository<BookList, Long> {
	// Gets all books from the database:
	List<BookList> findAll();
	
	// Retrieves all books belonging to a user:
	List<BookList> findByUserIdIs(Long userId);
}
