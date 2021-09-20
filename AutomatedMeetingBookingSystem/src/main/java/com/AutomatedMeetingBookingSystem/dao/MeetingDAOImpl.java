package com.AutomatedMeetingBookingSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.AutomatedMeetingBookingSystem.exception.ConnectionFailedException;
import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.utility.DatabaseUtils;

public class MeetingDAOImpl implements MeetingDAO {

	Connection connection = DatabaseUtils.getConnection();

	private static final String INSERT_MEETING = "insert into meeting (uniqueID, organizedBy, infoOfMeeting, title, date, starttime, endtime, type) values (?,?,?,?,?,?,?,?)";
	private static final String SELECT_MEETINGS_BY_USERID = "Select * where userID belongs to listOfMember  ";// to be edited
	private static final String SELECT_MEETING_BY_UNIQUEID = "Select * From Meeting where uniqueID = ?";//to be edited
	public Meeting createMeeting(Meeting meeting) throws ConnectionFailedException {
		if (connection != null) 
		{
			try {
				PreparedStatement statement = connection.prepareStatement(INSERT_MEETING);
				statement.setInt(1, meeting.getUniqueID());
				statement.setInt(2, meeting.getOrganizedBy());
				statement.setString(3, meeting.getInfoOfMeeting());
				statement.setString(4, meeting.getTitle());
				statement.setString(5, meeting.getDate().toString());
				statement.setString(6, meeting.getStarttime().toString());
				statement.setString(7, meeting.getEndtime().toString());
			    statement.setString(8, meeting.getType().toString());
				//statement.setString(9, meeting.getBooking().getuID());

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

	public static String getInsertMeeting() {
		return INSERT_MEETING;
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

	public List<Integer> fetchMeetingsByUserID(int userID) throws ConnectionFailedException {
		if (connection != null) {
			List<Integer> meetings = new ArrayList<>();
			try {
				PreparedStatement statement = connection.prepareStatement(SELECT_MEETINGS_BY_USERID);
				statement.setInt(1, userID);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					meetings.add(rs.getInt("userID"));
				}
				return meetings;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		throw new ConnectionFailedException("While fetching meetings by userID");
	}
	}