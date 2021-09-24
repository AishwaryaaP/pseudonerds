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
	private static final String SELECT_AVAILABLE_ROOMS = "SELECT * FROM meetingroom WHERE roomName in  (SELECT InfoMeetingRoomName FROM meeting WHERE meeting.date = ? and meeting.starttime < ? and meeting.endtime > ? UNION SELECT roomName from meetingroom WHERE amenities LIKE ?)";
	
	private static Logger logger;
	Connection connection;
	
	public BookingInformationDaoImpl() {
		 logger = LogManager.getLogger(BookingInformationDaoImpl.class);
		 connection = new DaoUtility().getInstance();
		BasicConfigurator.configure(); 
	}

	@Override
	public void saveBookingInformation(BookingInformation bookingInformation){
		
		if (connection != null) 
		{
			try {
				PreparedStatement statement = connection.prepareStatement(INSERT_BOOKING_INFO, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, bookingInformation.getUniqueId());
				statement.setString(2, bookingInformation.getRoomName());
				statement.setString(4, bookingInformation.getDate().toString());
				statement.setString(5, bookingInformation.getStartTime().toString());
				statement.setString(6, bookingInformation.getEndTime().toString());
				statement.setInt(7, bookingInformation.getOrganizedBy());
	
				ResultSet rs = statement.getGeneratedKeys();
				int id = 0;
				while(rs.next()) {
					id = rs.getInt(1);
				}
	
				if (id != 0) {
					statement.close();
					connection.commit();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				logger.info(e.getMessage());
			}
		}
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
				stmt.setString(1, meetingDate.toString());
				stmt.setString(2, startTime.toString());
				stmt.setString(3, endTime.toString());
				stmt.setString(4, amenities);
				ResultSet result = stmt.executeQuery();
				while(result.next())
				{
					MeetingRoom room = new MeetingRoom();
					Set<String> aminitySet = new HashSet<>();
					room.setRoomId(result.getInt(1));
					room.setRoomName(result.getString(2));
					room.setSeatingCapacity(result.getInt(3));
					room.setRating(result.getDouble(4));
					room.setRatingSum(result.getInt(5));
					room.setRatingCount(result.getInt(6));
					room.setCreditPerHour(result.getInt(7));
					String aminitiesStr = result.getString(8);
					room.setCount(result.getInt(9));

					String[] amininityArray = aminitiesStr.split(" ");
					for(String aminityItr : amininityArray)
					{
						aminitySet.add(aminityItr);
					}
					room.setAmenities(aminitySet);
					meetingRooms.add(room);
					aminitySet.clear();

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return meetingRooms;
	}


}
