package com.luv2code.springdemo;

public interface Coach {
	
	// Different coaches will implement this method depending on the type of coach they are.
	// Interface --> How it is available but we don't know how its implemented.
	public String getDailyWorkout();
	
	public String getDailyFortune();
		
}
