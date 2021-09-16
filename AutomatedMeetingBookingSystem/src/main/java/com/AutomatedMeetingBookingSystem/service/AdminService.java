package com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.dao.DummyDao;

public class AdminService {
	public static List<MeetingRooms> getAllRooms(Object meetingRooms) {
		return meetingRooms;
	}

	public static List<Employee> getAdminDetails(Object admin) {
		return admin;
	}

	public static List<MeetingRooms> createMeetingRoom(Object meetingrooms) { // logic to create a customized meeting
																				// room by calling the manager details
		return meetingrooms;
	}

	public static String editMeeting(String uniqueID)

	{
		// logic to edit the meeting time / date etc
		return uniqueID;

	}

}
