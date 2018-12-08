package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		//Load spring context
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//Check if they are the same object
		boolean result = (theCoach == alphaCoach);
		
		//Print out the result
		System.out.println("Pointing to the same obj: " + result);
		
		//Print out the memory location
		System.out.println("\nMemory Location for theCoach: " + theCoach);
				
		//Print out the memory location
		System.out.println("\nMemory Location for alphaCoach: " + alphaCoach);
		
		//Close spring context
		context.close();
				
	}

}
