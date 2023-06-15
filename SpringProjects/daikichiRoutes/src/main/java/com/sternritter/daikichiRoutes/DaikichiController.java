package com.sternritter.daikichiRoutes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	@GetMapping("")
	public String greeting() {
		return "Welcome!";
	}
	
	@GetMapping("/today")
	public String todaysFortune() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@GetMapping("/tomorrow")
	public String tomorrowsFortune() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@GetMapping("/travel/{city}")
	public String goToCity(@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to " + city + "!";
	}
	
	@GetMapping("/lotto/{number}")
	public String readNumber(@PathVariable("number") int number) {
		if (number % 2 == 0) {
			return "You will take a grand journey in the near future, but be wary of tempting offers.";
		} else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend with your family and friends.";
		}
	}
}
