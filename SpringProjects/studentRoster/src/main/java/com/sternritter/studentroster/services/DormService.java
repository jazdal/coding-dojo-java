package com.sternritter.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sternritter.studentroster.models.Dorm;
import com.sternritter.studentroster.repositories.DormRepository;

@Service
public class DormService {
	// Adds the DormRepository as a dependency:
	private final DormRepository dormRepository;
	
	public DormService(DormRepository dormRepository) {
		this.dormRepository = dormRepository;
	}
	
	// Returns all the dorms (READ):
	public List<Dorm> allDorms() {
		return dormRepository.findAll();
	}
	
	// Creates a new dorm (CREATE):
	public Dorm create(Dorm dorm) {
		return dormRepository.save(dorm);
	}
	
	// Retrieves a dorm (READ):
	public Dorm findDorm(Long id) {
		Optional<Dorm> optionalDorm = dormRepository.findById(id);
		if (optionalDorm.isPresent()) {
			return optionalDorm.get();
		}
		return null;
	}
}
