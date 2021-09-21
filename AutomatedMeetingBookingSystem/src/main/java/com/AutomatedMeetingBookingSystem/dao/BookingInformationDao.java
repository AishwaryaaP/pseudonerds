package com.AutomatedMeetingBookingSystem.dao;

import java.util.List;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;

public interface BookingInformationDao {
	public void saveBookingInformation(bookingInformation);
	public List<String> getMeetingRoomsByFilter(List<String> amenities);
	public List<String> getAvailableMeetingRooms(List<String> meetingRooms);
	public List<MeetingRoom> getMeetingRoomsDetails(List<String> avaliableMeetingRooms);
	
}
 