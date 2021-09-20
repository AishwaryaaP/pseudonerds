package com.AutomatedMeetingBookingSystem.dao;

import java.util.List;

import com.AutomatedMeetingBookingSystem.model.User;

public interface UserDao {
	
	public User getUserDetails(int userId, String password);
	public List<User> getAllUser();

}
