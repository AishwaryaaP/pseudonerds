package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.service.MemberService;
import com.AutomatedMeetingBookingSystem.service.MemberServiceImpl;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;
import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.User;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
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
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		String password = (String)request.getParameter("password");
		MemberService memberService = ServiceFactory.getMemberService();
		List<Meeting> scheduledMeeting = memberService.memberMeetingSchedule(userId);
		// Setting the attribute of the request object
			    // which will be later fetched by a JSP page
		request.setAttribute("meetingList", scheduledMeeting);
		RequestDispatcher rd2 = request.getRequestDispatcher("MemberJsp.jsp");
		rd2.forward(request, response);

		
	}

}
