package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			  //create student object
			  System.out.println("creating a new student object......"); 
			  Student student =new Student("dany","denny", "saw@luv2code.com"); 
				/*
				 * Student student1 =new Student("priyanka","shettar", "shettar@luv2code.com");
				 * Student student2 =new Student("sanjana","math", "math@luv2code.com");
				 */
			  
			  //start a transaction 
			  session.beginTransaction();
			  
			  //save the student object 
			  System.out.println("saving the student");
			  session.save(student); 
			  //session.save(student1);
			 // session.save(student2);
			  
			  
			  //commit transaction 
			  session.getTransaction().commit();
			  
			  //retrieve the object // 
			 // Student thestudent= session.get(Student.class, student.getId()); 
			  System.out.println("get the student: " + student.getId());
				System.out.println("retrieved student is here1!!!" + student);
			  System.out.println("object retrieved");
			  
			  
			 
		//get new session ad start the ew transaction
		session=factory.getCurrentSession();
		session.beginTransaction();
		
		//retrieve student based on the id
		System.out.println("get the student: " + student.getId());
		Student mystudent= session.get(Student.class, student.getId());
		System.out.println("retrieved student is here!!!" + student);
		 System.out.println("object retrieved");
		 
		 session.getTransaction().commit();
		}
		
finally {
	factory.close();
}
	}

}