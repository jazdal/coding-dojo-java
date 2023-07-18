package com.sternritter.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.dojooverflow.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
	// Gets all answers from the database:
	List<Answer> findAll();
	
	// Gets all answers to this question:
	List<Answer> findByQuestionIdIs(Long id);
}
