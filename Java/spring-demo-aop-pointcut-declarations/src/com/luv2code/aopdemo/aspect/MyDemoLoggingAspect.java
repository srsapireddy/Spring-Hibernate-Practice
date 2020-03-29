package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 321
@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	// Pointcut expression
	// Run this code BEFORE - target object method: "public void addAccount()"
	// 324
	// @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())") 
	// @Before("execution(public void add*())")
	// 325
	// @Before("execution(* add*())") 
	// 327, 327
	// @Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	// 328
	// @Before("execution(* add*(..))")
	
	// 330 --> Pointcut Declaration
	// Name of the declaration --> forDaoPackage
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// 328
	// @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	// 330
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		
	}

	// 330 --> Reusing pointcut declaration
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		
		System.out.println("\n=====>>> Perform API analytics");
		
	}

}
