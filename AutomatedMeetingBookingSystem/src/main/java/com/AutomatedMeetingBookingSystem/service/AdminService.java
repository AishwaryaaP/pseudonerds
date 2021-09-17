package com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.dao.DummyDao;

public class AdminService {
	public static List<MeetingRooms> getAllRooms(Object meetingRooms) { // checking if the object of meetingroom is null
																		// or not
		try {

			if (meetingRooms == null)

				throw new NullPointerException("No meeting room is created");
		} catch (Exception e) {
			System.err.println(e.getMessage()); //to print the error message when exception is thrown
		}

		return meetingRooms;
	}

	public static List<Employee> getAdminDetails(Object admin) 
	{
		try {
			if(admin == null)
				throw new NullPointerException("No admin is created");
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
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
