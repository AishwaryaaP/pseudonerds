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
    <form action="ManagerController" onsubmit = "validateForm()" >
        <label for="type">Choose meeting type:</label>
  		<select id="type" name="type">
    		<option value="classroomTraining">ClassRoom Training</option>
    		<option value="OnlineTraining">Online Training</option>
    		<option value="ConferenceCall">ConferenceCall</option>
    		<option value="business">Business</option>
  		</select>
  		        
        <label for="startTime">Start Time</label>
        <input type="time" id="startTime" name="startTime">
        
        <label for="endTime">End Time</label>
        <input type="time" id="endTime" name="endTime">

		
        <label for="date">Date</label>
        <input type="date" id="date" name="date"> //validate date for past dates

		<label for="members">Select Members</label>
		
      
  		
  		
        <button onclick = "ManagerHome.jsp">SUBMIT</button>
        
              
    </form>
    <%
		request.setAttribute("act","getAvailableRooms");
		RequestDispatcher dispatcher = request.getRequestDispatcher("ManagerController");
		dispatcher.forward(request, response);
	%>    


	<h1>Available Meeting Rooms</h1>
    
        <table  BORDER="5">
            <tr>
               <th>Room Name</th>
               <th>seatingCapacity</th>
               <th>Credit per hour</th>
               <th>Average Rating</th>
               <th>Amenities</th>
               <th>Select Room</th>
            </tr>
            
            
             <%=getAvailabeRooms%>
             <c:forEach items="${getAvailabeRooms}">
         		
             	
                 <tr>
                     <td><c:out value="${items.roomName}"/></td>
                     <td><c:out value="${items.seatingCapacity}"/></td>  
                     <td><c:out value="${items.creditPerHour}"/></td>  
                     <td><c:out value="${items.avgRating}"/></td>
                     <td><c:out value="${items.amenities}"/></td>  
                 	<button onclick="SelectedRoom.jsp">Select Room</button>
                 </tr>
                 	
                 
                </c:forEach>
             
        </table>
        
        
	

</body>
</html>