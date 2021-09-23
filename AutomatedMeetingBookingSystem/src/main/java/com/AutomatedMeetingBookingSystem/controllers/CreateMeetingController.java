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

@WebServlet("/CreateMeetingController")
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
		int organizedBy = Integer.parseInt(request.getParameter("userId"));
		String meetingId = request.getParameter("meetingId");
		String roomName = request.getParameter("roomName");
		String title = request.getParameter("title");
		String date = request.getParameter("meetingDate");
		String startHours = request.getParameter("startHours");
		String startMinutes = request.getParameter("startMinutes");
		String endHours = request.getParameter("endHours");
		String endMinutes = request.getParameter("endMinutes");
		String type = request.getParameter("type");
		String listOfMembers = request.getParameter("listOfMembers");
		boolean isMeetingCreated = false;
		isMeetingCreated = managerService.createMeeting(organizedBy, roomName, title, date, startHours, startMinutes, endHours, endMinutes, type, listOfMembers);
		if(isMeetingCreated) {
			request.setAttribute("meetingCreated", true);
			RequestDispatcher rd = request.getRequestDispatcher("manager.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("meetingCreated", false);
			RequestDispatcher rd = request.getRequestDispatcher("manager.jsp");
			rd.forward(request, response);
		}
	}

}
