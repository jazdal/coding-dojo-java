package com.sternritter.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.dojosandninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	// This method retrieves all dojos from the database:
	List<Dojo> findAll();
}