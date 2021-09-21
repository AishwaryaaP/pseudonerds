package com.AutomatedMeetingBookingSystem.service;

import com.AutomatedMeetingBookingSystem.model.User;

public class UserServiceImp implements UserServiceInterface{

	@Override
	public User getUserDetails(String name, String email) {
		User newUser = new User(1313, "Mohit", "mt@gmail.com", "9767982409", "Admin");
		
		return newUser;
	}



}
