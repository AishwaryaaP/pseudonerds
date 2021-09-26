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
		
		if ( user.getRole().equals ( "MEMBER" ) || user.getRole().equals ( "ADMIN" ) )
		{
			request.getRequestDispatcher("Login.jsp").forward ( request, response );
			
		}
	}
%>
<!DOCTYPE html>

<html>
<head>
<title>MeetPro | CreateRoom</title>
<link rel="stylesheet" href="./CreateRoomStyle.css">
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


	<header>
		<nav role="navigation">
			<img class="logo" src="./images/pnlogo.svg" alt="MeetPro" href="#">
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
	<div class="space"></div>
	<div class="testbox">
		<form action="CreateMeetingController" >
			<div class="banner">
				<h1>Schedule Meeting</h1>
			</div>
			<div class="item">
				<label for="type">Choose meeting type:</label>
  		<select id="type" name="type">
    		<option value="classroomTraining">ClassRoom Training</option>
    		<option value="OnlineTraining">Online Training</option>
    		<option value="ConferenceCall">ConferenceCall</option>
    		<option value="business">Business</option>
  		</select>
  		        

			</div>
			<div class="item">
				<label for="startTime">Start Time<span>*</span></label>
				<input type="time" id="startTime" name="startTime" class="input" required />
				<p id="startTimeError"></p>
			</div>
			
			<div class="item">
				<label for="endTime">End Time<span>*</span></label>
				<input type="time" id="endTime" name="endTime" class="input" required />
				<p id="endTimeError"></p>
			</div>
	
			<div class="item">
				<label for="date">Date<span>*</span></label>
				<input type="date" id="date" name="date" class="input" required />
				<p id="dateError"></p>
			</div>
			
	

  		
       <div class="btn-block">
				<button onclick="ManagerHome.jsp">SUBMIT</button>
			</div>
		</form>
	</div>
	

       
    
	
        
        
	

</body>
</html>