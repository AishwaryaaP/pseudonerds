<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <a href = "CreateMeeting.jsp"> CREATE MEETING</a>
    
    <h1>Created Meetings</h1>
    
        <table  BORDER="5">
            <tr>
            	<th>Meeting Id</th>
            	<th>Title</th>
               <th>Date</th>
               <th>startTime</th>
               <th>endTime</th>
               <th>Type</th>
               <th>Room Name</th>
               <th>Actions</th>
               
            </tr>
            
            
            
             <c:forEach items="${meetings}" var ='i'>
                 <tr>
                     <td><c:out value="${i.uniqueID}"/></a></td>
                     <td><c:out value="${i.title}"/></td>
                     <td><c:out value="${i.date}"/></td>  
                     <td><c:out value="${i.startTime}"/></td>  
                     <td><c:out value="${i.endTime}"/></td>
                     <td><c:out value="${i.type}"/></td>  
                     <td><c:out value="${i.infoMeetingRoomName}"/></td>
                     <td><a href = "DeleteMeetingController?uniqueID=${i.uniqueID}&date=${i.date}&startTime=${i.startTime}&endTime=${i.endTime}&roomName=${i.infoMeetingRoomName}"> delete </a></td>
                 </tr>
                 
                </c:forEach>
             
        </table>
	

</body>
</html>