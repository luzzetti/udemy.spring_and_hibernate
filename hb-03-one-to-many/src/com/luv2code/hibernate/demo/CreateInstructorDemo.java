package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// Create a session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {		
			// Create the objects
			
			Instructor instructor = new Instructor("Matteo","La Porta","matlap@gmail.com");

			InstructorDetail instructorDetail = 
					new InstructorDetail("http://www.dinsey.com", "Pippo Cosplay");
						
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			
			//begin transaction
			session.beginTransaction();
			
			//Save the instructor
			System.out.println("Saving Instructor");
			session.save(instructor);
			
			
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
