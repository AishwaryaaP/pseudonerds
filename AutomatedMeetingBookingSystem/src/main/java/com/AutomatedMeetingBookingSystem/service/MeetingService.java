package com.AutomatedMeetingBookingSystem.service;

import java.util.Collection;

import com.AutomatedMeetingBookingSystem.model.Meeting;

public interface MeetingService {

	static MeetingService getInstance() {
		return new MeetingServiceImpl();
	}

	Meeting saveMeeting(Meeting Meeting);

	Meeting fetchMeetingByMeetingId(String meetingId);

	Collection<Meeting> fetchMeetingsByUserId(String userId);

}