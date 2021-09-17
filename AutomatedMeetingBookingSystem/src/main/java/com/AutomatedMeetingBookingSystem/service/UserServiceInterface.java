package com.AutomatedMeetingBookingSystem.service;

import com.AutomatedMeetingBookingSystem.model.User;

public interface UserServiceInterface {

	public User getUserDetails(String username, String password);
}
