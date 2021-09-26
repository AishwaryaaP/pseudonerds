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
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
  			<option value="classroomTraining" Selected>ClassRoom Training</option>
    		<% }
          		else { %>
    		<option value="classroomTraining" >ClassRoom Training</option>
    		<%}
              if( type.value.equals("ONLINETRAINING")){
        	  %>
    		<option value="OnlineTraining"Selected>Online Training</option>
    		<% }
    		else {
    		%>
    		<option value="OnlineTraining">Online Training</option>
    		<% }
    			if(type.value.equals("CONFERENCECALL")){
        	  %>
    		<option value="ConferenceCall"Selected>ConferenceCall</option>
    		<% }
    		else {
    		%>
    		<option value="ConferenceCall">ConferenceCall</option>
    		<% }
    			if(type.value.equals("BUSINESS")){
        	  %>
    		<option value="business"Selected>Business</option>
    		<%  }
    		else {
    		%>
    		<option value="business">Business</option>
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