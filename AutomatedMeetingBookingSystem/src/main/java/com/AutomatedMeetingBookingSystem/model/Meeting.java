package com.AutomatedMeetingBookingSystem.model;

import java.time.LocalTime;
import java.util.List;
import java.time.LocalDate;

public class Meeting {
	private int uniqueID;
	private int organizedBy;
	private String infoOfMeeting;
	private String title;
	private LocalDate date;
	private LocalTime starttime;
	private LocalTime endtime;
	private List<Integer> listOfMember;
	public enum meetingType{CLASSROOMTRAINING,ONLINETRAINING,CONFERENCECAL,BUSINESS} meetingType type;

	public Meeting( int uniqueID, int organisedBy, String infoOfMeeting, String title, LocalDate date, LocalTime starttime,
			LocalTime endtime, meetingType type, List<Integer> listOfMember) {
		super();
		this.uniqueID = uniqueID;
		this.organizedBy = organisedBy;
		this.infoOfMeeting = infoOfMeeting;
		this.title = title;
		this.date = date;
		this.starttime = starttime;
		this.endtime = endtime;
		this.type = type;
		this.listOfMember = listOfMember;
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



	public String getInfoOfMeeting() {
		return infoOfMeeting;
	}



	public void setInfoOfMeeting(String infoOfMeeting) {
		this.infoOfMeeting = infoOfMeeting;
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


	public List<Integer> getListOfMember() {
		return listOfMember;
	}



	public void setListOfMember(List<Integer> listOfMember) {
		this.listOfMember = listOfMember;
	}


	public String toString() {
		return this.getUniqueID() + " " + this.getOrganizedBy() + " " + this.getInfoOfMeeting() + " " + this.getTitle() + " " + this.getDate()
				+ " " + this.getStarttime() + " " + this.getEndtime()+" "+this.getType()+ " "+ this.getListOfMember();
	}
}