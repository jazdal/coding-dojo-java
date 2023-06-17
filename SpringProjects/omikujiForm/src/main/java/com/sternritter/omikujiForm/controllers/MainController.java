package com.sternritter.omikujiForm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@GetMapping("/")
	public String reroute() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String processForm(
			@RequestParam(value="number") int number, 
			@RequestParam(value="city") String city, 
			@RequestParam(value="name") String name, 
			@RequestParam(value="hobby") String hobby, 
			@RequestParam(value="livingThing") String livingThing, 
			@RequestParam(value="comment") String comment, 
			HttpSession session
		) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("comment", comment);
		
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String showOmikuji() {
		return "omikuji.jsp";
	}
}