package com.AutomatedMeetingBookingSystem.service;

import com.AutomatedMeetingBookingSystem.model.User;

public interface UserServiceInterface {

	public User getUserDetails(int userId, String password);
}
