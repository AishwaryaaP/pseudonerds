package com.AutomatedMeetingBookingSystem.service;

import java.util.ArrayList;
import java.util.List;

import com.AutomatedMeetingBookingSystem.dao.MeetingDAO;
import com.AutomatedMeetingBookingSystem.exception.ConnectionFailedException;
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

	public Meeting fetchMeetingByUniqueID(int uniqueID) {
		Meeting meeting1 = null;
		try {
			meeting1 = this.dao.fetchMeetingByUniqueID(uniqueID);
		} catch (ConnectionFailedException e) {
			System.out.println(e.getMessage());
		}
		return meeting1;
	}

	public List<Meeting> fetchMeetingsByUserID(int userID) {
		List<Meeting> meetings = new ArrayList<>();
		List<Integer> uniqueIDs; 
		try {
			uniqueIDs = this.dao.fetchMeetingsByUserID(userID);
			for (int uniqueID : uniqueIDs) {
				Meeting meeting = fetchMeetingByUniqueID(uniqueID);
				meetings.add(meeting);
			}
		} catch (ConnectionFailedException e) {
			System.out.println(e.getMessage());
		}
		return meetings;
	}
}