package com.luv2code.springdemo;

public class UdemyCoach implements Coach {
	
	private FortuneService fortuneservice;
	
	public UdemyCoach(FortuneService theFortuneService) {
		fortuneservice = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Watch one more video!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneservice.getFortune();
	}
	
}
