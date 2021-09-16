package com.app.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBUtility {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(Driver.class.getName());
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/amrbs", "root", "1234");
		return connection;
	}
}
