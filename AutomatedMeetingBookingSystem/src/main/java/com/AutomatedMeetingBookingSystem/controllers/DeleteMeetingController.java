package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.ManagerService;
import com.AutomatedMeetingBookingSystem.service.MeetingService;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

/**
 * Servlet implementation class DeleteMeetingController
 */
public class DeleteMeetingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagerService managerService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMeetingController() {
        super();
        // TODO Auto-generated constructor stub
        managerService = ServiceFactory.getManagerService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uniqueID = Integer.parseInt(request.getParameter("uniqueID"));
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		LocalTime startTime = LocalTime.parse(request.getParameter("startTime"));
		LocalTime endTime = LocalTime.parse(request.getParameter("endTime"));
		String roomName = request.getParameter("roomName");
		int organizedBy = ((User)request.getSession().getAttribute("userDetail")).getUserId();
		boolean deleted = managerService.deleteMeeting(uniqueID, date, startTime,endTime,roomName,organizedBy);
		if(deleted) {
			System.out.print("meeting deleted");
			request.setAttribute("meetingDeleted", true);
			RequestDispatcher rd = request.getRequestDispatcher("GetScheduledByManagerController");
			rd.forward(request, response);
		}
		else {
			System.out.println("No meeting deleted");
			request.setAttribute("meetingDeleted", false);
			RequestDispatcher rd = request.getRequestDispatcher("GetScheduledByManagerController");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
