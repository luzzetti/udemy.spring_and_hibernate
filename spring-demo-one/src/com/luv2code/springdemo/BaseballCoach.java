package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	// define a private field for the dependency
	private FortuneService fortuneservice;
	
	//Define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneservice = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes in the batting cage";
	}

	@Override
	public String getDailyFortune() {
		//Use my fortune service to get a fortune
		return fortuneservice.getFortune();
	}

}
