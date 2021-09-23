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
		request.setAttribute("act","getScheduledByManager");
		session.setAttribute("organizedBy", user.getOrganizedBy());
		RequestDispatcher dispatcher = request.getRequestDispatcher("ManagerController");
		dispatcher.forward(request, response);
	%>    
	HttpSession session = request.getSession();
	
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
            
            
             <%=getScheduledByManager%>
             <c:forEach items="${getScheduledByManager}">
         		
             	
                 <tr>
                     <td><a href = "EditMeeting.jsp"><c:out value="${items.uniqueId}"/></a></td>
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