package com.sternritter.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@GetMapping("/")
	public String index(HttpSession session) {
		Integer count = 0;
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", count);
		} else {
			count = (Integer) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		}
		return "index.jsp";
	}
	
	@GetMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}
	
	@GetMapping("/counter2")
	public String counter2(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		count += 2;
		session.setAttribute("count", count);
		return "counter2.jsp";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/";
	}
}