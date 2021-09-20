package com.AutomatedMeetingBookingSystem.service;
import java.util.List;

import com.AutomatedMeetingBookingSystem.enums.MeetingType;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;

public interface BookingInformationService {
	public List<MeetingRoom> getAvailableMeetingRoom(MeetingType meetingType);
}
