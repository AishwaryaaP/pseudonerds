<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.AutomatedMeetingBookingSystem.model.User"%>
<%@page import="com.AutomatedMeetingBookingSystem.controllers.MemberController"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");

if ((request.getSession(false) == null) || (session.getAttribute("LOGINSTATUS") != "SUCCESS")) {

	request.getRequestDispatcher("Login.jsp").forward(request, response);

} else {
	User user = (User) session.getAttribute("userDetail");

	if (user.getRole().equals("ADMIN")) {
		request.getRequestDispatcher("AdminHome.jsp").forward(request, response);

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
<link rel="icon" type="image/png" sizes="32x32" href="./IMAGES/favicon.ico">
<title>MeetPro | Member</title>
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
			<img class="logo" src="./IMAGES/pnlogo.svg" alt="MeetPro" href="#">
			<div class="container1" id="container1">
				<ul class="nav-ul" id="nav-ul">
				   <%--  <li class="nav-link"><a>Last Loggedin: <%=user.getLastLoggedIn()%></a></li> --%>
					<li class="nav-link"><a href="MeetingForMember">Meeting Details</a></li>
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
						<li><a href="Index.jsp">Logout</a></li>
					</a>
				</ul>
			</div>
		</nav>
	</header>
	<!--table-->
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
            </tr>     
            </thead>
			</table>
		</div>
						<table>
<div class="tbl-content">
					<tbody>
             <c:forEach items="${meetings}" var ='i'>


                 <tr>
                     <td><c:out value="${i.uniqueID}"/></td>
                     <td><c:out value="${i.title}"/></td>
                     <td><c:out value="${i.date}"/></td>  
                     <td><c:out value="${i.startTime}"/></td>  
                     <td><c:out value="${i.endTime}"/></td>
                     <td><c:out value="${i.type}"/></td>  
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