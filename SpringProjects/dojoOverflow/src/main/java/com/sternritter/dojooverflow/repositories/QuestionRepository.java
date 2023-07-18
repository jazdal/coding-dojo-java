package com.sternritter.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.dojooverflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	// Gets all questions from the database:
	List<Question> findAll();
}