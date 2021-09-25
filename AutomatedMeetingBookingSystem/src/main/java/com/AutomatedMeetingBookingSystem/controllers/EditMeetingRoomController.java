package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.util.Enumeration;
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
import com.AutomatedMeetingBookingSystem.service.MeetingRoomService;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

/**
 * Servlet implementation class EditMeetingRoom
 */

@WebServlet("/EditMeetingRoomController")
public class EditMeetingRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminServiceInterface adminService;     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMeetingRoomController() {
        super();
		adminService = ServiceFactory.getAdminService();	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String roomName = req.getParameter("roomName");		
		int seatingCapacity = Integer.valueOf(req.getParameter("seatingCapacity"));
		int creditPerHour = 0;		
		String amenities ="";
		Map<String, Integer> creditMap = adminService.getAmenitiesCredit();
		String [] amenitiesList = req.getParameterValues("amenities");
		for(String amenity : amenitiesList) {
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
		MeetingRoom meetingRoom = new MeetingRoom();
		meetingRoom.setRoomName(roomName);
		meetingRoom.setSeatingCapacity(seatingCapacity);
		meetingRoom.setAmenities(amenities);
		meetingRoom.setCreditPerHour(creditPerHour);
		boolean updated = adminService.editMeetingRoom(meetingRoom);
		if(updated == true){
	  		System.out.println("meetingRoom Edited");
		}
		  RequestDispatcher dispatcher = req.getRequestDispatcher( "AdminHome.jsp" );
		  dispatcher.forward(req, resp);
		 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
