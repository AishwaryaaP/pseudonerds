<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p>Upload the json file containing user records to be inserted into
		database.</p>
	<form action="ImportUserController" method="post" enctype="multipart/form-data">
		<input type="file" name="myFile" accept="application/XML" required />
		<button type="submit" name="submit" value="insert data">Upload File</button>
	</form>
</body>
</html>