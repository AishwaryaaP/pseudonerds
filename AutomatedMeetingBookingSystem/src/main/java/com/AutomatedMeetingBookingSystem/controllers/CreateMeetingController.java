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
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int organizedBy = ((User)request.getSession().getAttribute("userDetail")).getUserId();
		String meetingId = request.getParameter("meetingId");
		String roomName = request.getParameter("roomName");
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String type = request.getParameter("type");
		String listOfMembers = request.getParameter("listOfMembers");
		boolean isMeetingCreated = false;
		isMeetingCreated = managerService.createMeeting(organizedBy,meetingId, roomName, title, date, startTime, endTime, type, listOfMembers);
		if(isMeetingCreated) {
			request.setAttribute("meetingCreated", true);
			RequestDispatcher rd = request.getRequestDispatcher("ManagerHome.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("meetingCreated", false);
			RequestDispatcher rd = request.getRequestDispatcher("ManagerHome.jsp");
			rd.forward(request, response);
		}
	}

}
