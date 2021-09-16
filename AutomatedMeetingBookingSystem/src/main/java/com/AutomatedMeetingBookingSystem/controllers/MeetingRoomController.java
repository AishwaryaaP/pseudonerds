package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutomatedMeetingBookingSystem.exception.RoomNotFoundException;
import com.AutomatedMeetingBookingSystem.model.MeetingRoom;
import com.AutomatedMeetingBookingSystem.service.MeetingRoomService;

public class MeetingRoomController {

	private MeetingRoomService roomService = null;
	private static final long serialVersionUID = 1L;

	public MeetingRoomController() {
		roomService = new MeetingRoomService();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("param = " + req.getHeader("act"));
		String action = req.getHeader("act");
		System.out.println(action);

		switch (action) {

		case "getSchedule":
		{
			String roomName = req.getHeader("roomName");

			//Get schedule obj for accepted roomName and return
			//No service method ****

			break;
		}
		case "getRoomdetails":
		{
			int roomId = Integer.valueOf(req.getHeader("roomId"));
			//Get room details for the accepted roomId and return
			MeetingRoom room = null;
			try {
				room = roomService.getRoomDetails(roomId);
			} catch (RoomNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println(roomId + " " + room.getRoomName());
			resp.getWriter().write(room.getRoomName());
			break;
		}

		case "setRoomdetails":
		{
			//Have to accept all or some???***
			int roomId = Integer.valueOf(req.getHeader("roomId"));
			String roomName = req.getHeader("roomName");
			int seatingCapacity = Integer.valueOf(req.getHeader("seatingCapacity"));
			double ratings = Double.parseDouble(req.getHeader("ratings"));	//Add to avg ratings
			int perHourCost = Integer.valueOf(req.getHeader("perHourCost"));
			MeetingRoom room = new MeetingRoom(roomId, roomName, perHourCost, seatingCapacity, ratings);
			//Have to accept each aminity seperately
			// call overloaded method to set the particular room detail or can set all
			break;
		}

		case "editAminitiyAvailability":
		{
			String aminity = req.getHeader("aminity");

			// get Id and call pass to service layer (Employee Controller missing)
			break;
		}

		case "getPerHourCost":
		{
			// get PerHourCost and return
			break;
		}


		}

	}
}
