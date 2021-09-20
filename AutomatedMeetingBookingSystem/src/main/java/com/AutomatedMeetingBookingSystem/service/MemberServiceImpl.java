package com.AutomatedMeetingBookingSystem.service;

import com.AutomatedMeetingBookingSystem.dao.MemberDao;
import com.AutomatedMeetingBookingSystem.model.User;

public class MemberServiceImpl implements MemberService{

	@Override
	public List<Meeting> memberMeetingSchedule(int userId) {
		MemberDao memberDao = new DaoFactory().getMemberDaoInstance();
		List<Meeting> meetingList;
		meetingList = memberDao.meetingScheduleDao(userId);
		return meetingList;
	}

	@Override
	public User memberDetails(int userId) {
		MemberDao memberDao = new DaoFactory().getMemberDaoInstance();
		User u = memberDao.memberDetailsDao(userId);
		return u;
	}
	

}
