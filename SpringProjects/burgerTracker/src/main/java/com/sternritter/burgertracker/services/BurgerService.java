package com.sternritter.burgertracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sternritter.burgertracker.models.Burger;
import com.sternritter.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	// Injects the BurgerRepository as a dependency:
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	// Returns all the burgers (READ):
	public List<Burger> allBurgers() {
		return burgerRepository.findAll();
	}
	
	// Creates a burger (CREATE):
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
}
