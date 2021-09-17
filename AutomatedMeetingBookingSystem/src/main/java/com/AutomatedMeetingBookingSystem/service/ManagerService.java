package service;

import java.util.List;

public interface ManagerService {
	
	public int createMeeting(int organizedBy, String title, String date, String startTime, String endTime, String type, String listOfMembers);

	public List<BookingInfo> getSchedule(User u);
	
	public List<MeetingRoom> getAvailableRooms(String startTime, String endTime, String type);
}
