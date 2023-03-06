package com.datahive.app;

import java.sql.*;


public class DelSurvey {
	String username;
	
	 DelSurvey(String username) {
		 this.username = username;
		 
    	 Connection conn = null;
	        String url = "jdbc:mysql://localhost:3306/datahive";
	        String userId = "root";
	        String password = "123456";
	        
	        try{
                //Register JDBC Driver
//                Class.forName("com.mysql.jdbc.Driver");

//Open a connection
                System.out.println("Connecting to database plz wait....!!");
                conn = DriverManager.getConnection(url, userId, password);
                
                String d = "DELETE FROM details WHERE USERNAME = ?";
                PreparedStatement pstmt = conn.prepareStatement(d);

//set the value to the query
                pstmt.setString(1, username);
                pstmt.executeUpdate();
                System.out.println("Data DELETED successfully..!");
                conn.close();
                

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
	        new thankyou(username);
	 
		
	}

	public static void main(String[] args) {
		DelSurvey d = new DelSurvey("");

	}

}
