package com.AutomatedMeetingBookingSystem.model;

import java.time.LocalTime;
import java.time.LocalDate;

public class Meeting {

	private int organisedBy;
	private String roomName;
	private String meetingTitle;
	private LocalDate date;
	private LocalTime starttime;
	private LocalTime endtime;
	//List listOfMember;
	public enum meetingType{CLASSROOMTRAINING,ONLINETRAINING,CONFERENCECAL,BUSINESS} meetingType type;

	public Meeting(int organisedBy, String roomName, String meetingTitle, LocalDate date, LocalTime starttime,
			LocalTime endtime, meetingType type) {
		super();
		this.organisedBy = organisedBy;
		this.roomName = roomName;
		this.meetingTitle = meetingTitle;
		this.date = date;
		this.starttime = starttime;
		this.endtime = endtime;
		this.type = type;
	}

	public int getOrganisedBy() {
		return organisedBy;
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
		return this.getOrganisedBy() + " " + this.getRoomName() + " " + this.getMeetingTitle() + " " + this.getDate()
				+ " " + this.getStartTime() + " " + this.getEndTime()+" "+this.getType();
	}
}