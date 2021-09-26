package com.AutomatedMeetingBookingSystem.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.AutomatedMeetingBookingSystem.model.BookingInformation;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;

public interface BookingInformationDao {

	boolean saveBookingInformation(BookingInformation bookingInformation);

	public List<MeetingRoom> getAvailableMeetingRooms(LocalDate meetingDate, LocalTime startTime, LocalTime endTime,
			String amenities);
	
	public boolean deleteBookingInfo(int uniqueId, LocalDate date, LocalTime startTime);
	
}
 