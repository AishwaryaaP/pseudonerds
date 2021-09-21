package com.AutomatedMeetingBookingSystem.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.AutomatedMeetingBookingSystem.exception.ResourceNotFoundException;

public class MeetingRoom {

	private String roomName;
	private int creditPerHour;
	private int seatingCapacity;
	private double rating;
	private int ratingSum=0,ratingCount=0;
	private Set<String> amenities = new HashSet<>();
	private static Map<String,Integer> amenitiesCredit = new HashMap<>();
	
	
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
	
	public static Map<String,Integer> getAmenitiesCredit()
	{
		amenitiesCredit.put("PROJECTOR", 5);
		amenitiesCredit.put("WIFICONNECTION", 10);
		amenitiesCredit.put("CONFERENCECALL", 15);
		amenitiesCredit.put("WHITEBOARD", 5);
		amenitiesCredit.put("WATERDISPENCER", 5);
		amenitiesCredit.put("TV", 10);
		amenitiesCredit.put("COFFEEMACHINE", 10);
		return amenitiesCredit;
	}
	public static boolean addNewAmenitiesCredit(String aminity, int credit)
	{
		if(aminity!=null)
		{
		amenitiesCredit.put(aminity, credit);
		return true;
		}
		else
			return false;
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
		return "MeetingRoom [roomName=" + roomName + ", creditPerHour=" + creditPerHour + ", seatingCapacity="
				+ seatingCapacity + ", rating=" + rating + ", amenities=" + amenities + "]";
	}
	
	
	
}
