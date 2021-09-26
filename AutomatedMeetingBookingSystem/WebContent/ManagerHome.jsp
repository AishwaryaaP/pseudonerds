<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.AutomatedMeetingBookingSystem.model.User"%>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
		
	if ((request.getSession(false) == null) || 
			(session.getAttribute ( "LOGINSTATUS" ) != "SUCCESS" )) {
		
		request.getRequestDispatcher("Login.jsp").forward ( request, response );		
	
	}
	else
	{
		User user = (User)session.getAttribute("userDetail");
		
		if ( user.getRole().equals ( "MEMBER" ) || user.getRole().equals ( "ADMIN" ))
		{
			request.getRequestDispatcher("Index.jsp").forward ( request, response );
			
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" sizes="32x32"
	href="./IMAGES/favicon.ico">
<title>MeetPro|Manager</title>
<link rel="stylesheet" href="./CSS/AdminHomeStyle.css">
</head>
<body>

	<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <a href = "CreateMeeting.jsp"> CREATE MEETING</a>
    
    <h1>Created Meetings</h1>
    
        <table  BORDER="5">
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
            
            
            
             <c:forEach items="${meetings}" var ='i'>
                 <tr>
                     <td><c:out value="${i.uniqueID}"/></a></td>
                     <td><c:out value="${i.title}"/></td>
                     <td><c:out value="${i.date}"/></td>  
                     <td><c:out value="${i.startTime}"/></td>  
                     <td><c:out value="${i.endTime}"/></td>
                     <td><c:out value="${i.type}"/></td>  
                     <td><c:out value="${i.infoMeetingRoomName}"/></td>
                     <td><a href = "DeleteMeetingController?uniqueID=${i.uniqueID}&date=${i.date}&startTime=${i.startTime}&endTime=${i.endTime}&roomName=${i.infoMeetingRoomName}"> delete </a></td>
                 </tr>
                 
                </c:forEach>
             
        </table>
	
	<%
		User user = (User) session.getAttribute("userDetail");
	%>

	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!-- Nav Bar -->

	<header>
		<nav role="navigation">
			<img class="logo" src="./IMAGES/pnlogo.svg" alt="MeetPro" href="#">
			<div class="container1" id="container1">
				<ul class="nav-ul" id="nav-ul">
					<li class="nav-link"><a href="GetScheduledByManagerController">Room
							Details</a></li>
					<li class="nav-link"><a>Credit: <%=user.getCredit() %></a></li>
					<li class="nav-link"><a>Last Loggedin: <%=user.getLastLoggedIn()%></a></li>
					<li claas="nav-link"><a href="UserProfile.jsp">Hello <%=user.getName() %></a></li>
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


		<h2 class="section-heading">Meetings Scheduled by Manager</h2>
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
							<td>><c:out value="${i.uniqueID}" /></td>
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
	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="footer">

				<div class="footer-icons">
					<a href="#"> <img src="./IMAGES/pseudo.svg" alt="">
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