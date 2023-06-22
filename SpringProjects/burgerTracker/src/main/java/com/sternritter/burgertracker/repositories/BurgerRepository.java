package com.sternritter.burgertracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.burgertracker.models.Burger;

public interface BurgerRepository extends CrudRepository<Burger, Long> {
	// This method retrieves all the burgers from the database:
	List<Burger> findAll();
}
