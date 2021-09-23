package com.AutomatedMeetingBookingSystem.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import org.apache.log4j.BasicConfigurator;  
import org.apache.log4j.LogManager;  
import org.apache.log4j.Logger;  

public class BookingInformationDaoImpl implements BookingInformationDao {

	private static final String INSERT_BOOKING_INFO = "insert into bookinginformation (UniqueId, roomName, date, starttime, endtime, organizedBy) values (?,?,?,?,?,?)";

	
	private static Logger logger;
	
	public BookingInformationDaoImpl() {
		 logger = LogManager.getLogger(BookingInformationDaoImpl.class);
		BasicConfigurator.configure(); 
	}

	@Override
	public void saveBookingInformation(BookingInformation bookingInformation){
		try {
			Connection connection = DBUtility.getConnection();
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
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}

	@Override
	public List<String> getMeetingRoomsByFilter(List<String> amenities) {
		List<String> avaliableMeetingRooms = new ArrayList<>();
		try {
				Connection connection = DBUtility.getConnection();
				String query = "select roomName,amenities from meetingRoom";
				PreparedStatement statement = connection.prepareStatement(query);
				ResultSet result = statement.executeQuery();
				//edits
				Map<String,String> allMeetingRooms = new HashMap<String, String>();					
				while(result.next()) {					
					allMeetingRooms.put(result.getString(1),result.getString(2));			
				}			
				List<String> toBeRemoved = new ArrayList<String>();
				for (Map.Entry<String, String> entry : allMeetingRooms.entrySet()) {				  
				    String value = entry.getValue();
				    for(String amenity : amenities){
				        if(!(value.contains(amenity))) {
				        	toBeRemoved.add(entry.getKey());	
				        	break;
				        } 		      
				    }
				}
				for (String meetingRoom : toBeRemoved ) {
					allMeetingRooms.remove(meetingRoom);
				}
				for (String meetingRoom : allMeetingRooms.keySet()) {	
					avaliableMeetingRooms.add(meetingRoom);
				}
			}
		    catch(SQLException | ClassNotFoundException e) {
		    	e.printStackTrace();
		    	logger.info(e.getMessage());
		}
		return avaliableMeetingRooms;
	}

	@Override
	public List<String> getAvailableMeetingRooms(List<String> meetingRooms) {
		List<String> avaliableMeetingRooms = new ArrayList<>();
		try {
			Connection connection = DBUtility.getConnection();			
			String query = "select roomName from bookinginformation;";
			Set<String> bookedRooms = new HashSet<String>();
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				bookedRooms.add(result.getString(1));
			}			
			for(String meetingRoom : meetingRooms) {
				if(!(bookedRooms.contains(meetingRoom))) {
					avaliableMeetingRooms.add(meetingRoom);
				}
			}
			
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return avaliableMeetingRooms;
	}

	@Override
	public List<MeetingRoom> getMeetingRoomsDetails(List<String> avaliableMeetingRooms) {		
		List<MeetingRoom> meetingRoomsDetails = new ArrayList<>();
		MeetingRoom meetingRoomDetail = new MeetingRoom();
		try {
			Connection connection = DBUtility.getConnection();
			String query = "select roomName,seatingCapacity, creditPerHour,rating,amenities from meetingRoom where roomName IN (";
			for ( int i = 0; i< avaliableMeetingRooms.size(); ++i) {
				query += "'" + avaliableMeetingRooms.get(i) + "'" ;
				if(i != avaliableMeetingRooms.size()-1) 
					query += ",";
			}
			query += ");";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();		
			while(result.next()) {
				meetingRoomDetail.setRoomName(result.getString(1));
				meetingRoomDetail.setSeatingCapacity(result.getInt(2));
				meetingRoomDetail.setCreditPerHour(result.getInt(3));
				meetingRoomDetail.setRating(result.getInt(4));
				String amenitiesStr = result.getString(5);

				String[] aminities = amenitiesStr.split(" ");
				Set<String> aminitiesSet = new HashSet<>();
				for (String str : aminities) {
					aminitiesSet.add(str);
				}
				meetingRoomDetail.setAmenities(aminitiesSet);
				meetingRoomsDetails.add(meetingRoomDetail);
			}	
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return meetingRoomsDetails;
	}

}
