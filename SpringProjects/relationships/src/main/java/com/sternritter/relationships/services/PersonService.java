package com.sternritter.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sternritter.relationships.models.Person;
import com.sternritter.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	// Adds the PersonRepository as a dependency:
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	// Returns all the persons (READ):
	public List<Person> allPersons() {
		return personRepository.findAll();
	}
	
	// Creates a person (CREATE):
	public Person create(Person person) {
		return personRepository.save(person);
	}
	
	// Retrieves a person (READ):
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
	
	// Updates a person (UPDATE):
	public Person update(Person person) {
		return personRepository.save(person);
	}
	
	// Deletes a person (DELETE):
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
}
