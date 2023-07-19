package com.sternritter.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sternritter.studentroster.models.Student;
import com.sternritter.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	// Adds the StudentRepository as a dependency:
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	// Returns all the students (READ):
	public List<Student> allStudents() {
		return studentRepository.findAll();
	}
	
	// Creates a new student (CREATE):
	public Student create(Student student) {
		return studentRepository.save(student);
	}
	
	// Retrieves a student (READ):
	public Student findStudent(Long id) {
		Optional <Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			return optionalStudent.get();
		}
		return null;
	}
	
	// Retrieves all students belonging to a certain dorm (READ):
	public List<Student> findDormStudents(Long dormId) {
		return studentRepository.findByDormIdIs(dormId);
	}
	
	// Retrieves all students taking a particular subject (READ):
	public List<Student> getStudentsBySubject(Long subjectId) {
		return studentRepository.findBySubjectsIdIs(subjectId);
	}
	
	// Updates an existing student (UPDATE):
	public Student update(Student student) {
		return studentRepository.save(student);
	}
	
	// Removes a student from a dorm (UPDATE):
	public void removeFromDorm(Student student) {
		student.setDorm(null);
		studentRepository.save(student);
	}
}
