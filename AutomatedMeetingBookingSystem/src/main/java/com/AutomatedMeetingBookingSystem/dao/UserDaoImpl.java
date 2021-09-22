
package com.AutomatedMeetingBookingSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
	public User getUserDetails(int userId, String password) {
		DaoUtilityInterface dao = new DaoUtility();
		Connection conn = dao.getInstance();
	
			User u;
			try
			{
				PreparedStatement ps = conn.prepareStatement ( "select userId, name, email, phone, credit, role from User where userId = ? and password = ?");
				ps.setInt ( 1, userId );
				ps.setString ( 2, password );
				ResultSet rs = ps.executeQuery ();
				while(rs.next())
				{
					u.setUserId(Integer.parseInt(rs.getString(1)));
					u.setName(rs.getString(2));
					u.setEmail(rs.getString(3));
					u.setPhoneNumber(rs.getString(4));
					u.setCredit(Integer.parseInt(rs.getString(5)));
					u.setRole(rs.getString(6));
				}
			}catch(Exception e) {

				System.out.println(e);
			}
			
			return u;

			
	}
	public List<User> getAllUser()
	{
		DaoUtilityInterface dao = new DaoUtility();
		Connection conn = dao.getInstance();
			List<User> allUser = new ArrayList<>();
			try {
				PreparedStatement statement = conn.prepareStatement("select * from user");
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					User u;
					u.setUserId(Integer.parseInt(rs.getString(1)));
					u.setName(rs.getString(2));
					u.setEmail(rs.getString(3));
					u.setPhoneNumber(rs.getString(4));
					u.setCredit(Integer.parseInt(rs.getString(5)));
					u.setRole(rs.getString(6));
					allUser.add(u);
				}
				return allUser;
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
}
