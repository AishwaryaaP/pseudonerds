package com.AutomatedMeetingBookingSystem.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;

import com.AutomatedMeetingBookingSystem.model.BookingInformation;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.service.MeetingRoomService;
import com.AutomatedMeetingBookingSystem.utility.DaoUtility;

import org.apache.log4j.BasicConfigurator;  
import org.apache.log4j.LogManager;  
import org.apache.log4j.Logger;  

public class BookingInformationDaoImpl implements BookingInformationDao {

	private static final String INSERT_BOOKING_INFO = "insert into bookinginformation (UniqueId, roomName, date, starttime, endtime, organizedBy) values (?,?,?,?,?,?)";
	private static final String SELECT_AVAILABLE_ROOMS = "SELECT * FROM meetingroom WHERE roomName in (SELECT roomName from meetingroom WHERE amenities LIKE ? and meetingroom.roomName NOT in (SELECT roomName FROM bookinginformation WHERE bookinginformation.date = ? and (?<=bookinginformation.starttime and ?<bookinginformation.endtime and ?>bookinginformation.starttime) or (?>bookinginformation.starttime and ?<bookinginformation.endtime) or (?<bookinginformation.starttime and ?>bookinginformation.endtime) or (?>=bookinginformation.starttime and ?<bookinginformation.endtime and ?>bookinginformation.endtime) or (?=bookinginformation.starttime and ?=bookinginformation.endtime)))";
	
	private static Logger logger;
	Connection connection;
	
	public BookingInformationDaoImpl() {
		 logger = LogManager.getLogger(BookingInformationDaoImpl.class);
		 connection = new DaoUtility().getInstance();
		BasicConfigurator.configure(); 
	}

	@Override

	public boolean saveBookingInformation(BookingInformation bookingInformation){
		if (connection != null) 
		{
			System.out.println("in");
			try {
				PreparedStatement statement = connection.prepareStatement(INSERT_BOOKING_INFO, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, bookingInformation.getUniqueId());
				statement.setString(2, bookingInformation.getRoomName());
				statement.setString(3, bookingInformation.getDate().toString());
				statement.setString(4, bookingInformation.getStartTime().toString());
				statement.setString(5, bookingInformation.getEndTime().toString());
				statement.setInt(6, bookingInformation.getOrganizedBy());
	
				statement.executeUpdate();
					statement.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
				logger.info(e.getMessage());
			}
		}
		return false;
	}

	@Override
	public List<MeetingRoom> getAvailableMeetingRooms(LocalDate meetingDate, LocalTime startTime, LocalTime endTime,
			String amenities) {
		List<MeetingRoom> meetingRooms = new ArrayList<>();
		if (connection != null) 
		{
			PreparedStatement stmt=null;

			try {
				stmt = connection.prepareStatement(SELECT_AVAILABLE_ROOMS);
				stmt.setString(1, amenities);
				stmt.setString(2, meetingDate.toString());
				stmt.setString(3, startTime.toString());
				stmt.setString(4, endTime.toString());
				stmt.setString(5, endTime.toString());
				stmt.setString(6, startTime.toString());
				stmt.setString(7, endTime.toString());
				stmt.setString(8, startTime.toString());
				stmt.setString(9, endTime.toString());
				stmt.setString(10, startTime.toString());
				stmt.setString(11, startTime.toString());
				stmt.setString(12, endTime.toString());
				stmt.setString(13, startTime.toString());
				stmt.setString(14, endTime.toString());

				
				ResultSet result = stmt.executeQuery();
				while(result.next())
				{
					MeetingRoom room = new MeetingRoom();
					Set<String> aminitySet = new HashSet<>();
					room.setRoomId(result.getInt(6));
					room.setRoomName(result.getString(1));
					room.setSeatingCapacity(result.getInt(2));
					room.setRating(result.getDouble(3));
					room.setRatingSum(result.getInt(7));
					room.setRatingCount(result.getInt(8));
					room.setCreditPerHour(result.getInt(5));
					String aminitiesStr = result.getString(4);
					room.setCount(result.getInt(9));

					/*
					 * String[] amininityArray = aminitiesStr.split(" "); for(String aminityItr :
					 * amininityArray) { aminitySet.add(aminityItr); }
					 */
					room.setAmenities(aminitiesStr);

					meetingRooms.add(room);
					aminitySet.clear();

				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.info(e.getMessage());
			}
			finally
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
					logger.info(e.getMessage());
				}
			}

		}
		return meetingRooms;
	}
	
	@Override
	public boolean deleteBookingInfo(int uniqueId, LocalDate date, LocalTime startTime) {
		if (connection != null) 
		{
			PreparedStatement stmt=null;

			try {
				stmt = connection.prepareStatement("delete from bookinginformation where uniqueid=? and date=? and starttime=?;");
				stmt.setInt(1, uniqueId);
				stmt.setString(2, date.toString());
				stmt.setString(3, startTime.toString());
				
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