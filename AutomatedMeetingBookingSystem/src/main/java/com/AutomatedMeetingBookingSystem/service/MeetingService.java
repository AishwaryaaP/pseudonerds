package com.AutomatedMeetingBookingSystem.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.AutomatedMeetingBookingSystem.model.Meeting;

public interface MeetingService {

	static MeetingService getInstance() {
		return new MeetingServiceImpl();
	}

	Meeting saveMeeting(int organizedBy, String roomName, String title, LocalDate meetingDate, LocalTime startTime, LocalTime endTime, String type, String listOfMembers);

	Meeting fetchMeetingByUniqueID(int uniqueID);

	List<Meeting> fetchMeetingsByUserID(int userID);
	
	List<Meeting> fetchMeetingsByOrganizedByManager(int managerId);
	public boolean deleteMeetingByUniqueId(int uniqueId);
	
	public boolean updateMeeting(Meeting meeting);

}