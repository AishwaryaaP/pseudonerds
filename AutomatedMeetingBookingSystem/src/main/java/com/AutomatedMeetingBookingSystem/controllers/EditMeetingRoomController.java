package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.service.AdminServiceInterface;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;

/**
 * Servlet implementation class EditMeetingRoom
 */

@WebServlet("/EditMeetingRoomController")
public class EditMeetingRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminServiceInterface adminService;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMeetingRoomController() {
        super();
		adminService = ServiceFactory.getAdminService();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String roomName1 = req.getParameter("roomName");
		int seatingCapacity1 = Integer.valueOf(req.getParameter("seatingCapacity"));
		int creditPerHour1 = 0;
		double rating1 = 0;
		int ratingSum1 = 0;
		int ratingCount1 = 0;
		Set<String> amenities1 = new HashSet<>();
		Map<String, Integer> creditMap1 = adminService.getAmenitiesCredit();
		String amenitiesString1 = req.getParameter("amenities");
		String[] s1 = amenitiesString1.split(" ");
		for (String str : s1) {
			amenities1.add(str);
			creditPerHour1 += creditMap1.get(str);
		}

		MeetingRoom meetingRoom1 = new MeetingRoom(roomName1, creditPerHour1, seatingCapacity1, rating1, ratingSum1,
				ratingCount1, amenities1);

		boolean updated = adminService.editMeetingRoom(meetingRoom1);
		req.setAttribute("updated", updated);
		RequestDispatcher rd2 = req.getRequestDispatcher("admin.jsp");
		rd2.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
