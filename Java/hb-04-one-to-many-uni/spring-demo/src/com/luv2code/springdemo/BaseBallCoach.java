package com.luv2code.springdemo;

public class BaseBallCoach implements Coach {
	
	
	// Dependency Injection --> Spring will construct our object they will pass a dependency and we will accept it and we assign it.
	
	
	// Creating constructor for injections
	// define a private field
	private FortuneService fortuneService;
	
	// Constructor
	public BaseBallCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
    @Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
        
		// use my fortuneService to get a fortune.
		return fortuneService.getFortune();
	}
}

