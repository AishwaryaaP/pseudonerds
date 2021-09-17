package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ManagerController")
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagerService managerService;
    public ManagerController() {
    	managerService = new ObjectFactory.getManagerServiceInstance();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("param = " + req.getHeader("act"));
		String action = request.getHeader("act");
		System.out.println(action);
		
		HttpSession session = request.getSession();
		User u = session.getAttribute("user");

		
		if(action.equals("createMeeting")) {
			int organizedBy = u.getId();
			String title = request.getParameter("title");
			String date = request.getParameter("meetingDate");
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String type = request.getParameter("type");
			List<User> listOfMembers = request.getParameter("listOfMembers");
			
			int meetingId = managerService.createMeeting(organizedBy, title, date, startTime, endTime, type, listOfMembers);
		}
		else if(action.equals("getSchedule")) {
			List<Meeting> meetings = managerService.getSchedule(u);
		}
		else if(action.equals("getAvailableRooms")) {
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String type = request.getParameter("type");
			List<MeetingRoom> meetingRooms = managerService.getAvailableRooms(startTime, endTime, type);
		}
		else if(action.equals("getManagerDetails")) {
			//Return User object stored in session
		}
	}

}
