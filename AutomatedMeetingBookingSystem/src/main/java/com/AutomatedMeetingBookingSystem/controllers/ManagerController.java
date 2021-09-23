package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AutomatedMeetingBookingSystem.enums.MeetingType;
import com.AutomatedMeetingBookingSystem.model.BookingInformation;
import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.ManagerService;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;


//@WebServlet("/ManagerController")
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
				HttpSession session = request.getSession();				
				session.setAttribute( "scheduleDetail", isMeetingCreated );
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
		
		else if(action.equals("editMeeting")) {

			/*
			 * int uniqueID = Integer.valueOf(request.getParameter("uniqueId")); int
			 * organizedBy ; String infoMeetingRoomName; String title =
			 * request.getParameter("title"); String date = request.getParameter("date");
			 * String startTime = request.getParameter("startTime"); String endTime =
			 * request.getParameter("endTime"); String listOfMember =
			 * request.getParameter("listOfMember"); String type =
			 * request.getParameter("type"); Meeting meeting = new Meeting(uniqueID,
			 * organizedBy, infoMeetingRoomName, title, date, startTime, endTime, type,
			 * listOfMember);
			 * 
			 * boolean updated = managerService.editMeeting(meeting);
			 * request.setAttribute("updated", updated); RequestDispatcher rd2 =
			 * request.getRequestDispatcher("EditRoom.jsp"); rd2.forward(request, response);
			 */	}

		else if(action.equals("deleteMeeting")) {
		// get meeting Id pass to service layer clickable so pass id from FE
		
		int uniqueId =Integer.valueOf(request.getParameter("uniqueId"));
		boolean deleted = managerService.deleteMeeting(uniqueId);
		request.setAttribute("deleted", deleted);
		RequestDispatcher rd3 = request.getRequestDispatcher("EditMeeting.jsp");
		rd3.forward(request, response);
	}

	}
		

}