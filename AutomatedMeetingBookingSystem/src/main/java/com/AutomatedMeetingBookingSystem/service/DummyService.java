package com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.dao.DummyDao;

public class DummyService 
{
	public static List<MeetingRooms> getAllRooms(Object meetingRooms)
	{
		return meetingRooms;
	}
	
	public static List<Employee> getAdminDetails(Object admin)
	{
		return admin;
	}
	
}

