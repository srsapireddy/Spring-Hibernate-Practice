package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	// 345
	// new code for new advice
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterThrowing on method: " + theExc);
		
		// log the exception
		System.out.println("\n=====>>> The exception is: " + method);
	}

	// 340
	// add a new advice for @AfterReturning on the findAccounts
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		
		// 342
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
	    System.out.println("\n=====>>> result is: " + result);
	
	    // 343
	    // let's post-process the data ... let's modify if:-)
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		System.out.println("\n=====>>> result is: " + result);
	}
	
	// 343
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// loop through accounts
		for(Account tempAccount: result) {
		
			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			// update the name of the account
			tempAccount.setName(theUpperName);
		}
	}


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
