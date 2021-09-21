package com.AutomatedMeetingBookingSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.AutomatedMeetingBookingSystem.exception.ConnectionFailedException;
import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.MeetingType;
import com.AutomatedMeetingBookingSystem.utility.DatabaseUtils;

public class MeetingDAOImpl implements MeetingDAO {

	Connection connection = DatabaseUtils.getConnection();

	private static final String INSERT_MEETING = "insert into meeting (organisedBy, infoMeetingRoomName, title, date, starttime, endtime, type, listOfMember) values (?,?,?,?,?,?,?,?)";// "insert into meeting values (?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_MEETINGS_BY_USERID = "Select * from meeting where userID ";// to be edited
	private static final String SELECT_MEETINGS_BY_DATE = "Select * from meeting where date = ?";
	private static final String SELECT_MEETING_BY_UNIQUEID = "Select * From Meeting where uniqueID = ?";//to be edited
	
	public Meeting createMeeting(int organizedBy, String roomName, String title, LocalDate date, LocalTime startTime, LocalTime endTime, String type, String listOfMembers) throws ConnectionFailedException {
		if (connection != null) 
		{
			try {
				PreparedStatement statement = connection.prepareStatement(INSERT_MEETING, Statement.RETURN_GENERATED_KEYS);
				//statement.setInt(1, meeting.getUniqueID());
				statement.setInt(1, organisedBy);
				statement.setString(2, roomName);
				statement.setString(3, title);
				statement.setString(4, date.toString());
				statement.setString(5, startTime.toString());
				statement.setString(6, endTime.toString());
			    statement.setString(7, type.toString());
				statement.setString(8, listOfMembers);
			    
				ResultSet rs = statement.getGeneratedKeys();
				int id = 0;
				while(rs.next()) {
					id = rs.getInt(1);
				}

				if (id != 0) {
					statement.close();
					connection.commit();
					return fetchMeetingByUniqueID(id);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		throw new ConnectionFailedException("Error while meeting creation");
	}



	public Meeting fetchMeetingByUniqueID(int uniqueID) throws ConnectionFailedException {
		if (connection != null) {
			try {
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		throw new ConnectionFailedException("While fetching meetings by uniqueID");
	}
	
	public List<Meeting> fetchMeetingsByUserID(int userID) throws ConnectionFailedException {
		if (connection != null) {
			List<Meeting> meetingSchedule = new ArrayList<>();
			try {
				PreparedStatement statement = connection.prepareStatement(SELECT_MEETINGS_BY_USERID);
				statement.setInt(1, userID);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					Meeting meeting1;
					meeting1.setUniqueID(rs.getInt(1));
					meeting1.setOrganizedBy(rs.getInt(2));
					meeting1.setInfoMeetingRoomName(rs.getString(3));
					meeting1.setTitle(rs.getString(4));
					meeting1.setDate(rs.getDate(5).toLocalDate());
					meeting1.setStarttime(rs.getTime(6).toLocalTime());
					meeting1.setEndtime(rs.getTime(7).toLocalTime());
					meeting1.setListOfMember(rs.getString(8));
					//meeting1.setType(rs.getString(9).toMeetingType());
					meeting1.type.valueOf(rs.getString(9));
					meetingSchedule.add(meeting1);
				}
				return meetingSchedule;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		throw new ConnectionFailedException("While fetching meetings by userID");
	}
  
  
}