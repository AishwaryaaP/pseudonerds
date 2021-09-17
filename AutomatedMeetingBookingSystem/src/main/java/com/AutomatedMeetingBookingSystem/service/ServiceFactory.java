package com.AutomatedMeetingBookingSystem.service;

public class ServiceFactory {
	
	public static UserServiceInterface getUserService() {
		
		return new UserServiceImp();
		
	}
	
}
