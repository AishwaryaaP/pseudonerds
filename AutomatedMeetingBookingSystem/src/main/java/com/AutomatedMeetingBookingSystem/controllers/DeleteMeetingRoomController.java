package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.service.AdminServiceInterface;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

/**
 * Servlet implementation class DeleteMeetingRoomController
 */
@WebServlet("/DeleteMeetingRoomController")
public class DeleteMeetingRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminServiceInterface adminService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMeetingRoomController() {
        super();
		adminService = ServiceFactory.getAdminService();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String meetingRoomIdForDelete =req.getParameter("roomName");
		boolean deleted = adminService.deleteMeetingRoom(meetingRoomIdForDelete);
		req.setAttribute("deleted", deleted);
		RequestDispatcher rd3 = req.getRequestDispatcher("admin.jsp");
		rd3.forward(req, resp);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
