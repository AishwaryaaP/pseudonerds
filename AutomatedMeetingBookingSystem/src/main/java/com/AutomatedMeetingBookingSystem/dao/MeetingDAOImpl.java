package com.AutomatedMeetingBookingSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
	
	public Meeting createMeeting(Meeting meeting) throws ConnectionFailedException {
		if (connection != null) 
		{
			try {
				PreparedStatement statement = connection.prepareStatement(INSERT_MEETING);
				//statement.setInt(1, meeting.getUniqueID());
				statement.setInt(1, meeting.getOrganizedBy());
				statement.setString(2, meeting.getInfoMeetingRoomName());
				statement.setString(3, meeting.getTitle());
				statement.setString(4, meeting.getDate().toString());
				statement.setString(5, meeting.getStarttime().toString());
				statement.setString(6, meeting.getEndtime().toString());
			    statement.setString(7, meeting.getType().toString());
			    
				int recordsUpdated = statement.executeUpdate();
				
				if (recordsUpdated > 0) {
					connection.commit();
					return meeting;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		throw new ConnectionFailedException("While meeting creation");
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