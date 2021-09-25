<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@ page import="com.AutomatedMeetingBookingSystem.model.Meeting" %>

<%@ page
	import="com.AutomatedMeetingBookingSystem.service.ServiceFactory.*"%>
<%@ page
	import="com.AutomatedMeetingBookingSystem.service.ServiceFactory"%>
<%@page
	import="com.AutomatedMeetingBookingSystem.service.MeetingService"%>
<%@ page import="com.AutomatedMeetingBookingSystem.model.Meeting"%>
<%@ page import="javax.servlet.http.HttpSession.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.AutomatedMeetingBookingSystem.controllers.*"%>
<%@ page import="com.AutomatedMeetingBookingSystem.enums.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function timeValidation() {
	var startTime = document.getElementById("startTime").value;
	var endTime = document.getElementById("endTime").value;
	var [startTimeHH, startTimeMM] = startTime.split(':');
	var [endTimeHH, endTimeMM] = endTime.split(':');
	var validationFailed = false;
	
	if (startTime === '' || startTime === null){
		document.getElementById('startTimeError').innerHTML="<font style=\"color: crimson\">*Empty Field</font>";
		document.getElementById('startTime').style.border='red 1px solid';
		validationFailed = true;
	}	
	if (endTime === '' || endTime === null){
		document.getElementById('endTimeError').innerHTML="<font style=\"color: crimson\">*Empty Field</font>";
		document.getElementById('endTime').style.border='red 1px solid';
		validationFailed = true;
	}

	if (startTimeHH > endTimeHH) {
		validationFailed = true;
	}
	else if (startTimeHH === endTimeHH && startTimeMM >= endTimeMM) {
		validationFailed = true;
	}


	if (validationFailed) {
		document.getElementById('startTimeError').innerHTML="<font style=\"color: crimson\">!Start time should always be less than end time</font>";
		document.getElementById('endTimeError').innerHTML="<font style=\"color: crimson\">!Start time should always be less than end time</font>";
		document.getElementById('endTime').style.border='red 1px solid';
		document.getElementById('startTime').style.border='red 1px solid';
	}
	return validationFailed;
}

function ready() {
	//initialze meeting date to tomorrow's date
	document.getElementById('date').value = new Date(getTomorrowDate()).toLocaleDateString().split('/').reverse().join('-')
}



function getTomorrowDate() {
	var tomorrow = new Date();
	tomorrow.setHours(0, 0, 0, 0)
	return tomorrow.setDate(new Date().getDate() + 1);
}

function dateValidation() {
	var meetingDate = document.getElementById("date").value;
	document.getElementById('dateError').innerHTML = '';

	if (new Date(meetingDate) < getTomorrowDate()) {
		document.getElementById('dateError').innerHTML="<font style=\"color: crimson\">!Booking date should always be a later date than today</font>";
		document.getElementById('date').style.border='red 1px solid';		
		return false;
	}
	
	return false;

}

function validateData() {
	var timeFlag=timeValidation();
	var dateFlag=dateValidation();
	if( timeFlag && dateFlag)
		return true;
	else
		return false;
	
}
</script>
</head>
<body>
	<%

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
        <input type=date  name="date" value="<%=meeting.getDate()%>"><p id="dateError"></p><br />
        
        <label for="startTime">startTime</label>
        <input type=time  name="startTime" value="<%=meeting.getStartTime()%>"><p id="startTimeError"></p><br />
        
        <label for="endTime">endTime</label>
        <input type=time  name="endTime" value="<%=meeting.getEndTime()%>"><p id="endTimeError"></p><br />
     
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
  		
				
		<div class="form-group col-9">
			<a href="#" class="btn btn-primary btn-block">
			   <button type="button" id="sbtn" name="sbtn"  onclick="validateData()" class="btn btn-primary btn-block "><h2>Create Meeting</h2></button><br/>
			</a>
        </div>
    	  
	






</body>
</html>