<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<% String root = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=root%>/rMateChartH5.css" />
<script language="javascript" type="text/javascript"
	src="<%=root%>/rMateChartH5License.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=root%>/rMateGaugeChartH5.js"></script>
<script type="text/javascript" src="<%=root%>/theme.js"></script>
<script>
function showAlert(){
	  document.getElementById("art").style.display="block";
	  document.getElementById("fireBtn").style.display="block";
}
function closeAlert(){
	  showLocation();
	  document.getElementById("art").style.display="none";
	  document.getElementById("fireBtn").style.display="none";
}
function showLocation(){
	  document.getElementById("lct").style.display="block";
}
function closeLocation(){
	  document.getElementById("lct").style.display="none";
}
</script>
<style>

</style>
<title>센서 기록 열람</title>

</head>
<body>
	<div class="wrapper">
		<div class="alert" id="art" >
			화재 발생
			<div id="fireBtn" onclick="closeAlert()">위치확인</div>			
		</div>
		<div class="location" id="lct" onclick="closeLocation()">
		</div>
		<div class="header">
			<div class="case">
				<img src="<%=root%>/img/logo1.png" alt="logo" class="logo" />
			</div>
		</div>
		<div class="sidebar">
			<div class="menuBtn" onclick="sensorlog.go">sensor log</div>
			<div class="menuBtn" onclick="eventlog.go">event log</div>
			<div class="menuBtn" onclick="streaming.go">streaming</div>
			<div class="menuBtn" onclick="hrtable.go">HR table</div>
			<div class="menuBtn" onclick="location.go">location info</div>

		</div>
		<div class="contents">
			<div id="content"
				style="height: 520px; width: 550; position: relative;">
				<!-- 차트가 삽입될 DIV -->
				<div id="chartHolder1" class="chartHolder" style="height: 130px;"></div>
				<div id="chartHolder2" class="chartHolder" style="height: 130px;"></div>
				<div id="chartHolder3" class="chartHolder" style="height: 130px;"></div>
				<div id="chartHolder4" class="chartHolder" style="height: 130px;"></div>
			</div>
			<div>
				<div id="result1"></div>
				<div id="result2"></div>
				<div id="result3"></div>
				<div id="result4"></div>
			</div>
		</div>
		<div class="footer">
			<div style="padding: 7px;">Copyright © 2018 HSB Inc.</div>
		</div>
	</div>
</body>
</html>