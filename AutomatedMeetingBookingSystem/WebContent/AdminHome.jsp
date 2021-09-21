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

   
	<%
		request.setAttribute("act","getAllRooms");
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminController");
		dispatcher.forward(request, response);
	%>    
    <h1>Created Rooms</h1>
    
        <table  BORDER="5">
            <tr>
               <th>Room Name</th>
               <th>seatingCapacity</th>
               <th>Number of Meeting</th>
               <th>Rating</th>
            </tr>
            
            
             <%=getAllMeeting%>
             <c:forEach items="${getAllMeeting}">
             	 <tr>
               		<th>Room Name</th>
               		<th>seatingCapacity</th>
               		<th>Credit per hour</th>
               		<th>Average Rating</th>
            	</tr>
                 <tr>
                     <td><a href = "EditRoom.jsp"><c:out value="${getAllMeeting.roomName}"/></a>
                     <input type="hidden" name="roomName" value="${getAllMeeting.roomName}"></td>
                     <td><c:out value="${getAllMeeting.seatingCapacity}"/></td>  
                     <td><c:out value="${getAllMeeting.creditPerHour}"/></td>  
                     <td><c:out value="${getAllMeeting.avgRating}"/></td>  
                 </tr>
             
        </table>
    
    
</body>
</html>