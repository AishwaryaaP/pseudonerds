package com.AutomatedMeetingBookingSystem.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.AutomatedMeetingBookingSystem.exception.ConnectionFailedException;
import com.AutomatedMeetingBookingSystem.model.Meeting;

public interface MeetingDAO {

	static MeetingDAO getInstance() {
		return new MeetingDAOImpl();
	}

	Meeting createMeeting(int organizedBy, String roomName, String title, LocalDate date, LocalTime startTime, LocalTime endTime, String type, String listOfMembers) throws ConnectionFailedException;

	List<Meeting> fetchMeetingsByUserID(int userID) throws ConnectionFailedException;

	Meeting fetchMeetingByUniqueID(int uniqueID) throws ConnectionFailedException;
}
