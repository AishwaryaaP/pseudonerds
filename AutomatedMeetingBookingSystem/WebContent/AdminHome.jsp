<%@page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom"%>
<%@page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom"%>
<%@page import="com.AutomatedMeetingBookingSystem.model.User"%>
<%@page
	import="com.AutomatedMeetingBookingSystem.controllers.FetchMeetingRoomDetailsController"%>

<%@ page import="java.util.*"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
if ((request.getSession(false) == null) || (session.getAttribute("LOGINSTATUS") != "SUCCESS")) {

	request.getRequestDispatcher("Login.jsp").forward(request, response);

} else {
	User user = (User) session.getAttribute("userDetail");
	if (user.getRole().equals("MEMBER")) {
		request.getRequestDispatcher("MemberHome.jsp").forward(request, response);
	} else if (user.getRole().equals("MANAGER")) {
		request.getRequestDispatcher("ManagerHome.jsp").forward(request, response);
	}
}
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" sizes="32x32"
	href="IMAGES/favicon.ico">
<title>MeetPro | Admin</title>
<link rel="stylesheet" href="./CSS/AdminHomeStyle.css">
</head>

<body>
	<%
	User user = (User) session.getAttribute("userDetail");
	%>


	<!-- Nav Bar -->

	<header>
		<nav role="navigation">
			<img class="logo" id="logo" src="./IMAGES/pnlogo.png"
				type="image/png" alt="MeetPro" href="#">
			<div class="container1" id="container1">
				<ul class="nav-ul" id="nav-ul">

					<li class="nav-link"><a>Last Loggedin: <%=user.getLastLoggedIn()%></a></li>
					<li><a href="GetAllRoomsController">Room Details</a></li>
					<li class="nav-link"><a href="UserProfile.jsp">Hello <%=user.getName()%></a></li>
				</ul>
			</div>
			<div class="menuToggle" id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>
				<ul class="menu" id="menu">
					<a href="#">
						<li><a href="CreateRoom.jsp">Create Room</li>
					</a>
					<a href="#">
						<li><a href="Index.jsp">Logout</a></li>
					</a>
				</ul>
			</div>
		</nav>
	</header>

	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



	<!--table-->
	<section class="table-room">
		<h1></h1>
		<h2
			style="text-align: center; padding-inline: inherit; padding-top: 40px; padding-bottom: 20px"
			class="section-heading">Created Rooms</h2>
		<div class="tbl-header">
			<table>
				<thead>
					<tr>
						<th>Room Name</th>
						<th>Seating Capacity</th>
						<th>Credit per hour</th>
						<th>Rating</th>
						<th>Delete</th>
					</tr>
				</thead>
			</table>
		</div>
		</thead>
		</table>
		</div>
		<c:forEach items="${meetingRoomList}" var='i'>
			<div>
				<table>
					<tbody>
						<tr>
							<td><a
								href="FetchMeetingRoomDetailsController?roomName=${i.roomName}">
									<c:out value="${i.roomName}" />
							</a></td>
							<td><c:out value="${i.seatingCapacity}" /></td>
							<td><c:out value="${i.creditPerHour}" /></td>
							<td><c:out value="${i.rating}" /></td>
							<td><a
								href="DeleteMeetingRoomController?roomName=${i.roomName}">delete</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
	</section>
	<!-- Import Section -->
	<section id="import" class="import">
		<h1></h1>
		<h2
			style="text-align: center; padding-inline: inherit; padding-top: 40px; padding-bottom: 20px"
			class="section-heading">Import Users</h2>
		<div class="tbl-header">
			<div class="import-container container">
				<div class="about-text">
					<h2 class="u-mb-small heading-secondary">Upload XML File to
						Import Users</h2>
					<p class="u-mb-large">XML file containing user records to be
						inserted into database.</p>
				</div>
				<div style="display: inline-block" class="form-container">
					<form action="ImportUserController" method="post" enctype="multipart/form-data">
						<input class="btn" type="file" name="myFile"accept="application/XML" required />
						<button class="btn" type="submit" name="submit" value="insert data">Upload File</button>
					</form>
				</div>
			</div>
	</section>
</body>
<!-- Footer -->
<section class="footer">
	<footer>
		<div class="container">
			<div class="footer">

				<div class="footer-icons">
					<a href="#"> <img src="" alt="">
					</a>
				</div>

				<div class="footer-links">
					<ul>
						<li><a href="./Index.jsp#about">About Us</a></li>
						<li><a href="./Index.jsp#contact">Contact</a></li>
					</ul>
				</div>

				<div class="footer-links">
					<ul>
						<li><a href="./CreateRoom.jsp">Create Room</li>
						<li><a href="./Index.jsp#feedback">Feedback</a></li>
					</ul>
				</div>

				<div class="footer-credit">
					<a href="https://github.com/AishwaryaaP/pseudonerds">Github
						Repository</a>
					<p>@PseudoNerds. All Rights Reserved</p>
				</div>
			</div>
		</div>
	</footer>
</section>
</html>