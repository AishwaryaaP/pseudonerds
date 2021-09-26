8<%@page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom"%>
<%@page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom"%>
<%@page import="com.AutomatedMeetingBookingSystem.model.User"%>
<%@page import="com.AutomatedMeetingBookingSystem.controllers.GetAllRoomsController" %>

<%@ page import="java.util.*"%>
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
		
		if ( user.getRole().equals ( "MEMBER" ) )
		{
			request.getRequestDispatcher("MemberHome.jsp").forward ( request, response );
			
		}
		else if ( user.getRole().equals ( "MANAGER" ) )
		{
			request.getRequestDispatcher("ManagerHome.jsp").forward ( request, response );
		}
	}
%>


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

    



	<%
		User user = (User) session.getAttribute("userDetail");
	%>


	<!-- Nav Bar -->

	<header>
		<nav role="navigation">
			<img class="logo" src="./images/pnlogo.svg" alt="MeetPro" href="#">
			<div class="container1" id="container1">
				<ul class="nav-ul" id="nav-ul">
					<li class="nav-link"><a href="GetAllRoomsController">Room Details</a></li>
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

		<h2 class="section-heading">Created Rooms</h2>
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
					<tr>
					 <td>AAD</td>
            <td>AUSENCO</td>
            <td>$2.38</td>
            <td>-0.01</td>
            <td>-1.36%</td>
          </tr>
          <tr>
            <td>AAX</td>
            <td>ADELAIDE</td>
            <td>$3.22</td>
            <td>+0.01</td>
            <td>+1.36%</td>
          </tr>
          <tr>
            <td>XXD</td>
            <td>ADITYA BIRLA</td>
            <td>$1.02</td>
            <td>-1.01</td>
            <td>+2.36%</td>
          </tr>
          <tr>
            <td>AAC</td>
            <td>AUSTRALIAN COMPANY </td>
            <td>$1.38</td>
            <td>+2.01</td>
            <td>-0.36%</td>
          </tr>
				</thead>
			</table>
		</div>
				</thead>
			</table>
		</div>


		<c:forEach items="${meetingRoomList}" var='i'>
			<div class="tbl-content">
				<table cellpadding="0" cellspacing="0" border="0" >
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