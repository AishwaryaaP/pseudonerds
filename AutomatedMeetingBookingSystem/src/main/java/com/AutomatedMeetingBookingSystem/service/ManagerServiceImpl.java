package com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.enums.MeetingType;
import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.model.User;

import java.time.Duration;
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
			int meetingRoomCredits = meetingRoomService.getRoomPerHourCredits(roomName);
			double meetingDuration = Duration.between(startTime, endTime).toMinutes();
			double creditsReqForMeeting = meetingDuration*meetingRoomCredits;
			double managerCredits = userService.getUserCredits(organizedBy);
			double updatedCredits = managerCredits - creditsReqForMeeting;
			if(updatedCredits > 0) {
				Meeting meeting = meetingService.saveMeeting(organizedBy, roomName, title, meetingDate, startTime, endTime, type, listOfMembers);
				userService.updateUserCredits(updatedCredits, organizedBy);
				bookingInfoService.saveBookingInformation(meeting);
				return true;
			}
			return false;
	}

	@Override
	public List<MeetingRoom> getAvailableRooms(String date, String startHours, String startMinutes, String endHours, String endMinutes, String type) {
		LocalDate meetingDate = LocalDate.parse(date);
		LocalTime startTime = LocalTime.of(Integer.parseInt(startHours), Integer.parseInt(startMinutes));
		LocalTime endTime = LocalTime.of(Integer.parseInt(endHours), Integer.parseInt(endMinutes));
		List<MeetingRoom> availableRooms = bookingInfoService.getAvailableMeetingRoom(MeetingType.valueOf(type));
		return availableRooms;
	}

	@Override
	public List<Meeting> getOrganizedByManager(int managerId) {
		List<Meeting> schedules = meetingService.fetchMeetingsByOrganizedByManager(managerId);
		return schedules;
	}

}
