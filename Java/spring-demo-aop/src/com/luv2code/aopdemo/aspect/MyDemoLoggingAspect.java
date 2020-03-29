package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		
	}
	
}
