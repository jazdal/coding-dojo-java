package com.sternritter.savetravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sternritter.savetravels.models.Expense;
import com.sternritter.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/")
	public String reroute() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String index(
			Model model,
			@ModelAttribute("expense") Expense expense
			) {
		model.addAttribute("expenses", expenseService.allExpenses());
		return "index.jsp";
	}
	
	@PostMapping("/expenses/new")
	public String createExpense(
			@Valid @ModelAttribute("expense") Expense expense, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses/{id}")
	public String showExpense(
			@PathVariable("id") Long id, 
			Model model
			) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String editForm(
			@PathVariable("id") Long id, 
			Model model
			) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PutMapping("/expenses/edit/{id}")
	public String updateExpense(
			@Valid @ModelAttribute("expense") Expense expense, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		expenseService.updateExpense(expense);
		return "redirect:/expenses";
	}
	
	@DeleteMapping("/expenses/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
}
