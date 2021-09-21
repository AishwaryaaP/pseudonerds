package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.AdminService;
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
		System.out.println("param = " + req.getParameter("act"));
		String action = req.getParameter("act");
		System.out.println(action);

		switch (action) {

		case "createRoom":

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
			RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
			rd.forward(req, resp);
			break;

		case "getAllRooms":
			List<MeetingRoom> meetingRoomList =  adminService.getAllRooms();
			req.setAttribute("meetingRoomList", meetingRoomList);
			RequestDispatcher rd1 = req.getRequestDispatcher("admin.jsp");
			rd1.forward(req, resp);
			break;

		case "editMeetingRoom":

			String roomName1 = req.getParameter("roomName");
			int seatingCapacity1 = Integer.valueOf(req.getParameter("seatingCapacity"));
			int creditPerHour1 = 0;
			double rating1 = 0;
			int ratingSum1 = 0;
			int ratingCount1 = 0;
			Set<String> amenities1 = new HashSet<>();
			Map<String, Integer> creditMap1 = adminService.getAmenitiesCredit();
			String amenitiesString1 = req.getParameter("amenities");
			String[] s1 = amenitiesString1.split(" ");
			for (String str : s1) {
				amenities1.add(str);
				creditPerHour1 += creditMap1.get(str);
			}
			MeetingRoom meetingRoom1 = new MeetingRoom(roomName1, creditPerHour1, seatingCapacity1, rating1, ratingSum1,
					ratingCount1, amenities1);

			boolean updated = adminService.editMeetingRoom(meetingRoom1);
			req.setAttribute("updated", updated);
			RequestDispatcher rd2 = req.getRequestDispatcher("admin.jsp");
			rd2.forward(req, resp);
			break;

		case "deleteMeetingRoom":
			// get meeting room Id pass to service layer clickable so pass id from FE
			String meetingRoomIdForDelete =req.getParameter("roomName");
			boolean deleted = adminService.deleteMeetingRoom(meetingRoomIdForDelete);
			req.setAttribute("deleted", deleted);
			RequestDispatcher rd3 = req.getRequestDispatcher("admin.jsp");
			rd3.forward(req, resp);
			break;
		}

	}

}
