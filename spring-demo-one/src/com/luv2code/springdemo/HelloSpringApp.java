package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		// Get Context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Ask for a bean
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		//Use the bean
		System.out.println(theCoach.getDailyWorkout());
		//Use new method
		System.out.println(theCoach.getDailyFortune());
		
		// Close Context
		context.close();
		
	}

}
