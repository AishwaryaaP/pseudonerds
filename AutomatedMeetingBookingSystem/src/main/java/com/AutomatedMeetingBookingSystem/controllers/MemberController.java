package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.service.MemberService;
import com.AutomatedMeetingBookingSystem.service.MemberServiceImpl;
import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.User;

/**
 * Servlet implementation class MemberController
 */
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MemberController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("param = " + request.getHeader("act"));
		String action = request.getHeader("act");
		System.out.println(action);
		int userId = Integer.parseInt(request.getParameter("userId"));
		MemberService service = new MemberServiceImpl();
		switch (action)
		{
			case "getMemberDetails":
				User u = service.memberDetails(userId);
				break;
			case "getScheduledMeetings":
				List<Meeting> scheduledMeeting = service.memberMeetingSchedule(userId);
				break;
		}
		
	}

}
