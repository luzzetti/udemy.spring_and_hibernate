package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		
		// Create a session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {		
			
			
			//begin transaction
			session.beginTransaction();
			
			//Create a course
			Course tempCourse = new Course("Pacman - How to score One Million Points");
			
			//add some review
			tempCourse.addReview(new Review("Great course ... love it!"));
			tempCourse.addReview(new Review("Boooo!"));
			tempCourse.addReview(new Review("Cool bro!!"));
			tempCourse.addReview(new Review("We want more of this!"));
			tempCourse.addReview(new Review("Gotta go play arkanoid, nooob"));
			
			// save the course ... and leverage the cascade all :-)
			System.out.println("Saving the course: " + tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);

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
