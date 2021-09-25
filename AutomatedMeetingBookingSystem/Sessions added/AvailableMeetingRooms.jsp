<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.AutomatedMeetingBookingSystem.model.User" %>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
		
	if ((request.getSession(false) == null) || 
			(session.getAttribute ( "LOGINSTATUS" ) != "SUCCESS" )) {
		
		request.getRequestDispatcher("Login.jsp").forward ( request, response );		
	
	}
	else
	{
		User user = (User)session.getAttribute("userDetail");
		
		if ( user.getRole().equals ( "MEMBER" ) )
		{
			request.getRequestDispatcher("MemberHome.jsp").forward ( request, response );
			
		}
		else if ( user.getRole().equals ( "ADMIN" ) )
		{
			request.getRequestDispatcher("AdminHome.jsp").forward ( request, response );
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Available Meeting Rooms</h1>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>      
        <table  BORDER="5">
            <tr>
               <th>Room Name</th>
               <th>seatingCapacity</th>
               <th>Credit per hour</th>
               <th>Average Rating</th>
               <th>Amenities</th>
               <th>Select Room</th>
            </tr>
             <c:forEach items="${meetingRooms}" var = 'i'>
         		
             	
                 <tr>
                     <td> <a href="SelectedRoom.jsp?roomName=${i.roomName}"><c:out value="${i.roomName}"/></a></td>
                     <td><c:out value="${i.seatingCapacity}"/></td>  
                     <td><c:out value="${i.creditPerHour}"/></td>  
                     <td><c:out value="${i.avgRating}"/></td>
                     <td><c:out value="${i.amenities}"/></td>  
                 
                 </tr>
                 	
                 
                </c:forEach>
             
        </table>
        
        
	

</body>
</html>