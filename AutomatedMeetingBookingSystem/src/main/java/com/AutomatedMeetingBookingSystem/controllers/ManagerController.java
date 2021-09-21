package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

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
		managerService = ServiceFactory.getManagerServiceInstance();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		String name = request.getParameter("name");
		System.out.println(action + " " + name);
		PrintWriter pw = response.getWriter();
		pw.print("<html><body>");
		pw.print("Hello" + name + " " + action);
		pw.print("</body></html>");
		
		//Not sure about this
		HttpSession session = request.getSession();
		//User u = session.getAttribute("user");
		User u = null;

		
		if(action.equals("createMeeting")) {
			int organizedBy = u.getId();
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
			Meeting meeting = managerService.createMeeting(organizedBy, roomName, title, date, startHours, startMinutes, endHours, endMinutes, type, listOfMembers);
		}
		else if(action.equals("getSchedule")) {
			List<Meeting> meetings = managerService.getSchedule(u);
		}
		else if(action.equals("getAvailableRooms")) {
			String date = request.getParameter("meetingDate");
			String startHours = request.getParameter("startHours");
			String startMinutes = request.getParameter("startMinutes");
			String endHours = request.getParameter("endHours");
			String endMinutes = request.getParameter("endMinutes");
			String type = request.getParameter("type");
			List<MeetingRoom> meetingRooms = managerService.getAvailableRooms(date, startHours, startMinutes, endHours, endMinutes, type);
		}
		else if(action.equals("getManagerDetails")) {
			//Return User object stored in session
		}
	}

}