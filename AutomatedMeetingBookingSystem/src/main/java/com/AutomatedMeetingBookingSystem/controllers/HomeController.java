package com.AutomatedMeetingBookingSystem.controllers;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.service.AdminService;
import com.AutomatedMeetingBookingSystem.service.AdminServiceInterface;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

/**
 * Servlet implementation class getAllRooms
 */
//@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminServiceInterface adminService;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
		adminService = ServiceFactory.getAdminService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MeetingRoom> meetingRoomList =  adminService.getAllRooms();	
		
		request.setAttribute("meetingRoomList", meetingRoomList);
		 request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	

}