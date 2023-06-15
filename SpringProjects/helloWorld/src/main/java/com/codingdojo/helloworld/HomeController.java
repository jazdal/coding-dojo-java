package com.codingdojo.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HomeController {
	@GetMapping("")
	public String hello(Model model) {
		
		String firstName = "Ada";
		String lastName = "Lovelace";
		String email = "ones@zeroes.com";
		Integer age = 160;
		
		model.addAttribute("fruit", "banana");
		model.addAttribute("first", firstName);
		model.addAttribute("last", lastName);
		model.addAttribute("email", email);
		model.addAttribute("age", age);
		
		return "demo.jsp";
	}
	
	@GetMapping("/world")
	public String world() {
		return "Class level annotations are cool too!";
	}
}
