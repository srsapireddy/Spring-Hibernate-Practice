package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

// 187
public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		
		// create session factory --> Creates session object
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session --> To save or retrieve objects to and from the database.
		
		// Object to get the current session
		Session session =factory.getCurrentSession();
		
		try {
			
			// start transaction
			session.beginTransaction();
			
			// 246
			// create a course
			Course tempCourse = new Course("Pacman - How to Score One Million Points");
			
			// 255
			// save the course
			System.out.println("\nSaving the course ...");
			session.save(tempCourse);
			System.out.println("Saved the course:  " + tempCourse);
			
			
			//255
			// create the students
			Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
			Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
			
			// add students to the course
			tempCourse.addStudents(tempStudent1);
			tempCourse.addStudents(tempStudent2);
			
			// save the students
			System.out.println("\nSaving students ...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved students: " + tempCourse.getStudents());
			
			
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
