package com.AutomatedMeetingBookingSystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.AutomatedMeetingBookingSystem.dao.MeetingRoomDao;
import com.AutomatedMeetingBookingSystem.exception.RoomNotFoundException;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;

public class MeetingRoomServiceImpl implements MeetingRoomService{
	MeetingRoomDao roomDao = MeetingRoomDao.getInstance();
	private List<MeetingRoom> roomList = new ArrayList<>();
	private static Map<String,Integer> amenitiesCredit = new HashMap<>();
	
	public MeetingRoomServiceImpl() {
		amenitiesCredit.put("PROJECTOR", 5);
		amenitiesCredit.put("WIFICONNECTION", 10);
		amenitiesCredit.put("CONFERENCECALL", 15);
		amenitiesCredit.put("WHITEBOARD", 5);
		amenitiesCredit.put("WATERDISPENCER", 5);
		amenitiesCredit.put("TV", 10);
		amenitiesCredit.put("COFFEEMACHINE", 10);
	}

	@Override
	public void getSchedule(String roomName)
	{
		//Dao serviceDao = DummyDao.getMeetingServiceClass();
		//List<Meeting> meetings = serviceDao.getMeetingsOnDate(roomName,private LocalTime endtime;);
		//Extract schedule for all meetings and return available time
	}
	
	@Override
	public MeetingRoom getRoomDetailsByRoomName(String roomName)
	{
		MeetingRoom room = null;
		try
		{
		room = roomDao.fetchMeetingRoomByName(roomName);
		if(room==null)
			throw new RoomNotFoundException("Room not found!!");
		
		}
		catch(RoomNotFoundException e)
		{
			System.err.println(e.getMessage());
		}
		return room;		
	}
	
	@Override
	public List<MeetingRoom> getAllMeetingRooms()
	{
		roomList = this.roomDao.fetchAllMeetingRooms();
		return roomList;
	}
	
	@Override
	public boolean updateRoomDetails(MeetingRoom roomToBeUpdated)

	{
		boolean result = roomDao.updateMeetingRoom(roomToBeUpdated);
		try
		{
		if(!result)
			throw new RoomNotFoundException("Room not found!!");
		}
		catch(RoomNotFoundException e)
		{
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	@Override
	public boolean deleteRoomByRoomName(String roomName)
	{
		boolean result = roomDao.deleteMeetingRoomByName(roomName);
		try
		{
		if(!result)
			throw new RoomNotFoundException("Room Not found!!");
		}
		catch(RoomNotFoundException e)
		{
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	@Override
	public boolean addRoom(MeetingRoom room)
	{
		boolean result = roomDao.insertMeetingRoom(room);
				return result;

	}

	@Override
	public Map<String,Integer> getAmenitiesCredit()
	{
		return amenitiesCredit;
	}
	
	@Override
	public boolean addNewAmenitiesCredit(String aminity, int credit)
	{
		if(aminity!=null)
		{
		amenitiesCredit.put(aminity, credit);
		return true;
		}
		else
			return false;
	}
	
	@Override
	public void addRating(String roomName, int rating)
	{
		MeetingRoom room = getRoomDetailsByRoomName(roomName);
		room.setRatingSum(room.getRatingSum()+rating);
		room.setRatingCount(room.getRatingCount()+1);
		room.setRating(room.getRatingSum()/room.getRatingCount());
	}

	

}
