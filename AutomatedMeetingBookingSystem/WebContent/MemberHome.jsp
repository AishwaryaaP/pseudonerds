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
		request.setAttribute("act","getScheduledMeetings");
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminController");
		dispatcher.forward(request, response);
	%>    
	HttpSession session = request.getSession();
	
	<a href = "UserProfile.jsp">User Details</a>
	
	<h1>Scheduled Meetings for Member</h1>
    
        <table  BORDER="5">
            <tr>
            	<th>Meeting Id</th>
            	<th>Title</th>
               <th>Date</th>
               <th>startTime</th>
               <th>endTime</th>
               <th>Type</th>
            </tr>           
            
            
             <c:forEach items="${getScheduledMeetings}">
             
              <tr>
                     <td><c:out value="${items.uniqueId}"/></td>
                     <td><c:out value="${items.title}"/></td>
                     <td><c:out value="${items.date}"/></td>  
                     <td><c:out value="${items.startTime}"/></td>  
                     <td><c:out value="${items.endTime}"/></td>
                     <td><c:out value="${items.type}"/></td>  
                 </tr>
                 
                </c:forEach>
             
        </table>

</body>
</html>