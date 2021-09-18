package main.java.com.AutomatedMeetingBookingSystem.service;
import java.util.List;

import main.java.com.AutomatedMeetingBookingSystem.model.Meeting;
import main.java.com.AutomatedMeetingBookingSystem.model.User;

public interface MemberService {
	
	public List<Meeting> memberMeetingSchedule(int userId);
	public User memberDetails(int userId);

}
