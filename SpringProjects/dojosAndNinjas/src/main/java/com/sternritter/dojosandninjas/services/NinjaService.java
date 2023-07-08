package com.sternritter.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sternritter.dojosandninjas.models.Ninja;
import com.sternritter.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	// Adds the NinjaRepository as a dependency:
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	// Returns all the ninjas (READ):
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
	
	// Creates a ninja (CREATE):
	public Ninja create(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
}
