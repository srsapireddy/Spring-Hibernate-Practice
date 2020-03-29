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
public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		
		// create session factory --> Creates session object
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session --> To save or retrieve objects to and from the database.
		
		// Object to get the current session
		Session session =factory.getCurrentSession();
		
		try {
			
			// start transaction
			session.beginTransaction();
			
			// 257
			// get the student mary from database
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("\nLoaded Student: " + tempStudent);
			System.out.println("Course: " + tempStudent.getCourses());
			
			// 258
			// create more courses
			Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
			Course tempCourse2 = new Course("Atari 2600 - Game Devlopment");
			
			// add student to courses
			tempCourse1.addStudents(tempStudent);
			tempCourse2.addStudents(tempStudent);
			
			// save the courses
			System.out.println("\nSaving the courses ...");
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
