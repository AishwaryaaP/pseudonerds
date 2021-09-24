package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.service.MeetingRoomService;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

/**
 * Servlet implementation class FetchMeetingRoomDetailsController
 */
public class FetchMeetingRoomDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchMeetingRoomDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    MeetingRoomService meetingRoomService = ServiceFactory.getMeetingRoomService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String roomName = request.getParameter("roomName");
		MeetingRoom meetingRoom = meetingRoomService.getRoomDetailsByRoomName(roomName);
		request.setAttribute("MeetingRoom", meetingRoom);
		RequestDispatcher dispatcher = request.getRequestDispatcher( "EditRoom.jsp" );
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
