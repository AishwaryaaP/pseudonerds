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
    <form action="AdminController" onsubmit = "validateForm()" >
        <label for="meetingRoom">Meeting Room Name</label>
        <input type="text"  placeholder="Enter room name" name="meetingRoom">
        
        <label for="seatingCapacity">Seating Capacity</label>
        <input type=number step=any /> Step any<br />



        <label for="amenities">Amenities</label>
        <label for="projector">Projector</label><br>
        <input type="checkbox" id="projector" name="projector" value="projector">
        
        <label for="Wifi-Connection">Wifi-Connection</label><br>
        <input type="checkbox" id="Wifi-Connection" name="Wifi-Connection" value="Wifi-Connection">
        
        <label for="Con-Call">Con-Call</label><br>
        <input type="checkbox" id="Con-Call" name="Con-Call" value="Con-Call">
        
        <label for="Whiteboard">Whiteboard</label><br>
        <input type="Whiteboard" id="Whiteboard" name="Whiteboard" value="Whiteboard">

        <label for="WaterDispenser">WaterDispenser</label><br>
        <input type="WaterDispenser" id="WaterDispenser" name="WaterDispenser" value="WaterDispenser">

        <label for="TV">TV</label><br>
        <input type="TV" id="TV" name="TV" value="TV">

        <label for="CoffeMachine">CoffeMachine</label><br>
        <input type="CoffeMachine" id="CoffeMachine" name="CoffeMachine" value="CoffeMachine">
        
        
        <button onclick = "AdminHome.jsp">SUBMIT</button>
        
              
    </form>
    <%
		request.setAttribute("act","createRoom");
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminController");
		dispatcher.forward(request, response);
	%>    


    
</body>
</html>