package com.AutomatedMeetingBookingSystem.model;

public class Employee {
	private int empId;
	private String name;
	private String email;
	private String phoneNumber;
	private String role;
	private int credit;
	


	public void giveFeedback() {
		System.out.println("Giving Feedback");
	}
	

	public Employee(int empId, String name, String email, String phoneNumber, String role) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}


	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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
	public int getCredit() {
		return credit;
	}


	public void setCredit(int credit) {
		this.credit = credit;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", role=" + role + ", credit=" + credit + "]";
	}

	
	
}
