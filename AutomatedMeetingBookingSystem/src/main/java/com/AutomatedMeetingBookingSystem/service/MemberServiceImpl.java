package com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.User;

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
