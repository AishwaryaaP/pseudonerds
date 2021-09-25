package com.AutomatedMeetingBookingSystem.model;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class BookingInformation {
	private int uniqueId;
    private String roomName;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
	private int organizedBy; 
	
    public BookingInformation() {
		super();
		
	}
	public BookingInformation(int uniqueId, String roomName, LocalDate date, LocalTime startTime, LocalTime endTime,int organizedBy) {
		super();
		this.uniqueId = uniqueId;
		this.roomName = roomName;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.organizedBy = organizedBy;
	}
	public int getUniqueId() {
		return uniqueId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
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
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public int getOrganizedBy() {
		return organizedBy;
	}
	public void setOrganizedBy(int organizedBy) {
		this.organizedBy = organizedBy;
	}

	
	}
