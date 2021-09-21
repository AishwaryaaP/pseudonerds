package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.service.UserServiceInterface;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

/**
 * Servlet implementation class GlobalServerlet
 */
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
		String action = request.getParameter("act");
		switch(action) {
		case "login":
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			System.out.println(name);
			System.out.println(email);
			UserServiceInterface userService = ServiceFactory.getUserService();
			User user = userService.getUserDetails(name , email);
			switch(user.getRole()) {
			case "admin":
				System.out.println("Admin");
			case "manager":
				System.out.println("Manager");
			case "member":
				System.out.println("Member");
				
			
			}
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
