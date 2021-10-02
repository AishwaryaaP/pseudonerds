/*
 * package com.AutomatedMeetingBookingSystem.controllers;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import com.AutomatedMeetingBookingSystem.service.ManagerService; import
 * com.AutomatedMeetingBookingSystem.service.ServiceFactory;
 * 
 *//**
	 * Servlet implementation class DeleteMeeting
	 */
/*
 * 
 * @WebServlet("/DeleteMeeting") public class DeleteMeeting extends HttpServlet
 * { private static final long serialVersionUID = 1L;
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * 
 * public DeleteMeeting() { super(); // TODO Auto-generated constructor stub }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * 
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
		 * response) throws ServletException, IOException { ManagerService
		 * managerService = ServiceFactory.getManagerService(); int uniqueId
		 * =Integer.valueOf(request.getParameter("uniqueId")); boolean deleted =
		 * managerService.deleteMeeting(uniqueId); request.setAttribute("deleted",
		 * deleted); RequestDispatcher rd3 =
		 * request.getRequestDispatcher("EditMeeting.jsp"); rd3.forward(request,
		 * response); }
		 * 
		 * }
		 */