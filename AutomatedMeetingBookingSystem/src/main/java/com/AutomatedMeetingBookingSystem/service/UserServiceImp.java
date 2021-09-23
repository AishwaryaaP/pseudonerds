package com.AutomatedMeetingBookingSystem.service;

import com.AutomatedMeetingBookingSystem.dao.DaoFactory;
import com.AutomatedMeetingBookingSystem.dao.UserDao;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.dao.DaoFactory;
import com.AutomatedMeetingBookingSystem.dao.UserDao;

public class UserServiceImp implements UserServiceInterface{

	private UserDao userDao;
	
	public UserServiceImp() {
		super();
		userDao = DaoFactory.getUserDaoInstance();
	}

	@Override
	public User getUserDetails(int userId, String email) {
		
		User user = userDao.getUserByNameAndEmail(userId, email);
		if(user!=null) {
			return user;
		}
		else {
			//Exception
			return null;
		}
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

	public boolean searchUserByEmailAndPassword(User user) {
		DaoFactory dao = new DaoFactory();
		UserDao userDao = dao.getUserDaoInstance();
		
		return userDao.searchUserByEmailAndPassword(user);
	}



}
