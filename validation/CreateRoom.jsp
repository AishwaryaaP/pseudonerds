<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function meetingName(){
	 var name=document.getElementById("meetingRoom").value;
	 if (name == null || name == "") 
	    {
	          document.getElementById('meetingName').innerHTML="<font style=\"color: crimson\">*Empty Field</font>";
	      document.getElementById('meetingRoom').style.border='red 1px solid';
	      return false;
	    }
	 else 
	  {
	    document.getElementById('meetingName').innerHTML="<font style=\"color: green\"></font>";
	    document.getElementById('meetingRoom').style.border='grey 1px solid'; 
	    return true;
	  }
}
function max_capacity(){
	 var num=document.getElementById("seatingCapacity").value;
	 if (num == null || num == "") 
	    {
	      document.getElementById('max_capacity').innerHTML="<font style=\"color: crimson\">*Empty Field</font>";
	      document.getElementById('seatingCapacity').style.border='red 1px solid';
	      return false;
	    }
	 else 
	  {
	    document.getElementById('max_capacity').innerHTML="<font style=\"color: green\"></font>";
	    document.getElementById('seatingCapacity').style.border='grey 1px solid'; 
	    return true;
	  }
	 
}
function validateamenities(){
	   var am=document.getElementsByName("amenities");
	   var cnt=0;
	   for(var i=0;i<am.length;i++){
		   if(am[i].checked){
			   cnt++;
			   if(cnt>=2){
				   document.getElementById("hberr").innerHTML="";
				   return true;
			   }
		   }
	   }
	   document.getElementById("hberr").innerHTML="<font style=\"color: crimson\">*Select Min 2 amenties</font>";
	   document.getElementByName("amenities").style.border='red 1px solid';
	   return false;
   
}
function clearfields()
{
  document.getElementById('meetingName').innerHTML="";
  document.getElementById('meetingRoom').style.border='grey 1px solid';
  
  document.getElementById('max_capacity').innerHTML="";
  document.getElementById('seatingCapacity').style.border='grey 1px solid';
}

function validateData()
{
  var submit = document.getElementById("sbtn").value;
    var b = meetingName();
    var a = max_capacity();
    var c = validateamenities();
   
  if(a&&b&&c)
  return true;
  else 
  return false;
  
}
</script>
<body>
    <h1>Create Room</h1>

    
    <form action="CreateRoomController"  method ="POST" onsubmit = "validateForm()" >
    
        <div>
    <label for="meetingRoom">Meeting Room Name:-</label>
    <input id="meetingRoom" type="text" name="meetingRoom" onKeyUp="meetingName()" autocomplete="off" placeholder="Enter room name" required>
                        <div id="meetingName"></div>
     </div><br /> 
      <div>
    <label for="seatingCapacity">Seating Capacity:-</label>
    <input id="seatingCapacity" type="number" step=any name="seatingCapacity" onKeyUp="max_capacity()" autocomplete="off" placeholder="Enter number please" required>
                        <div id="max_capacity"></div><br/>
     </div>
        
        <br /> 
  <div >
       <label for="amenities">Amenities</label>
        <label for="projector">Projector</label><br>
        <input type="checkbox" class ="messageCheckbox" id="projector" name="amenities" value="projector">
        
        <label for="Wifi-Connection">Wifi-Connection</label><br>
        <input type="checkbox" class ="messageCheckbox" id="Wifi-Connection" name="amenities" value="Wifi-Connection" checked>
        
        <label for="Con-Call">Con-Call</label><br>
        <input type="checkbox" class ="messageCheckbox" id="Con-Call" name="amenities" value="Con-Call">
        
        <label for="Whiteboard">Whiteboard</label><br>
        <input type="checkbox" class ="messageCheckbox" id="Whiteboard" name="amenities" value="Whiteboard">

        <label for="WaterDispenser">WaterDispenser</label><br>
        <input type="checkbox" class ="messageCheckbox" id="WaterDispenser" name="amenities" value="WaterDispenser">

        <label for="TV">TV</label><br>
        <input type="checkbox" class ="messageCheckbox" id="TV" name="amenities" value="TV">
        
        <label for="CoffeMachine">CoffeMachine</label><br>
        <input type="checkbox" class ="messageCheckbox" id="CoffeMachine" name="amenities" value="CoffeMachine"><br /> 
        <p id="hberr"></p>
        </div>
        <!-- Submit Button -->
                    <div class="form-group col-9">
                        <a href="#" class="btn btn-primary btn-block">
                           <button type="submit" id="sbtn" name="sbtn" value="Login" onclick="validateData()" class="btn btn-primary btn-block "><h2>Create Room</h2></button><br/>
                        </a>
                    </div>
         
    </form>
     <%--  <%
      boolean createStatus = (boolean) session.getAttribute("created");
		  	if(createStatus == true){
		  		System.out.println("meetingRoom Created");
		  	}
		  %> --%>
   
  
    
</body>
</html>