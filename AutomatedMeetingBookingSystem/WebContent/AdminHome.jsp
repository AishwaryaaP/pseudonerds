8<%@page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom"%>
<%@page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom"%>

<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" sizes="32x32"
	href="./images/favicon-32x32.png">
<title>MeetPro|Manager</title>
<link rel="stylesheet" href="./AdminHomeStyle.css">
</head>
<body>




	<!-- Nav Bar -->

	<header>
		<nav role="navigation">
			<img class="logo" src="./images/pnlogo.svg" alt="MeetPro" href="#">
			<div class="container1" id="container1">
				<ul class="nav-ul" id="nav-ul">
					<li class="nav-link"><a href="GetAllRoomsController">Room Details</a></li>
					<li class="nav-link"><a>Last Loggedin: 12pm</a></li>
					<li claas="nav-link"><a href="UserProfile.jsp">Hello
							Admin!</a></li>
				</ul>
			</div>
			<div class="menuToggle" id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>
				<ul class="menu" id="menu">
					<!--  -->
					<a href="#">
						<li></li>
					</a> -->
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

		<h1>Created Rooms</h1>
		<div class="tbl-header">
			<table cellpadding="0" cellspacing="0" border="0">
				<thead>
					<tr>
						<th>Room Name</th>
						<th>seatingCapacity</th>
						<th>Credit per hour</th>
						<th>Count</th>
						<th>DELETE</th>
					</tr>
				</thead>
			</table>
		</div>


		<c:forEach items="${meetingRoomList}" var='i'>
			<div class="tbl-content">
				<table cellpadding="0" cellspacing="0" border="0">
					<tbody>
						<tr>
							<td><a
								href="FetchMeetingRoomDetailsController?roomName=${i.roomName}"><c:out value="${i.roomName}" /></a></td>
							<td><c:out value="${i.seatingCapacity}" /></td>
							<td><c:out value="${i.creditPerHour}" /></td>
							<td><c:out value="${i.count}" /></td>
							<td><a href="DeleteMeetingRoomController?roomName=${i.roomName}">delete</a></td>
						</tr>
		</c:forEach>
		 </tbody>
      </table>
    </div>
  </section>
  
  <!-- Footer -->
  <footer>
    <div class="container">
      <div class="footer">

        <div class="footer-icons">
          <a href="#">
            <img src="./images/icon-facebook.svg" alt="">
          </a>
        </div>

        <div class="footer-links">
          <ul>
            <li><a href="#about">About Us</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div>

        <div class="footer-links">
          <ul>
            <li><a href="./LoginPage.html">Login Page</a></li>
            <li><a href="#feedback">Feedback</a></li>
          </ul>
        </div>

        <div class="footer-credit">
          <div class="u-mb-large">
            <a href="https://github.com/AishwaryaaP/pseudonerds">Github Repository</a>
            <p>@PseudoNerds. All Rights Reserved</p>
          </div>
        </div>
      </div>
    </div>
  </footer>
		
</body>
</html>