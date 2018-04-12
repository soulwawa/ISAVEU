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
  }
  function reset(){
	  $.ajax({
	      type: "GET",
	      url: "http://192.168.0.35:9999/module/eventIn.do?&module_id=0&temp=0&smoke=1200&gyro=1040&fire=1040&issue=0&reset=1",
	      dataType: "json",
	      success: function(data) {
	        	alert("reset success");
	        }
	    });	  
  }
  function changec(str){
	  document.getElementById("sname").innerHTML=str;
  }
  $(window).on("unload", function(){
	    alert("call");
	    console.log("this will be triggered");
	    clearInterval(alwayscheck);
	}); 
</script>
<style>
#streaming{
	height:482px; 
	width:642px; 
	padding:0px;
	position:relative;
	top:100px;
	left:452px;
	border: 1px solid #999;
	z-index:1000;
}
.streamBtn{
	float:left;
}
.playbtn{
	width:27px;
	height:27px;
	background:url(/img/play.png);
}
.stopbtn{
	width:27px;
	height:27px;
	background:url(/img/stop.png);
}
#btn1{
}
.stopbtn{
	margin-left:0 !important;
	text-align:center !important;
}
.playbtn{
	margin-left:0 !important;
	text-align:center !important;
}
.btncase{
	position:relative;
	top:10px;
	height:27px;
	width:54px;
	margin:0 auto;
}
.streamcontroler{
	width:120px;
	height:60px;
	margin:7px auto;
	border:solid 1px #bbb;
	border-radius:7px;
	background-color:#eee !important;
	text-align:center;
}
label{
	position:relative;
	left:26px;
}
#section1{
	float:left;
	height:100%;
	width:144px;
}
#section2{
	float:left;
	height:100%;
	width:1546px;
}
#section21{
	width:100%;
	height:700px;
}
#section22{
	width:100%;
	height:124px;
}
p{
	padding:0 !important;
	margin:0 auto; !important;
	text-align:center;
}
#resetbtn{
	position:relative;
	left:705px;
	margin-top:30px;
}
#sname{
	margin-top:20px;
	margin-bottom:20px;
	position:relative;
	left:743px;
}
</style>
<title>관리자 페이지</title>

</head>
<body>
	<div class="wrapper">
		<div class="alert" id="art"></div>
		<div class="location" id="lct" onclick="closeLocation()">
			<div id="fire">
				<div id="firecase">
					<img src="/img/fireloc.gif" id="fireloc" alt="fire" />
				</div>
				<div id="exts1">
					<div class="shake-freeze" id="ex0">
						<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"
							name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex1">
						<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"
							name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex2">
						<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"
							name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex3">
						<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"
							name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex4">
						<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"
							name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex5">
						<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"
							name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex6">
						<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"
							name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex7">
						<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"
							name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex8">
						<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"
							name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex9">
						<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"
							name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex10">
						<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"
							name="etgs1" />
					</div>
				</div>
			</div>
		</div>
		<div class="header">
			<div class="case" onclick="goReplace('/admin/admin')">
				<img src="/img/logo1.png" alt="logo" class="logo" />
			</div>
		</div>
		<div class="sidebar">
			<div class="menuBtn" id="btnSensor">
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/admin/sensor1')">
  					<span class="glyphicon glyphicon-tasks" ></span> Sensor Log
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/admin/event')">
  					<span class="glyphicon glyphicon-alert" ></span> Event Log
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/admin/stream')">
  					<span class="glyphicon glyphicon-play-circle" ></span> Status Check
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/admin/ex')">
  					<span class="glyphicon glyphicon-map-marker"></span> FE Maintenance
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/admin/index')">
  					<span class="glyphicon glyphicon-user" ></span> Emp Info
				</button>
			</div>
		</div>
		<div class="contents">
			<div id="section1">
				<button class="streamcontroler" value="Sensor 0" onclick="changec('Sensor 0')">
					<p>Sensor 0</p>
				</button>
				<button class="streamcontroler" value="Sensor 1" onclick="changec('Sensor 1')">
					<p>Sensor 1</p>
				</button>
				<button class="streamcontroler" value="Sensor 2" onclick="changec('Sensor 2')">
					<p>Sensor 2</p>
				</button>
				<button class="streamcontroler" value="Sensor 3" onclick="changec('Sensor 3')">
					<p>Sensor 3</p>
				</button>
				<button class="streamcontroler" value="Sensor 4" onclick="changec('Sensor 4')">
					<p>Sensor 4</p>
				</button>
				<button class="streamcontroler" value="Sensor 5" onclick="changec('Sensor 5')">
					<p>Sensor 5</p>
				</button>
				<button class="streamcontroler" value="Sensor 6" onclick="changec('Sensor 6')">
					<p>Sensor 6</p>
				</button>
				<button class="streamcontroler" value="Sensor 7" onclick="changec('Sensor 7')">
					<p>Sensor 7</p>
				</button>
				<button class="streamcontroler" value="Sensor 8" onclick="changec('Sensor 8')">
					<p>Sensor 8</p>
				</button>
				<button class="streamcontroler" value="Sensor 9" onclick="changec('Sensor 9')">
					<p>Sensor 9</p>
				</button>
				<button class="streamcontroler" value="Sensor 10" onclick="changec('Sensor 10')">
					<p>Sensor 10</p>
				</button>
			</div>
			<div id="section2">
				<div id="section21">
					<label id="sname">Sensor 0</label>
					<div id="cam">
					</div>
				</div>
				<div id="section22">
					<div class="btncase" id="case0">
						<div class="streamBtn">
							<button class="playbtn" onclick="play()"></button>
						</div>
						<div class="streamBtn">
							<button class="stopbtn" onclick="stop()"></button>
						</div>
					</div>
					<button class="streamcontroler" id="resetbtn" onclick="reset()">
					<p>장비 재설정</p>
					</button>
				</div>
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