package com.AutomatedMeetingBookingSystem.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.MeetingRoomServiceImpl;

import com.AutomatedMeetingBookingSystem.dao.DaoFactory;
import com.AutomatedMeetingBookingSystem.dao.UserDao;
import com.AutomatedMeetingBookingSystem.exception.NoRoomsFoundException;
import com.AutomatedMeetingBookingSystem.exception.NoServiceFoundException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class AdminService implements AdminServiceInterface {

	MeetingRoomService meetingRoomService;
	private static Logger logger;
	public AdminService() {
		try {
			meetingRoomService = ServiceFactory.getMeetingRoomService();
			if (meetingRoomService == null) {
				throw new NoServiceFoundException("No Meeting Room Service Found");
			}

		} catch (NoServiceFoundException e) {
			System.err.println(e.getMessage());
		}
		logger = LogManager.getLogger(MeetingRoomService.class);
		BasicConfigurator.configure();

	}

	public List<MeetingRoom> getAllRooms() {
		try {
			List<MeetingRoom>myList =  meetingRoomService.getAllMeetingRooms();
			if(myList.size() ==0) {
				throw new NoRoomsFoundException("No Rooms found Create a room first");
			}
			return myList;
			
		}
		catch(NoRoomsFoundException e) {
			System.err.println(e.getMessage());
			logger.info(e.getMessage());
			return null;
		}
		}

	public boolean createMeetingRoom(MeetingRoom room) {
		boolean inserted = meetingRoomService.addRoom(room);
		if (inserted)
			return true;
		return false;
	}

	public boolean deleteMeetingRoom(String roomName) {// have to implement

		boolean deleted = meetingRoomService.deleteRoomByRoomName(roomName);
		if (deleted)
			return true;
		return false;
	}

	public boolean editMeetingRoom(MeetingRoom updatedMeetingRoom) {
		boolean updated = meetingRoomService.updateRoomDetails(updatedMeetingRoom);
		if (updated)
			return true;

		return false;
	}

	@Override
	public Map<String, Integer> getAmenitiesCredit() {
		return meetingRoomService.getAmenitiesCredit();

	}

}