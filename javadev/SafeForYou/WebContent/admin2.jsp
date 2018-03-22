<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<% String root = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=root%>/javascript/temperature.js"></script>
<title>관리자 페이지</title>
</head>
<body>
	<div class="wrap">
		<div class="header">	
			<div class="top">
				<div class="case">
					<div>
						<%=request.getAttribute("result")%>
					</div>
					<div>
						hello admin
					</div>
					<div class="logout">
						logout
					</div>
				</div>
			</div>
			<div class="nav">
				<div class="flex">
					<div class="menuBtn" id="mBtn1" onclick="admin.do">
						<img src="<%=root%>/img/main.png" alt="logo" class="mainImg">
					</div>
					<div class="menuBtn" id="mBtn2">
						sensor log
					</div>
					<div class="menuBtn" id="mBtn3">
						event log
					</div>
					<div class="menuBtn" id="mBtn4">
						streaming
					</div>
					<div class="menuBtn" id="mBtn5">
						HR table
					</div>
					<div class="menuBtn" id="mBtn6">
						location info
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div>
				<div class="tempChart">
					<div style="width: 125px; height: 30px; background: pink;">현재 온도</div>
					<div id="chart_div1"></div>
				</div>
				<div>
				</div>
				<div>
				</div>
				<div>
				</div>
			</div>
			
		</div>
		<div class="footer">
			<%=request.getAttribute("result")%>
		</div>
	</div>		
</body>
</html>