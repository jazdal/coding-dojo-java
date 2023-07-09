package com.sternritter.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.studentroster.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	// This method retrieves all students from the database:
	List<Student> findAll();
	
	// This method retrieves all students belonging to a certain dorm:
	List<Student> findByDormIdIs(Long dormId);
}
