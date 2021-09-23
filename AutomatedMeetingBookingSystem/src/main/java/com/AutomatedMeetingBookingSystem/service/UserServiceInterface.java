package com.AutomatedMeetingBookingSystem.service;

import java.util.ArrayList;

import com.AutomatedMeetingBookingSystem.model.User;

public interface UserServiceInterface {

	public User getUserDetails(int userId, String email);

	public double getUserCredits(int organizedBy);

	void updateUserCredits(double creditsReqForMeeting, int userId);

	public boolean addUsers(ArrayList<User> userList);
	
}
