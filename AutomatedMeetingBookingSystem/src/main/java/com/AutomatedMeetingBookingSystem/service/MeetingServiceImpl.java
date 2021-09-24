package com.AutomatedMeetingBookingSystem.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;

import com.AutomatedMeetingBookingSystem.dao.DaoFactory;
import com.AutomatedMeetingBookingSystem.dao.MeetingDao;
import com.AutomatedMeetingBookingSystem.exception.ConnectionFailedException;
import com.AutomatedMeetingBookingSystem.model.Meeting;

public class MeetingServiceImpl implements MeetingService {
	
	private MeetingDao meetingDao;
	private MeetingRoomService meetingRoomService;
	
	public MeetingServiceImpl() {
		super();                                                                                 
		meetingDao = DaoFactory.getMeetingDaoInstance();
		meetingRoomService = ServiceFactory.getMeetingRoomService();
	}
	
	public Meeting saveMeeting(int organizedBy, String roomName, String title, LocalDate meetingDate, LocalTime startTime, LocalTime endTime, String type, String listOfMembers) {
		Meeting meeting1 = null;
		try {
			int meetingId = this.meetingDao.createMeeting(organizedBy, roomName, title, meetingDate, startTime, endTime, type, listOfMembers);
			meeting1 = this.meetingDao.fetchMeetingByUniqueID(meetingId);
			meetingRoomService.incrementMeetingCount(roomName);
		} catch (ConnectionFailedException e) {
			System.out.println(e.getMessage());
		}
		return meeting1;
	}
	
	public Meeting fetchMeetingByUniqueID(int uniqueID) {
		Meeting meeting1 = null;
		try {
			meeting1 = this.meetingDao.fetchMeetingByUniqueID(uniqueID);
		} catch (ConnectionFailedException e) {
			System.out.println(e.getMessage());
		}
		return meeting1;
	}
	
	public List<Meeting> fetchMeetingsByUserID(int userID) {
		List<Meeting> meetings = new ArrayList<>();
		try {        
			List<Meeting> allMeetings = this.meetingDao.fetchAllMeetings();
			for(Meeting meeting: allMeetings) {
				String userDetails = meeting.getListOfMember();				
				userDetails = userDetails.substring(1,userDetails.length()-1);
				String[] members = userDetails.split(",");	
				for(String member : members){
					if(member.trim().equals(String.valueOf(userID))) {
						meetings.add(meeting);
						break;
					}
				}
			}
		}catch (ConnectionFailedException e) {
			System.out.println(e.getMessage());
		}
		return meetings;
	}

	@Override
	public List<Meeting> fetchMeetingsByOrganizedByManager(int managerId) {
		List<Meeting> meetings = meetingDao.fetchMeetingsByManagerID(managerId);
		return meetings;
	}
	
	public boolean deleteMeetingByUniqueId(int uniqueId) {
		boolean result = meetingDao.deleteMeetingByUniqueId(uniqueId);
		return result;
	}

	@Override
	public boolean updateMeeting(Meeting meeting) {
		boolean result = meetingDao.updateMeeting(meeting);
		return result;
	}

}

