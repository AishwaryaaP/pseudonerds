package com.AutomatedMeetingBookingSystem.service;

import com.AutomatedMeetingBookingSystem.service.MeetingService;
import com.AutomatedMeetingBookingSystem.service.MeetingServiceImpl;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

import java.util.List;

import com.AutomatedMeetingBookingSystem.model.Meeting;

public class MemberServiceImpl implements MemberService{

	MeetingService meetingService;
	public MemberServiceImpl(){
		meetingService = ServiceFactory.getMeetingService();
	}
	@Override
	public List<Meeting> memberMeetingSchedule(int userId) {
		
		List<Meeting> meetingList;
		meetingList = meetingService.fetchMeetingsByUserID(userId);
		return meetingList;
	}

	

}
