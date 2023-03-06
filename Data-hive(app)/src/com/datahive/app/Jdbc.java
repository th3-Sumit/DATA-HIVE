package com.datahive.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Jdbc {
	String uname,firstname,lastname,gender,city,state;
	int age;
	          
	     Jdbc(String username,String firstname, String lastname, int age, String gender, String city, String state){
	    	 this.uname = username;
	    	 this.firstname = firstname;
	    	 this.lastname=lastname;
	    	 this.age = age;
	    	 this.gender = gender;
	    	 this.city = city;
	    	 this.state = state;
	    	 
	    
	    	 
//JDBC CODE	    	 
	    	 
	    	 Connection conn = null;
		        String url = "jdbc:mysql://localhost:3306/datahive";
		        String userId = "root";
		        String password = "123456";
		        
		        try{
	                //Register JDBC Driver
//	                Class.forName("com.mysql.jdbc.Driver");

	                //Open a connection
	                System.out.println("Connecting to database plz wait....!!");
	                conn = DriverManager.getConnection(url, userId, password);

//	                //Creating a table in datahive database
//	                String q = "create table Details(USERNAME varchar(20) not null, First_Name varchar(20) not null, Last_Name varchar(20), Age int(3) not null, Gender varchar(10) not null, City varchar(20) not null,  State varchar(20) not null)";
//	                Statement stmt = conn.createStatement();
//                    stmt.executeUpdate(q);

	                //inserting data to details table
	                String d = "insert into Details(USERNAME,First_Name, Last_Name, Age , Gender, City, State) values(?,?, ?, ?, ?, ?, ?)";
	                PreparedStatement pstmt = conn.prepareStatement(d);

	                //set the value to the query
	                pstmt.setString(1, username);
	                pstmt.setString(2, firstname);
	                pstmt.setString(3, lastname);
	                pstmt.setInt(4, age);
	                pstmt.setString(5, gender);
	                pstmt.setString(6, city);
	                pstmt.setString(7, state);
	                pstmt.executeUpdate();
	                
//calling thankyou class
	               new thankyou(username);
	                
	                
	                
	                
	                System.out.println("Data saved successfully..!");
	                conn.close();


	            } catch (SQLException ex) {
	                throw new RuntimeException(ex);
	            }
 	 
	    	 
	     }
	
	 void sucessFrame() {
		 
	 }
	
	
	public static void main(String args[]) {
		Jdbc j = new Jdbc("N/A","N/A", "N/A", 0, "N/A", "N/A", "N/A");
	}

}
