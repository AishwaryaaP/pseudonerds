<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.AutomatedMeetingBookingSystem.model.User"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MeetPro | Profile</title>
    <link rel="stylesheet" href="./UserProfileStyle.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>
	<%
		User user = (User) session.getAttribute("userDetail");
	%>
	<header>
        <nav class="navbar">
			<ul class="menu">
				<li><a class="btn" onclick="history.back()">Back</button></li>
			</ul>
		</nav>

	  	<div class="text-content">
        <img class="lsogo" src="./images/avatar.svg" alt="MeetPro" href="#">
			  <div>
				<ul><p>Fullname <%=user.getName()%></p>
				        <p>UserID: <%=user.getUserId()%></p>
                <p>Role: <%=user.getRole()%></p>
                <p>EMail: <%=user.getEmail()%></p>
                <p>Phone Number: <%=user.getPhoneNumber()%></p> 
                </ul>
			  </div>
		</div>
  </header>
	
</body>
</html>