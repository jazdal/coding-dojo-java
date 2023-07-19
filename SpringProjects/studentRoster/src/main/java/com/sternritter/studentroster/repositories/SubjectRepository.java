package com.sternritter.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.studentroster.models.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
	// This method retrieves all subjects from the database:
	List<Subject> findAll();
	
	// This method retrieves all subjects taken by a student:
	List<Subject> findByStudentsIdIs(Long studentId);
}
