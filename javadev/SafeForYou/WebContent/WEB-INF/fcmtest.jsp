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
		<form action="SendMessage" method="post">
		<textarea rows="message" rows ="40" cols="50" placeholder="입력하세요!" ></textarea><br>
		<input type = "submit" name = "submit" value="보내기" id = "SubmitButton">
	</form>
</body>
</html>