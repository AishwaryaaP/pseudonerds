package com.AutomatedMeetingBookingSystem.service;

import com.AutomatedMeetingBookingSystem.service.MeetingService;
import com.AutomatedMeetingBookingSystem.service.MeetingServiceImpl;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

import java.util.List;

import com.AutomatedMeetingBookingSystem.model.Meeting;

public class MemberServiceImpl implements MemberService{

	@Override
	public List<Meeting> memberMeetingSchedule(int userId) {
		MeetingService meetingService = new ServiceFactory().getMeetingServiceInstance();
		List<Meeting> meetingList;
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
