package com.AutomatedMeetingBookingSystem.dao;

public class DaoFactory {
	
	public static BookingInformationDao getBookingDaoInstance() {
		
		return new BookingInformationDaoImpl();
		
	}
	
	public static MeetingDao getMeetingDaoInstance() {
		
		return new MeetingDaoImpl();
		
	}
	
	public static UserDao getUserDaoInstance() {
		
		return new UserDaoImpl();
		
	}
	
	public static MeetingRoomDao getMeetingRoomDaoInstance() {
		
		return new MeetingRoomDaoImpl();
		
	}

}
