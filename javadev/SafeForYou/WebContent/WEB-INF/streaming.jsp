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
		<button id="btn6"><img src="<%=root%>/img/main.png" alt="logo" class="mainImg"></button><br>
		<input type="button" value="�����α�" class="menuBtn" id="btn1"><br>
		<input type="button" value="��Ǹ��" class="menuBtn" id="btn2"><br>
		<input type="button" value="�ǽð� ��Ʈ����" class="menuBtn" id="btn3"><br>
		<input type="button" value="�������" class="menuBtn" id="btn4"><br>
		<input type="button" value="��ġ����" class="menuBtn" id="btn5"><br>
	</div>
	<div class="container">
		<div class="top">
			�µ� api
		</div>
		<div class="content">
			��Ʈ����
		</div>
	</div>
</body>
</html>