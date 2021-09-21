package com.AutomatedMeetingBookingSystem.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.AutomatedMeetingBookingSystem.exception.ResourceNotFoundException;

public class MeetingRoom {

	private int roomId;
	private String roomName;
	private int creditPerHour;
	private int seatingCapacity;
	private double rating;
	private int ratingSum=0,ratingCount=0;
	private Set<String> amenities = new HashSet<>();
	
	
	public MeetingRoom(String roomName, int creditPerHour, int seatingCapacity, double rating, int ratingSum,
			int ratingCount, Set<String> amenities) {
		super();
		this.roomName = roomName;
		this.creditPerHour = creditPerHour;
		this.seatingCapacity = seatingCapacity;
		this.rating = rating;
		this.ratingSum = ratingSum;
		this.ratingCount = ratingCount;
		this.amenities = amenities;
	}
	public MeetingRoom(){
	}
	
	
	//Getter Setter
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
	public int getCreditPerHour() {
		return creditPerHour;
	}
	public void setCreditPerHour(int creditPerHour) {
		this.creditPerHour = creditPerHour;
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
	public int getRatingSum() {
		return ratingSum;
	}
	public void setRatingSum(int ratingSum) {
		this.ratingSum = ratingSum;
	}
	public int getRatingCount() {
		return ratingCount;
	}
	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}
	public Set<String> getAmenities() {
		return amenities;
	}
	public void setAmenities(Set<String> amenities) {
		this.amenities = amenities;
	}
	
	
	
	//Custom
	public void addAminity(String amenitiy) {
		this.amenities.add(amenitiy);
	}
	public void removeAminity(String amenitiy) throws ResourceNotFoundException {
		if(this.amenities.contains(amenitiy))
			this.amenities.remove(amenitiy);
		else
			throw new ResourceNotFoundException();
	}
	
	
	//toString
	@Override
	public String toString() {
		return "MeetingRoom [roomName=" + roomName + ", creditPerHour=" + creditPerHour + ", seatingCapacity="
				+ seatingCapacity + ", rating=" + rating + ", amenities=" + amenities + "]";
	}
	
	
	
}
