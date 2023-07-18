package com.sternritter.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sternritter.dojooverflow.models.Tag;
import com.sternritter.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	// Adds the repository as a dependency:
	@Autowired
	private TagRepository tRepo;
	
	// Gets all the tags (READ):
	public List<Tag> getAll() {
		return tRepo.findAll();
	}
	
	// Gets a tag by subject (READ):
	public Tag findBySubject(String subject) {
		return tRepo.findBySubjectIs(subject);
	}
	
	// Creates a new tag (CREATE):
	public Tag create(Tag tag) {
		return tRepo.save(tag);
	}
	
	// Finds a tag (READ):
	public Tag findTag(Long id) {
		return tRepo.findById(id).orElse(null);
	}
	
	// Updates a tag (UPDATE):
	public Tag update(Tag tag) {
		return tRepo.save(tag);
	}
	
	// Deletes a tag (DELETE):
	public void deleteTag(Long id) {
		tRepo.deleteById(id);
	}
}
