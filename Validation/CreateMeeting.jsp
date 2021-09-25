<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

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

<h1>Create Room</h1>
    <form action="ManagerController" >
        <label for="type">Choose meeting type:</label>
  		<select id="type" name="type">
    		<option value="classroomTraining">ClassRoom Training</option>
    		<option value="OnlineTraining">Online Training</option>
    		<option value="ConferenceCall">ConferenceCall</option>
    		<option value="business">Business</option>
  		</select>
         <br> 
        <label for="startTime">Start Time</label>
        <input type="time" id="startTime" name="startTime"><p id="startTimeError"></p>
        <br>
        <label for="endTime">End Time</label>
        <input type="time" id="endTime" name="endTime"><p id="endTimeError"></p>

		
        <label for="date">Date</label>
        <input type="date" id="date" name="date"> 
  		<p id="dateError"></p>
        <div class="form-group col-9">
			<a href="#" class="btn btn-primary btn-block">
			   <button type="button" id="sbtn" name="sbtn"  onclick="validateData()" class="btn btn-primary btn-block "><h2>Create Meeting</h2></button><br/>
			</a>
        </div>
        
              
    </form>
  
        

	
        
        
	

</body>
</html>