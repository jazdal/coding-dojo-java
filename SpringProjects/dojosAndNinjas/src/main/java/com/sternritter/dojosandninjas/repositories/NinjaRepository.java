package com.sternritter.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.dojosandninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	// This method retrieves all ninjas from the database:
	List<Ninja> findAll();
}
