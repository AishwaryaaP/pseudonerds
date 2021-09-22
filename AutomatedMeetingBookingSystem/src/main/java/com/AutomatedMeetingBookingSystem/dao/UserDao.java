package com.AutomatedMeetingBookingSystem.dao;

import java.util.List;

import com.AutomatedMeetingBookingSystem.model.User;

public interface UserDao {
	
	public List<User> getAllUser();

	public double getUserCredits(int userId);

	void updateUserCredits(double credits, int userId);

}
