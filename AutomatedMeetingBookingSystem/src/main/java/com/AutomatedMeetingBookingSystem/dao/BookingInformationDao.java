package com.app.dao;

import java.util.List;

import com.app.model.BookingInformation;

public interface BookingInformationDao {
	public List<String> getMeetingRoomsByFilter(List<String> amenities);
	public List<String> getAvailableMeetingRooms(List<String> meetingRooms);
	public List<MeetingRoom> getMeetingRoomsDetails();
	
}
 