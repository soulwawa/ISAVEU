<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String root = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css">
<title>관리자 페이지</title>
</head>
<body>
	<div class="nav">
		<button id="btn6"><img src="<%=root%>/img/main.png" alt="logo" class="mainImg"></button><br>
		<input type="button" value="센서로그" class="menuBtn" id="btn1"><br>
		<input type="button" value="사건목록" class="menuBtn" id="btn2"><br>
		<input type="button" value="실시간 스트리밍" class="menuBtn" id="btn3"><br>
		<input type="button" value="사원정보" class="menuBtn" id="btn4"><br>
		<input type="button" value="위치정보" class="menuBtn" id="btn5"><br>
	</div>
	<div class="container">
		<div class="top">
			온도 api
		</div>
		<div class="content">
			스트리밍
		</div>
	</div>
</body>
</html>