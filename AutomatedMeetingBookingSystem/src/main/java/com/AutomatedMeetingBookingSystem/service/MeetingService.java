package com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.model.Meeting;

public interface MeetingService {

	static MeetingService getInstance() {
		return new MeetingServiceImpl();
	}

	Meeting saveMeeting(Meeting Meeting);

	Meeting fetchMeetingByUniqueID(int uniqueID);

	List<Meeting> fetchMeetingsByUserID(int userID);

}