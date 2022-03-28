package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			//create student object
			System.out.println("creating a new student object......");
	        Student student =new Student("paul","wall", "paul@luv2code.com");
	       // Student student1 =new Student("priyanka","shettar", "shettar@luv2code.com");
	        //Student student2 =new Student("sanjana","math", "math@luv2code.com");
	        
	        	//start a transaction
	        session.beginTransaction();
			
			//save the student object
	        System.out.println("saving the student");
	        session.save(student);
			
			//commit transaction
	        session.getTransaction().commit();
		}
finally {
	factory.close();
}
	}

}
