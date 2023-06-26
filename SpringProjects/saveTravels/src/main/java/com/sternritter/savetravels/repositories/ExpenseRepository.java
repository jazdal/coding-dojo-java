package com.sternritter.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.savetravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	// This method retrieves all the expenses from the database:
	List<Expense> findAll();
}
