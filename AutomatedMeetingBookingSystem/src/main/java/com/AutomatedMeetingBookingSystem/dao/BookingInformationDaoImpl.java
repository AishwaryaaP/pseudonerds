package com.AutomatedMeetingBookingSystem.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;

public class BookingInformationDaoImpl implements BookingInformationDao {

	private static final String INSERT_BOOKINGINFO = "insert into bookinginformation (UniqueId, roomName, date, starttime, endtime, organizedBy) values (?,?,?,?,?,?)";

	@Override
	public void saveBookingInformation(bookingInformation){
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement statement = connection.prepareStatement(INSERT_MEETING, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, bookingInformation.getUniqueID());
			statement.setString(2, bookingInformation.getInfoMeetingRoomName());
			statement.setString(4, bookingInformation.getDate().toString());
			statement.setString(5, bookingInformation.getStartTime().toString());
			statement.setString(6, bookingInformation.getEndTime().toString());
			statement.setString(7, bookingInformation.getOrganizedBy());

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
				meetingRoomDetail.setAmenities(result.getString(5));
				meetingRoomsDetails.add(meetingRoomDetail);
			}	
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return meetingRoomsDetails;
	}

}
