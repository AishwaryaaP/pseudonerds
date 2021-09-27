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
<title>MeetPro | CreateRoom</title>
<link rel="stylesheet" href="./CSS/CreateRoomStyle.css">
</head>
<body>
	<header>
		<nav role="navigation">
			<img class="logo" id="logo" src="./IMAGES/pnlogo.png" type="image/png"  alt="MeetPro" href="#">
			<div class="container1" id="container1">
				<ul class="nav-ul" id="nav-ul">
					<li class="nav-link"><a onclick="history.back()">Return to Admin Home</a></li>
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
		<form action="CreateRoomController" method="POST">
			<div class="banner">
				<h1>Create Room</h1>
			</div>
			<div class="item">
				<label for="name">Room Name<span>*</span></label> <input id="name" type="text" name="roomName"placeholder="Enter the unique room name" required />
			</div>
			<div class="item">
				<label for="seatingCapacity">Seating Capacity<span>*</span></label>
				<input type="number" name="seatingCapacity" class="input"
					placeholder="Enter the desired Seating Capacity" required />
			</div>
			<div class="question">
				<label for="amenities">Select Amenities (minimum 2)</label>
				<div class="question-answer">
					<div>
						<input type="checkbox" value="projector" id="projector"
							name="amenities" /> <label for="projector" class="checkbox"><span>Projector</span></label>
					</div>
					<div>
						<input type="checkbox" value="Wifi-Connection"
							id="Wifi-Connection" name="amenities" /> <label
							for="Wifi-Connection" class="checkbox"><span>Wifi-Connection</span></label>
					</div>
					<div>
						<input type="checkbox" value="Con-Call" id="Con-Call"
							name="amenities" /> <label for="Con-Call" class="checkbox"><span>Con-Call</span></label>
					</div>
					<div>
						<input type="checkbox" value="Whiteboard" id="Whiteboard"
							name="amenities" /> <label for="Whiteboard" class="checkbox"><span>Whiteboard</span></label>
					</div>
					<div>
						<input type="checkbox" value="WaterDispenser" id="WaterDispenser"
							name="amenities" /> <label for="WaterDispenser" class="checkbox"><span>WaterDispenser</span></label>
					</div>
					<div>
						<input type="checkbox" value="TV" id="TV" name="amenities" /> <label
							for="TV" class="checkbox"><span>TV</span></label>
					</div>
					<div>
						<input type="checkbox" value="CoffeeMachine" id="CoffeeMachine"
							name="amenities" /> <label for="CoffeeMachine" class="checkbox"><span>Coffee
								Machine</span></label>
					</div>
				</div>
			</div>
			<div class="btn-block">
				<button onclick="AdminHome.jsp">SUBMIT</button>
			</div>
		</form>
	</div>
	<%--  <%
      boolean createStatus = (boolean) session.getAttribute("created");
		  	if(createStatus == true){
		  		System.out.println("meetingRoom Created");
		  	}
		  %> --%>
</body>
</html>