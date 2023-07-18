package com.sternritter.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sternritter.dojooverflow.models.Answer;
import com.sternritter.dojooverflow.models.Question;
import com.sternritter.dojooverflow.models.Tag;
import com.sternritter.dojooverflow.services.AnswerService;
import com.sternritter.dojooverflow.services.QuestionService;
import com.sternritter.dojooverflow.services.TagService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	// Sets up automatic dependency injection for all the services:
	@Autowired
	QuestionService qService;
	
	@Autowired
	AnswerService aService;
	
	@Autowired
	TagService tService;
	
	// DASHBOARD
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("questions", qService.getAll());
		return "dashboard.jsp";
	}
	
	// NEW QUESTION
	@GetMapping("/questions/new")
	public String newQuestionForm(
			@ModelAttribute("question") Question question, 
			HttpSession session
			) {
		session.invalidate();
		return "newquestion.jsp";
	}
	
	@PostMapping("/questions/new")
	public String addQuestion(
			@Valid @ModelAttribute("question") Question question, 
			BindingResult result, 
			@RequestParam("listOfTags") String listOfTags, 
			RedirectAttributes redirectAttributes
			) {
		if (result.hasErrors()) {
			return "newquestion.jsp";
		}
		List<Tag> questionTags = checkTags(listOfTags);
		
		if (questionTags == null || questionTags.size() > 3) {
			redirectAttributes.addFlashAttribute("error", "The number of tags must be between 1 and 3");
			return "redirect:/questions/new";
		}
		
		question.setTags(questionTags);
		qService.create(question);
		return "redirect:/";
	}

	private List<Tag> checkTags(String tags) {
		if (tags.length() > 0) {
			ArrayList<Tag> questionTags = new ArrayList<Tag>();
			String[] tagList = tags.split(",");
			for (String tagString:tagList) {
				Tag tag = tService.findBySubject(tagString.toLowerCase().strip());
				if (tag == null) {
					tag = new Tag(tagString.toLowerCase().strip());
					tService.update(tag);
				}
				questionTags.add(tag);
			}
			return questionTags;
		}
		return null;
	}
	
	// SHOW QUESTION
	@GetMapping("/questions/{questionId}")
	public String showQuestion(
			@PathVariable("questionId") Long id, 
			Model model, 
			@ModelAttribute("answer") Answer answer
			) {
		model.addAttribute("thisQuestion", qService.getQuestion(id));
		return "showquestion.jsp";
	}
	
	@PostMapping("/answer")
	public String addAnswer(
			@Valid @ModelAttribute("answer") Answer answer, 
			BindingResult result, 
			@RequestParam("questionId") Long questionId, 
			Model model
			) {
		Question thisQuestion = qService.getQuestion(questionId);
		if (result.hasErrors()) {
			model.addAttribute("thisQuestion", thisQuestion);
			return "showquestion.jsp";
		}
		answer.setQuestion(thisQuestion);
		aService.create(answer);
		return "redirect:/questions/" + questionId;
	}
}
