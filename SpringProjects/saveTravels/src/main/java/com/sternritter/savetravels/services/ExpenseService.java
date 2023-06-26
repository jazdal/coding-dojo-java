package com.sternritter.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sternritter.savetravels.models.Expense;
import com.sternritter.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	// Adds the ExpenseRepository as a dependency:
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	// Returns all the expenses (READ):
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	// Creates an expense (CREATE):
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	// Retrieves an expense (READ):
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	// Updates an expense (UPDATE):
	public Expense updateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	// Deletes an expense (DELETE):
	public void deleteExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			expenseRepository.deleteById(id);
		}
	}
}
