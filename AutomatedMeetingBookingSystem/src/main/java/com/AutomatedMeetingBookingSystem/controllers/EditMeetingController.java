/*
 * package com.AutomatedMeetingBookingSystem.controllers;
 * 
 * import java.io.IOException; import java.util.Map;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import com.AutomatedMeetingBookingSystem.model.MeetingRoom; import
 * com.AutomatedMeetingBookingSystem.service.AdminServiceInterface; import
 * com.AutomatedMeetingBookingSystem.service.ServiceFactory;
 * 
 *//**
	 * Servlet implementation class EditMeetingController
	 */
/*
 * public class EditMeetingController extends HttpServlet { private static final
 * long serialVersionUID = 1L; private AdminServiceInterface adminService;
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public EditMeetingController() { super(); adminService =
 * ServiceFactory.getAdminService(); // TODO Auto-generated constructor stub }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
 * ServletException, IOException {
 * 
 * int uniqueID = Integer.parseInt(req.getParameter("uniqueID")); int
 * organizedBy =Integer.parseInt( req.getParameter("organizedBy")); String title
 * = req.getParameter("title");
 * 
 * String date = req.getParameter("date"); String startTime =
 * req.getParameter("startTime"); String endTime = req.getParameter("endTime");
 * String type = req.getParameter("type");
 * 
 * 
 * 
 * 
 * MeetingRoom meetingRoom = new MeetingRoom();
 * meetingRoom.setRoomName(roomName);
 * meetingRoom.setSeatingCapacity(seatingCapacity);
 * meetingRoom.setAmenities(amenities);
 * meetingRoom.setCreditPerHour(creditPerHour); boolean updated =
 * adminService.editMeetingRoom(meetingRoom); if(updated == true){
 * System.out.println("meetingRoom Edited"); } RequestDispatcher dispatcher =
 * req.getRequestDispatcher( "AdminHome.jsp" ); dispatcher.forward(req, resp); }
 * 
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub doGet(request, response); }
		 * 
		 * }
		 */