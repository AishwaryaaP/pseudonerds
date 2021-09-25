package com.AutomatedMeetingBookingSystem.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.AutomatedMeetingBookingSystem.exception.ConnectionFailedException;
import com.AutomatedMeetingBookingSystem.model.Meeting;

public interface MeetingDao {
	public int createMeeting(int organizedBy, String roomName, String title, LocalDate date, LocalTime startTime, LocalTime endTime, String type, String listOfMembers);

	public List<Meeting> fetchAllMeetings();

	public Meeting fetchMeetingByUniqueID(int uniqueID) throws ConnectionFailedException;

	List<Meeting> fetchMeetingsByManagerID(int managerId);
	
	public boolean deleteMeetingByUniqueId(int uniqueId);
	
	public boolean updateMeeting(Meeting meeting);

}
