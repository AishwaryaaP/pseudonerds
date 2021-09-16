package com.AutomatedMeetingRoomSystem.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ObjectFactory {
	private static Connection conn;
	public static final String dbURL = "jdbc:mysql://localhost:3306/DB";
	public static final String username = "root";
	public static final String password = "root";

	private ObjectFactory() {
	}

	public static Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(dbURL, username, password);

			} catch (SQLException e) {
				System.out.println("Exception in the Object Facyory:" + e.getMessage());
			}

		}
		return conn;

	}
}
