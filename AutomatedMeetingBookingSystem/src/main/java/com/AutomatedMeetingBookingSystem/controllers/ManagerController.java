package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AutomatedMeetingBookingSystem.model.BookingInformation;
import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.ManagerService;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;


@WebServlet("/ManagerController")
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagerService managerService;
    
	public ManagerController() {
		managerService = ServiceFactory.getManagerService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		String name = request.getParameter("name");
		System.out.println(action + " " + name);
		
		//Not sure about this
		HttpSession session = request.getSession();
		//User u = session.getAttribute("user");
		//User u = null;

		
		if(action.equals("createMeeting")) {
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
		else if(action.equals("getScehduledByManager")) {
			int managerId = Integer.parseInt(request.getParameter("managerId"));
			List<Meeting> meetings = managerService.getOrganizedByManager(managerId);
			request.setAttribute("meetings", meetings);
			RequestDispatcher rd = request.getRequestDispatcher("manager.jsp");
			rd.forward(request, response);
		}
		else if(action.equals("getAvailableRooms")) {
			String date = request.getParameter("meetingDate");
			String startHours = request.getParameter("startHours");
			String startMinutes = request.getParameter("startMinutes");
			String endHours = request.getParameter("endHours");
			String endMinutes = request.getParameter("endMinutes");
			String type = request.getParameter("type");
			List<MeetingRoom> meetingRooms = managerService.getAvailableRooms(date, startHours, startMinutes, endHours, endMinutes, type);
			
			request.setAttribute("meetingRooms", meetingRooms);
			RequestDispatcher rd = request.getRequestDispatcher("manager.jsp");
			rd.forward(request, response);
		}
	}

}