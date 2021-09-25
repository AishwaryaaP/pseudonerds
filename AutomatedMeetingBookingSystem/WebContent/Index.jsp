<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="icon" type="image/png" sizes="32x32" href="./images/favicon-32x32.png">
  <script src="https://kit.fontawesome.com/54fd602259.js" crossorigin="anonymous"></script>
  <title>PseudoNerds | MeetPro</title>
  <link rel="stylesheet" href="./IndexStyle.css">
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
</script>


<body>



	<header>
    <div class="container">
      <nav>
        <img class="logo" src="./images/pnlogo.svg" alt="MeetPro" href="#">
        <ul class="nav-ul" id="nav-ul">
          <li class="nav-link"><a href="#about">About Us</a></li>
          <li class="nav-link"><a href="#about">Import Users</a></li>
          <li class="nav-link"><a href="#feedback">Feedback</a></li>
          <li class="nav-link"><a href="#contact">Contact Us</a></li>
          <li class="nav-link"><a href="Login.jsp">Login</a></li>
        </ul>
      </nav>
    </div>
  </header>
  <!-- Showcase -->
  <section class="welcome-section">
    <div class="container welcome ">
      <div class="welcome-text">
        <h1 class="u mb-small">
          Next generation <span>digital banking</span>
        </h1>
        <p class="u-mb-large">
          Take your financial life online. Your Easybank account will be a one-stop-shop
          for spending, saving, budgeting, investing, and much more.
        </p>
        <a href="#" class="btn">Request Invite</a>
      </div>
    </div>
  </section>

  <!-- About Section -->
  <section class="about" id="about">
    <div class="container about moveUP">
      <div class="about-text">
        <h2 class="u-mb-small heading-secondary">
          Why choose Easybank?
        </h2>
        <p class="u-mb-large">
          We leverage Open Banking to turn your bank account into your financial hub. Control
          your finances like never before.
        </p>
      </div>

      <div class="about-item">
        <div class="about-item-box">
          <img src="./images/icon-online.svg" alt="" class="u-mb-small">
          <h3 class="heading-tertiary u-mb-small">
            Online Banking
          </h3>
         <p>Upload the json file containing user records to be inserted into
		database.</p>
	<form action="ImportUserController" method="post" enctype="multipart/form-data">
		<input type="file" name="myFile" accept="application/XML" required />
		<button type="submit" name="submit" value="insert data">Upload File</button>
	</form>
        </div>

        <div class="about-item-box">
          <img src="./images/icon-budgeting.svg" alt="" class="u-mb-small">
          <h3 class="heading-tertiary u-mb-small">
            Simple Budgeting
          </h3>
          <p>See exactly where your money goes each month. Receive notifications when you’re
            close to hitting your limits.</p>
        </div>

        <div class="about-item-box">
          <img src="./images/icon-onboarding.svg" alt="" class="u-mb-small">
          <h3 class="heading-tertiary u-mb-small">
            Fast Onboarding
          </h3>
          <p>We don’t do branches. Open your account in minutes online and start taking control
            of your finances right away.</p>
        </div>

        <div class="about-item-box">
          <img src="./images/icon-api.svg" alt="" class="u-mb-small">
          <h3 class="heading-tertiary u-mb-small">
            Open API
          </h3>
          <p>Manage your savings, investments, pension, abd much more from one account. Tracking your money has never
            been easier. </p>
        </div>
      </div>
    </div>
  </section>

  <!-- FeedBack -->
  <section id="feedback" class="feedback">
    <h2 class="section-heading">Feedback</h2>
    <div class="feedback-container container">
      <h2 class="feedback-heading lg-heading">Have A Feedback For Us?<br>We would love to hear that!<br>We are
        Ever-Ready to Improvise!</h2>
      <div class="form-container">
        <input type="number" name="userid" class="input" placeholder="UserID" onKeyUp="checkid()" autocomplete="off"
          required>
        <input type="email" name="email" class="input" placeholder="Email Address" onKeyUp="checkemail()"
          autocomplete="off" required>
        <input type="number" name="userid" class="input" placeholder="RoomName Dropdown" onKeyUp="checkid()"
          autocomplete="off" required>
        <div class="form-container1">
          <div class="rate">
            <p>Rating</p>
            <input type="radio" id="star1" name="rate" value="1" />
            <label for="star1" title="text">1 star</label>
            <input type="radio" id="star2" name="rate" value="2" />
            <label for="star2" title="text">2 stars</label>
            <input type="radio" id="star3" name="rate" value="3" />
            <label for="star3" title="text">3 stars</label>
            <input type="radio" id="star4" name="rate" value="4" />
            <label for="star4" title="text">4 stars</label>
            <input type="radio" id="star5" name="rate" value="5" />
            <label for="star5" title="text">5 stars</label>
          </div>
        </div>
        <a type="submit" href="#" class="btn" value="Submit">Send Feedback</a>
      </div>
    </div>
    <script type="text/javascript" src="js.main.js"></script>
  </section>

  <!-- Contact -->
  <section id="contact" class="contact">
    <h2 class="section-heading" text="Green">Contact Us</h2>
    <div class="contact-container container">
      <h2 class="contact-heading lg-heading">Facing Issues?<br>Feel Free to Contact Us!<br> We PseudoNerds are available
        24/7 !</h2>
      <div class="form-container">
        <input type="text" name="" id="username" placeholder="YOUR NAME" required>
        <input type="email" name="" id="email2" placeholder="EMAIL" onKeyUp="checkemail()" autocomplete="off" required>
        <textarea name="" id="" cols="30" rows="5" placeholder="PLEASE TYPE YOUR MESSAGE HERE"></textarea required>
          <a type="submit" href="./LoginPage.html" class="btn" value="Submit">Submit</a>
      </div>
  </div>
  <script type="text/javascript" src="js.main.js"></script>
</section>

<!-- Footer -->
  <footer>
    <div class="container">
      <div class="footer">

        <div class="footer-icons">
          <a href="#">
            <img src="./images/icon-facebook.svg" alt="">
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
            <li><a href="./LoginPage.html">Login Page</a></li>
            <li><a href="#feedback">Feedback</a></li>
          </ul>
        </div>

        <div class="footer-credit">
          <div class="u-mb-large">
            <a href="https://github.com/AishwaryaaP/pseudonerds">Github Repository</a>
            <p>@PseudoNerds. All Rights Reserved</p>
          </div>
        </div>
      </div>
    </div>
  </footer>
	

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