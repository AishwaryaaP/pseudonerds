/**
 * 
 */
package main.java.com.AutomatedMeetingBookingSystem.dao;

import com.AutomatedMeetingBookingSystem.model.User;

public interface AdminDao
{
	public User getAdminDetails(int uniqueId);
}
