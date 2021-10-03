package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;
import com.AutomatedMeetingBookingSystem.service.UserServiceInterface;

/**
 * Servlet implementation class DropDownController
 */
public class DropDownController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private UserServiceInterface userService;
    public DropDownController() {
        super();
        userService = ServiceFactory.getUserService();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomName = request.getParameter("roomName");
		List <User> userList = userService.getAllUser();
		for(User u : userList) {
			System.out.println(u.toString());
		}
		request.setAttribute("roomName", roomName);
		request.setAttribute("userList", userList);
		RequestDispatcher rd = request.getRequestDispatcher("SelectedRoom.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
