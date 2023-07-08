package com.sternritter.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.relationships.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
    // This method retrieves all the persons from the database:
    List<Person> findAll();

    // This method finds persons with first names containing the search string:
    List<Person> findByFirstNameContaining(String search);
    
    // This method finds persons with last names containing the search string:
    List<Person> findByLastNameContaining(String search);

    // This method counts how many first names are contained in a certain string:
    Long countByFirstNameContaining(String search);
    
    // This method counts how many last names are contained in a certain string:
    Long countByLastNameContaining(String search);

    // This method deletes a person that starts with a specific first name:
    Long deleteByFirstNameStartingWith(String search);
    
    // This method deletes a person that starts with a specific last name:
    Long deleteByLastNameStartingWith(String search);
}
