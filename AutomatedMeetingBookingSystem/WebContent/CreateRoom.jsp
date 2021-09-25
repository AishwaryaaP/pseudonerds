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

    
    <form action="CreateRoomController"  method ="POST" >
    
        <label for="meetingRoom">Meeting Room Name</label>
        <input type="text"  placeholder="Enter room name" name="roomName" id ="roomName"><br /> 
        
        <label for="seatingCapacity">Seating Capacity</label>
        <input name="seatingCapacity" type=number step=any /> <br /> 
           
       <label for="amenities">Amenities</label>
        <label for="projector">Projector</label><br>
        <input type="checkbox" class ="messageCheckbox" id="projector" name="amenities" value="projector">
        
        <label for="Wifi-Connection">Wifi-Connection</label><br>
        <input type="checkbox" class ="messageCheckbox" id="Wifi-Connection" name="amenities" value="Wifi-Connection">
        
        <label for="Con-Call">Con-Call</label><br>
        <input type="checkbox" class ="messageCheckbox" id="Con-Call" name="amenities" value="Con-Call">
        
        <label for="Whiteboard">Whiteboard</label><br>
        <input type="checkbox" class ="messageCheckbox" id="Whiteboard" name="amenities" value="Whiteboard">

        <label for="WaterDispenser">WaterDispenser</label><br>
        <input type="checkbox" class ="messageCheckbox" id="WaterDispenser" name="amenities" value="WaterDispenser">

        <label for="TV">TV</label><br>
        <input type="checkbox" class ="messageCheckbox" id="TV" name="amenities" value="TV">
        
        <label for="CoffeMachine">CoffeMachine</label><br>
        <input type="checkbox" class ="messageCheckbox" id="CoffeMachine" name="amenities" value="CoffeMachine"><br /> 
        
          <input type="submit" > <br /> 
    </form>
     <%--  <%
      boolean createStatus = (boolean) session.getAttribute("created");
		  	if(createStatus == true){
		  		System.out.println("meetingRoom Created");
		  	}
		  %> --%>
   
  
    
</body>
</html>