package com.AutomatedMeetingBookingSystem.service;

import com.AutomatedMeetingBookingSystem.dao.DaoFactory;
import com.AutomatedMeetingBookingSystem.dao.UserDao;
import com.AutomatedMeetingBookingSystem.model.User;

public class UserServiceImp implements UserServiceInterface{

	private UserDao userDao;
	
	public UserServiceImp() {
		super();
		userDao = DaoFactory.getUserDaoInstance();
	}

	@Override
	public User getUserDetails(String name, String email) {
		User newUser = new User(1313, "Mohit", "mt@gmail.com", "9767982409", "Admin");
		return newUser;
	}

	@Override
	public double getUserCredits(int userId) {
		double credits = userDao.getUserCredits(userId);
		return credits;
	}

	@Override
	public void updateUserCredits(double updatedCredits, int userId) {
		userDao.updateUserCredits(updatedCredits, userId);
	}



}
