package com.luv2code.springdemo;

public class MyApp {

	public static void main(String[] args) {
		
		// Create the object --> For the App to talk to the baseball coach
		// Coach theCoach = new BaseBallCoach();
		// Hard coded.
		Coach theCoach = new TrackCoach();
		
		// Use the object
		// Can work with any Coach implementation.
        System.out.println(theCoach.getDailyWorkout());
        
	}

}
