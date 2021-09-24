package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.service.MeetingService;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

/**
 * Servlet implementation class FetchMeetingDetailsController
 */
public class FetchMeetingDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MeetingService meetingService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchMeetingDetailsController() {
        super();
        meetingService = ServiceFactory.getMeetingService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uniqueID = Integer.parseInt(request.getParameter("uniqueID"));
		Meeting meeting = meetingService.fetchMeetingByUniqueID(uniqueID);
		request.setAttribute("meeting", meeting);
		RequestDispatcher dispatcher = request.getRequestDispatcher( "EditMeeting.jsp" );
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
