<%@page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom" %>
<%@page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom"%>

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
	
	<a href = "GetAllRoomsController">User Details</a>	
    <h1>Created Rooms</h1>    
        <table  BORDER="5">
            <tr>
               <th>Room Name</th>
               <th>seatingCapacity</th>
               <th>Credit per hour</th>
               <th>Count</th>
               <th>DELETE</th>
            </tr>            
             <c:forEach items="${meetingRoomList}" var='i' >         		
                 <tr>
                     <td><a href = "FetchMeetingRoomDetailsController?roomName=${i.roomName}"><c:out value="${i.roomName}"/></a> </td>
                     <td><c:out value="${i.seatingCapacity}"/></td>  
                     <td><c:out value="${i.creditPerHour}"/></td>  
                      <td><c:out value="${i.count}"/></td> 
                      <td><a href = "DeleteMeetingRoomController?roomName=${i.roomName}"> delete</a></td>
                 </tr>
                </c:forEach>
             
        </table>
    
    
</body>
</html>