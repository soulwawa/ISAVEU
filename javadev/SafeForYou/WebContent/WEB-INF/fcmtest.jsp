<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>PUSH TEST</h1>
	<form action="/Notication/SendMessage" method="post">
	<textarea rows="message" rows ="40" cols="50" placeholder="입력하세요!" ></textarea><br>
	<input type = "submit" name = "submit" value="보내기" id = SubmitButton">
	</form>
</body>
</html>