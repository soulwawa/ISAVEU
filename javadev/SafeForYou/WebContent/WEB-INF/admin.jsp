<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String root = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css">
<title>������ ������</title>
</head>
<body>
	<div class="nav">
		<a href="admin.do">
			<button id="btn6">
				<img src="<%=root%>/img/main.png" alt="logo" class="mainImg">
			</button>
		</a>
		<br>
		<a href="sensorlog.do">
			<input type="button" value="�����α�" class="menuBtn" id="btn1">
		</a><br>
		<a href="eventlog.do">
			<input type="button" value="��Ǹ��" class="menuBtn" id="btn2">
		</a><br>
		<a href="streaming.do">
			<input type="button" value="�ǽð� ��Ʈ����" class="menuBtn" id="btn3">
		</a><br>
		<a href="employee.do">
			<input type="button" value="�������" class="menuBtn" id="btn4">
		</a><br>
		<a href="location.do">
			<input type="button" value="��ġ����" class="menuBtn" id="btn5">
		</a><br>
	</div>
	<div class="container">
		<div class="top">
			�µ� api
		</div>
		<div class="content">
		
		</div>
	</div>
</body>
</html>