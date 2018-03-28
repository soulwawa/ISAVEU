<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<% String root = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
<title>관리자 페이지 로그인</title>
<link href="<%=root%>/css/style1.css" rel="stylesheet" type="text/css">
</head>
<body>
	<section id="loginFormArea">
		<form action="/loing.do" method="POST">
			<div class="imgBox">
				<img src="<%=root%>/img/main.png" alt="logo" class="mainImg">
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
</html>