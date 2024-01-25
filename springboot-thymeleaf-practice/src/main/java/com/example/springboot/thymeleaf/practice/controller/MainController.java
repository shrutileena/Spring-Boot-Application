package com.example.springboot.thymeleaf.practice.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("Inside about handler ...");
		model.addAttribute("name", "Shruti");
		model.addAttribute("date", new Date());
		return "about";	//about.html
	}
	
	@GetMapping("/iterate")
	public String iterateHandler(Model model) {
		List<String> names = List.of("Ankit", "Lakshmi", "Karan", "John");
		model.addAttribute("names", names);
		return "iterate";
	}
	
	@GetMapping("/conditional")
	public String conditionalHandler(Model m) {
		m.addAttribute("isActive", false);
		m.addAttribute("gender", "F");
		
		List<Integer> list = List.of(1,2,3,4,5,6,7);
		m.addAttribute("list", list);
		
		return "conditional";
	}
	
	// handler for including fragments
	@GetMapping("/fragments")
	public String fragmentsHandler(Model m) {
		return "fragments";
	}
}
