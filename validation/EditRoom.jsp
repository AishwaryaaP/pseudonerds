<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.AutomatedMeetingBookingSystem.service.ServiceFactory.*" %>
<%@ page import="com.AutomatedMeetingBookingSystem.service.ServiceFactory" %>
<%@page import="com.AutomatedMeetingBookingSystem.service.MeetingRoomService" %>
<%@ page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom" %>
<%@ page import="javax.servlet.http.HttpSession.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.AutomatedMeetingBookingSystem.controllers.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function meetingName(){
	 var name=document.getElementById("meetingRoom").value;
	 if (name == null || name == "") 
	    {
	          document.getElementById('meetingName').innerHTML="<font style=\"color: crimson\">*Empty Field</font>";
	      document.getElementById('meetingRoom').style.border='red 1px solid';
	      return false;
	    }
	 else 
	  {
	    document.getElementById('meetingName').innerHTML="<font style=\"color: green\"></font>";
	    document.getElementById('meetingRoom').style.border='grey 1px solid'; 
	    return true;
	  }
}
function max_capacity(){
	 var num=document.getElementById("seatingCapacity").value;
	 if (num == null || num == "") 
	    {
	      document.getElementById('max_capacity').innerHTML="<font style=\"color: crimson\">*Empty Field</font>";
	      document.getElementById('seatingCapacity').style.border='red 1px solid';
	      return false;
	    }
	 else 
	  {
	    document.getElementById('max_capacity').innerHTML="<font style=\"color: green\"></font>";
	    document.getElementById('seatingCapacity').style.border='grey 1px solid'; 
	    return true;
	  }
	 
}
function validateamenities(){
	   var am=document.getElementsByName("amenities");
	   var cnt=0;
	   for(var i=0;i<am.length;i++){
		   if(am[i].checked){
			   cnt++;
			   if(cnt>=2){
				   document.getElementById("hberr").innerHTML="";
				   return true;
			   }
		   }
	   }
	   document.getElementById("hberr").innerHTML="<font style=\"color: crimson\">*Select Min 2 amenties</font>";
	   document.getElementByName("amenities").style.border='red 1px solid';
	   return false;
   
}
function clearfields()
{
  document.getElementById('meetingName').innerHTML="";
  document.getElementById('meetingRoom').style.border='grey 1px solid';
  
  document.getElementById('max_capacity').innerHTML="";
  document.getElementById('seatingCapacity').style.border='grey 1px solid';
}

function validateData()
{
  var submit = document.getElementById("sbtn").value;
    var b = meetingName();
    var a = max_capacity();
    var c = validateamenities();
   
  if(a&&b&&c)
  return true;
  else 
  return false;
  
}
</script>
<body>
	<%
		MeetingRoom room = (MeetingRoom)request.getAttribute("MeetingRoom");				
	%>
	
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	
	
		<form  action = "EditMeetingRoomController">
		
        <label for="meetingRoom">Meeting Room Name</label>
        <input id="meetingRoom" type="text" name="meetingRoom" onKeyUp="meetingName()" autocomplete="off" placeholder="Enter room name"  value="<%=room.getRoomName()%>" readonly>>
                        <div id="meetingName"></div>
        
        <label for="seatingCapacity">Seating Capacity</label>
        <input id="seatingCapacity" type=number step=any name="seatingCapacity" onKeyUp="max_capacity()" autocomplete="off" placeholder="Enter number please"  value="<%=room.getSeatingCapacity()%>"><br />

		<% 		
		 String [] amenitiesString = room.getAmenities().split(" ");
         Set<String> amenities = new HashSet<>();
         for(String amenity : amenitiesString) {
        	 amenities.add(amenity);
         }
         %> 
         <label for="projector">Projector</label><br>
         <% if(amenities.contains("PROJECTOR")) { %> 
             <input type="checkbox" id="projector" class ="messageCheckbox" name="amenities" Checked value="projector">
         <% } 
            else { %>
             <input type="checkbox" id="projector" class ="messageCheckbox" name="amenities"  value="projector">
         <% } %>
         
         <label for="Wifi-Connection">Wifi-Connection</label><br>
         <% if(amenities.contains("WIFICONNECTION")) { %> 
             <input type="checkbox" class ="messageCheckbox" id="Wifi-Connection" name="amenities" Checked value="Wifi-Connection" checked>
         <% } 
            else { %>
             <input type="checkbox" class ="messageCheckbox" id="Wifi-Connection" name="amenities"  value="Wifi-Connection">
         <% } %>
         
         <label for="Con-Call">Con-Call</label><br>
         <% if(amenities.contains("CONFERENCECALL")) { %> 
             <input type="checkbox" id="Con-Call" class ="messageCheckbox" name="amenities" Checked value="Con-Call">
         <% } 
            else { %>
             <input type="checkbox" id="Con-Call" class ="messageCheckbox" name="amenities"  value="Con-Call">
         <% } %>
         
         <label for="Whiteboard">Whiteboard</label><br>
         <% if(amenities.contains("WHITEBOARD")) { %> 
             <input type="checkbox" id="Whiteboard" class ="messageCheckbox" name="amenities" Checked value="Whiteboard">
         <% } 
            else { %>
             <input type="checkbox" id="Whiteboard" class ="messageCheckbox" name="amenities"  value="Whiteboard">
         <% } %>
         
         <label for="WaterDispenser">WaterDispenser</label><br>
         <% if(amenities.contains("WATERDISPENCER")) { %> 
             <input type="checkbox" id="WaterDispenser" class ="messageCheckbox" name="amenities" Checked value="WaterDispenser">
         <% } 
            else { %>
             <input type="checkbox" id="WaterDispenser" class ="messageCheckbox" name="amenities"  value="WaterDispenser">
         <% } %>
         
         <label for="TV">TV</label><br>
         <% if(amenities.contains("TV")) { %> 
             <input type="checkbox" id="TV" class ="messageCheckbox" name="amenities" Checked value="TV">
         <% } 
            else { %>
             <input type="checkbox" id="TV" class ="messageCheckbox" name="amenities"  value="TV">
         <% } %>
         
         <label for="CoffeMachine">CoffeMachine</label><br>
         <% if(amenities.contains("COFFEEMACHINE")) { %> 
             <input type="checkbox" id="CoffeMachine" class ="messageCheckbox" name="amenities" Checked value="CoffeMachine">
         <% } 
            else { %>
             <input type="checkbox" id="CoffeMachine" class ="messageCheckbox" name="amenities"  value="CoffeMachine">
         <% } %>
				
		<!-- Submit Button -->
                    <div class="form-group col-9">
                        <a href="#" class="btn btn-primary btn-block">
                           <button type="submit" id="sbtn" name="sbtn" value="Login" onclick="validateData()" class="btn btn-primary btn-block "><h2>Create Room</h2></button><br/>
                        </a>
                    </div>
    	  

	</form>


</body>
</html>