package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// Create a random number generator
	Random random = new Random();
	
	//Create an array of strings
	String[] fortune = {
			"Ce la puoi fare!",
			"Bestia!!!",
			"Bomber!"
	};
	
	@Override
	public String getFortune() {

		int randomIndex = random.nextInt(fortune.length);
		String randomFortuneString = fortune[randomIndex];
		return randomFortuneString;
	}

}
