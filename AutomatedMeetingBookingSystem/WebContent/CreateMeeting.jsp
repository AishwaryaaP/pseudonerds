<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Create Room</h1>
    <form action="GetAvailableRoomsController" >
        <label for="type">Choose meeting type:</label>
  		<select id="type" name="type">
    		<option value="CLASSROOMTRAINING">ClassRoom Training</option>
    		<option value="ONLINETRAINING">Online Training</option>
    		<option value="CONFERENCECALL">ConferenceCall</option>
    		<option value="BUSINESS">Business</option>
  		</select>
  		        
        <label for="startTime">Start Time</label>
        <input type="time" id="startTime" name="startTime">
        
        <label for="endTime">End Time</label>
        <input type="time" id="endTime" name="endTime">

		
        <label for="date">Date</label>
        <input type="date" id="date" name="date"> 
  		
        <button >SUBMIT</button>
        
              
    </form>

</body>
</html>