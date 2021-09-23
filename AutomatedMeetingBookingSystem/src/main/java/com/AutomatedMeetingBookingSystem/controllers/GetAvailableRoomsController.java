package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.service.ManagerService;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;


public class GetAvailableRoomsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagerService managerService;
       
    public GetAvailableRoomsController() {
        super();
        managerService = ServiceFactory.getManagerService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
