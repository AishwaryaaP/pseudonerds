package com.AutomatedMeetingBookingSystem.service;

import java.util.ArrayList;
import java.util.List;

import com.AutomatedMeetingBookingSystem.exception.RoomNotFoundException;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;

public class MeetingRoomServiceImpl implements MeetingRoomService{
	private List<MeetingRoom> roomList = new ArrayList<>();
	
	@Override
	public void getSchedule(String roomName)
	{
		//Dao serviceDao = DummyDao.getMeetingServiceClass();
		//List<Meeting> meetings = serviceDao.getMeetingsForRoom(roomName);
		//Extract schedule for all meetings and return available time
	}
	
	@Override
	public MeetingRoom getRoomDetailsByRoomName(String roomName) throws RoomNotFoundException
	{
		for(MeetingRoom room : getAllMeetingRooms())
			if(room.getRoomName()==roomName)
				return room;
		
		throw new RoomNotFoundException();
	}
	
	@Override
	public List<MeetingRoom> getAllMeetingRooms()
	{
		return roomList;
		//returns all meeting rooms
	}
	
	@Override
	public void updateRoomDetails(MeetingRoom room) throws RoomNotFoundException
	{
		for(MeetingRoom oldRoom : getAllMeetingRooms())
			if(oldRoom.getRoomName()==room.getRoomName())
				//update room
		
		throw new RoomNotFoundException();
	}
	
	@Override
	public void addRoom(MeetingRoom room)
	{
		//Add to meetingRoom table
	}

	

}
