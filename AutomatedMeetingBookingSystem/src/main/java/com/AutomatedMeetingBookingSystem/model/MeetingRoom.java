package com.AutomatedMeetingBookingSystem.model;

import java.util.HashSet;
import java.util.Set;

import com.AutomatedMeetingBookingSystem.exception.ResourceNotFoundException;

public class MeetingRoom {

	private String roomName;
	private int perHourCost;
	private int seatingCapacity;
	private double rating;
	private int ratingSum=0,ratingCount=0;
	private Set<String> amenities = new HashSet<>();
	
	
	public MeetingRoom(String roomName, int perHourCost, int seatingCapacity, double rating, Set<String> amenities) {
		super();
		this.roomName = roomName;
		this.perHourCost = perHourCost;
		this.seatingCapacity = seatingCapacity;
		this.rating = rating;
		this.amenities = amenities;
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
	public Set<String> getAmenities() {
		return amenities;
	}

	public void setAminities(Set<String> amenities) {
		this.amenities = amenities;
	}
	
	public void addAminity(String amenitiy) {
		this.amenities.add(amenitiy);
	}
	public void removeAminity(String amenitiy) throws ResourceNotFoundException {
		if(this.amenities.contains(amenitiy))
			this.amenities.remove(amenitiy);
		else
			throw new ResourceNotFoundException();
	}

	public void addRating(int rating) {
		ratingSum+=rating;
		ratingCount++;
		this.rating = ratingSum/ratingCount;
	}

	@Override
	public String toString() {
		return "MeetingRoom [roomName=" + roomName + ", perHourCost=" + perHourCost + ", seatingCapacity="
				+ seatingCapacity + ", rating=" + rating + ", amenities=" + amenities + "]";
	}
	
	
	
}
