<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.AutomatedMeetingBookingSystem.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" sizes="32x32"
	href="./IMAGES/favicon.ico">
<title>MeetPro | Manager</title>
<link rel="stylesheet" href="./CSS/AdminHomeStyle.css">
</head>
<body>

<script type="text/javascript">
	
function printAlert(){
	alert("Mail Sent");
}
</script>

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
	<%
	User user = (User) session.getAttribute("userDetail");
	%>

	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!-- Nav Bar -->

	<header>
		<nav role="navigation">
			<img class="logo" id="logo" src="./IMAGES/pnlogo.png"
				type="image/png" alt="MeetPro" href="#">
			<div class="container1" id="container1">
				<ul class="nav-ul" id="nav-ul">
					<li class="nav-link"><a>Last Loggedin: <%=user.getLastLoggedIn()%></a></li>
					<!-- <li class="nav-link"><a>Credit:user.getCredit()t() %></a></li> -->
					<li claas="nav-link"><a href="UserProfile.jsp">Hello <%=user.getName()%></a></li>
				</ul>
			</div>
			<div class="menuToggle" id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>
				<ul class="menu" id="menu">
					<a href="#">
						<li></li>
					</a>
					<a href="#">
						<li><a href="CreateMeeting.jsp">Create Meeting</a></li>
						<li><a href="Index.jsp">Logout</a></li>
					</a>
				</ul>
			</div>
		</nav>
	</header>
	<a href="GetAvailableRoomsController"> CREATE MEETING</a>

	<!--table-->


	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<section class="table-room">
		<h2
			style="text-align: center; padding-inline: inherit; padding-top: 40px; padding-bottom: 20px"
			class="section-heading">Your Scheduled Meetings</h2>
		<div class="tbl-header">
			<table>
				<thead>
					<tr>
						<th>Meeting Id</th>
						<th>Title</th>
						<th>Date</th>
						<th>startTime</th>
						<th>endTime</th>
						<th>Type</th>
						<th>Room Name</th>
						<th>Actions</th>
					</tr>
				</thead>
			</table>
		</div>
		<c:forEach items="${meetings}" var='i'>
			<div class="tbl-content">
				<table>
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
							<td><c:out value="${i.infoMeetingRoomName}" /></td>
							<td><a
								href="DeleteMeetingController?uniqueID=${i.uniqueID}&date=${i.date}&startTime=${i.startTime}&endTime=${i.endTime}&roomName=${i.infoMeetingRoomName}">
									delete </a></td>
						</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
	</section>
	<div>
		<section id="contact" class="contact">
			<h2 class="section-heading">Request for a Customized Room</h2>
			<div class="contact-container container">
				<div class="form-container">
					<form action="EmailSendingServlet" method="post">
						<input type="text" name="username" id="username"
							placeholder="Subject" required> <input type="hidden"
							name="email" id="email" placeholder="EMAIL"
							onKeyUp="checkemail()" autocomplete="off" value = <%= user.getEmail() %> required> <textarea
							name="textarea" id="textarea" cols="30" rows="5"
							placeholder="PLEASE TYPE YOUR MESSAGE HERE" required></textarea>
						<button type="submit"  onclick="printAlert()" class="btn"
							value="Submit">Submit</button>
					</form>
				</div>
			</div>
			<script type="text/javascript" src="js.main.js"></script>
		</section>
	</div>
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
						<li><a href="./CreateMeeting.jsp">Create Meeting</li>
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