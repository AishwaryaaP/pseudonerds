package com.AutomatedMeetingBookingSystem.service;

import java.util.List;
import java.util.Map;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;

public interface MeetingRoomService {

	public void getSchedule(String roomName);
	public MeetingRoom getRoomDetailsByRoomName(String roomName);
	public List<MeetingRoom> getAllMeetingRooms();
	public boolean updateRoomDetails(MeetingRoom room);
	public boolean addRoom(MeetingRoom room);
	public boolean deleteRoomByRoomName(String room);
	public Map<String, Integer> getAmenitiesCredit();
	boolean addNewAmenitiesCredit(String aminity, int credit);
	boolean addRating(String roomName, int rating);
	int getRoomPerHourCredits(String roomName);
	public void incrementMeetingCount(String roomName);


}
