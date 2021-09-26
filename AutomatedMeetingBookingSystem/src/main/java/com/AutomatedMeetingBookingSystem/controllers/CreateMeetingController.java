package com.AutomatedMeetingBookingSystem.controllers;

import com.AutomatedMeetingBookingSystem.model.User;

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
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("hit");

		int organizedBy =( (User)request.getSession().getAttribute("userDetail")).getUserId();


		String roomName = request.getParameter("roomName");
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String startTime = request.getParameter("startTime");
		String [] start = startTime.split(":");
		String startHours = start[0];
		String startMinutes = start[1];
		String endTime = request.getParameter("endTime");
		String [] end = endTime.split(":");
		String endHours = end[0];
		String endMinutes = end[1];
		String type = request.getParameter("type");
		String listOfMembers = request.getParameter("listOfMembers");
		boolean isMeetingCreated = false;
		isMeetingCreated = managerService.createMeeting(organizedBy, roomName, title, date, startHours, startMinutes, endHours, endMinutes, type, listOfMembers);
		if(isMeetingCreated) {

			System.out.print("meeting Created");

			request.setAttribute("meetingCreated", true);
			RequestDispatcher rd = request.getRequestDispatcher("GetScheduledByManagerController");
			rd.forward(request, response);
		}
		else {

			System.out.println("No meeting Created");

			request.setAttribute("meetingCreated", false);
			RequestDispatcher rd = request.getRequestDispatcher("GetScheduledByManagerController");
			rd.forward(request, response);
		}
	}

}