package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
//@ComponentScan("com.luv2code.springdemo")
public class SportConfig {
	
	//Define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	@Bean
	public FortuneService roughFortuneService() {
		return new RoughFortuneService();
	}
	
	//Define bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	
	@Bean
	public Coach springCoach() {
		return new SpringCoach(roughFortuneService());
	}
	
	
}
