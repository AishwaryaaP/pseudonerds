package com.AutomatedMeetingBookingSystem.service;

public interface MemberService {
	
	public List<Meeting> memberMeetingSchedule(int userId);
	public User memberDetails(int userId);

}
