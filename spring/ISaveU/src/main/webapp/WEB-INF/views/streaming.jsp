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
  }
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
	background:url(./img/play.png);
}
#stopbtn{
	width:27px;
	height:27px;
	background:url(./img/stop.png);
}
#btn1{
	margin-left:20px;
}
</style>
<title>관리자 페이지</title>

</head>
<body>
	<div class="wrapper">
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