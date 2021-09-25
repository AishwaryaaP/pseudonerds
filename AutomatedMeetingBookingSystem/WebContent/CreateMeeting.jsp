<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>MeetPro | CreateRoom</title>
<link rel="stylesheet" href="./CreateRoomStyle.css">
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
		<form action="ManagerController" >
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
			</div>
			
			<div class="item">
				<label for="endTime">End Time<span>*</span></label>
				<input type="time" id="endTime" name="endTime" class="input" required />
			</div>
	
			<div class="item">
				<label for="date">Date<span>*</span></label>
				<input type="date" id="date" name="date" class="input" required />
			</div>
			
	

  		
       <div class="btn-block">
				<button onclick="ManagerHome.jsp">SUBMIT</button>
			</div>
		</form>
	</div>
	<%--  <%
      boolean createStatus = (boolean) session.getAttribute("created");
		  	if(createStatus == true){
		  		System.out.println("meetingRoom Created");
		  	}
		  %> --%>

       
    
	
        
        
	

</body>
</html>