
package com.AutomatedMeetingBookingSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.MeetingRoomService;
import com.AutomatedMeetingBookingSystem.utility.DaoUtility;
import com.AutomatedMeetingBookingSystem.utility.DaoUtilityInterface;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class UserDaoImpl implements UserDao{
	private static Logger logger;
	public UserDaoImpl() {
      // PropertyConfigurator.configure("log4j.properties");
       logger = LogManager.getLogger(MeetingRoomService.class);
	BasicConfigurator.configure();

	}
	

	
	
	public List<User> getAllUser()
	{
		DaoUtilityInterface dao = new DaoUtility();
		Connection conn = dao.getInstance();
		List<User> allUser = new ArrayList<>();
		if (conn != null)
		{
			
			try {
				PreparedStatement statement = conn.prepareStatement("select * from user");
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					User u = new User();
					u.setUserId(Integer.parseInt(rs.getString(1)));
					u.setName(rs.getString(2));
					u.setEmail(rs.getString(3));
					u.setPhoneNumber(rs.getString(4));
					u.setCredit(Double.parseDouble(rs.getString(5)));
					u.setRole(rs.getString(6));
					allUser.add(u);
				}

				statement.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				logger.info(e.getMessage());
			}
			
		}
		return allUser;
		
	}
	@Override
	public User getUserByNameAndEmail(int userId, String email)
	{
		DaoUtilityInterface dao = new DaoUtility();
		Connection conn = dao.getInstance();
		User u = null;
		if (conn != null)
		{
			
			try {
				PreparedStatement statement = conn.prepareStatement("select userId,name,email,phone,credit,role, lastloggedin from user where userId =? and email =?;");
				statement.setInt(1, userId);
				statement.setString(2, email);
				System.out.println(statement.toString());
				ResultSet rs = statement.executeQuery();
				if(rs != null) {
					rs.next();
					u = new User();
					u.setUserId(rs.getInt(1));
					u.setName(rs.getString(2));
					u.setEmail(rs.getString(3));
					u.setPhoneNumber(rs.getString(4));
					u.setCredit(rs.getInt(5));
					u.setRole(rs.getString(6));
					u.setLastLoggedIn(Timestamp.valueOf(rs.getString(7)));
					System.out.println(rs.getString(6));
				}
				System.out.println(u.toString());
				statement.close();
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
				logger.info(e.getMessage());
				return null;
				}
			
		}
		return u;
		
	}
	

	@Override
	public double getUserCredits(int userId) {
		double credits = 0;
		try {
			Connection connection = new DaoUtility().getInstance();
			PreparedStatement statement = connection.prepareStatement("select credit from user where UserID = ?");
			statement.setInt(1, userId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				credits = rs.getDouble(1);
			}

			statement.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return credits;
	}

	@Override
	public void updateUserCredits(double credits, int userId) {
		System.out.println("koko");
		try {
			Connection connection = new DaoUtility().getInstance();
			PreparedStatement statement = connection.prepareStatement("Update user set credit=? where UserID = ?");
			statement.setDouble(1, credits);
			statement.setInt(2, userId);
			statement.executeUpdate();
			statement.close();
			System.out.println("okok");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			logger.info(e.getMessage());
		}
	}

	@Override
	public void resetManagerCredits() {
		try {
			Connection connection = new DaoUtility().getInstance();
			PreparedStatement statement = connection.prepareStatement("Update user set credit=2000 where role = ?");
			statement.setString(1, "MANAGER");
			statement.executeUpdate();
			statement.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			logger.info(e.getMessage());
		}
	}
	
	@Override
	public boolean addUsers(ArrayList<User> userList) {
		for(User user : userList) {
			DaoUtilityInterface dao = new DaoUtility();
			Connection conn = dao.getInstance();
			
			if (conn != null)
			{
				
				try {
					PreparedStatement statement = conn.prepareStatement("INSERT INTO meetingsystem.user(name,email,phone,role)VALUES(?,?,?,?);");
					//statement.setInt(1, user.getUserId());
					statement.setString(1, user.getName());
					statement.setString(2, user.getEmail());
					statement.setString(3, user.getPhoneNumber());
					//statement.setDouble(5, user.getCredit());
					statement.setString(4, user.getRole());


					int rs = statement.executeUpdate();
					if(rs==0) {
						//Exception
						return false;
					}

					statement.close();
					
				} catch (Exception e) {
					e.printStackTrace();
					logger.info(e.getMessage());
				}
				
			}
		}
		return true;
	}
	@Override
	public void setLastLoggedIn(int userId) {
		try {
			Connection connection = new DaoUtility().getInstance();
			PreparedStatement statement = connection.prepareStatement("Update user set lastloggedin=? where userId = ?");
			String currentTime = new Timestamp(System.currentTimeMillis()).toString();
			currentTime = currentTime.substring(0, currentTime.length() - 4);
			statement.setString(1, currentTime);
			statement.setInt(2, userId);
			statement.executeUpdate();
			statement.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			logger.info(e.getMessage());
		}
	}


}
