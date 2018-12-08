package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		

		// Create a session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {		
			// create 3 students object
			System.out.println("Creating 3 students object...");
			Student student1 = 
					new Student("Christian", "Luzzetti", "christian.luzzetti@gmail.com");
			Student student2 = 
					new Student("Matteo", "La Porta", "MatLaPorta");
			Student student3 = 
					new Student("Franco", "Franchi", "francoFranchi@franch.com");

			
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
	}

}
