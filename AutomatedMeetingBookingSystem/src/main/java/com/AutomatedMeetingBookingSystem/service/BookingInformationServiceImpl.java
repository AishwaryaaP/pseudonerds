package com.AutomatedMeetingBookingSystem.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.AutomatedMeetingBookingSystem.dao.BookingInformationDao;
import com.AutomatedMeetingBookingSystem.dao.DaoFactory;
import com.AutomatedMeetingBookingSystem.enums.MeetingType;
import static com.AutomatedMeetingBookingSystem.enums.MeetingType.CLASSROOMTRAINING;
import static com.AutomatedMeetingBookingSystem.enums.MeetingType.BUSINESS ;
import static com.AutomatedMeetingBookingSystem.enums.MeetingType.CONFERENCECALL;
import static com.AutomatedMeetingBookingSystem.enums.MeetingType.ONLINETRAINING;

import com.AutomatedMeetingBookingSystem.model.BookingInformation;
import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.utility.ObjectFactory;
public class  BookingInformationServiceImpl implements BookingInformationService {
	
	BookingInformationDao bookingInformationDao;
	
	
		

	public BookingInformationServiceImpl() {
		super();
		this.bookingInformationDao = DaoFactory.getBookingDaoInstance();
	}




	@Override
	public List<MeetingRoom> getAvailableMeetingRoom(LocalDate meetingDate, LocalTime startTime, LocalTime endTime, MeetingType type) {
		String amenities = "%";
		switch (type) {
			case CLASSROOMTRAINING : 
				amenities+="WHITEBOARD" + "%";
				amenities+="PROJECTOR" + "%";
				break;
			case ONLINETRAINING :
				amenities+="WIFICONNECTION" + "%";
				amenities+="PROJECTOR" + "%";		
				break;
			case CONFERENCECALL :
				amenities+="CONFERENCECALL" + "%";			
				break;
			case BUSINESS:		
				amenities+="PROJECTOR" + "%";	
				break;
		}
		List<MeetingRoom> meetingRoomsDetails = bookingInformationDao.getAvailableMeetingRooms(meetingDate, startTime, endTime, amenities);
		return meetingRoomsDetails;
	}
	
	@Override
	public void saveBookingInformation(Meeting meeting){
		BookingInformation bookingInformation = new BookingInformation(meeting.getUniqueID(), meeting.getInfoMeetingRoomName(), meeting.getDate(), meeting.getStartTime(), meeting.getEndTime(), meeting.getOrganizedBy());
		bookingInformationDao.saveBookingInformation(bookingInformation);
	}

}
