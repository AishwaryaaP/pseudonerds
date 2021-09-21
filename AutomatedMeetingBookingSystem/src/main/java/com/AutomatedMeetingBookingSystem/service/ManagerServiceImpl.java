package com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.enums.MeetingType;
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
		meetingService = ServiceFactory.getMeetingService();
		meetingRoomService = ServiceFactory.getMeetingRoomService();
		userService = ServiceFactory.getUserService();
	}

	@Override
	public boolean createMeeting(int organizedBy, String roomName, String title, String date, String startHours, String startMinutes, String endHours, String endMinutes, String type, String listOfMembers) {
			LocalDate meetingDate = LocalDate.parse(date);
			LocalTime startTime = LocalTime.of(Integer.parseInt(startHours), Integer.parseInt(startMinutes));
			LocalTime endTime = LocalTime.of(Integer.parseInt(endHours), Integer.parseInt(endMinutes));
			Meeting meeting = meetingService.saveMeeting(organizedBy, roomName, title, meetingDate, startTime, endTime, type, listOfMembers);
			bookingInfoService.saveBookingInformation(meeting);
			return true;
	}

	@Override
	public List<Meeting> getSchedule(int userId) {
		List<Meeting> schedules = meetingService.fetchMeetingsByUserID(userId);
		return schedules;
	}

	@Override
	public List<MeetingRoom> getAvailableRooms(String date, String startHours, String startMinutes, String endHours, String endMinutes, String type) {
		LocalDate meetingDate = LocalDate.parse(date);
		LocalTime startTime = LocalTime.of(Integer.parseInt(startHours), Integer.parseInt(startMinutes));
		LocalTime endTime = LocalTime.of(Integer.parseInt(endHours), Integer.parseInt(endMinutes));
		List<MeetingRoom> availableRooms = bookingInfoService.getAvailableMeetingRoom(MeetingType.valueOf(type));
		return availableRooms;
	}
	

}
