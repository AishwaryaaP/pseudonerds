package com.AutomatedMeetingBookingSystem.service;
import java.util.ArrayList;
import java.util.List;

import com.AutomatedMeetingBookingSystem.dao.BookingInformationDao;
import com.AutomatedMeetingBookingSystem.utility.ObjectFactory;
import com.AutomatedMeetingBookingSystem.model.Meeting.meetingType;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
public class  BookingInformationServiceImpl implements BookingInformationService {
	
	BookingInformationDao bookingInformationDao = new ObjectFactory().getBookingDaoInstance();
		
	@Override
	public List<MeetingRoom> getAvailableMeetingRoom(meetingType type) {
		List<String> amenities = new ArrayList<>();
		switch (type.toString()) {
			case "CLASSROOMTRAINING" : 
				amenities.add("WHITEBOARD");
				amenities.add("PROJECTOR");		
				break;
			case "ONLINETRAINING" : 
				amenities.add("WIFICONNECTION");
				amenities.add("PROJECTOR");		
				break;
			case "CONFERENCECALL" : 
				amenities.add("CONFERENCECALL");				
				break;
			case "BUSINESS":		
				amenities.add("PROJECTOR");		
				break;
		}
		List<String> filteredMeetingRooms = bookingInformationDao.getMeetingRoomsByFilter(amenities);
		List<String> availableMeetingRooms = bookingInformationDao.getAvailableMeetingRooms(filteredMeetingRooms);
		List<MeetingRoom> meetingRoomsDetails = bookingInformationDao.getMeetingRoomsDetails(availableMeetingRooms);
		return meetingRoomsDetails;
	}
	
}
