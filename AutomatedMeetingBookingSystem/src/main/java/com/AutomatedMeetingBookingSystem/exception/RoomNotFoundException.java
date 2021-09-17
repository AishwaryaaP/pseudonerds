package com.AutomatedMeetingBookingSystem.exception;

public class RoomNotFoundException extends Exception {

	@Override
	public String toString() {
		return "Room with given Room ID doesn't exists !!";
	}

}
