package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// Create a session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {		
			
			int studentID = 7;
			
			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentID);
			
			Student myStudent = session.get(Student.class, studentID);			
			
			System.out.println("Updating Student...");
			myStudent.setFirstName("Fracchia");
			
			// commit the transaction
			session.getTransaction().commit();
			
			
			//NEW CODE
			
			// Bulk update
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Update email for all the christian luzzetti
			System.out.println("Update email for all the christian luzzetti");
			
			session.createQuery("update Student s set email='christian.luzzetti@gmail.com' where s.firstName='Christian' AND s.lastName='Luzzetti'")
			.executeUpdate();
			
			
			
			//Commit transaction
			session.getTransaction().commit();
						
			
			System.out.println("Done!");
		
		} catch (Exception exc) {
			exc.printStackTrace();
			
		} finally {
			factory.close();
		}
		
	}

}
