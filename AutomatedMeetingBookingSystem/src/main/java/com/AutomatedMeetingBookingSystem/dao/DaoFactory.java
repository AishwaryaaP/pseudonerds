package com.AutomatedMeetingBookingSystem.dao;

public class DaoFactory {
	
	public static BookingInformationDao getBookingDaoInstance() {
		
		return new BookingInformationDaoImpl();
		
	}
	
	public static MeetingDAO getMeetingDaoInstance() {
		
		return new MeetingDAOImpl();
		
	}
	
	public static UserDao getUserDaoInstance() {
		
		return new UserDaoImpl();
		
	}
	
	public static MeetingRoomDao getMeetingRoomDaoInstance() {
		
		return new MeetingRoomDaoImpl();
		
	}

}
