<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.AutomatedMeetingBookingSystem.service.ServiceFactory.*"%>
<%@ page
	import="com.AutomatedMeetingBookingSystem.service.ServiceFactory"%>
<%@page
	import="com.AutomatedMeetingBookingSystem.service.MeetingService"%>
<%@ page import="com.AutomatedMeetingBookingSystem.model.Meeting"%>
<%@ page import="javax.servlet.http.HttpSession.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.AutomatedMeetingBookingSystem.controllers.*"%>
<%@ page import="com.AutomatedMeetingBookingSystem.enums.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
	Meeting meeting = (Meeting)request.getSession().getAttribute("scheduleDetail");
	int uniqueId = meeting.getUniqueID();
	MeetingService service = ServiceFactory.getMeetingService();
	Meeting meeting_details = service.fetchMeetingByUniqueID(uniqueId);
	%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ page import="java.util.Set"%>
	<form onsubmit="validateForm()" action="ManagerController">
		<label for="title">title</label> 
		<input type="text" placeholder="Enter meeting title" name="title" value="<%=meeting_details.getTitle()%>"> 
			
			<label for="date">Date</label>
		<input type=date name="date" value="<%=meeting_details.getDate()%>"><br />

		<label for="startTime">startTime</label> <input type=time
			name="startTime" value="<%=meeting_details.getStartTime()%>"><br />

		<label for="endTime">Date</label> <input type=time name="endTime"
			value="<%=meeting_details.getEndTime()%>"><br />
		<%
			MeetingType type = meeting_details.getType();
				switch (type) {
				case CLASSROOMTRAINING : 
					%>
					<label for="type">Choose meeting type:</label> <select id="type"
						name="type">
						<option value="classroomTraining" selected="selected">ClassRoom
							Training</option>
						<%
					break;
				case ONLINETRAINING : 
					%>
					<option value="OnlineTraining" selected="selected">Online
						Training</option>
					<%	
					break;
				case CONFERENCECALL : 
					%>
					<option value="ConferenceCall" selected="selected">ConferenceCall</option>
					<%			
					break;
				case BUSINESS:	
					%>
					<option value="business" selected="selected">Business</option>
					</select>
					<%	break;
			}
				%>
		
		 <label for="listOfMembers">listOfMembers</label> <input type=text
			id="listOfMembers" name="listOfMembers"
			value="<%=meeting_details.getListOfMember()%>"> </br>
		<%
			request.setAttribute("act", "editMeeting");
		RequestDispatcher dispatcher = request.getRequestDispatcher("ManagerController");
		dispatcher.forward(request, response);
		%>


		<button onClick="edit()" value ="editMeeting" name = "act"></button>    <button onClick="delete()" value ="deleteMeeting" name = "act"></button>     <button onClick="ManagerHome.jsp" value ="Edit" name = "act"></button>
	</form>
	<%
    	if(((String)request.getAttribute("act")).equals("editMeeting"))
    	{
    	if(((String)request.getAttribute("updated")).equals("updated"))
    	 System.out.println("Updated");
        else
        System.out.println("Not Updated! Plz try again");
    	}
    	if(((String)request.getAttribute("act")).equals("deleteMeeting"))
    	{
    	if(((String)request.getAttribute("deleted")).equals("deleted"))
    	 System.out.println("deleted");
        else
        System.out.println("Not Deleted! Plz try again");
    	}
    	
    	////conflict of act in attribute and button
    	
	%>   
	



</body>
</html>