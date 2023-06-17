package com.sternritter.ninjaGold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	Random random = new Random();
	SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM d, yyyy hh:mm a");
	ArrayList<String> messages = new ArrayList<String>();
	ArrayList<String> reversedMessages = new ArrayList<String>();
	
	@GetMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("totalGold") == null) {
			session.setAttribute("totalGold", 0);
		}
		
		if (session.getAttribute("messages") == null) {
			session.setAttribute("messages", messages);
		}
		
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String processForm(
			@RequestParam("type") String type,  
			HttpSession session) {
		
		int min = 0;
		int max = 0;
		
		if ("farm".equals(type)) {
			min = 10;
			max = 20;
		} else if ("cave".equals(type)) {
			min = 5;
			max = 10;
		} else if ("house".equals(type)) {
			min = 2;
			max = 5;
		} else if ("quest".equals(type)) {
			max = 50;
		} else {
			min = 5;
			max = 20;
		}
		
		Date timestamp = new Date();
		String formattedTimestamp = dateFormatter.format(timestamp);
		int goldValue = random.nextInt(max - min + 1) + min;
		int totalGold = (int) session.getAttribute("totalGold");
		
		if ("quest".equals(type)) {
			int choice = random.nextInt(2);
			if (choice == 0) {
				totalGold -= goldValue;
				String message = "You failed a quest and lost " + goldValue + " gold. Ouch. (" + formattedTimestamp + ")";
				messages.add(message);
			} else {
				totalGold += goldValue;
				String message = "You completed a quest and earned " + goldValue + " gold. (" + formattedTimestamp + ")";
				messages.add(message);
			}
		} else if ("spa".equals(type)) {
			totalGold -= goldValue;
			String message = "You entered a spa and lost " + goldValue + " gold. Ouch. (" + formattedTimestamp + ")";
			messages.add(message);
		} else {
			totalGold += goldValue;
			String message = "You entered a " + type + " and earned " + goldValue + " gold. (" + formattedTimestamp + ")";
			messages.add(message);
		}
		
		session.setAttribute("totalGold", totalGold);
		
		@SuppressWarnings("rawtypes")
		ListIterator listIterator = messages.listIterator(messages.size());
		reversedMessages.clear();
		while (listIterator.hasPrevious()) {
			reversedMessages.add((String) listIterator.previous());
		}
		session.setAttribute("messages", reversedMessages);
		
		if (totalGold < -30) {
			return "redirect:/prison";
		} else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/reset")
	public String resetCounter(HttpSession session) {
		messages.clear();
		reversedMessages.clear();
		session.setAttribute("totalGold", 0);
		session.setAttribute("messages", reversedMessages);
		return "redirect:/";
	}
	
	@GetMapping("/prison")
	public String showPrison() {
		return "prison.jsp";
	}
}