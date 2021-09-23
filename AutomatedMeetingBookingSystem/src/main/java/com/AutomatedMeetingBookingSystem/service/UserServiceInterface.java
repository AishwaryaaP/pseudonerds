package com.AutomatedMeetingBookingSystem.service;

import com.AutomatedMeetingBookingSystem.model.User;

public interface UserServiceInterface {

	public User getUserDetails(String  name, String email);

	public double getUserCredits(int organizedBy);

	void updateUserCredits(double creditsReqForMeeting, int userId);
}
