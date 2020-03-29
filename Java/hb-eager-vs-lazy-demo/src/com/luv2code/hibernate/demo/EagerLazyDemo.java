package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

// 187
public class EagerLazyDemo {

	public static void main(String[] args) {
		
		// create session factory --> Creates session object
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		// create session --> To save or retrieve objects to and from the database.
		
		// Object to get the current session
		Session session =factory.getCurrentSession();
		
		try {
			
			// start transaction
			session.beginTransaction();
			
			// 230
			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			// 234 
			// Toggle Break Point --> When we run this application in the debug mode the eclipse will stop at this location. 
			System.out.println("luv2code: Instructor: " + tempInstructor);
			
			// Retrieving courses for the instructor 
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
			// commit the transaction
			session.getTransaction().commit();
			
			// 236 --> Testing Lazy loading - closing the session - this should fail
			// Close the session
			session.close();
			
			// 237
			System.out.println("\nluv2code: The session is now closed!\n");
			// option 1: call getter method while session is open
			
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
			System.out.println("luv2code: Done!");
		}
		finally {
			// 228
			// add clean up code for the resources
			session.close();
			factory.close();
		}
		
	}

}
