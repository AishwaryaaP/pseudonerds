<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalTime"%>
<%@page import="com.AutomatedMeetingBookingSystem.enums.MeetingType" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.AutomatedMeetingBookingSystem.model.User" %>

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
<html><head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" sizes="32x32"
	href="IMAGES/favicon.ico">
<title>MeetPro | Selected Room</title>
<link rel="stylesheet" href="./CSS/CreateRoomStyle.css">
</head>
<body>
<header>
		<nav role="navigation">
			<img class="logo" id="logo" src="./IMAGES/pnlogo.png" type="image/png"  alt="MeetPro" href="#">
			<div class="container1" id="container1">
				<ul class="nav-ul" id="nav-ul">
					<li claas="nav-link"><a onclick="history.back()">Return</a></li>
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
	<h2
			style="text-align: center; padding-inline: inherit; padding-top: 90px; padding-bottom: 20px"
			class="section-heading">Selected Room</h2>
<form action="CreateMeetingController">
		 <%
			 String roomName = request.getParameter("roomName");
			 LocalDate localDate = (LocalDate)request.getSession().getAttribute("date");
			LocalTime startTime =(LocalTime) request.getSession().getAttribute("startTime");
			LocalTime endTime = (LocalTime)request.getSession().getAttribute("endTime");
			MeetingType type = (MeetingType)request.getSession().getAttribute("type");
		 %>
		 
		 <label for="roomName">room Name</label>
        <input type="text" id="roomName" name="roomName" value="<%=roomName%>" readonly>
        
		   <label for="type">Choose meeting type:</label>
	         <select id="type" name="type">
	         <% if( type.value.equals("CLASSROOMTRAINING") ){	  %>
	 			<option value="CLASSROOMTRAINING" Selected>CLASSROOMTRAINING</option>
	   		<% }
	         		else { %>
	   		<option value="CLASSROOMTRAINING" >CLASSROOMTRAINING</option>
	   		<%}
	             if( type.value.equals("ONLINETRAINING")){
	       	  %>
	   		<option value="ONLINETRAINING"Selected>ONLINETRAINING</option>
	   		<% }
	   		else {
	   		%>
	   		<option value="ONLINETRAINING">ONLINETRAINING</option>
	   		<% }
	   			if(type.value.equals("CONFERENCECALL")){
	       	  %>
	   		<option value="CONFERENCECALL"Selected>CONFERENCECALL</option>
	   		<% }
	   		else {
	   		%>
	   		<option value="CONFERENCECALL">CONFERENCECALL</option>
	   		<% }
	   			if(type.value.equals("BUSINESS")){
	       	  %>
	   		<option value="BUSINESS"Selected>BUSINESS</option>
	   		<%  }
	   		else {
	   		%>
	   		<option value="BUSINESS">BUSINESS</option>
	   		<% } %>
	 		</select>
	 		
        <label for="startTime">Start Time</label>
        <input type="time" id="startTime" name="startTime" value="<%=startTime%>" readonly>
        
        <label for="endTime">End Time</label>
        <input type="time" id="endTime" name="endTime" value="<%=endTime%>" readonly>

		
        <label for="date">Date</label>
        <input type="date" id="date" name="date"value="<%=localDate%>" readonly> 
        
        <label for="title">Agenda</label>
        <input type=text id="title" name="title">
        
		 <label for="listOfMembers">listOfMembers</label>
        <input type=text id="listOfMembers" name="listOfMembers">
        
     
        
       <input type="submit" value ="SUBMIT">
        
	
	</form>
	
	
</body>
</html>