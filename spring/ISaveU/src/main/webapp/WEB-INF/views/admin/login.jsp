<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<% String root = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="/css/style2.css" rel="stylesheet" type="text/css" />
<link href="/css/admincss.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="/js/rMateChartH5.css" />
<script language="javascript" type="text/javascript"
	src="/js/rMateChartH5License.js"></script>
<script language="javascript" type="text/javascript"
	src="/js/rMateIntegrationH5.js"></script>
<script type="text/javascript" src="/js/theme.js"></script>
<script language="javascript" type="text/javascript" src="/js/js1.js"></script>
<script language="javascript" type="text/javascript" src="/js/admin.js"></script>
<script>
$(window).on("load", function(){
	live1();
});
var interval1 = setInterval(function () {
    live1();
  }, 9900);
function live1() {
	 $.ajax({
	      type: "GET",
	      url: "http://192.168.0.35:9999/admin/DispatcherModuleRecent",
	      dataType: "json",
	      success: function(data2) {
	        obj = data2;
	        for (var i = 0; i < obj.length; i++) {
	    		var counter = obj[i];
	    		var cv = obj[i].value;
	    		var j = i + 10;
	    		document.getElementById("chart"+j).setData(cv);
	    		
	    		var dis = counter.value[11].issue;
	    		console.log(i+"번센서 상황번호"+dis);
	    		var k = i + 10;
	    		doalt(i,k,dis);
	        }
	      }
	    });
}
  $(window).on("unload", function(){
	    alert("call");
	    console.log("this will be triggered");
	    clearInterval(interval1);
	    clearInterval(interval2);
	    clearInterval(alwayscheck);
	}); 
  
function doalt(i,k,dis){
	var interval3;
	var interval4;
	var interval5;
	if(dis == 0){
		console.log(i+"번 센서 이상없음");
	}else if(dis == 2){
		console.log(i+"번 센서 지진감지");
		interval3 = setInterval(function () {
			setTimeout(function(){
				document.getElementById("cover"+k).style.background = "rgba(255,255,0,0.75)";
			},300);
			setTimeout(function(){
				document.getElementById("cover"+k).style.background= "rgba(255,255,0,0)";
			},600);
		  }, 620);
		
	}else if(dis == 1){
		console.log(i+"번 센서 화재감지");
		interval5 = setInterval(function () {
			setTimeout(function(){
				document.getElementById("cover"+k).style.background = "rgba(255,0,0,0.75)";
			},300);
			setTimeout(function(){
				document.getElementById("cover"+k).style.background= "rgba(255,0,0,0)";
			},600);
		  }, 620);
	}else{
		console.log(i+"번 센서 화재 지진 동시 발생");
		interval4 = setInterval(function () {
			setTimeout(function(){
				document.getElementById("cover"+k).style.background = "rgba(255,0,255,0.75)";
			},300);
			setTimeout(function(){
				document.getElementById("cover"+k).style.background= "rgba(255,0,255,0)";
			},600);
		  }, 620);
	}
	setTimeout(function(){
		clearInterval(interval3);
		clearInterval(interval4);
		clearInterval(interval5);
	},6200);
}
//	var interval3 = setInterval(function () {
//	  setTimeout(function(){
//			document.getElementById("cover14").style.background="rgba(255,255,255,0)";
//		},495);
//		setTimeout(function(){
//			document.getElementById("cover14").style.background="rgba(255,0,0,0.75)";
//		},990);
//  },1000);
</script>
<style>
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
  					<span class="glyphicon glyphicon-play-circle" ></span> Streaming
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/admin/index')">
  					<span class="glyphicon glyphicon-user" ></span> H.R
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/admin/ex')">
  					<span class="glyphicon glyphicon-map-marker"></span> Map
				</button>
			</div>
		</div>
		<div class="contents">
	<section id="loginFormArea">
		<form action="/user/loginPost" method="post">
			<div class="imgBox">
				<img src="/img/main.png" alt="logo" class="mainImg"/>
			</div>
			<div id="loginBox">
				<div class="box">
					<div>
						<input type="text" name="id" class="txtbox" placeholder="USER ID"/>
					</div>
					<div>
						<input type="password" name="pw" class="txtbox" placeholder="USER PASSWORD"/>
					</div>
				</div>
				<div class="loginBtn">
					<input type="submit" name="loginBtn" value="Login"/>
				</div>
			</div>
		</form>
		<div> HSB </div>
	</section>
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