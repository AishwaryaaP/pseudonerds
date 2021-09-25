<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href="ImportUser.jsp">IMPORT USER</a>
	<a href="Login.jsp">LOGIN</a>

	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%
		request.setAttribute("act", "getAllRooms");
	RequestDispatcher dispatcher = request.getRequestDispatcher("AdminController");
	dispatcher.include(request, response);
	%>

	<h1>MEETING ROOMS</h1>y
	<table BORDER="5">
		<tr>
			<th>Room Name</th>
			<th>seatingCapacity</th>
			<th>No of Meetings</th>
			<th>Average Rating</th>
		</tr>
		<c:forEach items="${meetingRoomList}">
			<tr>
				<td><c:out value="${items.roomName}" /></td>
				<td><c:out value="${items.seatingCapacity}" /></td>
				<td><c:out value="${items.noOfMeeting}" /></td>
				<td><c:out value="${items.avgRating}" /></td>
			</tr>
		</c:forEach>

	</table>



</body>
</html>