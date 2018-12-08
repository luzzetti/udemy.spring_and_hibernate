package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class SpringCoach implements Coach {

	FortuneService fortuneService;

	public SpringCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Exercise with IoC and DI";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
