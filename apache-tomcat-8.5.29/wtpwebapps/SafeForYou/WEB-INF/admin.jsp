<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<% String root = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css">
<title>관리자 페이지</title>
</head>
<body>
	<div class="nav">
		<div>
			<a href="admin.do">
				<button id="btn6">
					<img src="<%=root%>/img/main.png" alt="logo" class="mainImg">
				</button>
			</a>
		</div>
		<br>
		<div>
			<a href="sensorlog.do"> <input type="button" value="센서로그"
				class="menuBtn" id="btn1">
			</a>
		</div>
		<br>
		<div>
			<a href="eventlog.do"> <input type="button" value="사건목록"
				class="menuBtn" id="btn2">
			</a>
		</div>
		<br>
		<div>
			<a href="streaming.do"> <input type="button" value="실시간 스트리밍"
				class="menuBtn" id="btn3">
			</a>
		</div>
		<br>
		<div>
			<a href="employee.do"> <input type="button" value="사원정보"
				class="menuBtn" id="btn4">
			</a>
		</div>
		<br>
		<div>
			<a href="location.do"> <input type="button" value="위치정보"
				class="menuBtn" id="btn5">
			</a>
		</div>
	</div>
	<div class="container">
		<div class="top">온도 api <%=request.getAttribute("result")%></div>
		<div class="content"></div>
	</div>
</body>
</html>