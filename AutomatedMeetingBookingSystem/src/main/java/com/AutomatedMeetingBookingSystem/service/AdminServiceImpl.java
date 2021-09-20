package com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.MeetingRoomServiceImpl;

import com.AutomatedMeetingBookingSystem.dao.AdminDao;

public class AdminServiceImpl implements AdminServiceInterface {

	public List<MeetingRoom> getAllRooms() {
		MeetingRoomService meetingroom = ServiceFactory.getMeetingRoomService();
		return meetingroom.getAllMeetingRooms();
	}

// This function returns the details of a particular admin currently logged in
	// exception handling ????
	public User getAdminDetails(int empId) {
		// UserDao adminDao = new UserDaoImp();
//UserDao **************
		// return adminDao.getAdminDetails(empId);
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

	public void editMeetingRoom(int uniqueId) {// have to implement
		MeetingRoomService meetingRoomService = ServiceFactory.getMeetingRoomService();
		// name param*****************************
		
		meetingRoomService.updateRoomDetails(uniqueId);

	}
}