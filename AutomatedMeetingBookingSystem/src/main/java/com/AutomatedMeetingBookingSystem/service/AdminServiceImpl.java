package main.java.com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.MeetingRoomServiceImpl;

import main.java.com.AutomatedMeetingBookingSystem.dao.AdminDao;
import main.java.com.AutomatedMeetingBookingSystem.dao.AdminDaoImpl;

public class AdminServiceImpl implements AdminService {
	// to get all meeting rooms created.
	// handle the not null exception in the dao layer
	// exception handling ????
	public List<MeetingRoom> getAllRooms() {
		MeetingRoomService meetingroom = new MeetingRoomServiceImpl();
		return meetingroom.getAllMeetingRooms();
	}

// This function returns the details of a particular admin currently logged in
	// exception handling ????
	public User getAdminDetails(int empId) {
		AdminDao adminDao = new AdminDaoImpl();
		return adminDao.getAdminDetails(empId);
	}

	// to craete a meeting room
	public MeetingRoom createMeetingRoom(MeetingRoom room) {

		MeetingRoomService meetingRoomService = new MeetingRoomServiceImpl();
		meetingRoomService.addRoom(room);
		return room;
	}

	public String editMeeting(String uniqueId)

	{
		// logic to edit the meeting time / date etc
		return uniqueId;

	}

	public void deleteMeetingRoom(int uniqueId) {// have to implement

		System.out.println("Room Deleted");
	}
}
