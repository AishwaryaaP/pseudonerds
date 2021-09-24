package com.AutomatedMeetingBookingSystem.model;

public class User {
	private int userId;
	private String name;
	private String email;
	private String phoneNumber;
	private String role;
	private double credit;
	
	


	public User(int userId, String email) {
		super();
		this.userId = userId;
		this.email = email;
	}
	public void giveFeedback() {
		System.out.println("Giving Feedback");
	}
	
	public User() {
		this.credit=0;
	}

	public User(int empId, String name, String email, String phoneNumber, String role) {
		super();
		this.userId = empId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int empId) {
		this.userId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public double getCredit() {
		return credit;
	}


	public void setCredit(double credit) {
		this.credit = credit;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + userId + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", role=" + role + ", credit=" + credit + "]";
	}

	
	
}
