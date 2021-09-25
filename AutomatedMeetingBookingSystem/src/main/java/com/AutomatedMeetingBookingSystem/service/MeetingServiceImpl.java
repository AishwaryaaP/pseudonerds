package com.AutomatedMeetingBookingSystem.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.AutomatedMeetingBookingSystem.dao.DaoFactory;
import com.AutomatedMeetingBookingSystem.dao.MeetingDao;
import com.AutomatedMeetingBookingSystem.exception.ConnectionFailedException;
import com.AutomatedMeetingBookingSystem.exception.FailedToCreateMeetingException;
import com.AutomatedMeetingBookingSystem.exception.MeetingNotFoundException;
import com.AutomatedMeetingBookingSystem.model.Meeting;

public class MeetingServiceImpl implements MeetingService {
	
	private MeetingDao meetingDao;
	private MeetingRoomService meetingRoomService;
	private static Logger logger;
	
	public MeetingServiceImpl() {
		super();
		meetingDao = DaoFactory.getMeetingDaoInstance();
		meetingRoomService = ServiceFactory.getMeetingRoomService();
		logger = LogManager.getLogger(MeetingRoomService.class);
		BasicConfigurator.configure();
	}
	
	public Meeting saveMeeting(int organizedBy, String roomName, String title, LocalDate meetingDate, LocalTime startTime, LocalTime endTime, String type, String listOfMembers) {
		Meeting meeting1 = null;
		try {
			int meetingId = this.meetingDao.createMeeting(organizedBy, roomName, title, meetingDate, startTime, endTime, type, listOfMembers);
			meeting1 = this.meetingDao.fetchMeetingByUniqueID(meetingId);
			if(meeting1 == null)
				throw new FailedToCreateMeetingException("Falied to Create Meeting Exception");
			meetingRoomService.incrementMeetingCount(roomName);
		} catch (FailedToCreateMeetingException e) {
			System.err.println(e.getMessage());
			logger.info(e.getMessage());
		}
		return meeting1;
	}
	
	public Meeting fetchMeetingByUniqueID(int uniqueID) {
		Meeting meeting1 = null;
		try {
			meeting1 = this.meetingDao.fetchMeetingByUniqueID(uniqueID);
			if(meeting1 == null)
				throw new MeetingNotFoundException("Meeting with " + uniqueID + " not found");
		} catch (MeetingNotFoundException e) {
			System.out.println(e.getMessage());
			logger.info(e.getMessage());
		}
		return meeting1;
	}
	
	public List<Meeting> fetchMeetingsByUserID(int userID) {
		List<Meeting> meetings = new ArrayList<>();
		try {
			List<Meeting> allMeetings = this.meetingDao.fetchAllMeetings();
			for(Meeting meeting: allMeetings) {
				String userDetails = meeting.getListOfMember();
				
				JSONArray userIds = new JSONArray(userDetails);
				Iterator<Object> iterator = userIds.iterator();
				while(iterator.hasNext()) 
				{
					if((iterator.next()).equals(String.valueOf(userID)))
					{
						meetings.add(meeting);
						break;
					}
				}
				if(allMeetings.size() == 0)
					throw new MeetingNotFoundException("No meetings Found");
		}
		}catch (MeetingNotFoundException e) {
			System.out.println(e.getMessage());
			logger.info(e.getMessage());
		}
		return meetings;
	}

	@Override
	public List<Meeting> fetchMeetingsByOrganizedByManager(int managerId) {
		
		List<Meeting> meetings = null;
		try 
		{
			meetings = meetingDao.fetchMeetingsByManagerID(managerId);
			if(meetings.size() == 0)
				throw new MeetingNotFoundException("No meetings organized by " + managerId);
		}
		catch(MeetingNotFoundException e)
		{
			System.out.println(e.getMessage());
			logger.info(e.getMessage());
		}
		return meetings;
	}
	
	public boolean deleteMeetingByUniqueId(int uniqueId) {
		boolean result = meetingDao.deleteMeetingByUniqueId(uniqueId);
		try {
			if(!result)
				throw new MeetingNotFoundException("Meeting with " + uniqueId + " not found");
		}
		catch (MeetingNotFoundException e) 
		{
			System.out.println(e.getMessage());
			logger.info(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean updateMeeting(Meeting meeting) {
		boolean result = meetingDao.updateMeeting(meeting);
		try {
			if(!result)
				throw new MeetingNotFoundException("Meeting with " + meeting.getUniqueID() + " not found");
		}
		catch (MeetingNotFoundException e) 
		{
			System.out.println(e.getMessage());
			logger.info(e.getMessage());
		}
		return result;
	}

}

