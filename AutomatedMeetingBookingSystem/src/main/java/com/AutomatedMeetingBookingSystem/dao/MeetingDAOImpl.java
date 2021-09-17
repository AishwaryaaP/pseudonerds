package com.AutomatedMeetingBookingSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.AutomatedMeetingBookingSystem.exceptions.ConnectionFailedException;
import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.utility.DatabaseUtils;

public class MeetingDAOImpl implements MeetingDAO {

	Connection connection = DatabaseUtils.getConnection();

	private static final String INSERT_MEETING = "insert into meeting (organiser, roomName, meetingTitle, date, starttime, endtime, type) values (?,?,?,?,?,?,?)";
	private static final String SELECT_MEETING_BY_USERID = "Enter list_of_people where  = ?";
	private static final String SELECT_MEETING_BY_MEETINGID = "";
	public Meeting createMeeting(Meeting meeting) throws ConnectionFailedException {
		if (connection != null) 
		{
			try {
				PreparedStatement statement = connection.prepareStatement(INSERT_MEETING);
				statement.setInt(1, meeting.getOrganisedBy());
				statement.setString(2, meeting.getRoomName());
				statement.setString(3, meeting.getMeetingTitle());
				statement.setString(4, meeting.getDate().toString());
				statement.setString(5, meeting.getStarttime().toString());
				statement.setString(6, meeting.getEndtime().toString());
			    statement.setString(7, meeting.getType().toString());
				//statement.setString(8, meeting.getBooking().getuID());

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

	public Collection<String> fetchMeetingsByUserId(String userId) throws ConnectionFailedException {
		if (connection != null) {
			List<String> meetings = new ArrayList<>();
			try {
				PreparedStatement statement = connection.prepareStatement(SELECT_MEETING_BY_USERID);
				statement.setString(1, userId);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					meetings.add(rs.getString("uid"));
				}
				return meetings;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		throw new ConnectionFailedException("While fetching meetings by userId");
	}

	public Meeting fetchMeetingByMeetingId(String meetingId) throws ConnectionFailedException {
		if (connection != null) {
			try {
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		throw new ConnectionFailedException("While fetching meetings by meetingId");
	}
	}