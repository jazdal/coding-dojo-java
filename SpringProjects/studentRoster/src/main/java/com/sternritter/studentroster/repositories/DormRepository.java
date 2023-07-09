package com.sternritter.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.studentroster.models.Dorm;

public interface DormRepository extends CrudRepository<Dorm, Long> {
	// This method retrieves all dorms from the database:
	List<Dorm> findAll();
}
