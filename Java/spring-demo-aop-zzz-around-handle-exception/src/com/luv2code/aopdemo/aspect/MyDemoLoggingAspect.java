package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	// 351
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// 350
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @Around on method: " + method);	
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// now, let's execute the method
		// 353, 354 --> Handling and re-throwing the exception
		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());
			
			// 353
			// give user a custom message or default fortune
			// result = "Major accident! But no worries, your private AOP helicopter is on the way";
			// 354
			// re-throw the excption
			throw e;
		}
				
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		myLogger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");
		return result;
		
	}
	
	// 347
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @After (finally) on method: " + method);	
		
	}
	
	// 345
	// new code for new advice
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		myLogger.info("\n=====>>> The exception is: " + theExc);
	}

	// 340
	// add a new advice for @AfterReturning on the findAccounts
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		
		// 342
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
	    myLogger.info("\n=====>>> result is: " + result);
	
	    // 343
	    // let's post-process the data ... let's modify if:-)
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		myLogger.info("\n=====>>> result is: " + result);
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
		
		myLogger.info("\n=====>>> Executing @Before advice on addAccount()");
		
		// 337
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: " + methodSig);
		
		// 338
		// display the method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for(Object tempArg: args) {
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				// downcast and print account specific stuff
				
				Account theAccount = (Account) tempArg;
				myLogger.info("account name: " + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());
			}
		}
	}

}
