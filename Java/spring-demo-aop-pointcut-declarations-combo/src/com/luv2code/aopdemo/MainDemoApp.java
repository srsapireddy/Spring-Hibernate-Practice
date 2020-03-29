package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		// 323
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		// 327
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		
		// 332
		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		// 323, 324
		// call the membership business method
		theMembershipDAO.addSillyMember();
		
		// 328
		theAccountDAO.doWork();
		theMembershipDAO.goToSleep();
		
		// 321
		// do it again!
		// System.out.println("\n let's call it again!\n");
		// call the business method
		// theAccountDAO.addAccount();
		
		// close the context
        context.close();
	}

}
