<%@page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom" %>
<%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>		
		<li> <a href="CreateRoom.jsp">Create Room </a>		
	</ul>
	<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
	
	<a href = "AdminController">User Details</a>	
	
	
    <h1>Created Rooms</h1>    
        <table  BORDER="5">
            <tr>
               <th>Room Name</th>
               <th>seatingCapacity</th>
               <th>Credit per hour</th>
               <th>Average Rating</th>
            </tr>            
             <c:forEach items="${meetingRoomList}" >         		
                 <tr>
                     <td><a href = "EditRoom.jsp"><c:out value="${items.roomName}"/></a> </td>
                     <td><c:out value="${items.seatingCapacity}"/></td>  
                     <td><c:out value="${items.creditPerHour}"/></td>  
                     <td><c:out value="${items.avgRating}"/></td>  
                 </tr>
                </c:forEach>
             
        </table>
    
    
</body>
</html>