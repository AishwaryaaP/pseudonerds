package com.AutomatedMeetingBookingSystem.model;

public class MeetingRoom {

	private int roomId;
	private String roomName;
	private int perHourCost;
	private int seatingCapacity;
	private double rating;
	//Amenities
	
	public MeetingRoom(int roomId, String roomName, int perHourCost, int seatingCapacity, double rating) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.perHourCost = perHourCost;
		this.seatingCapacity = seatingCapacity;
		this.rating = rating;
	}	
	
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
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
		return "MeetingRoom [roomId=" + roomId + ", roomName=" + roomName + ", perHourCost=" + perHourCost
				+ ", seatingCapacity=" + seatingCapacity + ", rating=" + rating + "]";
	}

	
	
}
