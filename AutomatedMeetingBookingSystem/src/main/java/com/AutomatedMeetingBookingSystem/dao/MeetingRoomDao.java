package com.AutomatedMeetingBookingSystem.dao;

import java.util.List;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;

public interface MeetingRoomDao {
	
	static MeetingRoomDao getInstance() {
		return new MeetingRoomDaoImpl();
	}

	MeetingRoom fetchMeetingRoomByName(String roomName);
	List<MeetingRoom> fetchAllMeetingRooms();
	boolean insertMeetingRoom(MeetingRoom room);
	boolean updateMeetingRoom(MeetingRoom room);
	boolean deleteMeetingRoomByName(String roomName);

}
