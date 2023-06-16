package com.sternritter.testForm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam(value="email") String email, 
			@RequestParam(value="password") String password, 
			HttpSession session
			) {
		session.setAttribute("email", email);
		return "welcome.jsp";
		
	}
}
