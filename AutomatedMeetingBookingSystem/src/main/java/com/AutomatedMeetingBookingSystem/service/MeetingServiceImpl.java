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
		//List<Meeting> meetings = serviceDao.getMeetingsOnDate(roomName,private LocalTime endtime;);
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
		MeetingRoom roomToBeUpdated = getRoomDetailsByRoomName(room.getRoomName());
		//update
		
		throw new RoomNotFoundException();
	}
	
	@Override
	public void deleteRoomByRoomName(String roomName) throws RoomNotFoundException
	{
		MeetingRoom roomToBeDeleted = getRoomDetailsByRoomName(roomName);
		//delete
		
		throw new RoomNotFoundException();
	}
	
	@Override
	public void addRoom(MeetingRoom room)
	{
		//Add to meetingRoom table
	}

	

}
