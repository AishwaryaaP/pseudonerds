<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function validateMeetingName(){
	 var name=document.getElementById("meeting_name").value;
	 if (name == null || name == "") 
	    {
	          document.getElementById('validateMeetingName').innerHTML="<font style=\"color: crimson\">Please Enter Meeting Name</font>";
	      document.getElementById('meeting_name').style.border='red 1px solid';
	      return false;
	    }
}
</script>
<body>
	<ul>
		<li> <a href="Admin.jsp"> Home </a> </li>
		<li> <a href="#"> Import Users </a> </li>
		<li> <a href="login.jsp"> Login </a> </li>
		<li > <a href="index.jsp"> Logout </a> </li>
		<li> <a href="#"> Give Feedback </a> </li>    
		<li> <a href="CreateRoom.jsp">Create Room </a>
		<li> <a href="EditRoom.jsp">Edit Room</a>
	</ul>
	<form action="AdminController" method="post" name="AdminCreateRoomForm" id="AdminCreateRoomForm">
	
			<div class="input-group">
			<input type="text" placeholder="Meeting Name" id="meeting_name" name="meeting_name" class="form-control bg-white border-left-0 border-md" onKeyup="validateMeetingName()" autocomplete="off" required>
			<div id="validateMeetingName"></div>
			</div>
	
	
	
</body>
	

</html>