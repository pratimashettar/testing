package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) 
	{
	String jdbcurl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
String user="hbstudent";
String pass="hbstudent";
try {
	
	System.out.println("connecting to database:" +jdbcurl);
	Connection myconn=DriverManager.getConnection(jdbcurl, user, pass);
	System.out.println("connection successful");
}
catch(Exception exc)
{
	exc.printStackTrace();
	
}
	}

}

