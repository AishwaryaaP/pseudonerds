<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="GlobalServlet" method="post" enctype="multipart/form-data">
            
        <input type="file" name="userFile"  /><br>
		<input type="submit" value="Upload" />
	</form>


</body>
</html>