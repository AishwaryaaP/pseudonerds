<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.AutomatedMeetingBookingSystem.service.ServiceFactory.*" %>
<%@ page import="com.AutomatedMeetingBookingSystem.service.ServiceFactory" %>
<%@page import="com.AutomatedMeetingBookingSystem.service.MeetingRoomService" %>
<%@ page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom" %>
<%@ page import="javax.servlet.http.HttpSession.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.AutomatedMeetingBookingSystem.controllers.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		MeetingRoom room = (MeetingRoom)request.getSession().getAttribute("meetingDetail");
		String roomName = room.getRoomName();	
 		MeetingRoomService service = ServiceFactory.getMeetingRoomService();
		MeetingRoom meeting_details = service.getRoomDetailsByRoomName(roomName);			
	%>
	
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<%@ page import="java.util.Set" %>
		<form onsubmit = "validateForm()" action = "AdminController">
		<%
		request.setAttribute("act","editMeetingRoom");
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminController");
		dispatcher.forward(request, response);
		%>
        <label 
		for="meetingRoom">Meeting Room Name</label>
        <input type="text"  placeholder="Enter room name" name="meetingRoom" value="<%=meeting_details.getRoomName()%>">
        
        <label for="seatingCapacity">Seating Capacity</label>
        <input type=number step=any name="seatingCapacity" value="<%=meeting_details.getSeatingCapacity()%>"><br />

		<% 		
		 Set<String> amenities = new HashSet<>();
        amenities = meeting_details.getAmenities();
        if(amenities.contains("projector"))
        	%> 
      	   <label for="projector">Projector</label><br>
             <input type="checkbox" id="projector" name="projector" Checked value="projector">
        if(amenities.contains("Wifi-Connection")) 
       	   <label for="Wifi-Connection">Projector</label><br>
              <input type="checkbox" id="Wifi-Connection" name="Wifi-Connection" Checked value="Wifi-Connection"> 
        if(amenities.contains("Con-Call")) 
       	   <label for="Con-Call">Projector</label><br>
              <input type="checkbox" id="Con-Call" name="Con-Call" Checked value="Con-Call">
        if(amenities.contains("Whiteboard")) 
       	   <label for="Whiteboard">Projector</label><br>
              <input type="checkbox" id="Whiteboard" name="Whiteboard" Checked value="Whiteboard">
        if(amenities.contains("WaterDispenser")) 
      	   <label for="WaterDispenser">Projector</label><br>
             <input type="checkbox" id="WaterDispenser" name="WaterDispenser" Checked value="WaterDispenser">
        if(amenities.contains("TV")) 
       	   <label for="TV">Projector</label><br>
              <input type="checkbox" id="TV" name="TV" Checked value="TV">
        if(amenities.contains("CoffeMachine")) 
       	   <label for="CoffeMachine">Projector</label><br>
              <input type="checkbox" id="CoffeMachine" name="CoffeMachine" Checked value="CoffeMachine">
		%>  
		<button onClick="edit()" value ="editMeetingRoom" name = "act"></button>    <button onClick="delete()" value ="deleteMeetingRoom" name = "act"></button>     <button onClick="AdminHome.jsp" value ="Edit" name = "act"></button>           
    </form>
    	<%
    	if(((String)request.getAttribute("act")).equals("editMeetingRoom"))
    	{
    	if(((String)request.getAttribute("updated")).equals("updated"))
    	 System.out.println("Updated");
        else
        System.out.println("Not Updated! Plz try again");
    	}
    	if(((String)request.getAttribute("act")).equals("deleteMeetingRoom"))
    	{
    	if(((String)request.getAttribute("deleted")).equals("deleted"))
    	 System.out.println("deleted");
        else
        System.out.println("Not Deleted! Plz try again");
    	}
    	
    	////conflict of act in attribute and button
    	
	%>   
	


</body>
</html>