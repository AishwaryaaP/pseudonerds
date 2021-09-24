package com.AutomatedMeetingBookingSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.utility.DaoUtility;
import com.AutomatedMeetingBookingSystem.utility.DaoUtilityInterface;

public class MeetingRoomDaoImpl implements MeetingRoomDao{

	private static final String SELECT_BY_ROOM_NAME = "SELECT roomId,roomName,seatingCapacity,rating,ratingSum,ratingCount,creditPerHour,amenities, count FROM MeetingRoom WHERE roomName=?";
	private static final String SELECT_ALL_ROOMS = "SELECT roomId,roomName,seatingCapacity,rating,ratingSum,ratingCount,creditPerHour,amenities, count FROM MeetingRoom";
	private static final String INSERT_ROOM = "INSERT INTO MeetingRoom(roomName, seatingCapacity, rating, ratingSum, ratingCount, creditPerHour, amenities, count) VALUES (?,?,?,?,?,?,?,?)";
	private static final String UPDATE_ROOM = "UPDATE MeetingRoom SET seatingCapacity=?, creditPerHour=?, amenities=? WHERE roomName=?";
	private static final String DELETE_ROOM_BY_NAME = "DELETE FROM MeetingRoom WHERE roomName=?";
	private static final String UPDATE_MEETING_COUNT = "Update MeetingRoom SET count=? WHERE roomName=?";

	DaoUtilityInterface dao = new DaoUtility();
	Connection connection = dao.getInstance();

	@Override
	public MeetingRoom fetchMeetingRoomByName(String roomName)
	{
		MeetingRoom room = new MeetingRoom();
		Set<String> aminitySet = new HashSet<>(); 
		if (connection != null) 
		{
			PreparedStatement stmt=null;
			try {
				stmt = connection.prepareStatement(SELECT_BY_ROOM_NAME);
				stmt.setString(1, roomName);

				ResultSet result = stmt.executeQuery();
				while(result.next())
				{
					room.setRoomId(result.getInt(1));
					room.setRoomName(result.getString(2));
					room.setSeatingCapacity(result.getInt(3));
					room.setRating(result.getDouble(4));
					room.setRatingSum(result.getInt(5));
					room.setRatingCount(result.getInt(6));
					room.setCreditPerHour(result.getInt(7));
					String aminitiesStr = result.getString(8);
					room.setCount(result.getInt(9));
					room.setAmenities(aminitiesStr);
				}

			}
			catch (SQLException e) {
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
		return room;	
	}

	@Override
	public List<MeetingRoom> fetchAllMeetingRooms()
	{
		List<MeetingRoom> roomList = new ArrayList<>();
		if (connection != null) 
		{
			PreparedStatement stmt=null;

			try {
				stmt = connection.prepareStatement(SELECT_ALL_ROOMS);
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

					room.setAmenities(aminitiesStr);
					roomList.add(room);
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
		return roomList;
	}

	@Override
	public boolean insertMeetingRoom(MeetingRoom room)
	{
		if (connection != null) 
		{
			PreparedStatement stmt;
			String amenitiesStr=room.getAmenities();

		
			try {
				stmt = connection.prepareStatement(INSERT_ROOM);
				//stmt.setInt(1, room.getRoomId());
				stmt.setString(1, room.getRoomName());
				stmt.setInt(2, room.getSeatingCapacity());
				stmt.setDouble(3, room.getRating());
				stmt.setInt(4, room.getRatingSum());
				stmt.setInt(5, room.getRatingCount());
				stmt.setInt(6, room.getCreditPerHour());
				stmt.setString(7, amenitiesStr);
				stmt.setInt(8, room.getCount());

				int recordsUpdated = stmt.executeUpdate();
				if(recordsUpdated>0)
				{
					stmt.close();
					/* connection.commit(); */
					return true;
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}

		}
		return false;
	}

	@Override
	public boolean updateMeetingRoom(MeetingRoom room)
	{
		if (connection != null) 
		{
			PreparedStatement stmt;
			String amenitiesStr=room.getAmenities();

			
			try {
				stmt = connection.prepareStatement(UPDATE_ROOM);				
				stmt.setInt(1, room.getSeatingCapacity());				
				stmt.setInt(2, room.getCreditPerHour());
				stmt.setString(3, amenitiesStr);
				stmt.setString(4, room.getRoomName());				
				int recordsUpdated = stmt.executeUpdate();
				if(recordsUpdated>0)
				{
					stmt.close();
					//connection.commit();
					return true;
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}

		}
		return false;
	}

	@Override
	public boolean deleteMeetingRoomByName(String roomName)
	{
		if (connection != null) 
		{
			PreparedStatement stmt;

			try {
				stmt = connection.prepareStatement(DELETE_ROOM_BY_NAME);
				stmt.setString(1, roomName);

				int recordsUpdated = stmt.executeUpdate();
				if(recordsUpdated>0)
				{
					stmt.close();
					//connection.commit();
					return true;
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}

		}
		return false;
	}

	@Override
	public void incrementMeetingCount(String roomName, int currentCount) {
		if(connection != null)
		{
			try {
				int updatedCount=currentCount+1;
				PreparedStatement stmt = connection.prepareStatement(UPDATE_MEETING_COUNT);
				stmt.setInt(1, updatedCount);
				stmt.setString(2, roomName);
				int recordsUpdated = stmt.executeUpdate();
				if(recordsUpdated>0)
				{
					stmt.close();
				//	connection.commit();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
