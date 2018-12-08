package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		//Read spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		
		//Call a method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//Close the context
		context.close();
	}

}
