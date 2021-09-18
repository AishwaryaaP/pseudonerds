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
		MeetingRoom m;
		try {
			Connection connection = DBUtility.getConnection();
			String query = "select roomName,seatingCapacity, creditPerHour,rating,amenities from meetingRoom where roomName IN (";
			for ( int i = 0; i< avaliableMeetingRooms.size(); ++i) {
				query += "'" + avaliableMeetingRooms.get(i) + "'" ;
				if(i != avaliableMeetingRooms.size()-1) 
					query += ",";
			}
			query += ")";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();		
			while(result.next()) {
				m = new MeetingRoom();
				m.setRoomName(result.getString(1));
				m.setSeatingCapacity(result.getInt(2));
				m.setCreditPerHour(result.getInt(3));
				m.setRating(result.getInt(4));
				m.setAmenities(result.getString(5));
				 meetingRoomsDetails.add(m);
			}
			
			
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return meetingRoomsDetails;
	}

}
