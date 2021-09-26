<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./available.css">
</head>
<body>
<header>
		<nav role="navigation">
			<img class="logo" id="logo" src="./IMAGES/pnlogo.png" type="image/png"  alt="MeetPro" href="#">
			<div class="container1" id="container1">
				<ul class="nav-ul" id="nav-ul">
					<li claas="nav-link"><a onclick="history.back()">Return</a></li>
				</ul>
			</div>
			<div class="menuToggle" id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>
				<ul class="menu" id="menu">
					<a href="#edit">
						<li><a href="Index.jsp">Logout</a></li>
					</a>
				</ul>
			</div>
		</nav>
	</header>
	<h1>Available Meeting Rooms</h1>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>      
        <table  BORDER="5">
            <tr>
               <th>Room Name</th>
               <th>seatingCapacity</th>
               <th>Credit per hour</th>               
               <th>Amenities</th>
              
            </tr>
             <c:forEach items="${meetingRooms}" var = 'i'>
         		
             	
                 <tr>
                     <td> <a href="SelectedRoom.jsp?roomName=${i.roomName}"><c:out value="${i.roomName}"/></a></td>
                     <td><c:out value="${i.seatingCapacity}"/></td>  
                     <td><c:out value="${i.creditPerHour}"/></td>                     
                     <td><c:out value="${i.amenities}"/></td>  
                 
                 </tr>
                 	
                 
                </c:forEach>
             
        </table>
        
        
	

</body>
</html>