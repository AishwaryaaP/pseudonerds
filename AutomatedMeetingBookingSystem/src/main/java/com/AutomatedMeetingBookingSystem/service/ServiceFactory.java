package com.AutomatedMeetingBookingSystem.service;

public class ServiceFactory {
	
	public static UserServiceInterface getUserService() {
		
		return new UserServiceImp();
		
	}
	
	public static MemberService getMemberServiceInstance(){
		
		return new MemberServiceImpl();
	
	}
	
	public static MeetingRoomService getMeetingRoomServiceInstance(){
		
		return new MeetingRoomServiceImpl();
	
	}
	
	public static BookingInformationService getBookingInformationServiceInstance(){
		
		return new BookingInformationServiceImpl();
	
	}
	
	public static MeetingService getMeetingServiceInstance(){
		
		return new MeetingServiceImpl();
		
	}
	
	public static AdminServiceInterface getAdminServiceInterfaceInstance() {
		
		return new AdminServiceImpl();
		
	}
	
	public static ManagerService getManagerServiceInstance() {
		
		return new ManagerServiceImpl();
		
	}
	
	
	
	
}
