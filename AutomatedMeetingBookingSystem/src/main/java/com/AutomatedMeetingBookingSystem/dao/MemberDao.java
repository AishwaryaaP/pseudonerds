package com.AutomatedMeetingBookingSystem.dao;

public interface MemberDao {

	public List<Meeting> meetingScheduleDao(int userId);
	public User memberDetailsDao(int userId);
}
