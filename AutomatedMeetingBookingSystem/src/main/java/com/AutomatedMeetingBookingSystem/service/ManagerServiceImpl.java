package com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.model.User;

import java.time.LocalDate;
import java.time.LocalTime;

public class ManagerServiceImpl implements ManagerService{

	private MeetingRoomService meetingRoomService;
	private MeetingService meetingService;
	private BookingInformationService bookingInfoService;
	private UserServiceInterface userService;
	
	public ManagerServiceImpl() {
		super();
//		meetingService = ServiceFactory.getMeetingServiceInstance();
//		meetingRoomService = new ServiceFactory.getMeetingRoomServiceInstance();
//		userService = new ServiceFactory.getUserServiceInstance();
		meetingService = new MeetingServiceImpl();
		meetingRoomService = new MeetingRoomServiceImpl();
		userService = new UserServiceImp();
	}

	@Override
	public Meeting createMeeting(int organizedBy, String roomName, String title, String date, String startHours, String startMinutes, String endHours, String endMinutes, String type, String listOfMembers) {
			LocalDate meetingDate = LocalDate.parse(date);
			LocalTime startTime = LocalTime.of(Integer.parseInt(startHours), Integer.parseInt(startMinutes));
			LocalTime endTime = LocalTime.of(Integer.parseInt(endHours), Integer.parseInt(endMinutes));
			List<User> userList = null;
			Meeting meeting = meetingService.saveMeeting(organizedBy, roomName, title, date, startTime, endTime, type, userList);
			bookingInfoService.saveBookingInformation(roomName, meetingDate, startTime, endTime, organizedBy);
			return meeting;
	}

	@Override
	public List<Meeting> getSchedule(User u) {
		List<Meeting> schedules = meetingService.fetchMeetingsByUserID(u.getEmpId());
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
