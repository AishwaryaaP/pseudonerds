package com.AutomatedMeetingBookingSystem.dao;

public interface MemberDao {

	public List<Meeting> meetingScheduleDao(User user);
	public User memberDetailsDao(int userId);
}
