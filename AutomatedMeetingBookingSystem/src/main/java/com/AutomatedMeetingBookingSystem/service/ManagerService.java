package com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.model.User;

public interface ManagerService {

	boolean createMeeting(int organizedBy, String roomName, String title, String date, String startHours,
			String startMinutes, String endHours, String endMinutes, String type, String listOfMembers);

	List<MeetingRoom> getAvailableRooms(String date, String startHours, String startMinutes, String endHours,
			String endMinutes, String type);
	
	List<Meeting> getOrganizedByManager(int managerId);
	
	void resetManagerCredits();
	public boolean deleteMeeting(int uniqueId);
	
	public boolean editMeeting(Meeting meeting);

}