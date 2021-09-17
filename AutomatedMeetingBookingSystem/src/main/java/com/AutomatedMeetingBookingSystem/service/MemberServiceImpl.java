package com.AutomatedMeetingBookingSystem.service;

public class MemberServiceImpl implements MemberService{

	@Override
	public List<Meeting> memberMeetingSchedule(int userId) {
		MemberDao memberDao = new ObjectFactory().getMemberDaoInstance();
		List<Meeting> meetingList;
		meetingList = memberDao.meetingScheduleDao(userId);
		return meetingList;
	}

	@Override
	public User memberDetails(int userId) {
		MemberDao memberDao = new ObjectFactory().getMemberDaoInstance();
		User u = memberDao.memberDetailsDao(userId);
		return u;
	}
	

}
