<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.AutomatedMeetingBookingSystem.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./managerStyle.css">

</head>
<body>

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
		
		if ( user.getRole().equals ( "MEMBER" ) )
		{
			request.getRequestDispatcher("MemberHome.jsp").forward ( request, response );
			
		}
		else if ( user.getRole().equals ( "ADMIN" ) )
		{
			request.getRequestDispatcher("AdminHome.jsp").forward ( request, response );
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
	<%

		User user = (User) session.getAttribute("userDetail");
	%>

	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!-- Nav Bar -->

	<header>
		<nav role="navigation">
			<img class="logo" id="logo" src="./IMAGES/pnlogo.png" type="image/png"  alt="MeetPro" href="#">
			<div class="container1" id="container1">
				<ul class="nav-ul" id="nav-ul">

				   <%--  <li class="nav-link"><a>Last Loggedin: <%=user.getLastLoggedIn()%></a></li> --%>

					<li class="nav-link"><a href="GetScheduledByManagerController">Meeting Details</a></li>
					<li class="nav-link"><a>Credit: <%=user.getCredit() %></a></li>
					<li claas="nav-link"><a href="UserProfile.jsp">Hello <%=user.getName() %></a></li>
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


	<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <a href = "CreateMeeting.jsp"> CREATE MEETING</a>
 <section class="table-room">
	<h1>                              </h1>
		<h2 style="text-align:center; padding-inline:inherit; padding-top: 40px; padding-bottom:20px" class="section-heading">Your Scheduled Meetings</h2>
		<div class="tbl-header">
    
    
    
        <table>
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
             <c:forEach items="${meetings}" var ='i'>
             <div class="tbl-content">
				<table>
					<tbody>
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
                </tbody>
				</table>
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