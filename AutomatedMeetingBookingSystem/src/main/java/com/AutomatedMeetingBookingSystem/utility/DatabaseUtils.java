package com.AutomatedMeetingBookingSystem.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import com.AutomatedMeetingBookingSystem.model.Meeting.meetingType;

public class DatabaseUtils {
	/**
	 * 
	 * @return Connection object to get connection instance to database
	 */
	
	public static Connection getConnection()
	{
		Connection conn=null;
		try {
			
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		    conn=DriverManager.getConnection("jdbc:derby://localhost:1527/RoomBooking2");
			
		} 
		
		catch (ClassNotFoundException e) {
		
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return conn;
	}
}