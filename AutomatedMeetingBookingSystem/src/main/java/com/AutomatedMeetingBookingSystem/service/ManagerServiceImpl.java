package service;

import java.util.List;

public class ManagerServiceImpl implements ManagerService{

	private MeetingRoomService meetingRoomService;
	private MeetingService meetingService;
	private BookingInfoService bookingInfoService;
	private UserService userService;
	
	public ManagerServiceImpl() {
		super();
		meetingService = new ObjectFactory.getMeetingServiceInstance();
		meetingRoomService = new ObjectFactory.getMeetingRoomServiceInstance();
		userService = new ObjectFactory.getUserServiceInstance();
	}

	@Override
	public int createMeeting(int organizedBy, String title, String date, String startTime, String endTime, String type,
			String listOfMembers) {
		if(userService.findById(organizedBy) != null) {
			int meetingId = meetingService.createMeeting(organizedBy, title, date, startTime, endTime, type, listOfMembers);
			return meetingId;
		}
		return 0;
	}

	@Override
	public List<BookingInfo> getSchedule(User u) {
		List<BookingInfo> schedules = bookingInfoService.getSchedule(u);
		return schedules;
	}

	@Override
	public List<MeetingRoom> getAvailableRooms(String startTime, String endTime, String type) {
		List<MeetingRoom> availableRooms = bookingInfoService.getAvailableRooms(startTime, endTime, type);
		return null;
	}
	

}
