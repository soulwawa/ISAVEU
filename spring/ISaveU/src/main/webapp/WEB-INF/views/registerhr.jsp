<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
	String root = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>HR Registry</title>

</head>
<body>
	<div class="wrapper">
		<div class="alert" id="art">
			화재 발생
			<div id="fireBtn" onclick="closeAlert()">위치확인</div>
		</div>
		<div class="location" id="lct" onclick="closeLocation()">
			<div id="fire">
				<div id="exts1">
					<div class="shake-freeze" id="ex0">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex1">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex2">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex3">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex4">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex5">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex6">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex7">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex8">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex9">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex10">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
				</div>
			</div>
		</div>
		<div class="header">
			<div class="case" onclick="goReplace('/admin')">
				<img src="<%=root%>/img/logo1.png" alt="logo" class="logo" />
			</div>
		</div>
		<div class="sidebar">
			<div class="menuBtn">
				<button type="button" class="btn btn-default btn-lg btn-block"
					onclick="goReplace('/sensor')">
					<span class="glyphicon glyphicon-tasks"></span> Sensor Log
				</button>
			</div>
			<div class="menuBtn">
				<button type="button" class="btn btn-default btn-lg btn-block"
					onclick="goReplace('/event')">
					<span class="glyphicon glyphicon-alert"></span> Envent Log
				</button>
			</div>
			<div class="menuBtn">
				<button type="button" class="btn btn-default btn-lg btn-block"
					onclick="goReplace('/stream')">
					<span class="glyphicon glyphicon-play-circle"></span> Striming
				</button>
			</div>
			<div class="menuBtn">
				<button type="button" class="btn btn-default btn-lg btn-block"
					onclick="goReplace('/hr')">
					<span class="glyphicon glyphicon-user"></span> H.R
				</button>
			</div>
			<div class="menuBtn">
				<button type="button" class="btn btn-default btn-lg btn-block"
					onclick="goReplace('/ex')">
					<span class="glyphicon glyphicon-map-marker"></span> Map
				</button>
			</div>
			<input type="button" value="불내기" onclick="showAlert()" />
		</div>
		<div class="contents">
				<label for="basic-url">HR REGISTER</label>
				<div class="input-group">
  				<span class="input-group-addon" >ID</span>
  				<input type="text" class="form-control">
				</div>
				<div class="input-group">
  				<span class="input-group-addon" >PW</span>
  				<input type="text" class="form-control">
				</div>
				<div class="input-group">
  <span class="input-group-addon" id="basic-addon1">asdsadsadsa</span>
  <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
</div>
				
				
		<div class="footer">
			<div style="padding: 7px;">Copyright © 2018 HSB Inc.</div>
		</div>
	</div>
</body>
</html>