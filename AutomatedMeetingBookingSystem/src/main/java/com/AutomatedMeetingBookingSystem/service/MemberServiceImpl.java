package com.AutomatedMeetingBookingSystem.service;

public class MemberServiceImpl implements MemberService{

	@Override
	public List<Meeting> memberMeetingSchedule(User user) {
		meetingSchedule = MemberServiceFactory.createObject();
		List<Meeting> meetingList;
		meetingList = meetingSchedule.meetingScheduleDao(user);
		return meetingList;
	}

	@Override
	public User memberDetails(int userId) {
		memberDetail = MemberServiceFactory.createObject();
		User u = memberDetail.memberDetailsDao(userId);
		return u;
	}
	

}
