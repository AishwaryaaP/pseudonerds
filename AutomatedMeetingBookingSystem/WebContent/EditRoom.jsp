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
		MeetingRoom room = (MeetingRoom)request.getAttribute("MeetingRoom");				
	%>
	
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
		<form  action = "EditMeetingRoomController">
		
        <label for="roomName">Meeting Room Name</label>
        <input type="text"  placeholder="Enter room name" name="roomName" id="roomName" value="<%=room.getRoomName()%>" readonly>
        
        <label for="seatingCapacity">Seating Capacity</label>
        <input type=number step=any name="seatingCapacity" value="<%=room.getSeatingCapacity()%>"><br />

		<% 		
		 String [] amenitiesString = room.getAmenities().split(" ");
         Set<String> amenities = new HashSet<>();
         for(String amenity : amenitiesString) {
        	 amenities.add(amenity);
         }
         %> 
         <label for="projector">Projector</label><br>
         <% if(amenities.contains("PROJECTOR")) { %> 
             <input type="checkbox" id="projector" name="amenities" Checked value="projector">
         <% } 
            else { %>
             <input type="checkbox" id="projector" name="amenities"  value="projector">
         <% } %>
         
         <label for="Wifi-Connection">Wifi-Connection</label><br>
         <% if(amenities.contains("WIFICONNECTION")) { %> 
             <input type="checkbox" id="Wifi-Connection" name="amenities" Checked value="Wifi-Connection">
         <% } 
            else { %>
             <input type="checkbox" id="Wifi-Connection" name="amenities"  value="Wifi-Connection">
         <% } %>
         
         <label for="Con-Call">Con-Call</label><br>
         <% if(amenities.contains("CONFERENCECALL")) { %> 
             <input type="checkbox" id="Con-Call" name="amenities" Checked value="Con-Call">
         <% } 
            else { %>
             <input type="checkbox" id="Con-Call" name="amenities"  value="Con-Call">
         <% } %>
         
         <label for="Whiteboard">Whiteboard</label><br>
         <% if(amenities.contains("WHITEBOARD")) { %> 
             <input type="checkbox" id="Whiteboard" name="amenities" Checked value="Whiteboard">
         <% } 
            else { %>
             <input type="checkbox" id="Whiteboard" name="amenities"  value="Whiteboard">
         <% } %>
         
         <label for="WaterDispenser">WaterDispenser</label><br>
         <% if(amenities.contains("WATERDISPENCER")) { %> 
             <input type="checkbox" id="WaterDispenser" name="amenities" Checked value="WaterDispenser">
         <% } 
            else { %>
             <input type="checkbox" id="WaterDispenser" name="amenities"  value="WaterDispenser">
         <% } %>
         
         <label for="TV">TV</label><br>
         <% if(amenities.contains("TV")) { %> 
             <input type="checkbox" id="TV" name="amenities" Checked value="TV">
         <% } 
            else { %>
             <input type="checkbox" id="TV" name="amenities"  value="TV">
         <% } %>
         
         <label for="CoffeMachine">CoffeMachine</label><br>
         <% if(amenities.contains("COFFEEMACHINE")) { %> 
             <input type="checkbox" id="CoffeMachine" name="amenities" Checked value="CoffeMachine">
         <% } 
            else { %>
             <input type="checkbox" id="CoffeMachine" name="amenities"  value="CoffeMachine">
         <% } %>
				
		<button > submit</button>        </form>
    	  
	


</body>
</html>