package com.sternritter.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.bookclub.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	// Gets all users from the database:
	List<User> findAll();
	
	// Finds a user in the database via email:
	Optional<User> findByEmail(String email);
}
