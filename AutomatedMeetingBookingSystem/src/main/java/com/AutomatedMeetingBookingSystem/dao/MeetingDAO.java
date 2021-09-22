package com.AutomatedMeetingBookingSystem.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.AutomatedMeetingBookingSystem.exception.ConnectionFailedException;
import com.AutomatedMeetingBookingSystem.model.Meeting;

public interface MeetingDAO {
	Meeting createMeeting(int organizedBy, String roomName, String title, LocalDate date, LocalTime startTime, LocalTime endTime, String type, String listOfMembers) throws ConnectionFailedException;

	public List<Meeting> fetchAllMeetings() throws ConnectionFailedException;

	Meeting fetchMeetingByUniqueID(int uniqueID) throws ConnectionFailedException;

	List<Meeting> fetchMeetingsByManagerID(int managerId);
}
