<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.AutomatedMeetingBookingSystem.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		User user = (User) session.getAttribute("UserDetail");
	%>
	<table>
		<tr>
			<th>User ID</th>

			<th>Name</th>

			<th>Email id</th>

			<th>Phone Number</th>

			<th>Role</th>

		</tr>
		<tr>

			<td><%=user.getUserId()%></td>

			<td><%=user.getName()%></td>

			<td><%=user.getEmail()%></td>

		
			<td><%=user.getPhoneNumber()%></td>
			
			<td><%=user.getRole()%></td>


		</tr>


	</table>
</body>
</html>