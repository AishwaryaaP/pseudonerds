package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.AdminServiceImpl;
import com.AutomatedMeetingBookingSystem.service.AdminServiceInterface;
import com.AutomatedMeetingBookingSystem.service.MeetingRoomService;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;



/*
 * Missed Out points:
 * For new empadd xml read
 * 
 * 
 *DaoFactory
 *AdminDaoInterface
 *AdminDaoImp
 *ManagerDaoInterface
 *ManagerDaoImp
 * 
 * */



public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminServiceInterface adminService;
	public AdminController() {
		adminService = ServiceFactory.getAdminService();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("param = " + req.getHeader("act"));
		String action = req.getHeader("act");
		System.out.println(action);

		switch (action) {

		case "createRoom":
			String roomName = req.getHeader("roomName");
			int seatingCapacity = Integer.valueOf(req.getHeader("seatingCapacity"));
			int rating = 0;
	// aminities???
			break;

		case "getAllRooms":
			adminService.getAllRooms();
			break;

		case "getAdminDetails":
			//redux ? 
			
			break;

		case "editMeetingRoom":
			// get meeting room Id pass to service layer clickable so pass id from FE
			
			String roomName1;
			int perHourCost;
			int seatingCapacity1;
			double rating1;
			
			int meetingRoomIdForEdit = Integer.valueOf( req.getHeader("meetingId") ) ;
			boolean updated = adminService.editMeetingRoom(meetingRoomIdForEdit);
			break;

		case "deleteMeetingRoom":
			// get meeting room Id pass to service layer clickable so pass id from FE
			int meetingRoomIdForDelete = Integer.valueOf( req.getHeader("meetingId") ) ;
			adminService.deleteMeetingRoom(meetingRoomIdForDelete);
		}

	}

}

