/*
 * package com.AutomatedMeetingBookingSystem.controllers;
 * 
 * import java.io.IOException; import java.time.LocalDate; import
 * java.time.format.DateTimeFormatter; import java.util.HashSet; import
 * java.util.Map; import java.util.Set;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import com.AutomatedMeetingBookingSystem.model.Meeting; import
 * com.AutomatedMeetingBookingSystem.service.ManagerService; import
 * com.AutomatedMeetingBookingSystem.service.ServiceFactory;
 * 
 *//**
	 * Servlet implementation class EditMeeting
	 */
/*
 * //@WebServlet("/EditMeeting") public class EditMeeting extends HttpServlet {
 * private static final long serialVersionUID = 1L;
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * private ManagerService managerService;
 * 
 * public EditMeeting() { super(); managerService =
 * ServiceFactory.getManagerService(); }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { // TODO Auto-generated
 * method stub
 * response.getWriter().append("Served at: ").append(request.getContextPath());
 * }
 * 
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { int uniqueId =
		 * Integer.parseInt(request.getParameter("uniqueId")); int organizedBy =
		 * Integer.parseInt(request.getParameter("userId")); String meetingId =
		 * request.getParameter("meetingId"); String roomName =
		 * request.getParameter("roomName"); String title =
		 * request.getParameter("title"); String date =
		 * request.getParameter("meetingDate"); String startTime =
		 * request.getParameter("startTime"); String [] start = startTime.split(":");
		 * String startHours = start[0]; String startMinutes = start[1]; String endTime
		 * = request.getParameter("endTime"); String [] end = endTime.split(":"); String
		 * endHours = end[0]; String endMinutes = end[1]; String type =
		 * request.getParameter("type"); String listOfMembers =
		 * request.getParameter("listOfMembers"); boolean isMeetingCreated = false;
		 * isMeetingCreated = managerService.editMeeting(uniqueId,organizedBy, roomName,
		 * title, date, startHours, startMinutes, endHours, endMinutes, type,
		 * listOfMembers); if(isMeetingCreated) { request.setAttribute("meetingCreated",
		 * true); RequestDispatcher rd =
		 * request.getRequestDispatcher("ManagerHome.jsp"); rd.forward(request,
		 * response); } else { request.setAttribute("meetingCreated", false);
		 * RequestDispatcher rd = request.getRequestDispatcher("ManagerHome.jsp");
		 * rd.forward(request, response); } } <<<<<<< HEAD } ======= } >>>>>>>
		 * de4ff1e717caf32117484fb7807555c7a0dec435
		 */