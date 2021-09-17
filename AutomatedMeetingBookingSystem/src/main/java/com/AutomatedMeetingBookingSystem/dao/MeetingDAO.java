package com.AutomatedMeetingBookingSystem.dao;

import java.util.Collection;

import com.AutomatedMeetingBookingSystem.exceptions.ConnectionFailedException;
import com.AutomatedMeetingBookingSystem.model.Meeting;

public interface MeetingDAO {

	static MeetingDAO getInstance() {
		return new MeetingDAOImpl();
	}

	Meeting createMeeting(Meeting meeting) throws ConnectionFailedException;

	Collection<String> fetchMeetingsByUserId(String userId) throws ConnectionFailedException;

	Meeting fetchMeetingByMeetingId(String meetingId) throws ConnectionFailedException;
}