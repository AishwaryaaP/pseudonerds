package com.AutomatedMeetingBookingSystem.service;

import java.util.List;

import com.AutomatedMeetingBookingSystem.dao.DaoFactory;
import com.AutomatedMeetingBookingSystem.dao.UserDao;
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
	private UserDao userDao;
	
	public ManagerServiceImpl() {
		super();
		meetingService = ServiceFactory.getMeetingService();
		meetingRoomService = ServiceFactory.getMeetingRoomService();
		userService = ServiceFactory.getUserService();
		userDao = DaoFactory.getUserDaoInstance();
		bookingInfoService = ServiceFactory.getBookingInformationService();
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
			System.out.println(startTime.toString());
			System.out.println(endTime.toString());
			System.out.println(meetingDuration);
			System.out.println(updatedCredits);
			System.out.println(creditsReqForMeeting);
			System.out.println(managerCredits);
			System.out.println(meetingRoomCredits);
			if(updatedCredits > 0) {
				Meeting meeting = meetingService.saveMeeting(organizedBy, roomName, title, meetingDate, startTime, endTime, type, listOfMembers);
				userService.updateUserCredits(updatedCredits, organizedBy);
				System.out.print(meeting.getInfoMeetingRoomName());
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
		List<MeetingRoom> availableRooms = bookingInfoService.getAvailableMeetingRoom(meetingDate, startTime, endTime, MeetingType.valueOf(type));
		return availableRooms;
	}

	@Override
	public List<Meeting> getOrganizedByManager(int managerId) {
		List<Meeting> schedules = meetingService.fetchMeetingsByOrganizedByManager(managerId);
		return schedules;
	}

	@Override
	public void resetManagerCredits() {
		String dayOfWeek = LocalDate.now().getDayOfWeek().toString();
		if(dayOfWeek.equals("MONDAY"))
		{
			userDao.resetManagerCredits();
		}
	}
	
	@Override
	public boolean deleteMeeting(int uniqueId, LocalDate date , LocalTime startTime, LocalTime endTime, String roomName,int organizedBy) {// have to implement
		boolean bookingdeleted = bookingInfoService.deleteBookingInformation(uniqueId, date, startTime);
		boolean deleted = meetingService.deleteMeetingByUniqueId(uniqueId);		
		if(deleted && bookingdeleted) {
			int meetingRoomCredits = meetingRoomService.getRoomPerHourCredits(roomName);
			double meetingDuration = Duration.between(startTime, endTime).toMinutes();
			double creditsReqForMeeting = meetingDuration*meetingRoomCredits;
			double managerCredits = userService.getUserCredits(organizedBy);
			double updatedCredits = managerCredits + creditsReqForMeeting;
			userService.updateUserCredits(updatedCredits, organizedBy);
			return true;
		}
		return false;
	}

	@Override
	public boolean editMeeting(int uniqueId , int organizedBy, String roomName, String title, String date, String startHours,
		String startMinutes, String endHours, String endMinutes, String type, String listOfMembers) {
		LocalDate meetingDate = LocalDate.parse(date);
		LocalTime startTime = LocalTime.of(Integer.parseInt(startHours), Integer.parseInt(startMinutes));
		LocalTime endTime = LocalTime.of(Integer.parseInt(endHours), Integer.parseInt(endMinutes));
		int meetingRoomCredits = meetingRoomService.getRoomPerHourCredits(roomName);
		double meetingDuration = Duration.between(startTime, endTime).toMinutes();
		double creditsReqForMeeting = meetingDuration*meetingRoomCredits;
		double managerCredits = userService.getUserCredits(organizedBy);
		double updatedCredits = managerCredits - creditsReqForMeeting;
	
		Meeting newMeeting =  new Meeting(uniqueId,  organizedBy,  roomName,  title, meetingDate,  startTime,
				 endTime,MeetingType.valueOf(type),  listOfMembers);
		boolean updated = meetingService.updateMeeting(newMeeting);
		if(updated)
			return true;
		return false;
		
	}

	

	

}
