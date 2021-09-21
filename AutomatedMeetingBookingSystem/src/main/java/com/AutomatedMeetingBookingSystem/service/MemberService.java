package com.AutomatedMeetingBookingSystem.service;
import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.User;

public interface MemberService {
	
	public Meeting memberMeetingSchedule(int userId);
	public User memberDetails(int userId, String password);

}
