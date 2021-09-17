package com.AutomatedMeetingBookingSystem.service;
import java.util.List;
import com.AutomatedMeetingBookingSystem.model.BookingInformation;

public interface BookingInformationService {
	public List<MeetingRoom> getAvailableMeetingRoom(MeetingType meetingType);
}
