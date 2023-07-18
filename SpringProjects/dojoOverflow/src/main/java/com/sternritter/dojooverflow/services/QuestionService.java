package com.sternritter.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sternritter.dojooverflow.models.Question;
import com.sternritter.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	// Adds the repository as a dependency:
	@Autowired
	private QuestionRepository qRepo;
	
	// Gets all the questions (READ):
	public List<Question> getAll() {
		return qRepo.findAll();
	}
	
	// Creates a new question (CREATE):
	public Question create(Question question) {
		return qRepo.save(question);
	}
	
	// Retrieves a question (READ):
	public Question getQuestion(Long id) {
		return qRepo.findById(id).orElse(null);
	}
	
	// Updates a question (UPDATE):
	public Question update(Question question) {
		return qRepo.save(question);
	}
	
	// Deletes a question (DELETE):
	public void deleteQuestion(Long id) {
		qRepo.deleteById(id);;
	}
}
