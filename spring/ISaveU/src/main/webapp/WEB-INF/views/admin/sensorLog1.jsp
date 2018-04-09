<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="/css/style2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="/css/rMateChartH5.css" />
<script language="javascript" type="text/javascript"
	src="/js/rMateChartH5License.js"></script>
<script type="text/javascript" src="/js/theme.js"></script>
<script type="text/javascript" src="/js/rMateChartH5.js"></script>
<script language="javascript" type="text/javascript" src="/js/js1.js"></script>
<script language="javascript" type="text/javascript" src="/js/sensorlog1.js"></script>

<script>
var interval = setInterval(function () {
    $.ajax({
      type: "GET",
      url: "http://192.168.0.35:9999/admin/DispatcherPart/temp",
      dataType: "json",
      success: function(data) {
        obtemp = data;
        document.getElementById("chart6").setData(obtemp);
        console.log(obtemp);
      }
    });
  }, 9900);
var interval = setInterval(function () {
    $.ajax({
      type: "GET",
      url: "http://192.168.0.35:9999/admin/DispatcherPart/smoke",
      dataType: "json",
      success: function(data) {
        obsmoke = data;
        document.getElementById("chart7").setData(obsmoke);
        console.log(obsmoke);
      }
    });
  }, 9900);
var interval = setInterval(function () {
    $.ajax({
      type: "GET",
      url: "http://192.168.0.35:9999/admin/DispatcherPart/gyro",
      dataType: "json",
      success: function(data) {
        obgyro = data;
        document.getElementById("chart8").setData(obgyro);
        console.log(obgyro);
      }
    });
  }, 9900);
var interval = setInterval(function () {
    $.ajax({
      type: "GET",
      url: "http://192.168.0.35:9999/admin/DispatcherPart/fire",
      dataType: "json",
      success: function(data) {
        obfire = data;
        document.getElementById("chart9").setData(obfire);
        console.log(obfire);
      }
    });
  }, 9900);
</script>
<style>
.contents{
	position:relative;
}
.ui-tabs-nav{
	margin:0 0 10px 0;
	padding:0;
	display:table;
}
.ui-tabs-nav *{
	box-sizing:border-box;
}
.ui-tabs-tab{
	float:left;
	color:#666;
	position:relative;
	list-style:none;
	margin-right:4px;
	border:solid 1px #eee;
	border-bottom:none;
}
.ui-tabs-tab:hover{
	color:#222;
	font-weight:bold;
}
.li_select{
	color:#000;
	border-color:#40b2e6;
}
.ui-tabs-anchor{
	float:left;
	color:inherit;
	padding:10px 30px;
	text-decoration:none;
	outline:none;
}
.area{
	background:red;
}
.chartHolder{
}
#chartHolder6{
	position:relative;
	top:25px;
	left:20px;
	width:820px !important;
	height:380px !important;
}
#chartHolder7{
	position:relative;
	left:850px;
	bottom:355px;
	width:820px !important;
	height:380px !important;
}
#chartHolder8{
	position:relative;
	left:20px;
	bottom:345px;
	width:820px !important;
	height:380px !important;
}
#chartHolder9{
	position:relative;
	left:850px;
	bottom:725px;
	width:820px !important;
	height:380px !important;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>관리자 페이지</title>

</head>
<body>
	<div class="wrapper">
		<div class="alert" id="art" >
		</div>
		<div class="location" id="lct" onclick="closeLocation()">
			<div id="fire">
			<div id="firecase">
			<img src="/img/fireloc.gif" id="fireloc"alt="fire"/>
			</div>
			<div id="exts1">
				<div class="shake-freeze" id="ex0">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex1">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex2">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex3">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex4">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex5">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex6">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex7">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex8">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex9">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex10">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
			</div>
			</div>
		</div>
		<div class="header">
			<div class="case" onclick="goReplace('/admin')">
				<img src="/img/logo1.png" alt="logo" class="logo" />
			</div>
		</div>
		<div class="sidebar">
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/sensor')">
  					<span class="glyphicon glyphicon-tasks" ></span> Sensor Log
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/event')">
  					<span class="glyphicon glyphicon-alert" ></span> Envent Log
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/stream')">
  					<span class="glyphicon glyphicon-play-circle" ></span> Striming
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/hr')">
  					<span class="glyphicon glyphicon-user" ></span> H.R
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/ex')">
  					<span class="glyphicon glyphicon-map-marker"></span> Map
				</button>
			</div>
			<input type="button" value="불내기" onclick="showAlert()"/>
		</div>
		<div class="contents">
			<div id="chartHolder6" class="chartHolder"></div>
			<div id="chartHolder7" class="chartHolder"></div>
			<div id="chartHolder8" class="chartHolder"></div>
			<div id="chartHolder9" class="chartHolder"></div>
		
			
		</div>
		<div class="footer">
			<div style="padding: 7px;">Copyright © 2018 HSB Inc.</div>
			<div>
				<div id="result1"></div>
				<div id="result2"></div>
				<div id="result3"></div>
				<div id="result4"></div>
			</div>
		</div>
	</div>
</body>
</html>