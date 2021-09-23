package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.service.AdminServiceInterface;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

/**
 * Servlet implementation class CreateRoomController
 */
//@WebServlet("/CreateRoomController")
public class CreateRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminServiceInterface adminService;

    public CreateRoomController() {
        super();
		adminService = ServiceFactory.getAdminService();

    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		String roomName = req.getParameter("roomName");
		int seatingCapacity = Integer.valueOf(req.getParameter("seatingCapacity"));
		int creditPerHour = 0;
		double rating = 0;
		int ratingSum = 0;
		int ratingCount = 0;
		Set<String> amenities = new HashSet<>();
		Map<String, Integer> creditMap = adminService.getAmenitiesCredit();
		String amenitiesString = req.getParameter("amenities");
		String[] s = amenitiesString.split(" ");
		for (String str : s) {
			amenities.add(str);
			creditPerHour += creditMap.get(str);
		}
    
		MeetingRoom meetingRoom = new MeetingRoom(roomName, creditPerHour, seatingCapacity, rating, ratingSum,
				ratingCount, amenities);
		boolean created = adminService.createMeetingRoom(meetingRoom);
		req.setAttribute("created", created);
		RequestDispatcher rd = req.getRequestDispatcher("AdminHome.jsp");
		rd.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
