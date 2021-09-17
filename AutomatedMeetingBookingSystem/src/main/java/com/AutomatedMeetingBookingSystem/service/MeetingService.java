package com.AutomatedMeetingBookingSystem.service;

import java.util.Collection;

import com.AutomatedMeetingBookingSystem.model.Meeting;

public interface MeetingService {

	static MeetingService getInstance() {
		return new MeetingServiceImpl();
	}

	Meeting saveMeeting(Meeting Meeting);

	Meeting fetchMeetingByUniqueID(int uniqueID);

	Collection<Meeting> fetchMeetingsByUserID(int userID);

}