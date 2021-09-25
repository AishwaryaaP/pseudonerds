<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.AutomatedMeetingBookingSystem.service.ServiceFactory.*"%>
<%@ page
	import="com.AutomatedMeetingBookingSystem.service.ServiceFactory"%>
<%@page
	import="com.AutomatedMeetingBookingSystem.service.MeetingRoomService"%>
<%@ page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom"%>
<%@ page import="javax.servlet.http.HttpSession.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.AutomatedMeetingBookingSystem.controllers.*"%>
<!DOCTYPE html>
<html>
<head>
<title>MeetPro | EditRoom</title>
<link rel="stylesheet" href="./CreateRoomStyle.css">
</head>
<body>
	<%
		MeetingRoom room = (MeetingRoom) request.getAttribute("MeetingRoom");
	%>
	<header>
		<nav role="navigation">
			<img class="logo" src="./images/pnlogo.svg" alt="MeetPro" href="#">
			<div class="container1" id="container1">
				<ul class="nav-ul" id="nav-ul">
					<li claas="nav-link"><a onclick="history.back()">Return</a></li>
				</ul>
			</div>
			<div class="menuToggle" id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>
				<ul class="menu" id="menu">
					<a href="#edit">
						<li><a href="Index.jsp">Logout</a></li>
					</a>
				</ul>
			</div>
		</nav>
	</header>
	<div class="space"></div>
	<div class="testbox">

		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<form action="EditMeetingRoomController">

			<div class="banner">
				<h1>Create Room</h1>
			</div>
			<div class="item">
				<label for="name">Room Name</label> <input id="name"
					type="text" placeholder="Enter the unique room name"
					name="roomName" id="roomName" value="<%=room.getRoomName()%>"
					readonly />
			</div>


			<div class="item">
				<label for="seatingCapacity">Seating Capacity<span>*</span></label>
				<input type="number" class="input"
					placeholder="Enter the desired Seating Capacity" step=any
					name="seatingCapacity" value="<%=room.getSeatingCapacity()%>"
					required />
			</div>

			<%
				String[] amenitiesString = room.getAmenities().split(" ");
			Set<String> amenities = new HashSet<>();
			for (String amenity : amenitiesString) {
				amenities.add(amenity);
			}
			%>

			<div class="question">
				<label for="amenities">Select Amenities (minimum 2)</label>
				<div class="question-answer">
					<div>
						<%
							if (amenities.contains("PROJECTOR")) {
						%>
						<input type="checkbox" id="projector" name="amenities" Checked
							value="projector">
						<%
							} else {
						%>
						<input type="checkbox" id="projector" name="amenities"
							value="projector">
						<%
							}
						%>
						<label for="projector" class="checkbox"><span>Projector</span></label>
					</div>
					
					<div>
						<%
						if (amenities.contains("WIFICONNECTION")) {
					%>
					<input type="checkbox" id="Wifi-Connection" name="amenities"
						Checked value="Wifi-Connection">
					<%
						} else {
					%>
					<input type="checkbox" id="Wifi-Connection" name="amenities"
						value="Wifi-Connection">
					<%
						}
					%>

						
						
						 <label
							for="Wifi-Connection" class="checkbox"><span>Wifi-Connection</span></label>
					</div>
					
					
					<div>
						<%
						if (amenities.contains("CONFERENCECALL")) {
					%>
					<input type="checkbox" id="Con-Call" name="amenities" Checked
						value="Con-Call">
					<%
						} else {
					%>
					<input type="checkbox" id="Con-Call" name="amenities"
						value="Con-Call">
					<%
						}
					%>

					 <label for="Con-Call" class="checkbox"><span>Con-Call</span></label>
					</div>
					
					<div>
					<%
						if (amenities.contains("WHITEBOARD")) {
					%>
					<input type="checkbox" id="Whiteboard" name="amenities" Checked
						value="Whiteboard">
					<%
						} else {
					%>
					<input type="checkbox" id="Whiteboard" name="amenities"
						value="Whiteboard">
					<%
						}
					%>

					 <label for="Whiteboard" class="checkbox"><span>Whiteboard</span></label>
					</div>
					
					
					<div>
						<%
						if (amenities.contains("WATERDISPENSER")) {
					%>
					<input type="checkbox" id="WaterDispenser" name="amenities" Checked
						value="WaterDispenser">
					<%
						} else {
					%>
					<input type="checkbox" id="WaterDispenser" name="amenities"
						value="WaterDispenser">
					<%
						}
					%>

 					<label for="WaterDispenser" class="checkbox"><span>WaterDispenser</span></label>
					</div>
					
					<div>
					
					
					<%
						if (amenities.contains("TV")) {
					%>
					<input type="checkbox" id="TV" name="amenities" Checked value="TV">
					<%
						} else {
					%>
					<input type="checkbox" id="TV" name="amenities" value="TV">
					<%
						}
					%>

					<label for="TV" class="checkbox"><span>TV</span></label>
					
					</div>
					
					<div>
						<%
						if (amenities.contains("COFFEEMACHINE")) {
					%>
					<input type="checkbox" id="CoffeMachine" name="amenities" Checked
						value="CoffeMachine">
					<%
						} else {
					%>
					<input type="checkbox" id="CoffeMachine" name="amenities"
						value="CoffeMachine">
					<%
						}
					%>
				 <label for="CoffeeMachine" class="checkbox"><span>Coffee Machine</span></label>
					</div>
				</div>
			</div>
			<div class="btn-block">
				<button onclick="AdminHome.jsp">SUBMIT</button>
			</div>
		</form>
		</div>
	<%--  <%
      boolean editStatus = (boolean) session.getAttribute("edited");
		  	if(editStatus == true){
		  		System.out.println("meetingRoom edited");
		  	}
		  %> --%>			
					
					
					
					
					
</body>
</html>