package com.AutomatedMeetingBookingSystem.service;

import java.util.List;
import java.util.Map;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.MeetingRoomServiceImpl;

import com.AutomatedMeetingBookingSystem.dao.DaoFactory;
import com.AutomatedMeetingBookingSystem.dao.UserDao;

public class AdminService implements AdminServiceInterface {

	MeetingRoomService meetingRoomService;
	public AdminService() {
		meetingRoomService = ServiceFactory.getMeetingRoomService();
	}
	
	public List<MeetingRoom> getAllRooms() {
		return meetingRoomService.getAllMeetingRooms();
	}


	public boolean createMeetingRoom(MeetingRoom room) {
		boolean inserted = meetingRoomService.addRoom(room);
		if(inserted)
			return true;
		return false;
	}

	public boolean deleteMeetingRoom(int uniqueId) {// have to implement
		
		boolean deleted = meetingRoomService.deleteMeetingRoom(uniqueId);
		if(deleted)
			return true;
		return false;
	}

	public boolean editMeetingRoom(MeetingRoom updatedMeetingRoom) {
		boolean updated = meetingRoomService.updateRoomDetails(updatedMeetingRoom);
		if(updated)
			return true;
		
		return false;
	}

	
	@Override
	public Map<String, Integer> getAmenitiesCredit() {
		return meetingRoomService.getAmenitiesCredit();
		
	}


	

	
}