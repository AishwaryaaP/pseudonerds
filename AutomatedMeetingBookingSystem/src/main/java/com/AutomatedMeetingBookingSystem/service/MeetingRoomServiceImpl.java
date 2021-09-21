package com.AutomatedMeetingBookingSystem.service;

import java.util.ArrayList;
import java.util.List;

import com.AutomatedMeetingBookingSystem.dao.MeetingRoomDao;
import com.AutomatedMeetingBookingSystem.exception.RoomNotFoundException;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;

public class MeetingRoomServiceImpl implements MeetingRoomService{
	MeetingRoomDao roomDao = MeetingRoomDao.getInstance();
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
		roomList = this.roomDao.fetchAllMeetingRooms();
		return roomList;
		//returns all meeting rooms
	}
	
	@Override
	public boolean updateRoomDetails(MeetingRoom roomToBeUpdated) throws RoomNotFoundException

	{
		boolean result = this.roomDao.updateMeetingRoom(roomToBeUpdated);
		if(!result)
			throw new RoomNotFoundException();
			return result;
	}
	
	@Override
	public boolean deleteRoomByRoomName(String roomName) throws RoomNotFoundException
	{
		boolean result = this.roomDao.deleteMeetingRoomByName(roomName);
		if(!result)
			throw new RoomNotFoundException();
		return result;
	}
	
	@Override
	public boolean addRoom(MeetingRoom room)
	{
		boolean result = this.roomDao.insertMeetingRoom(room);
				return result;

	}

	

}
