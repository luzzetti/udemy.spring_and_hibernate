package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		// Create a session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {		
		
			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int id = 2;
			InstructorDetail instructorDetail =
					session.get(InstructorDetail.class, id);
			
			// print the instructor detail
			System.out.println("instructorDetail :" + instructorDetail);
			
			// print the associated instructor
			System.out.println("Instructor: " + 
								instructorDetail.getInstructor());
			
			// let's delete the instructor detail
			//This will also delete the Instructor because of cascade
			System.out.println("Deleting: " + 
								instructorDetail);
			
			session.delete(instructorDetail);
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			//Handle connection leak issue
			session.close();
			
			factory.close();
		}
		
	}

}
