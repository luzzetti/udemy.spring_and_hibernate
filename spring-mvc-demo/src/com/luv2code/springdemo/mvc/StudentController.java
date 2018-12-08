package com.luv2code.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/student")
public class StudentController {

	
	//WHY...
	@Value("#{countryOptions}")
	private Map<String,String> countryOptions;
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// Create a new student Object
		Student theStudent = new Student();
		
		//add student object to the model
		//mapping name-Object
		theModel.addAttribute("student", theStudent);
		
		theModel.addAttribute("theCountryOptions", countryOptions);
		
		return "student-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm(
			@ModelAttribute("student") Student theStudent) {
		
		// log the input data
		System.out.println(">> INPUT: " + theStudent.getFirstName());
		System.out.println(">> INPUT: " + theStudent.getLastName());
		
		return "student-confirmation";
	}
	
}
