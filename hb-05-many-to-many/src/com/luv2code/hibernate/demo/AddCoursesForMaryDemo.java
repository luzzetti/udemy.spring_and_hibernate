package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		
		// Create a session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {		
			
			
			//begin transaction
			session.beginTransaction();
			
			//Get Matteo from Database
			int theId = 2;
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println("\n\nLoaded student: " + tempStudent);
			
			// Create more courses
			Course tempCourse1 = new Course("Airplanez");
			Course tempCourse2 = new Course("Mortal Kombat II");
			//Course tempCourse3 = new Course("Hibernate");
			
			// add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent); 
			
			//Save the courses
			System.out.println("\nSaving the courses ... ");
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
		
	}

}
