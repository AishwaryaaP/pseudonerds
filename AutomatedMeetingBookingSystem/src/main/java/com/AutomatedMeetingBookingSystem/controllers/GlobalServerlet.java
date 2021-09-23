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
 * Servlet implementation class GlobalServerlet
 */
@WebServlet("/GlobalServerlet")
public class GlobalServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlobalServerlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int userId = Integer.parseInt( request.getParameter("name"));
			String email = request.getParameter("email");
			System.out.println(userId);
			System.out.println(email);
			UserServiceInterface userService = ServiceFactory.getUserService();
			User user = userService.getUserDetails(userId , email);			
			if ( user != null ) {
				request.getSession().setAttribute( "userDetail", user );
				RequestDispatcher dispatcher1= request.getRequestDispatcher( "UserProfile.jsp" );
				request.getSession().setAttribute( "LOGINSTATUS", "SUCCESS");
				switch(user.getRole()) {
				case "admin":
					RequestDispatcher dispatcher2= request.getRequestDispatcher( "AdminHome.jsp" );
					break;
				case "manager":
					RequestDispatcher dispatcher3= request.getRequestDispatcher( "MemberHome.jsp" );
					break;
				case "member":
					RequestDispatcher dispatcher4= request.getRequestDispatcher( "home.jsp" );		
					break;
				}
						
				
			} else {
				request.getSession().setAttribute( "LOGINSTATUS", "FAILURE");
				RequestDispatcher dispatcher = request.getRequestDispatcher( "Login.jsp" );
				
				
				

			}
				
			
			
			
		
	}

}
