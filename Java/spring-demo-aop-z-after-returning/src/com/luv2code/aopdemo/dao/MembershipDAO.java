package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

// 323
@Component
public class MembershipDAO {

	public void addAccount() {
		
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		
	}

	public boolean addSillyMember() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	return true;
	}

	public void goToSleep() {
		
		System.out.println(getClass() + ": I'm going to sleep now...");
		
	}
	
}
