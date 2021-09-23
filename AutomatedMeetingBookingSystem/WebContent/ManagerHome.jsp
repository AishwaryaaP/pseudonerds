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

   <form action="GetScheduledByManagerController" method= "post">
   	<input type=submit value = 1></input>
   </form>
	
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
            
            
            
             <c:forEach items="${meetings}" var ='i'>
         		
             	
                 <tr>
                     <td><a href = "EditMeeting.jsp"><c:out value="${i.uniqueId}"/></a></td>
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