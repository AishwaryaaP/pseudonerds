package com.AutomatedMeetingBookingSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;

import java.sql.SQLException;

import com.AutomatedMeetingBookingSystem.exception.ConnectionFailedException;
import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.service.BookingInformationService;
import com.AutomatedMeetingBookingSystem.service.MeetingRoomService;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;
import com.AutomatedMeetingBookingSystem.enums.MeetingType;
import com.AutomatedMeetingBookingSystem.utility.DaoUtility;
import com.AutomatedMeetingBookingSystem.utility.DaoUtilityInterface;
import com.mysql.cj.protocol.Resultset.Type;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.stream.Collectors; 

public class MeetingDaoImpl implements MeetingDao {
	
	private static Logger logger;
	private DaoUtilityInterface dao = new DaoUtility();
	private BookingInformationService bookingInformationService = ServiceFactory.getBookingInformationService();
	Connection connection = dao.getInstance();

	public MeetingDaoImpl() {
		LogManager.getLogger(MeetingRoomService.class);
		BasicConfigurator.configure();
	}

	private static final String INSERT_MEETING = "insert into meeting (organizedBy, infoMeetingRoomName, title, date, starttime, endtime, type, listOfMember) values (?,?,?,?,?,?,?,?)";// "insert
	private static final String SELECT_MEETING_BY_MANAGERID = "Select uniqueId, type, infoMeetingRoomName, title, date, startTime, endTime from meeting where organizedBy = ?"; // into
	// meeting
	// values
	// (?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_MEETINGS = "Select * from meeting";
	private static final String SELECT_MEETINGS_BY_DATE = "Select * from meeting where date = ?";
	private static final String SELECT_MEETING_BY_UNIQUEID = "Select * From Meeting where uniqueID = ?";// to be edited

	private static final String UPDATE_MEETING = "UPDATE Meeting SET infoMeetingRoomName=?, title=?, date=?, startTime=?, endTime=?,  type=?, listOfMember=?, WHERE uniqueId=?";
	private static final String DELETE_MEETING_BY_ID = "DELETE FROM Meeting WHERE uniqueId=?";

	public synchronized int createMeeting(int organizedBy, String roomName, String title, LocalDate date, LocalTime startTime,
			LocalTime endTime, String type, String listOfMembers) {
		int id = 0;
		try {
			
			List<String> availableRoomNames = bookingInformationService.getAvailableMeetingRoom(date, startTime, endTime, MeetingType.valueOf(type)).stream().map(m -> m.getRoomName()).collect(Collectors.toList());
			if(availableRoomNames.contains(roomName))
			{


			PreparedStatement statement = connection.prepareStatement(INSERT_MEETING, Statement.RETURN_GENERATED_KEYS);
			// statement.setInt(1, meeting.getUniqueID());
			statement.setInt(1, organizedBy);
			statement.setString(2, roomName);
			statement.setString(3, title);
			statement.setString(4, date.toString());
			statement.setString(5, startTime.toString());
			statement.setString(6, endTime.toString());
			statement.setString(7, type.toString());
			String[] members = listOfMembers.split(" ");
			listOfMembers ="[";
			for ( String member : members) 
				listOfMembers += member + ",";
			listOfMembers = listOfMembers.substring(0,listOfMembers.length()-1);
			listOfMembers += "]";
			statement.setString(8, listOfMembers);
			statement.executeUpdate();

			ResultSet rs = statement.getGeneratedKeys();
			rs.next();
			id = rs.getInt(1);

			if (id != 0) {
				statement.close();
				//connection.commit();
				return id;
			}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.info(e.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			
		}
		return id;
	}

	public Meeting fetchMeetingByUniqueID(int uniqueID) {

		Meeting meeting = new Meeting();
		try {
			PreparedStatement stmt = null;
			try {
				stmt = connection.prepareStatement(SELECT_MEETING_BY_UNIQUEID);
				stmt.setInt(1, uniqueID);

				ResultSet result = stmt.executeQuery();
				result.next();
					meeting.setUniqueID(result.getInt(1));
					meeting.setTitle(result.getString(3));
					meeting.setInfoMeetingRoomName(result.getString(9));

					meeting.setDate(result.getDate(4).toLocalDate());
					meeting.setStartTime(result.getTime(5).toLocalTime());
					meeting.setEndTime(result.getTime(6).toLocalTime());
					meeting.setType(MeetingType.valueOf(result.getString(7)));
					meeting.setListOfMember(result.getString(8));
					meeting.setOrganizedBy(result.getInt(2));

					
				

			} catch (SQLException e) {
				e.printStackTrace();
				logger.info(e.getMessage());
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return meeting;
	}

	public List<Meeting> fetchAllMeetings() {
		
			List<Meeting> meetings = new ArrayList<>();
			try {
				PreparedStatement statement = connection.prepareStatement(SELECT_ALL_MEETINGS);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					Meeting meeting1 = new Meeting();
					meeting1.setUniqueID(rs.getInt(1));
					meeting1.setOrganizedBy(rs.getInt(2));
					meeting1.setInfoMeetingRoomName(rs.getString(9));
					meeting1.setTitle(rs.getString(3));
					meeting1.setDate(rs.getDate(4).toLocalDate());
					meeting1.setStartTime(rs.getTime(5).toLocalTime());
					meeting1.setEndTime(rs.getTime(6).toLocalTime());
					meeting1.setListOfMember(rs.getString(8));
					meeting1.setType(MeetingType.valueOf(rs.getString(7)));
					meetings.add(meeting1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				logger.info(e.getMessage());
			}
			return meetings;
	}

	@Override
	public List<Meeting> fetchMeetingsByManagerID(int managerId) {
		List<Meeting> meetings = new ArrayList<>();
		if (connection != null) {
			try {
				PreparedStatement statement = connection.prepareStatement(SELECT_MEETING_BY_MANAGERID);
				statement.setInt(1, managerId);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					Meeting meeting1 = new Meeting();
					meeting1.setUniqueID(rs.getInt(1));
					meeting1.setType(MeetingType.valueOf(rs.getString(2)));
					meeting1.setInfoMeetingRoomName(rs.getString(3));
					meeting1.setTitle(rs.getString(4));
					meeting1.setDate(rs.getDate(5).toLocalDate());
					meeting1.setStartTime(rs.getTime(6).toLocalTime());
					meeting1.setEndTime(rs.getTime(7).toLocalTime());
					meetings.add(meeting1);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.info(e.getMessage());
			}
		}
		return meetings;
	}

	public boolean updateMeeting(Meeting meeting) {
		if (connection != null) {
			PreparedStatement statement;

			try {
				statement = connection.prepareStatement(UPDATE_MEETING);
				statement.setString(1, meeting.getInfoMeetingRoomName());
				statement.setString(2, meeting.getTitle());
				statement.setString(3, meeting.getDate().toString());
				statement.setString(4, meeting.getStartTime().toString());
				statement.setString(5, meeting.getEndTime().toString());
				statement.setString(6, meeting.getType().toString());
				statement.setString(7, meeting.getListOfMember());

				statement.executeUpdate();
				ResultSet rs = statement.getGeneratedKeys();
				int id = 0;
				while (rs.next()) {
					id = rs.getInt(1);
				}

				if (id != 0) {
					statement.close();
					connection.commit();
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.info(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				logger.info(e.getMessage());
			}
		}
		return false;
	}

	public boolean deleteMeetingByUniqueId(int uniqueId) {
		if (connection != null) {
			PreparedStatement stmt;

			try {
				stmt = connection.prepareStatement(DELETE_MEETING_BY_ID);
				stmt.setInt(1, uniqueId);

				stmt.executeUpdate();
				stmt.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				logger.info(e.getMessage());
				return false;
			}

		}
		return false;
	}

}