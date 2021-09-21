package com.AutomatedMeetingBookingSystem.service;

import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.User;

public class MemberServiceImpl implements MemberService{

	@Override
	public Meeting memberMeetingSchedule(int userId) {
		MeetingService meetingService = ServiceFactory.getMeetingService();
		Meeting meetingList;
		meetingList = meetingService.fetchMeetingByUniqueID(userId);
		return meetingList;
	}

	@Override
	public User memberDetails(int userId, String password) {
		UserServiceInterface service = ServiceFactory.getUserService();
		User u = service.getUserDetails(userId, password);
		return u;
	}
	

}
