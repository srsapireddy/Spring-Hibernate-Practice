package com.luv2code.aopdemo;

public class Account {

	// 327
	private String name;
	private String level;
	
	
	// 340
	public Account() {}
	
	public Account(String name, String level) {
		this.name = name;
		this.level = level;
	}

	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}

	// 340
	// To display values for a given account
	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}
	
	
	
}
