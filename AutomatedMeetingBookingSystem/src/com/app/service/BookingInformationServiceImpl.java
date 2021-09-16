package com.app.service;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.BookingInformationDao;
import com.app.factory.ObjectFactory;
import com.app.model.BookingInformation;
public class  BookingInformationServiceImpl implements BookingInformationService {
	BookingInformationDao bookingInformationDao = new ObjectFactory().getBookingDaoInstance();
	List<String> amenities = new ArrayList<>();
	public List<MeetingRoom> getAvailableMeetingRoom(MeetingType meetingType) {
		switch (meetingType) {
		case MeetingType.CLASSROOMTRAINING : 
			amenities.add("WHITEBOARD");
			amenities.add("PROJECTOR");		
			break;
		case MeetingType.ONLINETRAINING : 
			amenities.add("WIFICONNECTION");
			amenities.add("PROJECTOR");		
			break;
		case MeetingType.CONFERENCECALL : 
			amenities.add("CONFERENCECALL");				
			break;
		case MeetingType.BUSINESS : 		
			amenities.add("PROJECTOR");		
			break;
		};
		List<String> filteredMeetingRooms = bookingInformationDao.getMeetingRoomsByFilter(amenities);
		List<String> availableMeetingRooms = bookingInformationDao.getAvailableMeetingRooms(filteredMeetingRooms);
		List<MeetingRoom> meetingRoomsDetails = bookingInformationDao.getMeetingRoomsDetails(availableMeetingRooms);
		return meetingRoomsDetails;
	}

}
