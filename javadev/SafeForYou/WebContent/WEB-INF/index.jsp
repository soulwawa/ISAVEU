<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<% String root = request.getContextPath(); %>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<link href="<%=root%>/css/style1.css" rel="stylesheet" type="text/css">
<style>
	body{
		background:red;
	}
	
	#loginFormArea{
		background:blue;
		width:400px;
		heigh:500px;
		margin-right: auto;
  		margin-left: auto;
	}
	.loginBtn{
		float:left;
	}
</style>
</head>
<body>
	<section id = "loginFormArea">
	<form action="login.do" method="POST">
		<div class="imgBox">
			<img src="<%=root%>/img/main.png" alt="logo">
		</div>
		<div id="loginBox">
			<div>
				<input type="text" name="id" class="txtbox" name="idBox">
			</div>
			<div>
				<input type="password" name="password" class="txtbox" name="pwdBox">
			</div>
		</div>
		<div class="loginBtn">
			<input type="submit" name="loginBtn" value="Login">
		</div>
	</form>
	</section>
</body>
</html>