<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!-- css applied-->
<style>
.circular_image{
width:200px;
height:200px;
border-radius:50%;
overflow:hidden;
display:inline-block;
background-color:grey;
}

body {font-size:16px;}
#p1 h6{
    visibility: hidden;
  }
  #p1:hover h6  {
      visibility: visible;
  }
  #team #p1:hover{
    transform: scale(1.2);
    transition: .3s;
  }
  .gradient-custom-2 {
  /* fallback for old browsers */
  background: #fccb90;


  /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  background: linear-gradient(to right, #556b2f, #00bfff, #00ced1, #556b2f);
}

@media (min-width: 768px) {
  .gradient-form {
    height: 110vh !important;
  }
}
@media (min-width: 769px) {
  .gradient-custom-2 {
    border-top-right-radius: .3rem;
    border-bottom-right-radius: .3rem;
  }
}

</style>
<body>
<center>
<!-- Navbar functions -->
<div class="w3-top w3-hide-small">
  <div class="w3-bar w3-xlarge w3-black w3-opacity w3-hover-opacity-off" id="myNavbar">
    <a href="#" class="w3-bar-item w3-button">HOME</a>
    <a href="#login" class="w3-bar-item w3-button">LOGIN</a>
    <a href="#about" class="w3-bar-item w3-button">ABOUT</a>
     <a href="#contact" class="w3-bar-item w3-button">CONTACT</a>
    <a href="#myMap" class="w3-bar-item w3-button">PSEUDO_NERDS</a>
  </div>
</div>
<!--Navbar function ended-->
<!--Rooms  -->
<div><br/><br/>
 <h1 class="w3-jumbo w3-text-red"><b>Automated Meeting Room Booking System</b></h1>
    <h3 class="w3-center" style="color: grey"><i>ENABLE DIGITAL WORKFORCES WITH REMOTE CONNECTIVITY,COLLABORATION,AND<br><b>ENDPOINT SECURITY</b></i></h3>
      <div class="w3-container" style="padding:0px 0px;" id="team"><br>
        <div class="w3-row-paddingd- " style="margin-top:10px; margin-left:60px; ">
        		<div class="w3-col l3 m6 w3-card-4 w3-red" style="padding: 10px; width:250px;margin-right: 50px" id="p1">
               <div class="w3-center"><img src="photo/c2.jpg" class=" circular_image" alt="Conference Room"></div>
               <h4 class="w3-center w3-light-grey">Classroom Training</h4>
               <h4 class="w3-center w3-pale-red">Rooms: </h4> 
               <h6 class="w3-center w3-light-grey w3-text-red">Projector,Whiteboard</h6> 
               </div>
            <div class="w3-col l3 m6 w3-card-4 w3-red" style="padding: 10px; width:240px;margin-right: 50px" id="p1">
              <div class="w3-center"><img src="photo/troom.jpg" class="circular_image"  alt="Online Training"></div>
              <h4 class="w3-center w3-light-grey">Online Training</h4>
              <h4 class="w3-center w3-pale-red">Rooms: </h4>
              <h6 class="w3-center w3-light-grey w3-text-red">Projector,Wifi</h6>
              </div>
         
            <div class="w3-col l3 m6 w3-card-4 w3-red" style="padding: 10px; width:240px;margin-right: 50px" id="p1">
              <div class="w3-center"><img src="photo/concall.jpg" class="circular_image" alt="Class Training"></div>
              <h4 class="w3-center w3-light-grey">Conference Call</h4>
              <h4 class="w3-center w3-pale-red">Rooms: </h4>
              <h6 class="w3-center w3-light-grey w3-text-red">Conn Call Facility,Wifi</h6>
            </div>
            <div class="w3-col l3 m6 w3-card-4 w3-red" style="padding: 10px; width:240px;" id="p1">
              <div class="w3-center"><img src="photo/business.jpg" class="circular_image" alt="Business"></div>
              <h4 class="w3-center w3-light-grey">Business</h4>
              <h4 class="w3-center w3-pale-red">Rooms: </h4>
              <h6 class="w3-center w3-light-grey w3-text-red">Projector,Water dispenser</h6>
            </div>
        </div>
    </div>
  </div><br/>
  <!-- Login Form -->
 
<form class="login-form" action="login" method="post" onsubmit="return validateData()" >
<section class="h-100 gradient-form" style="background-color: #eee;">
  <div class="container py-5 h-100" id="login">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-xl-10">
        <div class="card rounded-3 text-black">
          <div class="row g-0">
            <div class="col-lg-6">
              <div class="card-body p-md-5 mx-md-4">

                <div class="text-center">
                  <img src="photo/login.jpg" style="width: 185px;" alt="logo">
                  <h4 class="mt-1 mb-5 pb-1"></h4>
                </div>

                <form>
                  <p>Please login to your account</p>

                  <div class="form-outline mb-4">
                  <label class="form-label d-flex align-items-left" >Unique_ID</label>
                    <input type="text" id="form2Example11" class="form-control" placeholder="Enter Unique_ID"/> 
                  </div>

                  <div class="form-outline mb-4">
                  <label class="form-label d-flex align-items-left">Password</label>
                    <input type="password" id="form2Example22" class="form-control" placeholder="Enter Password"/>
                  </div>
                  <div class="text-center">
                    <button class="btn btn-block fa-lg gradient-custom-2 mb-3" type="button">Log in</button>
                  </div>
                   <div class="text-center w-100">
                        <p class="text-muted font-weight-bold">Do not have an account?? <a href="createPage.html" class="text-primary ml-2">SignIn</a></p>
                    </div>
                </form>
              </div>
            </div>
            <div class="col-lg-6 d-flex align-items-center gradient-custom-2">
              <div class="text-white px-3 py-4 p-md-5 mx-md-4">
                <h1 class="mb-7">WELCOME</h1>
                <h2 class="mb-4">Please Sign In</h2>
                <h3 class="small mb-3"><b>Video conferencing boosts productivity, saves time, reduces travel expenses, and overall promotes collaboration. The advantage of video conferencing is the ability to facilitate all of those benefits without requiring constant travel for face-to-face communication.</b></br></h3>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

</body>

<!-- form method ended -->

<!-- footer -->
<div id="contact">
 <footer class="w3-center w3-dark-grey " style="width:110%;margin-left: -40px;margin-top: 40px;" >
  <a href="#" class="w3-button w3-black"><i class="w3-margin-right"></i>To the top</a>
  <div class="w3-large w3-section">
    Automated Meeting Room Booking System
    <h4><i class="w3-xlarge w3-margin-right"></i>Required Help? &nbsp&nbsp&nbsp&nbsp&nbsp&nbspFeel free to contact Us : &nbsp&nbsp&nbsp&nbsp
      <i class="w3-xlarge w3-margin-right"></i>Phone:&nbsp1111-56893 &nbsp&nbsp&nbsp&nbsp
      <i class="w3-xlarge w3-margin-right"></i>Email:&nbspcontact@hsbc.com</h4>
      <i class="w3-xlarge w3-margin-right"></i>twitter:&nbsphsbc.twitter.com</h4>
  </div>
<div>We don't care what people know, we care what they do. It's all about performance.
</div>
<div class="border-top">
<h6 class="text-center mt-3">Copyright @2021 All rights reserved</h6>
</div>
</div>
</center>
</footer>
</html>