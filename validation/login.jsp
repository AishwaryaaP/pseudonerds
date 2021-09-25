<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function checkid()
{
  var userid = document.getElementById("userid").value; 
  
  if(isNaN(userid))
  {
    document.getElementById('checkid').innerHTML="<font style=\"color: crimson\"> Invalid Format</font>";
    document.getElementById('userid').style.border='red 1px solid';
    return false;
  }
  else if(userid.length != 9 || userid.length == 0)
  {
    document.getElementById('checkid').innerHTML="<font style=\"color: crimson\">* Invalid Format (9-digits).</font>";
    document.getElementById('userid').style.border='red 1px solid';
    return false;
  }
  else 
  {
    document.getElementById('checkid').innerHTML="<font style=\"color: green\"></font>";
    document.getElementById('userid').style.border='grey 1px solid'; 
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
  document.getElementById('userid').style.border='grey 1px solid';
  
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
  return false;
  
}
</script>
<body>

	<form action="GlobalServlet">
	<div>
	<label for="userId">Enter UserId</label>
	<input type="text" id="userid"  onKeyUp="checkid()" autocomplete="off"  placeholder="Enter Unique_ID" required> 
                    <div id="checkid" align="center"></div>
     </div>
	
	<div>
	<label for="email">Enter Email</label>
	<input id="email" type="email" name="email" placeholder="Email Address" onKeyUp="checkemail()" autocomplete="off" required>
	<div id="checkemail" ></div>
	</div>
	
	<div >
    <button  type="submit" id="sbtn" name="sbtn" value="Login">Log in</button>
  </div>
	</form>
	
	

</body>
</html>