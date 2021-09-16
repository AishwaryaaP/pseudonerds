package com.AutomatedMeetingBookingSystem.service;

import java.util.ArrayList;
import java.util.List;

import com.AutomatedMeetingBookingSystem.exception.RoomNotFoundException;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;

public class MeetingRoomService {
	private List<MeetingRoom> roomList = new ArrayList<>();
	
	//getSchedule ??***
	
	public MeetingRoom getRoomDetails(int roomId) throws RoomNotFoundException
	{
		for(MeetingRoom room : getAllMeetingRooms())
			if(room.getRoomId()==roomId)
				return room;
		
		throw new RoomNotFoundException();
	}
	
	private List<MeetingRoom> getAllMeetingRooms()
	{
		return roomList;
		//returns all meeting rooms
	}
	
	public void updateRoomDetails(MeetingRoom room) throws RoomNotFoundException
	{
		for(MeetingRoom oldRoom : getAllMeetingRooms())
			if(oldRoom.getRoomId()==room.getRoomId())
				//update room
		
		throw new RoomNotFoundException();
	}
	
	public void addRoom(MeetingRoom room)
	{
		//Add to meetingRoom table
	}
}
