package com.AutomatedMeetingBookingSystem.service;

public interface MemberService {
	
	public List<Meeting> memberMeetingSchedule(User user);
	public User memberDetails(int userId);

}
