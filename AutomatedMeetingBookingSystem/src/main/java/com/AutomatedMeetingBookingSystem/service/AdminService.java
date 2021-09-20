package main.java.com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.model.User;

public interface AdminService {

	public static List<MeetingRoom> getAllRooms();

	public User getAdminDetails(int empId);

	public MeetingRoom createMeetingRoom(MeetingRoom room);

	public String editMeeting(String uniqueId);

	public void deleteMeetingRoom(int uniqueId);

}
