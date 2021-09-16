package com.AutomatedMeetingBookingSystem.utility;

public class ConnectionManager {

	public static Connection getConnection() {
		Connection connection = null;
		if (connection != null)
			return connection;
		else
		{
			try
			{

				Properties prop = new Properties();
				InputStream inputStream = new FileInputStream("config.properties.txt");
				prop.load(inputStream);
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
    
			}
			catch (ClassNotFoundException e){
				e.printStackTrace();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}	
			return connection;
		}
	}
}