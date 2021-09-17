package com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.exception.RoomNotFoundException;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;

public interface MeetingRoomService {

	public void getSchedule(String roomName);
	public MeetingRoom getRoomDetailsByRoomName(String roomName) throws RoomNotFoundException;
	public List<MeetingRoom> getAllMeetingRooms();
	public void updateRoomDetails(MeetingRoom room) throws RoomNotFoundException;
	public void addRoom(MeetingRoom room);
}