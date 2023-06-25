package com.sternritter.burgertracker.services;

import java.util.List;
import java.util.Optional;

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
	
	// Retrieves a burger (READ):
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		if (optionalBurger.isPresent()) {
			return optionalBurger.get();
		} else {
			return null;
		}
	}
	
	// Updates a burger (UPDATE);
	public Burger updateBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
}