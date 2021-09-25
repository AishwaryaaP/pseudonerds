<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.AutomatedMeetingBookingSystem.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" sizes="32x32"
	href="./images/favicon-32x32.png">
<title>MeetPro|Manager</title>
<link rel="stylesheet" href="./MemberHomeStyle.css">
</head>
<body>

	<%
		User user = (User) session.getAttribute("userDetail");
	%>

	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!-- Nav Bar -->

	<header>
		<nav role="navigation">
			<img class="logo" src="./images/pnlogo.svg" alt="MeetPro" href="#">
			<div class="container1" id="container1">
				<ul class="nav-ul" id="nav-ul">
					<li class="nav-link"><a href="GetAllRoomsController">Room
							Details</a></li>
					<li class="nav-link">Credit: <%=user.getCredit() %></li>
					<li class="nav-link">Last Loggedin: <%=user.getLastLoggedIn()%></li>
					<li claas="nav-link"><a href="UserProfile.jsp">Hello
							<%=user.getName() %></a></li>
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
						<li>Credits: <c:out value="${user.credits}" /></li>
						<li><a href="CreateMeeting.jsp">Create Meeting</a></li>
						<li><a href="Index.jsp">Logout</a></li>
					</a>
				</ul>
			</div>
		</nav>
	</header>
	<a href="GetAvailableRoomsController"> CREATE MEETING</a>

	<!--table-->
	<section class="table-room">


		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


		<h1>Meetings Scheduled by Manager</h1>
		<div class="tbl-header">
			<table cellpadding="0" cellspacing="0" border="0">
				<thead>
					<tr>
						<th>Meeting Id</th>
						<th>Title</th>
						<th>Date</th>
						<th>startTime</th>
						<th>endTime</th>
						<th>Type</th>

					</tr>
				</thead>
			</table>
		</div>

		<c:forEach items="${meetings}" var='i'>
			<div class="tbl-content">
				<table cellpadding="0" cellspacing="0" border="0">
					<tbody>
						<tr>
							<td><a
								href="FetchMeetingDetailsController?uniqueID=${i.uniqueID}"><c:out
										value="${i.uniqueID}" /></a></td>
							<td><c:out value="${i.title}" /></td>
							<td><c:out value="${i.date}" /></td>
							<td><c:out value="${i.startTime}" /></td>
							<td><c:out value="${i.endTime}" /></td>
							<td><c:out value="${i.type}" /></td>
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
					<a href="#"> <img src="./images/icon-facebook.svg" alt="">
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
						<li><a href="./Login.jsp">Login Page</a></li>
						<li><a href="#feedback">Feedback</a></li>
					</ul>
				</div>

				<div class="footer-credit">
					<div class="u-mb-large">
						<a href="https://github.com/AishwaryaaP/pseudonerds">Github
							Repository</a>
						<p>@PseudoNerds. All Rights Reserved</p>
					</div>
				</div>
			</div>
		</div>
	</footer>



</body>
</html>