package com.AutomatedMeetingBookingSystem.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.utility.DaoUtility;
import com.AutomatedMeetingBookingSystem.utility.DaoUtilityInterface;

public class AdminDao {

//	public List<MeetingRoom> getAllRooms(){
//		
//	}
//	
//	public boolean deleteRoom(MeetingRoom obj) {
//		
//	}
	public User getAdminDetails(int uniqueId) {
		DaoUtilityInterface dao = new DaoUtility();
		Connection conn = dao.getInstance();
		return null;
		
	}
}
