package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// Create a session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = factory.getCurrentSession();
		
		try {		
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents =
					session.createQuery("from Student").getResultList();
			
			// Display the students
			displayStudents(theStudents);
			
			// query students: lastname="luzzetti"
			theStudents =
					session.createQuery("from Student s where s.lastName='Luzzetti'").getResultList();

			// Display the students
			System.out.println("\n\nStudent who have last name of Luzzetti");
			displayStudents(theStudents);
			
			
			// query students: lastName='Luzzetti' OR firstname='Daffy'
			theStudents =
					session.createQuery("from Student s where"
							+ " s.lastName='Luzzetti' OR s.firstName='Daffy'").getResultList();
			
			// Display students with Daffy or Luzzetti
			System.out.println("\n\nStudents with name Daffy or lastname Luzzetti:");
			displayStudents(theStudents);

			
			theStudents =
					session.createQuery("from Student s where"
							+ " s.lastName LIKE '_uzzetti'").getResultList();
			
			// Display _uzzetti 
			System.out.println("\n\nDisplay students with lastname _uzzetti");
			displayStudents(theStudents);
			
			
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		// Display the students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
