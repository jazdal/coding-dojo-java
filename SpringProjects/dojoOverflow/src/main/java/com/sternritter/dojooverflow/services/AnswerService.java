package com.sternritter.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sternritter.dojooverflow.models.Answer;
import com.sternritter.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	// Adds the repository as a dependency:
	@Autowired
	private AnswerRepository aRepo;
	
	// Gets all the answers (READ):
	public List<Answer> getAll() {
		return aRepo.findAll();
	}
	
	// Gets all answers to this question (READ):
	public List<Answer> getAnswersToQuestion(Long questionId) {
		return aRepo.findByQuestionIdIs(questionId);
	}
	
	// Creates a new answer (CREATE):
	public Answer create(Answer answer) {
		return aRepo.save(answer);
	}
	
	// Retrieves an answer (READ):
	public Answer getAnswer(Long id) {
		return aRepo.findById(id).orElse(null);
	}
	
	// Updates an answer (UPDATE):
	public Answer update(Answer answer) {
		return aRepo.save(answer);
	}
	
	// Deletes an answer (DELETE):
	public void deleteAnswer(Long id) {
		aRepo.deleteById(id);
	}
}
