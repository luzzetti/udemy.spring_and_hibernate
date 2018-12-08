package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RoughFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Studia plebeo! STUDIA!";
	}

}
