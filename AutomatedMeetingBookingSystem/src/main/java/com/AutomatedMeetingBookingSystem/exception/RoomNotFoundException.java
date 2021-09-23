package com.AutomatedMeetingBookingSystem.exception;

public class RoomNotFoundException extends Exception {
	

	public RoomNotFoundException() {
		super();
	}

	public RoomNotFoundException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return "Room with given Room ID doesn't exists !!";
	}

}
