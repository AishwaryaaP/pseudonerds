
package com.AutomatedMeetingBookingSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AutomatedMeetingBookingSystem.exception.ConnectionFailedException;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.utility.DaoUtility;
import com.AutomatedMeetingBookingSystem.utility.DaoUtilityInterface;

public class UserDaoImpl implements UserDao{

//	public List<MeetingRoom> getAllRooms(){
//		
//	}
//	
//	public boolean deleteRoom(MeetingRoom obj) {
//		
//	}
	
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
					u.setCredit(Integer.parseInt(rs.getString(5)));
					u.setRole(rs.getString(6));
					allUser.add(u);
				}

				statement.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return allUser;
		
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
		try {
			Connection connection = new DaoUtility().getInstance();
			PreparedStatement statement = connection.prepareStatement("Update user set credit=? where UserID = ?");
			statement.setDouble(1, credits);
			statement.setInt(2, userId);
			statement.executeUpdate();
			statement.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
