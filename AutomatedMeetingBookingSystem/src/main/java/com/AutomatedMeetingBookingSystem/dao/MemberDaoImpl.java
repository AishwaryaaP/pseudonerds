package com.AutomatedMeetingBookingSystem.dao;

import com.AutomatedMeetingBookingSystem.service.MemberService;
import com.AutomatedMeetingBookingSystem.model.User;

public class MemberDaoImpl implements MemberDao {

	public User memberDetailsDao(int userId)
	{
		UserService service = ServiceFactory.getUserService();
		User u = service.getUserDetailById(userId);
		return u;
	
	}
		
	
}

