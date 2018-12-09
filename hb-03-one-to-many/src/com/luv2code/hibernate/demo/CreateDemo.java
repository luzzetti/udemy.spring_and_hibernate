package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

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
			// Create the objects
			
			Instructor instructor = new Instructor("Christian","Luzzetti","Christian.luzzetti@gmail.com");

			InstructorDetail instructorDetail = 
					new InstructorDetail("http://www.google.it", "Databasing!");
			
			/*
			
			Instructor instructor =
					new Instructor("Matteo","La Porta","mat.laporta@gmail.com");

			InstructorDetail instructorDetail = 
					new InstructorDetail("http://www.google.it", "Middleware");
			*/
			
			// Associate the objects together
			instructor.setInstructorDetail(instructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			//NOTE: This will ALSO save the details object
			//because of the cascadeType.ALL
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
	}

}
