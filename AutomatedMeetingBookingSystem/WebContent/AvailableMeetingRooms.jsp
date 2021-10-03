
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.AutomatedMeetingBookingSystem.model.User"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
if ((request.getSession(false) == null) || (session.getAttribute("LOGINSTATUS") != "SUCCESS")) {
	request.getRequestDispatcher("Login.jsp").forward(request, response);
} else {
	User user = (User) session.getAttribute("userDetail");
	if (user.getRole().equals("MEMBER")) {
		request.getRequestDispatcher("MemberHome.jsp").forward(request, response);
	} else if (user.getRole().equals("ADMIN")) {
		request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
	}
}
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" sizes="32x32"
	href="IMAGES/favicon.ico">
<title>MeetPro | Available Rooms</title>
<link rel="stylesheet" href="./CSS/AdminHomeStyle.css">

</head>
<body>
<header>
		<nav role="navigation">
			<img class="logo" id="logo" src="./IMAGES/pnlogo.png" type="image/png"  alt="MeetPro" >
			<div class="container1" id="container1">
				<ul class="nav-ul" id="nav-ul">
					<li class="nav-link"><a onclick="history.back()">Return</a></li>
				</ul>
			</div>
			<div class="menuToggle" id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>
				<ul class="menu" id="menu">
					<a ><li><a href="./Login.jsp">Logout</a></li></a>
				</ul>
			</div>
		</nav>
	</header>
	<% String status =(String) session.getAttribute("status");
	if (status.equalsIgnoreCase("TRUE"))
	{ 
	%>
	<section class="table-room">	
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<h2
			style="text-align: center; padding-inline: inherit; padding-top: 90px; padding-bottom: 20px"
			class="section-heading">Available Meeting Rooms</h2>
	<table class="table">
		<tr>
			<th>Room Name</th>
			<th>Seating Capacity</th>
			<th>Credit Per Hour</th>
			<th>Amenities</th>
		</tr>
		<c:forEach items="${meetingRooms}" var='i'>
			<tr>
				<td><a style="color:blue" href="SelectedRoom.jsp?roomName=${i.roomName}"><c:out value="${i.roomName}" /></a></td>
				<td><c:out value="${i.seatingCapacity}" /></td>
				<td><c:out value="${i.creditPerHour}" /></td>
				<td><c:out value="${i.amenities}" /></td>
			</tr>
		</c:forEach>
	</table>
	</section> 
	<% } 
else { %>
		<h2
			style="text-align: center; padding-inline: inherit; padding-top: 90px; padding-bottom: 20px"
			class="section-heading">No Rooms Available</h2>
<% } %>
</body>
</html>