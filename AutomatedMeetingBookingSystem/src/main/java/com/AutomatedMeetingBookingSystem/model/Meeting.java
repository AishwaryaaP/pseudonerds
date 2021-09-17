package com.AutomatedMeetingBookingSystem.model;

import java.time.LocalTime;
import java.time.LocalDate;

public class Meeting {

	private int organiser;
	private String roomName;
	private String meetingTitle;
	private LocalDate date;
	private LocalTime starttime;
	private LocalTime endtime;
	public enum meetingType{CLASSROOMTRAINING,ONLINETRAINING,CONFERENCECAL,BUSINESS} meetingType type;

	public Meeting(int organiser, String roomName, String meetingTitle, LocalDate date, LocalTime starttime,
			LocalTime endtime, meetingType type) {
		super();
		this.organiser = organiser;
		this.roomName = roomName;
		this.meetingTitle = meetingTitle;
		this.date = date;
		this.starttime = starttime;
		this.endtime = endtime;
		this.type = type;
	}

	public int getOrganiser() {
		return organiser;
	}

	public String getRoomName() {
		return roomName;
	}

	public String getMeetingTitle() {
		return meetingTitle;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getStartTime() {
		return starttime;
	}

	public LocalTime getEndTime() {
		return endtime;
	}
	
	public meetingType getType() {
		return type;
	}

	public String toString() {
		return this.getOrganiser() + " " + this.getRoomName() + " " + this.getMeetingTitle() + " " + this.getDate()
				+ " " + this.getStartTime() + " " + this.getEndTime()+" "+this.getType();
	}
}