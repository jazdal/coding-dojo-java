package com.sternritter.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sternritter.authentication.models.LoginUser;
import com.sternritter.authentication.models.User;
import com.sternritter.authentication.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	// Sets up automatic dependency injection for all the services
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("loginuser", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("user") User user, 
			BindingResult result, 
			Model model, 
			HttpSession session
			) {
		userService.register(user, result);
		if (result.hasErrors()) {
			model.addAttribute("loginuser", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("user", user.getId());
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("loginuser") LoginUser user, 
			BindingResult result, 
			Model model, 
			HttpSession session
			) {
		if (result.hasErrors()) {
			model.addAttribute("user", new User());
			return "index.jsp";
		}
		User loginuser = userService.login(user, result);
		session.setAttribute("userId", loginuser.getId());
		return "redirect:/welcome";
	}
	
	@GetMapping("/welcome")
	public String welcome( 
			Model model, 
			HttpSession session
			) {
		// Attempt to get the user ID from session:
		Long userId = (Long) session.getAttribute("userId");
		
		/* If there is no user ID stored in session (null), redirect
		 * the user back to the login / registration page 
		 * (most likely unauthorized access) */
		if (userId == null) {
			return "redirect:/";
		}
		
		// Attempt to get the user from the database by user ID:
		User currentUser = userService.findUser(userId);
		
		/* If user doesn't exist in the database (null), redirect
		 * the user back to the login / registration page */
		if (currentUser == null) {
			return "redirect:/";
		}
		
		// If user passes all checks:
		model.addAttribute("currentUser", currentUser);
		return "welcome.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
