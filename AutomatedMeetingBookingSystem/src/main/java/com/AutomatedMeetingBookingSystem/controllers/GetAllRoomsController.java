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
//@WebServlet("/GetAllRoomsController")
public class GetAllRoomsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminServiceInterface adminService;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllRoomsController() {
        super();
		adminService = ServiceFactory.getAdminService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello");
		List<MeetingRoom> meetingRoomList =  adminService.getAllRooms();
		for(MeetingRoom meetingRoom1 : meetingRoomList) {
			System.out.println(meetingRoom1.toString());
		}
		request.setAttribute("meetingRoomList", meetingRoomList);
		 request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
	}

	

}
