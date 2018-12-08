package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	//Field level injection
	@Value("${teamA.name}")
	private String nome;
	
	@Value("${teamA.mail}")
	private String eMail;
	
	public SwimCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Fatti due vasche";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getNome() {
		return nome;
	}

	public String geteMail() {
		return eMail;
	}

}
