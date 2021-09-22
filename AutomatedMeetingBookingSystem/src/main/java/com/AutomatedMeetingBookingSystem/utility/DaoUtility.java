package com.AutomatedMeetingBookingSystem.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoUtility implements DaoUtilityInterface{

	private static Connection obj;
	 
    public DaoUtility() {}
 
    public synchronized Connection getInstance()
    {
    	try {
	        if (obj==null) {
	        	Class.forName("com.mysql.jdbc.Driver");  	        	
	            obj = DriverManager.getConnection("jdbc:mysql://localhost:3306/meetingsystem","root","Mohitt@13");
	        }
    	}
    	catch(Exception e) {
    		System.err.println(e.getMessage());
    	}
            
        return obj;
    }
}
