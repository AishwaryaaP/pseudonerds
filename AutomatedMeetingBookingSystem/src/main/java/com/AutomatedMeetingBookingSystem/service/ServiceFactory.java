package com.AutomatedMeetingBookingSystem.service;

public class ServiceFactory {
	
	public static UserServiceInterface getUserService() {
		
		return new UserServiceImp();
		
	}
	public static AdminServiceInterface getAdminService() {
		return new AdminServiceImpl();
	}
	public static MeetingRoomService getMeetingRoomService() {
		
		return new MeetingRoomServiceImpl();
	}
	
}
