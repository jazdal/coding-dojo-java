package com.sternritter.studentroster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sternritter.studentroster.models.Dorm;
import com.sternritter.studentroster.models.Student;
import com.sternritter.studentroster.services.DormService;
import com.sternritter.studentroster.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	// Sets up automatic dependency injection for all the services:
	@Autowired
	DormService dormService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public String reroute() {
		return "redirect:/dorms";
	}
	
	@GetMapping("/dorms")
	public String dashboard(Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return "dashboard.jsp";
	}
	
	@GetMapping("/dorms/new")
	public String dormForm(@ModelAttribute Dorm dorm) {
		return "newdorm.jsp";
	}
	
	@PostMapping("/dorms/new")
	public String newDorm(
			@Valid @ModelAttribute Dorm dorm, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "newdorm.jsp";
		}
		dormService.create(dorm);
		return "redirect:/dorms";
	}
	
	@GetMapping("/students/new")
	public String studentForm(
			Model model, 
			@ModelAttribute Student student
			) {
		model.addAttribute("dorms", dormService.allDorms());
		return "newstudent.jsp";
	}
	
	@PostMapping("/students/new")
	public String newStudent(
			Model model, 
			@Valid @ModelAttribute Student student, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			model.addAttribute("dorms", dormService.allDorms());
			return "newstudent.jsp";
		}
		studentService.create(student);
		return "redirect:/dorms";
	}
	
	@GetMapping("/dorms/{dormId}")
	public String showDormStudents(
			@PathVariable("dormId") Long id, 
			@ModelAttribute Student student, 
			Model model
			) {
		model.addAttribute("dorm", dormService.findDorm(id));
		model.addAttribute("allStudents", studentService.allStudents());
		model.addAttribute("dormStudents", studentService.findDormStudents(id));
		return "dormstudents.jsp";
	}
	
	@PostMapping("/students/addToDorm/{dormId}")
	public String addToDorm(
			@ModelAttribute("dorm") Dorm dorm, 
			@PathVariable("dormId") Long dormId, 
			@RequestParam("id") Long studentId
			) {
		dorm = dormService.findDorm(dormId);
		Student student = studentService.findStudent(studentId);
		if (dorm != null && student != null) {
			student.setDorm(dorm);
			studentService.update(student);
		}
		return "redirect:/dorms/" + dorm.getId();
	}
	
	@GetMapping("/students/remove/{id}")
	public String removeStudent(@PathVariable("id") Long id) {
		studentService.removeFromDorm(studentService.findStudent(id));
		return "redirect:/dorms";
	}
}
