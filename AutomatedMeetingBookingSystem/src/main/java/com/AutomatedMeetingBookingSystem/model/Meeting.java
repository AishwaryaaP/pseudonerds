package com.AutomatedMeetingBookingSystem.model;

import java.time.LocalTime;
import java.time.LocalDate;

public class Meeting {
	private int uniqueID;
	private int organisedBy;
	private String roomName;
	private String meetingTitle;
	private LocalDate date;
	private LocalTime starttime;
	private LocalTime endtime;
	//List listOfMember JSON;
	public enum meetingType{CLASSROOMTRAINING,ONLINETRAINING,CONFERENCECAL,BUSINESS} meetingType type;

	public Meeting( int uniqueID, int organisedBy, String roomName, String meetingTitle, LocalDate date, LocalTime starttime,
			LocalTime endtime, meetingType type) {
		super();
		this.uniqueID = uniqueID;
		this.organisedBy = organisedBy;
		this.roomName = roomName;
		this.meetingTitle = meetingTitle;
		this.date = date;
		this.starttime = starttime;
		this.endtime = endtime;
		this.type = type;
	}

	

	public int getUniqueID() {
		return uniqueID;
	}



	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}



	public int getOrganisedBy() {
		return organisedBy;
	}



	public void setOrganisedBy(int organisedBy) {
		this.organisedBy = organisedBy;
	}



	public String getRoomName() {
		return roomName;
	}



	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}



	public String getMeetingTitle() {
		return meetingTitle;
	}



	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public LocalTime getStarttime() {
		return starttime;
	}



	public void setStarttime(LocalTime starttime) {
		this.starttime = starttime;
	}



	public LocalTime getEndtime() {
		return endtime;
	}



	public void setEndtime(LocalTime endtime) {
		this.endtime = endtime;
	}



	public meetingType getType() {
		return type;
	}



	public void setType(meetingType type) {
		this.type = type;
	}



	public String toString() {
		return this.getUniqueID() + " " + this.getOrganisedBy() + " " + this.getRoomName() + " " + this.getMeetingTitle() + " " + this.getDate()
				+ " " + this.getStarttime() + " " + this.getEndtime()+" "+this.getType();
	}
}