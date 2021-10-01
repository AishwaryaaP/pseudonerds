package com.AutomatedMeetingBookingSystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.AutomatedMeetingBookingSystem.dao.MeetingRoomDao;
import com.AutomatedMeetingBookingSystem.exception.RoomNotFoundException;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MeetingRoomServiceImpl implements MeetingRoomService {
	MeetingRoomDao roomDao = MeetingRoomDao.getInstance();
	private List<MeetingRoom> roomList = new ArrayList<>();
	private static Map<String, Integer> amenitiesCredit = new HashMap<>();

	private static Logger logger;

	public MeetingRoomServiceImpl() {
		amenitiesCredit.put("PROJECTOR", 5);
		amenitiesCredit.put("WIFICONNECTION", 10);
		amenitiesCredit.put("CONFERENCECALL", 15);
		amenitiesCredit.put("WHITEBOARD", 5);
		amenitiesCredit.put("WATERDISPENCER", 5);
		amenitiesCredit.put("TV", 10);
		amenitiesCredit.put("COFFEEMACHINE", 10);
		logger = LogManager.getLogger(MeetingRoomService.class);
		BasicConfigurator.configure();
	}

	@Override
	public void getSchedule(String roomName) {
		// Dao serviceDao = DummyDao.getMeetingServiceClass();
		// List<Meeting> meetings = serviceDao.getMeetingsOnDate(roomName,private
		// LocalTime endtime;);
		// Extract schedule for all meetings and return available time
	}

	@Override
	public MeetingRoom getRoomDetailsByRoomName(String roomName) {
		MeetingRoom room = null;
		try {
			room = roomDao.fetchMeetingRoomByName(roomName);
			if (room == null)
				throw new RoomNotFoundException("Room not found!!");

		} catch (RoomNotFoundException e) {
			System.err.println(e.getMessage());
			logger.info(e.getMessage());
		}
		return room;
	}

	@Override
	public List<MeetingRoom> getAllMeetingRooms() {
		try {

			roomList = this.roomDao.fetchAllMeetingRooms();
			if (roomList == null) {
				throw new RoomNotFoundException("No rooms Found!");
			}
		} catch (RoomNotFoundException e) {
			System.err.println(e.getMessage());
			logger.info(e.getMessage());
		}
		return roomList;
	}

	@Override
	public boolean updateRoomDetails(MeetingRoom roomToBeUpdated)

	{
		boolean result = roomDao.updateMeetingRoom(roomToBeUpdated);
		try {
			if (!result)
				throw new RoomNotFoundException("Room not found!!");
		} catch (RoomNotFoundException e) {
			System.err.println(e.getMessage());
			logger.info(e.getMessage());
			return false;
		}
		return result;
	}

	@Override
	public boolean deleteRoomByRoomName(String roomName) {
		boolean result = roomDao.deleteMeetingRoomByName(roomName);
		try {
			if (!result)
				throw new RoomNotFoundException("Room Not found!!");
		} catch (RoomNotFoundException e) {
			System.err.println(e.getMessage());
			logger.info(e.getMessage());
			return false;
		}
		return result;
	}

	@Override
	public boolean addRoom(MeetingRoom room) {
		boolean result = roomDao.insertMeetingRoom(room);
		return result;

	}

	@Override
	public Map<String, Integer> getAmenitiesCredit() {
		return amenitiesCredit;
	}

	@Override
	public boolean addNewAmenitiesCredit(String aminity, int credit) {
		if (aminity != null) {
			amenitiesCredit.put(aminity, credit);
			return true;
		} else
			return false;
	}

	@Override
	public boolean addRating(String roomName, int rating) {
		
		MeetingRoom room = getRoomDetailsByRoomName(roomName);
		room.setRatingSum(room.getRatingSum() + rating);
		room.setRatingCount(room.getRatingCount() + 1);
		room.setRating(room.getRatingSum() / room.getRatingCount());
		return(roomDao.updateRatingMeetingRoom(room));
	}

	@Override
	public int getRoomPerHourCredits(String roomName) {
		MeetingRoom room = getRoomDetailsByRoomName(roomName);
		return room.getCreditPerHour();
	}

	@Override
	public void incrementMeetingCount(String roomName) {
		int currentCount = getRoomDetailsByRoomName(roomName).getCount();
		roomDao.incrementMeetingCount(roomName, currentCount);
	}

}
