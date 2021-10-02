<%@page import="jdk.internal.misc.FileSystemOption"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.AutomatedMeetingBookingSystem.model.MeetingRoom"%>
<%@ page
	import="com.AutomatedMeetingBookingSystem.controllers.GetAllRoomsController"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" sizes="32x32"
	href="./IMAGES/favicon.ico">
<title>PseudoNerds | MeetPro</title>
<link rel="stylesheet" href="./CSS/IndexStyle.css">
</head>
</head>
<script>
  function checkid() {
    var userid = document.getElementById("userid").value;
    if (isNaN(userid)) {
      document.getElementById('checkid').innerHTML = "<font style=\"color: crimson\"> Invalid Format</font>";
      document.getElementById('userid').style.border = 'red 1px solid';
      return false;
    }
    else if (userid.length != 9 || userid.length == 0) {
      document.getElementById('checkid').innerHTML = "<font style=\"color: crimson\">* Invalid Format (9-digits).</font>";
      document.getElementById('userid').style.border = 'red 1px solid';
      return false;
    }
    else {
      document.getElementById('checkid').innerHTML = "<font style=\"color: green\"></font>";
      document.getElementById('userid').style.border = 'grey 1px solid';
      return true;
    }
  }
  function checkemail() {
    var email = document.getElementById("email").value;
    var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");
    if (email == null || email == "") {
      document.getElementById('checkemail').innerHTML = "<font style=\"color: crimson\">*Empty Field</font>";
      document.getElementById('email').style.border = 'red 1px solid';
      return false;
    }
    else if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {
      document.getElementById('checkemail').innerHTML = "<font style=\"color: crimson\">*Invalid Email</font>";
      document.getElementById('email').style.border = 'red 1px solid';
      return false;
    }
    else {
      document.getElementById('checkemail').innerHTML = "<font style=\"color: green\"></font>";
      document.getElementById('email').style.border = 'grey 1px solid';
      return true;
    }
  }
  function clearfields() {
    document.getElementById('checkid').innerHTML = "";
    document.getElementById('userid').style.border = 'grey 1px solid';
    document.getElementById('checkemail').innerHTML = "";
    document.getElementById('email').style.border = 'grey 1px solid';
  }
  function validateData() {
    var submit1 = document.getElementById("sbtn1").value;
    var submit2 = document.getElementById("sbtn2").value;
    var a = checkid();
    var b = checkemail();
    if (a && b)
      form.submit1;
    else if (b)
      form.submit2;
    else
      return false;
  }
  function contactusfn() {
  	alert("We've recieved your query. We'll get back to you within next 48 hours ! :)");
  }
  function feedbackfn() {
	  alert("Thankyou for the feedback!");
  }
</script>



<body>
	<header>
		<div class="container">
			<nav>
				<img class="logo" id="logo" src="./IMAGES/pnlogo.png"
					type="image/png" alt="MeetPro" href="#">
				<ul class="nav-ul" id="nav-ul">
					<li class="nav-link"><a href="#about">About Us</a></li>
					<li class="nav-link"><a href="#roomtable">Created Rooms</a></li>
					<li class="nav-link"><a href="#feedback">Feedback</a></li>
					<li class="nav-link"><a href="#contact">Contact Us</a></li>
					<li class="nav-link"><a href="Login.jsp">Login</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<!-- Showcase -->
	<section id="about" class="feedback">
		<h2 class="feedback-heading lg-heading1">
			<img class="logg" id="logo" src="./IMAGES/meetpro.png"
				type="image/png" alt="" href="#">
		</h2>
		<div class="feedback-container container">
			<h2 class="feedback-heading lg-heading">Next generation meeting
				room booking system. Take your boardroom life online. Your MeetPro
				account will be a one-stop-solution for creating rooms, scheduling
				meetings, managing rooms, inviting members, and much more</h2>
			<p class="u-mb-large">
				<a href="#"> <img src="./IMAGES/pseudoNerds.png"
					type="image/png" alt="MEETPRO">
				</a>
			</p>
		</div>
		</div>
		</div>
	</section>
	<!--table-->
	<section id="roomtable" class="table-room">
		<h1></h1>
		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<h2 style="text-align: center; padding-inline: inherit; padding-top: 40px; padding-bottom: 20px" class="section-heading">Current Meeting Rooms</h2>
		<div class="tbl-header">
			<table>
				<thead>
					<tr>
						<th>Room ID</th>
						<th>Room Name</th>
						<th>Seating Capacity</th>
						<th>Credit Per Hour</th>
						<th>Room Rating</th>
						<th>Meeting Count</th>
					</tr>
				</thead>
			</table>
		</div>
		</thead>
		</table>
		</div>
		<c:forEach items="${meetingRoomList}" var='i'>
			<div>
				<table>
					<tbody>
						<tr>
							<td><c:out value="${i.roomId}" /></td>
							<td><c:out value="${i.roomName}" /></td>
							<td><c:out value="${i.seatingCapacity}" /></td>
							<td><c:out value="${i.creditPerHour}" /></td>
							<td><c:out value="${i.rating}" /></td>
							<td><c:out value="${i.count}" /></td>
							</c:forEach>
					</tbody>
				</table>
			</div>
	</section>

	<!-- FeedBack -->
	<section id="feedback" class="feedback">
		<form action="FeedbackController" method="POST">
			<h2 class="section-heading">Feedback</h2>
			<div class="feedback-container container">
				<h2 class="feedback-heading lg-heading">
					Have A Feedback For Us?<br>We would love to hear that!<br>We
					are Ever-Ready to Improvise!
				</h2>
				<div class="form-container">
					<input type="number" name="userid" class="input"
						placeholder="UserID" onKeyUp="checkid()" autocomplete="off"
						required> <input type="email" name="email" class="input"
						placeholder="Email Address" onKeyUp="checkemail()"
						autocomplete="off" required>
					<div class="form-container1">
						<div class="dropdown-content">
							<p>Select Room Name</p>
							<select class="form-container1" name="roomName">
								<c:forEach items="${meetingRoomList}" var='i'>
									<option value=<c:out value="${i.roomName}" />>
										<c:out value="${i.roomName}" /></option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-container1">
						<div class="wrapper">
							<p>Rating</p>
								<input name="rating" type="radio" id="st1" value="5" /> <label for="st1"></label> 
								<input name="rating" type="radio" id="st2" value="4" /> <label for="st2"></label> 
								<input name="rating" type="radio" id="st3" value="3" /> <label for="st3"></label>
								<input name="rating" type="radio" id="st4" value="2" /> <label for="st4"></label>
								<input name="rating" type="radio" id="st5" value="1" /> <label for="st5"></label>
						</div>
					</div>
					<button OnClick="feedbackfn()" type="submit" class="btn" value="Submit">Send Feedback</button>
				</div>
			</div>
			<script type="text/javascript" src="js.main.js"></script>
		</form>
	</section>

	<!-- Contact US -->
	<section id="contact" class="contact">
		<h2 class="section-heading">Contact Us</h2>
		<div class="contact-container container">
			<h2 class="contact-heading lg-heading">
				Facing Issues?<br>Feel Free to Contact Us!<br> We
				PseudoNerds are available 24/7 !
			</h2>
			<div class="form-container">

				<form class="form-container" action="EmailSendingServlet"
					method="POST">
					<input type="text" autocomplete="off" name="username" id="username" placeholder="Subject" required>
					<input type="email" name="email" id="email" placeholder="EMAIL" onKeyUp="checkemail()" autocomplete="off" required>
					<input name="textarea" id="textarea" cols="30" rows="5" placeholder="PLEASE TYPE YOUR MESSAGE HERE" autocomplete="off" required>
					<input type="hidden" name="index" value="index" id="index" />
					<button OnClick="contactusfn()" type="submit" class="btn" value="Submit">Submit</button>
				</form>
			</div>
		</div>
		<script type="text/javascript" src="js.main.js"></script>
	</section>
</body>

<!-- Footer -->
<section class="footer">
	<footer>
		<div class="container">
			<div class="footer">

				<div class="footer-icons">
					<a href="#"> <img src="" alt="">
					</a>
				</div>

				<div class="footer-links">
					<ul>
						<li><a href="#about">About Us</a></li>
						<li><a href="#contact">Contact</a></li>
					</ul>
				</div>

				<div class="footer-links">
					<ul>
						<li><a href="./Login.jsp">Login Page</li>
						<li><a href="#feedback">Feedback</a></li>
					</ul>
				</div>

				<div class="footer-credit">
					<a href="https://github.com/AishwaryaaP/pseudonerds">Github
						Repository</a>
					<p>@PseudoNerds. All Rights Reserved</p>
				</div>
			</div>
		</div>
	</footer>
</section>
</html>