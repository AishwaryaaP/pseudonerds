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

import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.service.ManagerService;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

/**
 * Servlet implementation class EditMeeting
 */
@WebServlet("/EditMeeting")
public class EditMeeting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMeeting() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerService managerService = ServiceFactory.getManagerService();
		int uniqueID = (int)(request.getAttribute("uniqueId"));
		int organizedBy = (int)request.getAttribute("organizedBy");
		String infoMeetingRoomName;
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String listOfMember = request.getParameter("listOfMember");
		String type = request.getParameter("type");
		Meeting meeting = managerService.createMeeting(uniqueID, organizedBy, infoMeetingRoomName, title, date, startTime, endTime, type,listOfMember);

		boolean updated = managerService.editMeeting(meeting);
		request.setAttribute("updated", updated);
		RequestDispatcher rd2 = request.getRequestDispatcher("EditRoom.jsp");
		rd2.forward(request, response);
	}
}
