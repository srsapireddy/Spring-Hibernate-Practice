package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	// 332
	private String name;
	private String serviceCode;
	
	
	// 340
	// add a new method: findAccount()
	public List<Account> findAccounts(boolean tripWire){
		
		
		//345
		// for academic purpose ... simulate an exception
		if(tripWire == true) {
			throw new RuntimeException("No soup for you!!!");
		}
		
		
		List<Account> myAccounts = new ArrayList<>();
	
	// 340
	// create sample
	Account temp1 = new Account("John", "Silver");
	Account temp2 = new Account("Madhu", "Platinum");
	Account temp3 = new Account("Luca", "Gold");
	
	// add them to our accounts list
	myAccounts.add(temp1);
	myAccounts.add(temp2);
	myAccounts.add(temp3);
	
	return myAccounts;
	}
	// --
	
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
	
	System.out.println(getClass() + ": in doWork()");
	return false;
	
}

public String getName() {
	System.out.println(getClass() + ": in getName()");
	return name;
}

public void setName(String name) {
	System.out.println(getClass() + ": in setName()");
	this.name = name;
}

public String getServiceCode() {
	System.out.println(getClass() + ": in getServiceCode()");
	return serviceCode;
}

public void setServiceCode(String serviceCode) {
	System.out.println(getClass() + ": in setServiceCode()");
	this.serviceCode = serviceCode;
}



}
