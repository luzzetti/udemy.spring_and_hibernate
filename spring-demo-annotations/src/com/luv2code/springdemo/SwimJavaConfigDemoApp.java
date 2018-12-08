package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		//Read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from spring container
		Coach theCoach = context.getBean("springCoach", Coach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//Call a method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//Close the context
		context.close();
	}

}
