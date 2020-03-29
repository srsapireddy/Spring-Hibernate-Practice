package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

// 321
@Aspect
@Component
@Order(2)
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
	
	// 328
	// @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	// 330
	// @Before("forDaoPackage()")
	// 333
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		
		// 337
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		// 338
		// display the method arguments
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for(Object tempArg: args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				// downcast and print account specific stuff
				
				Account theAccount = (Account) tempArg;
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
	}

}
