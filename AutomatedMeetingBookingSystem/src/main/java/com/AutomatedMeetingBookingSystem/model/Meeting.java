package com.AutomatedMeetingBookingSystem.model;

import java.time.LocalTime;
import java.util.List;
import java.time.LocalDate;

public class Meeting {
	private int uniqueID;
	private int organizedBy;
	private String infoMeetingRoomName;
	private String title;
	private LocalDate date;
	private LocalTime starttime;
	private LocalTime endtime;
	private List<Integer> listOfMember;
	public MeetingType type;

	public Meeting( int uniqueID, int organisedBy, String infoMeetingRoomName, String title, LocalDate date, LocalTime starttime,
			LocalTime endtime, MeetingType type, List<Integer> listOfMember) {
		super();
		this.uniqueID = uniqueID;
		this.organizedBy = organisedBy;
		this.infoMeetingRoomName = infoMeetingRoomName;
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



	public MeetingType getType() {
		return type;
	}



	public void setType(MeetingType type) {
		this.type = type;
	}


	public List<Integer> getListOfMember() {
		return listOfMember;
	}



	public void setListOfMember(List<Integer> listOfMember) {
		this.listOfMember = listOfMember;
	}
	
	public String toString() {
		return this.getUniqueID() + " " + this.getOrganizedBy() + " " + this.getInfoMeetingRoomName() + " " + this.getTitle() + " " + this.getDate()
				+ " " + this.getStarttime() + " " + this.getEndtime()+" "+this.getType()+ " "+ this.getListOfMember();
	}
}