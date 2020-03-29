package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

// 187
public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory --> Creates session object
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session --> To save or retrieve objects to and from the database.
		
		// Object to get the current session
		Session session =factory.getCurrentSession();
		
		try {
			
			// use the session object to save the Java object 
			
			//  create the student object
			System.out.println("Creating the new Student object...");
			Student tempStudent = new Student("Paul","Wall","paul@luv2code.com");
			
			// begin a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
	}

}
