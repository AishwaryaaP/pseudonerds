package service;

import java.util.List;

public interface ManagerService {
	
	public int createMeeting(int organizedBy, int title, String date, String startHours, String startMinutes, String endHours, String endMinutes, String type, List<User> listOfMembers)

	public List<BookingInfo> getSchedule(User u);
	
	public List<MeetingRoom> getAvailableRooms(String startTime, String endTime, String type);
}
