package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.enums.MeetingType;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.service.BookingInformationService;
import com.AutomatedMeetingBookingSystem.service.ManagerService;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

@WebServlet("/GetAvailableRoomsController")
public class GetAvailableRoomsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingInformationService bookingInformationService;
       
    public GetAvailableRoomsController() {
        super();
        bookingInformationService = ServiceFactory.getBookingInformationService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hi");
		String date = req.getParameter("date");
		LocalDate localDate = LocalDate.parse(date);
		String sTime = req.getParameter("startTime");	
		LocalTime startTime = LocalTime.parse(sTime);
		String eTime = req.getParameter("endTime");
		LocalTime endTime = LocalTime.parse(eTime);
		String Mtype = req.getParameter("type");
		MeetingType type = MeetingType.valueOf(Mtype);
		List<MeetingRoom> meetingRooms = bookingInformationService.getAvailableMeetingRoom(localDate, startTime, endTime, type);
		for(MeetingRoom meetingRoom :meetingRooms ) {
			System.out.println(meetingRoom.getRoomId());
		}
//		req.setAttribute("meetingRooms", meetingRooms);
//		req.getSession().setAttribute("date", localDate);
//		req.getSession().setAttribute("startTime", startTime);
//		req.getSession().setAttribute("endTime", endTime);
//		req.getSession().setAttribute("type", type);
//		RequestDispatcher rd = req.getRequestDispatcher("AvailableMeetingRooms.jsp");
//		rd.forward(req, resp);
	}

}