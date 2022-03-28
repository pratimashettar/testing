package com.luv2code.hibernate.demo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			
	        	//start a transaction
	        session.beginTransaction();
			
			//query students
	        List<Student> theStudents=session.createQuery("from Student").getResultList();
	        
	        //display students
	       dispalyStudent(theStudents);
			
		
	     //query students last name 
	      
	         theStudents=session.createQuery("from Student s where s.lastName='shettar' OR s.firstName='priyanka'").getResultList();
	         System.out.println("students who have the last name"); 
	        dispalyStudent(theStudents);
	       
	       //query email like @luv2code.com 
	        theStudents=session.createQuery("from Student s where s.email like '%luv2code.com'").getResultList();
	         System.out.println(" students who have the email id as luv2code"); 
	        dispalyStudent(theStudents);
			//commit transaction
	        session.getTransaction().commit();
		}
finally {
	factory.close();
}
	}

	private static void dispalyStudent(List<Student> theStudents) {
		for (Student student : theStudents) 
	       {
			System.out.println(student);
		}
	}

}
