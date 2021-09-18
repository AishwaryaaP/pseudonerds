package main.java.com.AutomatedMeetingBookingSystem.service;

import main.java.com.AutomatedMeetingBookingSystem.service.MeetingService;
import main.java.com.AutomatedMeetingBookingSystem.service.MeetingServiceImpl;

import java.util.List;

import main.java.com.AutomatedMeetingBookingSystem.model.Meeting;

public class MemberServiceImpl implements MemberService{

	@Override
	public List<Meeting> memberMeetingSchedule(int userId) {
		MeetingService meetingService = new ServiceFactory().getMeetingServiceInstance();
		List<Meeting> meetingList;
		meetingList = meetingService.fetchMeetingByUniqueID(userId);
		return meetingList;
	}

	@Override
	public User memberDetails(int userId) {
		MemberDao memberDao = new DaoFactory().getMemberDaoInstance();
		User u = memberDao.memberDetailsDao(userId);
		return u;
	}
	

}
