package com.sternritter.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.relationships.models.License;

public interface LicenseRepository extends CrudRepository<License, Long> {
	// This method retrieves all the licenses from the database:
	List<License> findAll();
	
	// This method finds licenses with numbers containing the search string:
	List<License> findByNumberContaining(String search);
	
	// This method counts how many license numbers are contained in a certain string:
	Long countByNumberContaining(String search);
	
	// This method deletes a license that starts with a specific number:
	Long deleteByNumberStartingWith(String search);
}