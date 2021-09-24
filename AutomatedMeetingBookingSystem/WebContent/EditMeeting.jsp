<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.AutomatedMeetingBookingSystem.model.Meeting" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Meeting meeting = (Meeting)request.getAttribute("meeting");				
	%>
	
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
		<form  action = "EditMeetingController">
		
        <label for="uniqueID">Meeting ID</label>
        <input type="text"   name="uniqueID" id="uniqueID" value="<%=meeting.getUniqueID()%>" readonly>
        
        <label for="organizedBy">organizedby</label>
        <input type=number  name="organizedBy" value="<%=meeting.getOrganizedBy()%>" readonly><br />
        
         <label for="title">title</label>
        <input type=text  name="title" value="<%=meeting.getTitle()%>"><br />
        
        <label for="date">date</label>
        <input type=date  name="date" value="<%=meeting.getDate()%>"><br />
        
        <label for="startTime">startTime</label>
        <input type=time  name="startTime" value="<%=meeting.getStartTime()%>"><br />
        
        <label for="endTime">endTime</label>
        <input type=time  name="endTime" value="<%=meeting.getEndTime()%>"><br />
     
          <label for="type">Choose meeting type:</label>
          <select id="type" name="type">
          <% if( meeting.getType().value.equals("CLASSROOMTRAINING") ){	  %>
  			<option value="classroomTraining" Selected>ClassRoom Training</option>
    		<% }
          		else { %>
    		<option value="classroomTraining" >ClassRoom Training</option>
    		<%}
              if( meeting.getType().value.equals("ONLINETRAINING")){
        	  %>
    		<option value="OnlineTraining"Selected>Online Training</option>
    		<% }
    		else {
    		%>
    		<option value="OnlineTraining">Online Training</option>
    		<% }
    			if(meeting.getType().value.equals("CONFERENCECALL")){
        	  %>
    		<option value="ConferenceCall"Selected>ConferenceCall</option>
    		<% }
    		else {
    		%>
    		<option value="ConferenceCall">ConferenceCall</option>
    		<% }
    			if( meeting.getType().value.equals("BUSINESS")){
        	  %>
    		<option value="business"Selected>Business</option>
    		<%  }
    		else {
    		%>
    		<option value="business">Business</option>
    		<% } %>
  		</select>
  		
				
		<button > submit</button>        </form>
    	  
	


</body>
</html>