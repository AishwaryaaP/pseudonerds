package com.AutomatedMeetingBookingSystem.service;
import java.util.List;

import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.User;

public interface MemberService {
	
	public List<Meeting> memberMeetingSchedule(int userId);

}
