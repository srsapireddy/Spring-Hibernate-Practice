package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

// 189
public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory --> Creates session object
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				// create session --> To save or retrieve objects to and from the database.
				
				// Object to get the current session
				Session session =factory.getCurrentSession();
				
				try {
					
					// use the session object to save the Java object 
					
					//  create 3 student objects
					System.out.println("Creating 3 Student object...");
					Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
					Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
					Student tempStudent3 = new Student("Bonita","Applebum","bonita@luv2code.com");
					
					// begin a transaction
					session.beginTransaction();
					
					// save the student object
					System.out.println("Saving the student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					// commit the transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
				}
	}


