package com.AutomatedMeetingBookingSystem.model;

import java.sql.Time;
import java.sql.Date;

public class Meeting {

	private int organiser;
	private String roomName;
	private String meetingTitle;
	private Date date;
	private Time starttime;
	private Time endtime;
	public enum meetingType{CLASSROOMTRAINING,ONLINETRAINING,CONFERENCECAL,BUSINESS} meetingType type;

	public Meeting(int organiser, String roomName, String meetingTitle, Date date, Time starttime,
			Time endtime, meetingType type) {
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

	public Date getDate() {
		return date;
	}

	public Time getStartTime() {
		return starttime;
	}

	public Time getEndTime() {
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