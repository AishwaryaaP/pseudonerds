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

	private static final String SELECT_BY_ROOM_NAME = "SELECT roomId,roomName,seatingCapacity,rating,ratingSum,ratingCount,creditPerHour,amenities FROM MeetingRoom WHERE roomName=?";
	private static final String SELECT_ALL_ROOMS = "SELECT roomId,roomName,seatingCapacity,rating,ratingSum,ratingCount,creditPerHour,amenities FROM MeetingRoom";
	private static final String INSERT_ROOM = "INSERT INTO MeetingRoom(roomName, seatingCapacity, rating, ratingSum, ratingCount, creditPerHour, amenities) VALUES (?,?,?,?,?,?,?)";
	private static final String UPDATE_ROOM = "UPDATE MeetingRoom SET roomId=?, seatingCapacity=?, rating=?, ratingSum=?, ratingCount=?, creditPerHour=?, amenities=? WHERE roomName=?";
	private static final String DELETE_ROOM_BY_NAME = "DELETE FROM MeetingRoom WHERE roomName=?";

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

					String[] amininityArray = aminitiesStr.split(" ");
					for(String aminityItr : amininityArray)
					{
						aminitySet.add(aminityItr);
					}
					room.setAmenities(aminitySet);
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

					String[] amininityArray = aminitiesStr.split(" ");
					for(String aminityItr : amininityArray)
					{
						aminitySet.add(aminityItr);
					}
					room.setAmenities(aminitySet);
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
			String amenitiesStr=null;

			for(String amenityItr : room.getAmenities())
			{
				amenitiesStr+=" " + amenityItr;
			}
			try {
				stmt = connection.prepareStatement(INSERT_ROOM);
				stmt.setInt(1, room.getRoomId());
				stmt.setString(2, room.getRoomName());
				stmt.setInt(3, room.getSeatingCapacity());
				stmt.setDouble(4, room.getRating());
				stmt.setInt(5, room.getRatingSum());
				stmt.setInt(6, room.getRatingCount());
				stmt.setInt(7, room.getCreditPerHour());
				stmt.setString(8, amenitiesStr);

				int recordsUpdated = stmt.executeUpdate();
				if(recordsUpdated>0)
				{
					stmt.close();
					connection.commit();
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
			String amenitiesStr=null;

			for(String amenityItr : room.getAmenities())
			{
				amenitiesStr+=" " + amenityItr;
			}
			try {
				stmt = connection.prepareStatement(UPDATE_ROOM);
				stmt.setInt(1, room.getRoomId());
				stmt.setInt(2, room.getSeatingCapacity());
				stmt.setDouble(3, room.getRating());
				stmt.setInt(4, room.getRatingSum());
				stmt.setInt(5, room.getRatingCount());
				stmt.setInt(6, room.getCreditPerHour());
				stmt.setString(7, amenitiesStr);
				stmt.setString(8, room.getRoomName());

				int recordsUpdated = stmt.executeUpdate();
				if(recordsUpdated>0)
				{
					stmt.close();
					connection.commit();
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
					connection.commit();
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
}
