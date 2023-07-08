package com.sternritter.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sternritter.dojosandninjas.models.Dojo;
import com.sternritter.dojosandninjas.models.Ninja;
import com.sternritter.dojosandninjas.services.DojoService;
import com.sternritter.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	// Sets up automatic dependency injection for all the services
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String dojoForm(@ModelAttribute Dojo dojo) {
		return "dojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(
			@Valid @ModelAttribute Dojo dojo, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "dojo.jsp";
		}
		dojoService.create(dojo);
		return "redirect:/";
	}
	
	@GetMapping("/ninjas/new")
	public String ninjaForm(
			Model model, 
			@ModelAttribute Ninja ninja
			) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "ninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(
			Model model, 
			@Valid @ModelAttribute Ninja ninja, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoService.allDojos());
			return "ninja.jsp";
		}
		ninjaService.create(ninja);
		return "redirect:/dojos/" + ninja.getDojo().getId();
	}
	
	@GetMapping("/dojos/{dojoId}")
	public String showDojoNinjas(
			Model model, 
			@PathVariable("dojoId") Long id
			) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "dojoNinjas.jsp";
	}
	
	@DeleteMapping("/dojos/{dojoId}")
	public void deleteDojo(@PathVariable("dojoId") Long id) {
		dojoService.deleteDojo(id);
	}
}
