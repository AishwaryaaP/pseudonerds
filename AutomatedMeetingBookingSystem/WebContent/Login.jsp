<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Login Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="LoginStyle.css">
<script src="https://kit.fontawesome.com/54fd602259.js" crossorigin="anonymous"></script>
  </head>
<script>
function checkid()
{
  var userid = document.getElementById("userId").value; 
  
  if(isNaN(userid))
  {
    document.getElementById('checkid').innerHTML="<font style=\"color: crimson\"> Invalid Format</font>";
    document.getElementById('userId').style.border='red 1px solid';
    return false;
  }
  else if(userid.length != 9 || userid.length == 0)
  {
    document.getElementById('checkid').innerHTML="<font style=\"color: crimson\">* Invalid Format (9-digits).</font>";
    document.getElementById('userId').style.border='red 1px solid';
    return false;
  }
  else 
  {
    document.getElementById('checkid').innerHTML="<font style=\"color: green\"></font>";
    document.getElementById('userId').style.border='grey 1px solid'; 
    return true;
  }
}
function checkemail() {
	  var email=document.getElementById("email").value;
	  var atpos=email.indexOf("@");
	  var dotpos = email.lastIndexOf(".");
	    if (email == null || email == "") 
	    {
          document.getElementById('checkemail').innerHTML="<font style=\"color: crimson\">*Empty Field</font>";
	      document.getElementById('email').style.border='red 1px solid';
	      return false;
	    }
	    else if(atpos< 1 || dotpos<atpos+2 || dotpos+2>=email.length)
	    {
	      document.getElementById('checkemail').innerHTML="<font style=\"color: crimson\">*Invalid Email</font>";
	      document.getElementById('email').style.border='red 1px solid';
	      return false;
	    }
	    else
	    {
	    document.getElementById('checkemail').innerHTML="<font style=\"color: green\"></font>";
	    document.getElementById('email').style.border='grey 1px solid';
	    return true;
	    }
	 }
function clearfields()
{
  document.getElementById('checkid').innerHTML="";
  document.getElementById('userId').style.border='grey 1px solid';
  
  document.getElementById('checkemail').innerHTML="";
  document.getElementById('email').style.border='grey 1px solid';
}
function validateData()
{
  var submit = document.getElementById("sbtn").value;
    var b = checkid();
    var a = checkemail();
  if(a&&b)
  return true;
  else 
  return false  
}
</script>
  <body>
    <div class="container">

      <div class="img">
          <img src="images/back.svg">
      </div>

      <div class="login-container">

          <form  action="GlobalServlet" method="post">

              <img src="images/avatar.svg" alt="avatar" class="avatar">

              <h2>Welcome</h2>
              <!--UserID-->
              <div class="input-div one">
                <div class="i">
                  <i class="fas fa-user"></i>
                </div>
                <div>
                    <input type="number"name="userId" id="userId" class="input" placeholder="UserID" onKeyUp="checkid()" autocomplete="off" required>
                </div>
              </div>

              <!--Email-->

              <div class="input-div two">
                <div class="i">
                  <i class="fas fa-lock"></i>
                </div>
                <div class="div">
                    <input type="email" name="email" id="email" class="input" placeholder="Email Address" onKeyUp="checkemail()" autocomplete="off" required>
                </div>
              </div>

              <input type="submit" class="btn"  value="Login">
              <a href="./Index.jsp#contact" class="account">Unable to Login? Contact Us.</a> 
          </form>
      </div>
    </div>
    <script type="text/javascript" src="js.main.js">

    </script>
  </body>
</html>
	
	

</body>
</html>