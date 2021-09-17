package com.AutomatedMeetingBookingSystem.dao;

import java.util.List;

import com.AutomatedMeetingBookingSystem.exceptions.ConnectionFailedException;
import com.AutomatedMeetingBookingSystem.model.Meeting;

public interface MeetingDAO {

	static MeetingDAO getInstance() {
		return new MeetingDAOImpl();
	}

	Meeting createMeeting(Meeting meeting) throws ConnectionFailedException;

	List<Integer> fetchMeetingsByUserID(int userID) throws ConnectionFailedException;

	Meeting fetchMeetingByUniqueID(int uniqueID) throws ConnectionFailedException;
}