package com.AutomatedMeetingBookingSystem.exception;

public class ResourceNotFoundException extends Exception {

	@Override
	public String toString() {
		return "Resource doesn't exists !!";
	}

}
