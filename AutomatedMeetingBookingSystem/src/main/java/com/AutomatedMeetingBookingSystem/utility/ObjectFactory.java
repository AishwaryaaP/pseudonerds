package com.AutomatedMeetingBookingSystem.utility;
import com.AutomatedMeetingBookingSystem.dao.BookingInformationDao;
import com.AutomatedMeetingBookingSystem.dao.BookingInformationDaoImpl;
import com.AutomatedMeetingBookingSystem.service.BookingInformationService;
import com.AutomatedMeetingBookingSystem.service.BookingInformationServiceImpl;
public class ObjectFactory {
	public BookingInformationDao getBookingDaoInstance() {
		BookingInformationDao dao = new BookingInformationDaoImpl();
		return dao;
	} 
	public BookingInformationService getServiceInstance() {
		BookingInformationService service = new BookingInformationServiceImpl();
		return service;
	}

}
