package com.sternritter.authentication.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.sternritter.authentication.models.LoginUser;
import com.sternritter.authentication.models.User;
import com.sternritter.authentication.repositories.UserRepository;

@Service
@Validated
public class UserService {
	// Adds the UserRepository as a dependency:
	@Autowired
	private UserRepository userRepo;
	
	// Returns all the users (READ):
	public List<User> getAll() {
		return userRepo.findAll();
	}
	
	// Creates a new user (CREATE):
	public User create(User user) {
		return userRepo.save(user);
	}
	
	// Retrieves a user (READ):
	public User findUser(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	// Updates an existing user (UPDATE):
	public User update(User user) {
		return userRepo.save(user);
	}
	
	// Deletes a user (DELETE):
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
	
	// Regex filter method for password:
	private boolean passwordMeetsRequirements(String password) {
		// Regex pattern to match at least one uppercase letter and one number:
		String pattern = "^(?=.*[A-Z])(?=.*\\d).+$";
		return password.matches(pattern);
	}
	
	// Handles new user registration and additional data validations:
	public User register(User user, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(user.getEmail());
		// If user's email already exists in the database...
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "An account with that email already exists!");
		}
		
		// Check to see if the user is at least 10 years old...
		if (user.getBirthday() != null) {
			LocalDate today = LocalDate.now();
			LocalDate minimumAgeDate = today.minusYears(10);
			if (user.getBirthday().isAfter(minimumAgeDate)) {
				result.rejectValue("birthday", "Invalid", "You must be at least 10 years old to register!");
			}
		}
		
		/* If the password doesn't pass the filter requirement 
		 * (Must have at least one uppercase letter and one number)... */
		if (!passwordMeetsRequirements(user.getPassword())) {
			result.rejectValue("password", "Invalid", "Password must contain at least one uppercase letter and one number!");
		}

		// If password doesn't match the confirm password...
		if (!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Passwords do not match!");
		}
		
		if (result.hasErrors()) {
			return null;
		}
		
		// Hash and salt the password...
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		
		// Set the password to the hashed password, and save the user to the database!
		user.setPassword(hashed);
		return userRepo.save(user);
	}
	
	// Handles user login:
	public User login(LoginUser user, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(user.getEmail());
		// If the user's email is not in the database...
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "User not found!");
			return null;
		}
		User userFromDb = potentialUser.get();
		
		if(!BCrypt.checkpw(user.getPassword(), userFromDb.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid password!");
		}
		
		if (result.hasErrors()) {
			return null;
		}
		return userFromDb;
	}
}
