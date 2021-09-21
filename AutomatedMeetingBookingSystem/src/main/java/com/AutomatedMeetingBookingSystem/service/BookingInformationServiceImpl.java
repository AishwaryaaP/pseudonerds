package com.AutomatedMeetingBookingSystem.service;
import java.util.ArrayList;
import java.util.List;

import com.AutomatedMeetingBookingSystem.dao.BookingInformationDao;
import com.AutomatedMeetingBookingSystem.enums.MeetingType;
import static com.AutomatedMeetingBookingSystem.enums.MeetingType.CLASSROOMTRAINING;
import static com.AutomatedMeetingBookingSystem.enums.MeetingType.BUSINESS ;
import static com.AutomatedMeetingBookingSystem.enums.MeetingType.CONFERENCECALL;
import static com.AutomatedMeetingBookingSystem.enums.MeetingType.ONLINETRAINING;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.utility.ObjectFactory;
public class  BookingInformationServiceImpl implements BookingInformationService {
	
	BookingInformationDao bookingInformationDao = new ObjectFactory().getBookingDaoInstance();
		
	@Override
	public List<MeetingRoom> getAvailableMeetingRoom(MeetingType type) {
		List<String> amenities = new ArrayList<>();
		switch (type) {
			case CLASSROOMTRAINING : 
				amenities.add("WHITEBOARD");
				amenities.add("PROJECTOR");		
				break;
			case ONLINETRAINING : 
				amenities.add("WIFICONNECTION");
				amenities.add("PROJECTOR");		
				break;
			case CONFERENCECALL : 
				amenities.add("CONFERENCECALL");				
				break;
			case BUSINESS:		
				amenities.add("PROJECTOR");		
				break;
		}
		List<String> filteredMeetingRooms = bookingInformationDao.getMeetingRoomsByFilter(amenities);
		List<String> availableMeetingRooms = bookingInformationDao.getAvailableMeetingRooms(filteredMeetingRooms);
		List<MeetingRoom> meetingRoomsDetails = bookingInformationDao.getMeetingRoomsDetails(availableMeetingRooms);
		return meetingRoomsDetails;
	}

	@Override
	public void saveBookingInformation(Meeting meeting){
		BookingInformation bookingInformation = new BookingInformation(meeting.getuniqueId(), meeting.getInfoMeetingRoomName(), meeting.getDate(), meeting.getStartTime(), meeting.getEndTime(), meeting.getOrganizedBy());
		bookingInformationDao.saveBookingInformation(bookingInformation);
	}
	
}
