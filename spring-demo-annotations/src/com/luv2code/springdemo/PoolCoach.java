package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component("poolCoach")
public class PoolCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Allenati con le sponde! Scarso!";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}
