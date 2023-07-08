package com.sternritter.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sternritter.dojosandninjas.models.Dojo;
import com.sternritter.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	// Adds the DojoRepository as a dependency:
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	// Returns all the dojos (READ):
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}
	
	// Creates a dojo (CREATE):
	public Dojo create(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	// Retrieves a dojo (READ):
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		return null;
	}
	
	// Deletes a dojo (DELETE):
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
}
