package com.sternritter.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.dojooverflow.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
	// Gets all tags from the database:
	List<Tag> findAll();
	
	// Gets a tag by subject:
	Tag findBySubjectIs(String subject);
}
