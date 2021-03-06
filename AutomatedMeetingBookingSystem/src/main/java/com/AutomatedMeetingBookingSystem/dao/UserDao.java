package com.AutomatedMeetingBookingSystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.AutomatedMeetingBookingSystem.model.User;

public interface UserDao {
	
	public List<User> getAllUser();

	public double getUserCredits(int userId);

	void updateUserCredits(double credits, int userId);

	public void resetManagerCredits();
	public User getUserByNameAndEmail(int userId, String email);

	public boolean addUsers(ArrayList<User> userList);

	public void setLastLoggedIn(int userId);


}
