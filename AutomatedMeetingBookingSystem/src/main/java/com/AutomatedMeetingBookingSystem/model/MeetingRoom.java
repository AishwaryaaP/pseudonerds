package com.AutomatedMeetingBookingSystem.model;

public class MeetingRoom {

	public MeetingRoom() {
		super();
		// TODO Auto-generated constructor stub
	}


	private String roomName;
	private int perHourCost;
	private int seatingCapacity;
	private double rating;
	//Amenities
	
	public MeetingRoom(String roomName, int perHourCost, int seatingCapacity, double rating) {
		super();
		this.roomName = roomName;
		this.perHourCost = perHourCost;
		this.seatingCapacity = seatingCapacity;
		this.rating = rating;
	}	
	

	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getPerHourCost() {
		return perHourCost;
	}
	public void setPerHourCost(int perHourCost) {
		this.perHourCost = perHourCost;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	@Override
	public String toString() {
		return "MeetingRoom [roomName=" + roomName + ", perHourCost=" + perHourCost
				+ ", seatingCapacity=" + seatingCapacity + ", rating=" + rating + "]";
	}

	
	
}
