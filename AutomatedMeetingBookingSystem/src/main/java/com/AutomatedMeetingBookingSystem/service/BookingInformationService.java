package com.AutomatedMeetingBookingSystem.service;
import java.util.List;
import com.AutomatedMeetingBookingSystem.model.Meeting.meetingType;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;

public interface BookingInformationService {
	public List<MeetingRoom> getAvailableMeetingRoom(meetingType meetingType);
}
