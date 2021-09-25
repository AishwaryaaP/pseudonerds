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
<!-- M -->

<h1>Create Room</h1>
    <form action="ManagerController" >
        <label for="type">Choose meeting type:</label>
  		<select id="type" name="type">
    		<option value="classroomTraining">ClassRoom Training</option>
    		<option value="OnlineTraining">Online Training</option>
    		<option value="ConferenceCall">ConferenceCall</option>
    		<option value="business">Business</option>
  		</select>
  		        
        <label for="startTime">Start Time</label>
        <input type="time" id="startTime" name="startTime">
        
        <label for="endTime">End Time</label>
        <input type="time" id="endTime" name="endTime">

		
        <label for="date">Date</label>
        <input type="date" id="date" name="date"> //validate date for past dates
  		
        <button >SUBMIT</button>
        
              
    </form>
      


	
        
        
	

</body>
</html>