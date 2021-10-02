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


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		String roomName = req.getParameter("roomName");
		int seatingCapacity = Integer.valueOf(req.getParameter("seatingCapacity"));
		int creditPerHour = 0;
		double rating = 0;
		int ratingSum = 0;
		int ratingCount = 0;
		String amenities ="";
		Map<String, Integer> creditMap = adminService.getAmenitiesCredit();
		String [] amenitiesList = req.getParameterValues("amenities");
		for(String amenity : amenitiesList)
		{
			System.out.println(amenity);
			switch(amenity) {
			case "projector" :
				amenities += "PROJECTOR" + " ";
				creditPerHour += creditMap.get("PROJECTOR");
				break;
			case "Wifi-Connection" :
				amenities += "WIFICONNECTION" + " ";
				creditPerHour += creditMap.get("WIFICONNECTION");
				break;
			case "Con-Call" :
				amenities += "CONFERENCECALL" + " ";
				creditPerHour += creditMap.get("CONFERENCECALL");
				break;
			case "Whiteboard" :
				amenities += "WHITEBOARD" + " ";
				creditPerHour += creditMap.get("WHITEBOARD");
				break;
			case "WaterDispenser" :
				amenities += "WATERDISPENCER" + " ";
				creditPerHour += creditMap.get("WATERDISPENCER");
				break;
			case "TV" :
				amenities += "TV" + " ";
				creditPerHour += creditMap.get("TV");
				break;
			case "CoffeMachine" :
				amenities += "COFFEEMACHINE" + " ";
				creditPerHour += creditMap.get("COFFEEMACHINE");
				break;
			}
		}
		System.out.println(amenities);
		MeetingRoom meetingRoom = new MeetingRoom(roomName, creditPerHour, seatingCapacity, rating, ratingSum,ratingCount, amenities);
		boolean created = adminService.createMeetingRoom(meetingRoom);
		if(created == true){
	  		System.out.println("meetingRoom Created");
		}
		
		
		  
		  RequestDispatcher dispatcher = req.getRequestDispatcher( "AdminHome.jsp" );
		  dispatcher.forward(req, resp);
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
