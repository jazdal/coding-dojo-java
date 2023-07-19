package com.sternritter.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sternritter.studentroster.models.Student;
import com.sternritter.studentroster.models.Subject;
import com.sternritter.studentroster.repositories.SubjectRepository;

@Service
public class SubjectService {
	@Autowired
	private SubjectRepository sRepo;
	
	// Gets all the subjects (READ):
	public List<Subject> getAll() {
		return sRepo.findAll();
	}
	
	// Gets all subjects taken by a student(READ):
	public List<Subject> getStudentSubjects(Long id) {
		return sRepo.findByStudentsIdIs(id);
	}
	
	// Creates a new subject (CREATE):
	public Subject create(Subject subject) {
		return sRepo.save(subject);
	}
	
	// Gets one subject via ID (READ):
	public Subject getSubject(Long id) {
		return sRepo.findById(id).orElse(null);
	}
	
	// Updates a subject (UPDATE):
	public Subject update(Subject subject) {
		return sRepo.save(subject);
	}
	
	// Deletes a subject (DELETE):
	public void deleteSubject(Long id) {
		sRepo.deleteById(id);
	}
	
	// Removes a student from a subject (UPDATE):
	public void removeFromSubject(Subject subject, Student student) {
		subject.getStudents().remove(student);
		sRepo.save(subject);
	}
}
