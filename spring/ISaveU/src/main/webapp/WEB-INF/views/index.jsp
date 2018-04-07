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
<!--  
<script type="text/javascript">
	self.location = "/admin"
</script>
-->
	<section id="loginFormArea">
		<form action="/admin/weblogin" method="post">
			<div class="imgBox">
				<img src="<%=root%>/img/main.png" alt="logo" class="mainImg">
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