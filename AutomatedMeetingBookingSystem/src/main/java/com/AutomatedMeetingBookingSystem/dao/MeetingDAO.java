package com.AutomatedMeetingBookingSystem.dao;

import java.util.List;

import com.AutomatedMeetingBookingSystem.exception.ConnectionFailedException;
import com.AutomatedMeetingBookingSystem.model.Meeting;

public interface MeetingDAO {

	static MeetingDAO getInstance() {
		return new MeetingDAOImpl();
	}

	Meeting createMeeting(Meeting meeting) throws ConnectionFailedException;

	List<Meeting> fetchMeetingsByUserID(int userID) throws ConnectionFailedException;

	Meeting fetchMeetingByUniqueID(int uniqueID) throws ConnectionFailedException;
}
