<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="/css/style2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script language="javascript" type="text/javascript" src="/js/js1.js"></script>
<script>
  function play(){
	  $.ajax({
	      type: "GET",
	      url: "http://192.168.0.13:5001/stream/1/",
	      dataType: "json",
	      success: function(data) {
	        	alert("play success");
	        }
	    });
	  var delayInMilliseconds = 5000;
	  
	  setTimeout(function() {
		  var element = document.getElementById("cam");
		  var newElement = '<iframe id="streaming" src="http://192.168.0.13:5000/video_stream"></iframe>';
		  element.insertAdjacentHTML( 'afterend', newElement );
		}, delayInMilliseconds);	  
  }
  function stop(){
	  $.ajax({
	      type: "GET",
	      url: "http://192.168.0.13:5001/stream/0/",
	      dataType: "json",
	      success: function(data) {
	        	alert("play success");
	        }
	    });
	  
	  setTimeout(function() {
		  location.reload();
	  }, 3000);
</script>
<style>
#streaming{
	height:700px; 
	width:1200px; 
	margin:10px;
	padding:0px;
	position:relative;
	border: 1px solid #999;
	z-index:1000;
}
.streamBtn{
	margin:10px;
	float:left;
}
#playbtn{
	width:27px;
	height:27px;
	background:url(/img/play.png);
}
#stopbtn{
	width:27px;
	height:27px;
	background:url(/img/stop.png);
}
#btn1{
	margin-left:20px;
}
</style>
<title>관리자 페이지</title>

</head>
<body>
	<div class="wrapper">
		<div class="alert" id="art" >
				화재 발생
				<div id="fireBtn" onclick="closeAlert()">위치확인</div>			
			</div>
			<div class="location" id="lct" onclick="closeLocation()">
				<div id="fire">
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
			<div id="cam">
				
			</div>
				<div class="streamBtn" id="btn1">
					<button id="playbtn" onclick="play()">
					</button>
				</div>
				<div class="streamBtn" id="btn2">
					<button id="stopbtn" onclick="stop()">
					</button>
				</div>
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