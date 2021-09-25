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

	<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <a href = "GetAvailableRoomsController"> CREATE MEETING</a>
    
    <h1>Created Meetings</h1>
    
        <table  BORDER="5">
            <tr>
            	<th>Meeting Id</th>
            	<th>Title</th>
               <th>Date</th>
               <th>startTime</th>
               <th>endTime</th>
               <th>Type</th>
               
            </tr>
            
            
            
             <c:forEach items="${meetings}" var ='i'>
                 <tr>
                     <td><a href = "FetchMeetingDetailsController?uniqueID=${i.uniqueID}"><c:out value="${i.uniqueID}"/></a></td>
                     <td><c:out value="${i.title}"/></td>
                     <td><c:out value="${i.date}"/></td>  
                     <td><c:out value="${i.startTime}"/></td>  
                     <td><c:out value="${i.endTime}"/></td>
                     <td><c:out value="${i.type}"/></td>  
                 </tr>
                 
                </c:forEach>
             
        </table>
	

</body>
</html>