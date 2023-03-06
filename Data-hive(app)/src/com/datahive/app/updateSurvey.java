package com.datahive.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateSurvey {
	
	
	String username,firstname,lastname,gender,city,state;
	int age;
	
	 updateSurvey(String username,String firstname, String lastname, int age, String gender, String city, String state) {
		
	      this.username = username;
   	      this.firstname = firstname;
   	      this.lastname=lastname;
   	      this.age = age;
   	      this.gender = gender;
   	      this.city = city;
   	      this.state = state;
   	      
//calling class to fill details again   	      
		 
   	 Connection conn = null;
	        String url = "jdbc:mysql://localhost:3306/datahive";
	        String userId = "root";
	        String password = "123456";
	        
	        try{
               //Register JDBC Driver
//               Class.forName("com.mysql.jdbc.Driver");

//Open a connection
               System.out.println("Connecting to database plz wait....!!");
               conn = DriverManager.getConnection(url, userId, password);
               
               String d = "UPDATE details  SET First_Name=?, Last_Name=?, Age=? , Gender=?, City=?, State=? WHERE USERNAME=?";
               PreparedStatement pstmt = conn.prepareStatement(d);
               
               
               pstmt.setString(1, firstname);
               pstmt.setString(2, lastname);
               pstmt.setInt(3, age);
               pstmt.setString(4, gender);
               pstmt.setString(5, city);
               pstmt.setString(6, state);
               pstmt.setString(7, username);
               pstmt.executeUpdate();

//set the value to the query
               pstmt.setString(1, username);
               pstmt.executeUpdate();
   
               conn.close();
               
               System.out.println("UPDATED");
               new thankyou(username);
               

           } catch (SQLException ex) {
               throw new RuntimeException(ex);
           }
		
	}
	
	

	public static void main(String[] args) {
		new updateSurvey("N/A","N/A", "N/A", 0, "N/A", "N/A", "N/A");

	}

}
