package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.service.UserServiceInterface;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

/**
 * Servlet implementation class GlobalServlet
 */
@WebServlet("/GlobalServlet")
public class GlobalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlobalServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int userId = Integer.parseInt( request.getParameter("userId"));
			String email = request.getParameter("email");
			System.out.println(userId);
			System.out.println(email);
			UserServiceInterface userService = ServiceFactory.getUserService();
			User user = userService.getUserDetails(userId , email);			
			if ( user != null ) {
				request.getSession().setAttribute( "userDetail", user );
				request.getSession().setAttribute( "LOGINSTATUS", "SUCCESS");
				RequestDispatcher dispatcher = null;
				switch(user.getRole()) {
				case "ADMIN":
					dispatcher= request.getRequestDispatcher( "AdminHome.jsp" );
					break;
				case "MANAGER":
					dispatcher= request.getRequestDispatcher( "GetScheduledByManagerController" );
					break;
				case "MEMBER":
					dispatcher= request.getRequestDispatcher( "MemberHome.jsp" );		
					break;
				}
				dispatcher.forward(request, response);
			} else {
				request.getSession().setAttribute( "LOGINSTATUS", "FAILURE");
				RequestDispatcher dispatcher = request.getRequestDispatcher( "Login.jsp" );
				dispatcher.forward(request, response);
			}
	}

}