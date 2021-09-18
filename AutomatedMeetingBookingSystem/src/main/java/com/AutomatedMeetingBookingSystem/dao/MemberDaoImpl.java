package main.java.com.AutomatedMeetingBookingSystem.dao;

import main.java.com.AutomatedMeetingBookingSystem.service.MemberService;
import main.java.com.AutomatedMeetingBookingSystem.model.User;

public class MemberDaoImpl implements MemberDao {

	public User memberDetailsDao(int userId)
	{
		UserService service = ServiceFactory.getUserService();
		User u = service.getUserDetailById(userId);
		return u;
	
	}
		
	
}

