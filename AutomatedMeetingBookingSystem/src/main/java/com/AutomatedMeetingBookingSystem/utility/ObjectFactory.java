package com.app.factory;
import com.app.dao.BookingInformationDao;
import com.app.dao.BookingInformationDaoImpl;
import com.app.service.BookingInformationService;
import com.app.service.BookingInformationServiceImpl;
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
