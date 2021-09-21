package com.AutomatedMeetingBookingSystem.model;

import java.time.LocalTime;
import java.time.LocalDate;
import com.AutomatedMeetingBookingSystem.enums.MeetingType;

public class Meeting {
	private int uniqueID;
	private int organizedBy;
	private String infoMeetingRoomName;
	private String title;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	private String listOfMember;
	public MeetingType type;

	public Meeting( int uniqueID, int organisedBy, String infoMeetingRoomName, String title, LocalDate date, LocalTime startTime,
			LocalTime endTime, MeetingType type, String listOfMember) {
		super();
		this.uniqueID = uniqueID;
		this.organizedBy = organisedBy;
		this.infoMeetingRoomName = infoMeetingRoomName;
		this.title = title;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.type = type;
		this.listOfMember = listOfMember;
	}


	public Meeting() {
		super();
	}


	public int getUniqueID() {
		return uniqueID;
	}



	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}



	public int getOrganizedBy() {
		return organizedBy;
	}


	public void setOrganizedBy(int organizedBy) {
		this.organizedBy = organizedBy;
	}
	
	
	
	public String getInfoMeetingRoomName() {
		return infoMeetingRoomName;
	}
	

	
	public void setInfoMeetingRoomName(String infoMeetingRoomName) {
		this.infoMeetingRoomName = infoMeetingRoomName;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public LocalTime getStartTime() {
		return startTime;
	}



	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}



	public LocalTime getEndTime() {
		return endTime;
	}



	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}



	public MeetingType getType() {
		return type;
	}



	public void setType(MeetingType type) {
		this.type = type;
	}


	public String getListOfMember() {
		return listOfMember;
	}



	public void setListOfMember(String listOfMember) {
		this.listOfMember = listOfMember;
	}
	
	public String toString() {
		return "Meeting [getUniqueID()=" + getUniqueID() + ", getOrganizedBy()=" + getOrganizedBy()
				+ ", getInfoMeetingRoomName()=" + getInfoMeetingRoomName() + ", getTitle()=" + getTitle()
				+ ", getDate()=" + getDate() + ", getStartTime()=" + getStartTime() + ", getEndTime()=" + getEndTime()
				+ ", getType()=" + getType() + ", getListOfMember()=" + getListOfMember() + "]";
	}
}
