package com.AutomatedMeetingBookingSystem.service;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

import com.AutomatedMeetingBookingSystem.dao.DaoFactory;
import com.AutomatedMeetingBookingSystem.dao.UserDao;
import com.AutomatedMeetingBookingSystem.exception.UserNotFoundException;
import com.AutomatedMeetingBookingSystem.model.User;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
public class UserServiceImp implements UserServiceInterface{

	private UserDao userDao;
	private static Logger logger;
	
	public UserServiceImp() {
		super();
		userDao = DaoFactory.getUserDaoInstance();
		logger = LogManager.getLogger(MeetingRoomService.class);
		BasicConfigurator.configure();
		//PropertyConfigurator.configure("//AutomatedMeetingBookingSystem//log4j.properties");
	}

	@Override
	public User getUserDetails(int userId, String email) {
		
		User user = userDao.getUserByNameAndEmail(userId, email);
		try {
		if(user!=null) {
			return user;
		}
		else {
			
			throw new UserNotFoundException("No such user found");
			
		}
		}
		catch(UserNotFoundException e) {
			System.err.println(e.getMessage());
			logger.info(e.getMessage());
		}
		return user;
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

	@Override
	public boolean addUsers(ArrayList<User> userList) {
		if(userDao.addUsers(userList)) {
			return true;
		}
		return false;
	}

	@Override
	public void setLastLoggedIn(int userId) {
		userDao.setLastLoggedIn(userId);
	}



}
