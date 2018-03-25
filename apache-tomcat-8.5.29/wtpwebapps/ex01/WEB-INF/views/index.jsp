<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>관리자 페이지 로그인</title>
<link href="<c:url value="/resources/css/style1.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
	<section id="loginFormArea">
		<form action="login.do" method="POST">
			<div class="imgBox">
				<img src="<c:url value="/resources/img/main.png"/>" alt="logo" class="mainImg">
			</div>
			<div id="loginBox">
				<div class="box">
					<div>
						<input type="text" name="id" class="txtbox">
					</div>
					<div>
						<input type="password" name="password" class="txtbox">
					</div>
				</div>
				<div class="loginBtn">
					<input type="submit" name="loginBtn" value="Login">
				</div>
			</div>
		</form>
		<footer> HSB </footer>
	</section>
</body>
<footer>
</footer>
</html>