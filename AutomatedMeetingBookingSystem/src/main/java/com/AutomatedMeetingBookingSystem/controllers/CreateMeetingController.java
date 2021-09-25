package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.service.ManagerService;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

//@WebServlet("/CreateMeetingController")
public class CreateMeetingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagerService managerService;
     
    public CreateMeetingController() {
        super();
        managerService = ServiceFactory.getManagerService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("hit");
		int organizedBy = Integer.parseInt(request.getParameter("userId"));
		String roomName = request.getParameter("roomName");
		String title = request.getParameter("title");
		String date = request.getParameter("meetingDate");
		String startTime = request.getParameter("startTime");
		String [] start = startTime.split(":");
		String startHours = start[0];
		String startMinutes = start[1];
		String endTime = request.getParameter("endTime");
		String [] end = startTime.split(":");
		String endHours = end[0];
		String endMinutes = end[1];
		String type = request.getParameter("type");
		String listOfMembers = request.getParameter("listOfMembers");
		boolean isMeetingCreated = false;
		isMeetingCreated = managerService.createMeeting(organizedBy, roomName, title, date, startHours, startMinutes, endHours, endMinutes, type, listOfMembers);
		if(isMeetingCreated) {
			System.out.print("okok");
			request.setAttribute("meetingCreated", true);
			RequestDispatcher rd = request.getRequestDispatcher("ManagerHome.jsp");
			rd.forward(request, response);
		}
		else {
			System.out.println("llll");
			request.setAttribute("meetingCreated", false);
			RequestDispatcher rd = request.getRequestDispatcher("ManagerHome.jsp");
			rd.forward(request, response);
		}
	}

}