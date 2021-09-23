<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li> <a href="Admin.jsp"> Home </a> </li>
		<li> <a href="#"> Import Users </a> </li>
		<li> <a href="login.jsp"> Login </a> </li>
		<li > <a href="index.jsp"> Logout </a> </li>
		<li> <a href="#"> Give Feedback </a> </li>    
		<li> <a href="CreateRoom.jsp">Create Room </a>
		<li> <a href="EditRoom.jsp">Edit Room</a>
	</ul>
	<form action="AdminController" method="post" name="AdminCreateRoomForm" id="AdminCreateRoomForm">
			<div class="input-group">
			<input type=text placeholder="Meeting Name" id="meeting_name" name="meeting_name" class=form-control onkeyup="validateMeetingName()" required>
			<div id="meetingRoomError"></div>
			</div>
	
	
	
</body>
</html>