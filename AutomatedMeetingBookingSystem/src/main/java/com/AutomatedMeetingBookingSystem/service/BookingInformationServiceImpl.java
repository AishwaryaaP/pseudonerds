package com.AutomatedMeetingBookingSystem.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.AutomatedMeetingBookingSystem.dao.BookingInformationDao;
import com.AutomatedMeetingBookingSystem.dao.DaoFactory;
import com.AutomatedMeetingBookingSystem.enums.MeetingType;
import com.AutomatedMeetingBookingSystem.exception.RoomNotFoundException;

import static com.AutomatedMeetingBookingSystem.enums.MeetingType.CLASSROOMTRAINING;
import static com.AutomatedMeetingBookingSystem.enums.MeetingType.BUSINESS ;
import static com.AutomatedMeetingBookingSystem.enums.MeetingType.CONFERENCECALL;
import static com.AutomatedMeetingBookingSystem.enums.MeetingType.ONLINETRAINING;

import com.AutomatedMeetingBookingSystem.model.BookingInformation;
import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.utility.ObjectFactory;
public class  BookingInformationServiceImpl implements BookingInformationService {
	
	private BookingInformationDao bookingInformationDao;
	private static Logger logger;
	
		

	public BookingInformationServiceImpl() {
		super();
		this.bookingInformationDao = DaoFactory.getBookingDaoInstance();
		logger = LogManager.getLogger(MeetingRoomService.class);
		BasicConfigurator.configure();
	}




	@Override
	public List<MeetingRoom> getAvailableMeetingRoom(LocalDate meetingDate, LocalTime startTime, LocalTime endTime, MeetingType type) {
		List<MeetingRoom> meetingRoomsDetails = null;
		try
		{
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
			meetingRoomsDetails = bookingInformationDao.getAvailableMeetingRooms(meetingDate, startTime, endTime, amenities);
			if(meetingRoomsDetails.size() == 0)
				throw new RoomNotFoundException("MeetingRoom not found");
		}
		catch(RoomNotFoundException e)
		{
			System.err.println(e.getMessage());
			logger.info(e.getMessage());
		}
		return meetingRoomsDetails;
	}
	
	@Override
	public boolean saveBookingInformation(Meeting meeting){
		BookingInformation bookingInformation = new BookingInformation(meeting.getUniqueID(), meeting.getInfoMeetingRoomName(), meeting.getDate(), meeting.getStartTime(), meeting.getEndTime(), meeting.getOrganizedBy());
		boolean result = bookingInformationDao.saveBookingInformation(bookingInformation);
		return result;
	}
	
	@Override
	public boolean deleteBookingInformation(int uniqueId, LocalDate date, LocalTime startTime) {
		return bookingInformationDao.deleteBookingInfo(uniqueId, date, startTime);
	}

}
