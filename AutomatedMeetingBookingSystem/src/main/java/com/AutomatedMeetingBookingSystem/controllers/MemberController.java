package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
		int userId = (int)request.getAttribute("userId");
		String password = (String)request.getAttribute("password");
		MemberService service = ServiceFactory.getMemberServiceInstance();
		switch (action)
		{
			case "getMemberDetails":
				User u = service.memberDetails(userId, password);
				
				// Setting the attribute of the request object
			    // which will be later fetched by a JSP page
			    request.setAttribute("userObject", u);
			  
			    // Creating a RequestDispatcher object to dispatch
			    // the request the request to another resource
			    RequestDispatcher rd1 = request.getRequestDispatcher("MemberJsp.jsp");
			  
			    // The request will be forwarded to the resource specified
			    rd1.forward(request, response);
				
			    break;
			
			case "getScheduledMeetings":
				List<Meeting> scheduledMeeting = service.memberMeetingSchedule(userId);
				// Setting the attribute of the request object
			    // which will be later fetched by a JSP page
			    request.setAttribute("meetingList", scheduledMeeting);
			  
			    // Creating a RequestDispatcher object to dispatch
			    // the request the request to another resource
			    RequestDispatcher rd2 = request.getRequestDispatcher("MemberJsp.jsp");
			  
			    // The request will be forwarded to the resource specified
			    rd2.forward(request, response);

				break;
		}
		
	}

}
