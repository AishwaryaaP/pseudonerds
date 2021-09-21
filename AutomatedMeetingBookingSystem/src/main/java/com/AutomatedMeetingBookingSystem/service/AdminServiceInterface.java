package com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.model.User;

public interface AdminServiceInterface {

	public List<MeetingRoom> getAllRooms();

	public User getAdminDetails(int empId);

	public MeetingRoom createMeetingRoom(MeetingRoom room);
	public boolean editMeetingRoom(int uniqueId);

	public void deleteMeetingRoom(int uniqueId);

}