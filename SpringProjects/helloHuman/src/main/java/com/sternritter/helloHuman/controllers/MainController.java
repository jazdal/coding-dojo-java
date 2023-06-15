package com.sternritter.helloHuman.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@GetMapping("/")
	public String greeting(
			@RequestParam(value="name", required=false) String name, 
			@RequestParam(value="last_name", required=false) String last_name, 
			@RequestParam(value="times", required=false) Integer times
			) {
		if (name == null) {
			return "Hello Human";
		} else if (times == null) {
			if (last_name == null) {
				return "Hello " + name;
			} else {
				return "Hello " + name + " " + last_name;
			}
		} else {
			if (last_name == null) {
				return ("Hello " + name + " ").repeat(times);
			} else {
				return ("Hello " + name + " " + last_name + " ").repeat(times);
			}
		}
	}
}
