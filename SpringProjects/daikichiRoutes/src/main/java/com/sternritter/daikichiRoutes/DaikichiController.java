package com.sternritter.daikichiRoutes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	@RequestMapping("")
	public String greeting() {
		return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String todaysFortune() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrowsFortune() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
}
