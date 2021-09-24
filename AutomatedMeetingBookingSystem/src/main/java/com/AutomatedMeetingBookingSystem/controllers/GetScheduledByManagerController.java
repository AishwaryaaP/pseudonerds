package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.model.Meeting;
import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.ManagerService;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

//@WebServlet("/GetScheduledByManagerController")
public class GetScheduledByManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagerService managerService;
	
    public GetScheduledByManagerController() {
        super();
        managerService = ServiceFactory.getManagerService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("userDetail");
		List<Meeting> meetings = managerService.getOrganizedByManager(user.getUserId());
		request.setAttribute("meetings", meetings);
		RequestDispatcher rd = request.getRequestDispatcher("ManagerHome.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
