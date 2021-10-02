package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.service.MeetingRoomService;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

/**
 * Servlet implementation class FeedbackController
 */
public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MeetingRoomService meetingRoomService;
    
    public FeedbackController() {
        super();
        meetingRoomService = ServiceFactory.getMeetingRoomService();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomName = request.getParameter("roomName");
		System.out.println(roomName);
		int rating = Integer.parseInt(request.getParameter("rating"));
		System.out.println(rating);
		meetingRoomService.addRating(roomName, rating);
		System.out.println("add");
		RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
		rd.forward(request, response);

	}

}
