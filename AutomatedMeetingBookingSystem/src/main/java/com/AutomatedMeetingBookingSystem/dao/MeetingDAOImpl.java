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
import com.AutomatedMeetingBookingSystem.enums.MeetingType;
import com.AutomatedMeetingBookingSystem.utility.DaoUtility;
import com.AutomatedMeetingBookingSystem.utility.DaoUtilityInterface;
import com.mysql.cj.protocol.Resultset.Type;

public class MeetingDAOImpl implements MeetingDAO {

	DaoUtilityInterface dao = new DaoUtility();
	Connection connection = dao.getInstance();

	private static final String INSERT_MEETING = "insert into meeting (organisedBy, infoMeetingRoomName, title, date, starttime, endtime, type, listOfMember) values (?,?,?,?,?,?,?,?)";// "insert
																																														// into
																																														// meeting
																																														// values
																																														// (?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_MEETINGS = "Select * from meeting";
	private static final String SELECT_MEETINGS_BY_DATE = "Select * from meeting where date = ?";
	private static final String SELECT_MEETING_BY_UNIQUEID = "Select * From Meeting where uniqueID = ?";// to be edited

	public int createMeeting(int organizedBy, String roomName, String title, LocalDate date, LocalTime startTime,
			LocalTime endTime, String type, String listOfMembers) throws ConnectionFailedException {
		int id = 0;
		try {

			PreparedStatement statement = connection.prepareStatement(INSERT_MEETING, Statement.RETURN_GENERATED_KEYS);
			// statement.setInt(1, meeting.getUniqueID());
			statement.setInt(1, organizedBy);
			statement.setString(2, roomName);
			statement.setString(3, title);
			statement.setString(4, date.toString());
			statement.setString(5, startTime.toString());
			statement.setString(6, endTime.toString());
			statement.setString(7, type.toString());
			statement.setString(8, listOfMembers);
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();

			id = rs.getInt(1);

			if (id != 0) {
				statement.close();
				connection.commit();
				return id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public Meeting fetchMeetingByUniqueID(int uniqueID) throws ConnectionFailedException {

		Meeting meeting = new Meeting();
		try {
			PreparedStatement stmt=null;
			 try {
					stmt = connection.prepareStatement(SELECT_MEETING_BY_UNIQUEID);
					stmt.setInt(1, uniqueID);

					ResultSet result = stmt.executeQuery();
					while(result.next())
					{
						meeting.setUniqueID(result.getInt(1));
						meeting.setTitle(result.getString(2));
						
						meeting.setDate(result.getDate(3).toLocalDate());
						meeting.setStartTime(result.getTime(4).toLocalTime());
						meeting.setEndTime(result.getTime(5).toLocalTime());
						meeting.setType(MeetingType.valueOf(result.getString(6)));
						meeting.setListOfMember(result.getString(7));
						meeting.setOrganizedBy(uniqueID);
						return meeting;
					}

				}
				catch (SQLException e) {
					e.printStackTrace();
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return meeting;
	}

	public List<Meeting> fetchAllMeetings() throws ConnectionFailedException {
		if (connection != null) {
			List<Meeting> meetings = new ArrayList<>();
			try {
				PreparedStatement statement = connection.prepareStatement(SELECT_ALL_MEETINGS);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					Meeting meeting1 = new Meeting();
					meeting1.setUniqueID(rs.getInt(1));
					meeting1.setOrganizedBy(rs.getInt(2));
					meeting1.setInfoMeetingRoomName(rs.getString(3));
					meeting1.setTitle(rs.getString(4));
					meeting1.setDate(rs.getDate(5).toLocalDate());
					meeting1.setStartTime(rs.getTime(6).toLocalTime());
					meeting1.setEndTime(rs.getTime(7).toLocalTime());
					meeting1.setListOfMember(rs.getString(8));
					meeting1.setType(MeetingType.valueOf(rs.getString(9)));
					meetings.add(meeting1);
				}
				return meetings;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		throw new ConnectionFailedException("While fetching meetings by userID");
	}


	
}