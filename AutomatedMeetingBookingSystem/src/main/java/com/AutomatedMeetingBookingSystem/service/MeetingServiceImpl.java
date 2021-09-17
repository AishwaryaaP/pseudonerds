package com.AutomatedMeetingBookingSystem.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.AutomatedMeetingBookingSystem.dao.MeetingDAO;
import com.AutomatedMeetingBookingSystem.exceptions.ConnectionFailedException;
import com.AutomatedMeetingBookingSystem.model.Meeting;

public class MeetingServiceImpl implements MeetingService {
	private MeetingDAO dao = MeetingDAO.getInstance();

	public Meeting saveMeeting(Meeting meeting) {
		Meeting meeting1 = null;
		try {
			meeting1 = this.dao.createMeeting(meeting);
		} catch (ConnectionFailedException e) {
			System.out.println(e.getMessage());
		}
		return meeting1;
	}

	public Meeting fetchMeetingByMeetingId(String meetingId) {
		Meeting meeting1 = null;
		try {
			meeting1 = this.dao.fetchMeetingByMeetingId(meetingId);
		} catch (ConnectionFailedException e) {
			System.out.println(e.getMessage());
		}
		return meeting1;
	}

	public Collection<Meeting> fetchMeetingsByUserId(String userId) {
		List<Meeting> meetings = new ArrayList<>();
		Collection<String> meetingIds;
		try {
			meetingIds = this.dao.fetchMeetingsByUserId(userId);
			for (String meetingId : meetingIds) {
				Meeting meeting = fetchMeetingByMeetingId(meetingId);
				meetings.add(meeting);
			}
		} catch (ConnectionFailedException e) {
			System.out.println(e.getMessage());
		}
		return meetings;
	}

}
