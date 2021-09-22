<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setAttribute("act","createMeeting");
		RequestDispatcher dispatcher = request.getRequestDispatcher("ManagerController");
		dispatcher.forward(request, response);
	%>    
	

	<form action="ManagerController">
		
		 <label for="listOfMembers">listOfMembers</label>
        <input type=text id="listOfMembers" name="listOfMembers"> //javascript se invalid user k liye validations
        
         <label for="title">Agenda</label>
        <input type=text id="title" name="title">
        
        <button>Submit</button>
        
	
	</form>
	
</body>
</html>