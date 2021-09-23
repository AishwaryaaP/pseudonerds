package com.AutomatedMeetingBookingSystem.service;

public class ServiceFactory {
	
	public static UserServiceInterface getUserService() {
		
		return new UserServiceImp();
		
	}
	
	public static MemberService getMemberService(){
		
		return new MemberServiceImpl();
	
	}
	
	public static MeetingRoomService getMeetingRoomService(){
		
		return new MeetingRoomServiceImpl();
	
	}
	
	public static BookingInformationService getBookingInformationService(){
		
		return new BookingInformationServiceImpl();
	
	}
	
	public static MeetingService getMeetingService(){
		
		return new MeetingServiceImpl();
		
	}
	
	public static AdminServiceInterface getAdminService() {
		
		return new AdminService();
		
	}
	
	public static ManagerService getManagerService() {
		
		return new ManagerServiceImpl();
		
	}
	
	
	
	
}
