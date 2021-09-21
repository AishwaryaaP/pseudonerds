package com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.MeetingRoomServiceImpl;

import com.AutomatedMeetingBookingSystem.dao.AdminDao;
import com.AutomatedMeetingBookingSystem.dao.DaoFactory;

public class AdminService implements AdminServiceInterface {

	public List<MeetingRoom> getAllRooms() {
		MeetingRoomService meetingroom = ServiceFactory.getMeetingRoomService();
		return meetingroom.getAllMeetingRooms();
	}

// This function returns the details of a particular admin currently logged in
	// exception handling ????
	public User getAdminDetails(int empId) {
		 UserDao adminDao = DaoFactory.getUserDaoInstance();
		 
		return adminDao.getUserDetails(empId);
		return null;
	}

	// to craete a meeting room
	public MeetingRoom createMeetingRoom(MeetingRoom room) {

		MeetingRoomService meetingRoomService = ServiceFactory.getMeetingRoomService();
//name***************************** 
		meetingRoomService.addRoom(room);
		return room;
	}

	public void deleteMeetingRoom(int uniqueId) {// have to implement
		MeetingRoomService meetingRoomService = ServiceFactory.getMeetingRoomService();
		// name param*****************************
		// add method
		meetingRoomService.deleteMeetingRoom(uniqueId);

	}

	public boolean editMeetingRoom(int uniqueId) {// have to implement
		MeetingRoomService meetingRoomService = ServiceFactory.getMeetingRoomService();
		// name param*****************************
		
		boolean updated = meetingRoomService.updateRoomDetails(uniqueId);
		if(updated)
			return true;
		
		return false;
	}

	

	
}