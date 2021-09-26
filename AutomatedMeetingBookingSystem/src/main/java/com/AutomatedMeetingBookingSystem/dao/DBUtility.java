package com.AutomatedMeetingBookingSystem.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBUtility {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(Driver.class.getName());
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/meetingsystem", "root", "Mohitt@13");
		return connection;
	}
}
