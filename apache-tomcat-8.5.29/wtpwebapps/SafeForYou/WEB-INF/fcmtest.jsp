<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>

<body>
	<h1>PUSH TEST</h1>
		<form action="SendMessage" method="post" id ="message" name = "message">
    <textarea name="message" rows="4" cols="50" >${message }</textarea><br>
    <input type="submit" name="test" value="test" id="submitButton">
    <br>
</form>

</body>
</html>