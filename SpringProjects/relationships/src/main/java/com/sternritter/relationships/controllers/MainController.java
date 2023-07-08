package com.sternritter.relationships.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sternritter.relationships.models.License;
import com.sternritter.relationships.models.Person;
import com.sternritter.relationships.services.LicenseService;
import com.sternritter.relationships.services.PersonService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	PersonService personService;
	
	@Autowired
	LicenseService licenseService;
	
	@GetMapping("/persons/new")
	public String personForm(@ModelAttribute Person person) {
		return "newPerson.jsp";
	}
	
	@PostMapping("/newPerson")
	public String createPerson(
			@Valid @ModelAttribute Person person, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "newPerson.jsp";
		}
		personService.create(person);
		return "redirect:/persons/" + person.getId();
	}
	
	@GetMapping("/persons/{person_id}")
	public String showPerson(
			@PathVariable Long person_id, 
			Model model
			) {
		Person someAwesomePerson = personService.findPerson(person_id);
		model.addAttribute("person", someAwesomePerson);
		return "showPerson.jsp";
	}
	
	@GetMapping("/licenses/new")
	public String licenseForm(
			Model model, 
			@ModelAttribute License license
			) {
		model.addAttribute("persons", personService.allPersons());
		return "newLicense.jsp";
	}
	
	@PostMapping("/newLicense")
	public String createLicense(
			Model model, 
			@Valid @ModelAttribute License license, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			model.addAttribute("persons", personService.allPersons());
			return "newLicense.jsp";
		}
		licenseService.create(license);
		return "redirect:/persons/" + license.getPerson().getId();
	}
}
