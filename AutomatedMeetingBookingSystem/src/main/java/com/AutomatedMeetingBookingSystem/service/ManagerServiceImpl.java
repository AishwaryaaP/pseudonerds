package service;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class ManagerServiceImpl implements ManagerService{

	private MeetingRoomService meetingRoomService;
	private MeetingService meetingService;
	private BookingInfoService bookingInfoService;
	private UserService userService;
	
	public ManagerServiceImpl() {
		super();
		meetingService = new ServiceFactory.getMeetingServiceInstance();
		meetingRoomService = new ServiceFactory.getMeetingRoomServiceInstance();
		userService = new ServiceFactory.getUserServiceInstance();
	}

	@Override
	public Meeting createMeeting(int organizedBy, String roomName, int title, String date, String startHours, String startMinutes, String endHours, String endMinutes, String type, List<User> listOfMembers) {
			LocalDate meetingDate = LocalDate.parse(date);
			LocalTime startTime = LocalTime.of(Integer.parseInt(startHours), Integer.parseInt(startMinutes));
			LocalTime endTime = LocalTime.of(Integer.parseInt(endHours), Integer.parseInt(endMinutes));
			Meeting meeting = meetingService.saveMeeting(organizedBy, roomName, title, date, startTime, endTime, type, listOfMembers);
			bookingInfoService.saveBookingInfo(roomName, meetingDate, startTime, endTime, organizedBy);
			return meeting;
	}

	@Override
	public List<BookingInfo> getSchedule(User u) {
		List<BookingInfo> schedules = bookingInfoService.getSchedule(u);
		return schedules;
	}

	@Override
	public List<MeetingRoom> getAvailableRooms(String date, String startHours, String startMinutes, String endHours, String endMinutes, String type) {
		LocalDate meetingDate = LocalDate.parse(date);
		LocalTime startTime = LocalTime.of(Integer.parseInt(startHours), Integer.parseInt(startMinutes));
		LocalTime endTime = LocalTime.of(Integer.parseInt(endHours), Integer.parseInt(endMinutes));
		List<MeetingRoom> availableRooms = bookingInfoService.getAvailableRooms(meetingDate, startTime, endTime, type);
		return availableRooms;
	}
	

}