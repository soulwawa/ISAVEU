<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
<title>관리자 페이지 로그인</title>
<link href="/css/style1.css" rel="stylesheet" type="text/css">

</head>
<body>

	<section id="loginFormArea">
		<form action="/admin/loginPost" method="post">
			<div class="imgBox">
				<img src="/img/main.png" alt="logo" class="mainImg">
			</div>
			<div id="loginBox">
				<div class="box">
					<div>
						<input type="text" name="id" class="txtbox" placeholder="USER ID">
					</div>
					<div>
						<input type="password" name="pw" class="txtbox" placeholder="USER PASSWORD">
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