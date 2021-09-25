package com.AutomatedMeetingBookingSystem.service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.AutomatedMeetingBookingSystem.enums.MeetingType;
import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;

public interface BookingInformationService {

	List<MeetingRoom> getAvailableMeetingRoom(LocalDate meetingDate, LocalTime startTime, LocalTime endTime, MeetingType type);
	
	public void saveBookingInformation(Meeting meeting);
	
	public boolean deleteBookingInformation(int uniqueId, LocalDate date, LocalTime startTime);
}
