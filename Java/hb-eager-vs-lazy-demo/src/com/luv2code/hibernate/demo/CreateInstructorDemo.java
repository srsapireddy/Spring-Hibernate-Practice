package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

// 187
public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// create session factory --> Creates session object
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		// create session --> To save or retrieve objects to and from the database.
		
		// Object to get the current session
		Session session =factory.getCurrentSession();
		
		try {
			
			// use the session object to save the Java object 
			
			// create the objects
			
			Instructor tempInstructor = new Instructor("Susan","Public","susan.public@luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com","Video Games");
			
			
			// associate the objects together
			// Here these two objects are associate in the memory
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			// begin a transaction
			session.beginTransaction();
			
			// Saving the associated object to the database
			// Note: This will ALSO save the details object
			// because of cascadeType.ALL
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			// 228
			// add clean up code for the resources
			session.close();
			factory.close();
		}
		
	}

}
