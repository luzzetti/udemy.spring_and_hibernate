package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">> TennisCoach -Inside Default Constructor");
	}
	
	//Define my init method
	
	@PostConstruct
	public void myPostConstructMethod() {
		System.out.println(">> Do My Init Stuff");
	}
	
	/*
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService");
		this.fortuneService = fortuneService;
	}
	*/

	@Override
	public String getDailyWorkout() {
		return "Tira un po' di palle";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	//Define my destroy method
	
	@PreDestroy
	public void myPreDestroyMethod() {
		System.out.println(">> Do my Cleanup Stuff");
	}

}
