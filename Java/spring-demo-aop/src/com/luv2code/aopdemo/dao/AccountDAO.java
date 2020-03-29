package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public boolean addSillyMember() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	return true;
	}

	// 327
public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		
	}

// 328
public boolean doWork() {
	
	System.out.println(getClass() + ": doWork()");
	return false;
	
}

}
