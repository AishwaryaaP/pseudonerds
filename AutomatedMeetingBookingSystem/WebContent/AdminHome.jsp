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
	HttpSession session = request.getSession();
	
    <h1>Created Rooms</h1>
    
        <table  BORDER="5">
            <tr>
               <th>Room Name</th>
               <th>seatingCapacity</th>
               <th>Credit per hour</th>
               <th>Average Rating</th>
            </tr>
            
            
             <%=getAllMeeting%>
             <c:forEach items="${getAllMeeting}">
         		
                 <tr>
                     <td><a href = "EditRoom.jsp"><c:out value="${items.roomName}"/></a>
                     <form input type="hidden" name="roomName" value="${items.roomName}"></form>
                     <% session.setAttribute("roomName", items.getRoomName()); %></td>
                     <td><c:out value="${items.seatingCapacity}"/></td>  
                     <td><c:out value="${items.creditPerHour}"/></td>  
                     <td><c:out value="${items.avgRating}"/></td>  
                 </tr>
                 
                </c:forEach>
             
        </table>
    
    
</body>
</html>