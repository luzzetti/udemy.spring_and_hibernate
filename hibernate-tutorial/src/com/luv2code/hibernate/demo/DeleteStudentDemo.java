package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// Create a session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {		
			
			int studentID = 9;
			
			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentID);
			
			Student myStudent = session.get(Student.class, studentID);			
			
			// Delete the student
			System.out.println("Deleting student: " + myStudent);
			session.delete(myStudent);
			
			// Delete students
			System.out.println("\n\nDeleting more students: ");
			session.createQuery("delete from Student where id=12")
			.executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			
			
			System.out.println("Done!");
		
		} catch (Exception exc) {
			exc.printStackTrace();
			
		} finally {
			factory.close();
		}
		
	}

}
