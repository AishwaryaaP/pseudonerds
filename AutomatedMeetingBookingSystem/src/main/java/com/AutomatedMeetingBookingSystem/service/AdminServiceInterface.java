package com.AutomatedMeetingBookingSystem.service;

import java.util.List;
import java.util.Map;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.model.User;

public interface AdminServiceInterface {

	public List<MeetingRoom> getAllRooms();

	//public User getAdminDetails(int empId);

	public boolean createMeetingRoom(MeetingRoom room);
	public boolean editMeetingRoom(MeetingRoom meetingRoom);

	public boolean deleteMeetingRoom(int uniqueId);

	public Map<String, Integer> getAmenitiesCredit();

}