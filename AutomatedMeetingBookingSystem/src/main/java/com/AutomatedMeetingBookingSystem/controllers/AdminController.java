package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.model.User;




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

	public AdminController() {
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
		case "addEmployee":
			//dummy for reference.
			int empId; // get from DB and increment
			String name = req.getHeader("name");
			String email = req.getHeader("email");
			String phoneNumber = req.getHeader("phoneNumber");
			String role = req.getHeader("role");
			int credit = Integer.valueOf(req.getHeader("credit"));
			// pass object to service layer

			System.out.println(name + " " + role);
			resp.getWriter().write(name);
			break;

		case "getAllRooms":
			// call service layer for meetingroom.getall
//			MeetingRoomService meetingRoomService = ServiceFactory.getSeriveInstance();
//			List<MeetingRoom> allMeetingRooms = meetingRoomService.getAllRooms();
			
			break;

		case "getAdminDetails":
			//redux ? 
			
			break;

		case "editMeetingRoom":
			// get meeting room Id pass to service layer clickable so pass id from FE
			int meetingRoomIdForEdit = Integer.valueOf( req.getHeader("meetingId") ) ;
			//call service layer with this id
			break;

		case "deleteMeetingRoom":
			// get meeting room Id pass to service layer clickable so pass id from FE
			int meetingRoomIdForDelete = Integer.valueOf( req.getHeader("meetingId") ) ;
			//call service layer with this id
		}

	}

}

