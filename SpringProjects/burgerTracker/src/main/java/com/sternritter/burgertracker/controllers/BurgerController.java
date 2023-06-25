package com.sternritter.burgertracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sternritter.burgertracker.models.Burger;
import com.sternritter.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	@Autowired
	BurgerService burgerService;
	
	@GetMapping("/")
	public String index(
			Model model, 
			@ModelAttribute("burger") Burger burger) {
		model.addAttribute("burgers", burgerService.allBurgers());
		return "index.jsp";
	}
	
	@PostMapping("/burgers/new")
	public String createBurger(
			@Valid @ModelAttribute("burger") Burger burger, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		burgerService.createBurger(burger);
		return "redirect:/";
	}
	
	@GetMapping("/burgers/edit/{id}")
	public String editForm(
			@PathVariable("id") Long id, 
			Model model
			) {
		Burger burger = burgerService.findBurger(id);
		model.addAttribute("burger", burger);
		return "edit.jsp";
	}
	
	@PutMapping("/burgers/edit/{id}")
	public String updateBurger(
			@Valid @ModelAttribute("burger") Burger burger, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			burgerService.updateBurger(burger);
			return "redirect:/";
		}
	}
}