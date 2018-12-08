package com.luv2code.springdemo.mvc;

// import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// Need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	

	// Need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	@RequestMapping("/processFormVersionThree")
	//Rimuovo HttpServletRequest
	//Uso il binding del parametro al posto degli argomenti
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, 
			Model model) {
		
		// Non ho più bisogno di:
		// String theName = request.getParameter("studentName");
		
		theName = theName.toUpperCase();
		
		String result = "OOOOH " + theName;
		
		model.addAttribute("message", result);
		
		return "helloworld";
		
	}

	
}
