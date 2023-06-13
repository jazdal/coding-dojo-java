package com.sternritter.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
public class MainController {
	Date today = new Date();
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/date")
	public String date(Model model) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		String formattedDate = dateFormatter.format(today);
		model.addAttribute("date", formattedDate);
		return "date.jsp";
	}
	
	@GetMapping("/time")
	public String time(Model model) {
		SimpleDateFormat timeFormatter = new SimpleDateFormat("h:m a");
		String formattedTime = timeFormatter.format(today).toUpperCase();
		model.addAttribute("time", formattedTime);
		return "time.jsp";
	}
}
