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
   var interval1 = setInterval(function () {
    $.ajax({
      type: "GET",
      url: "http://192.168.0.35:9999/admin/Dispatcher",                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
      dataType: "json",
      success: function(data) {
        ob = data;
        console.log("온도:"+ob.temp+",진동 "+ob.gyro+",CO "+ob.smoke+",불꽃 "+ob.fire+", "+ob.date);
      }
    });
  }, 9900);
  var interval2 = setInterval(function () {
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
	        }
	      
	      
	      
	      }
	    });
	  }, 9900);
  
  $(window).on("unload", function(){
	    alert("call");
	    console.log("this will be triggered");
	    clearInterval(interval1);
	    clearInterval(interval2);
	}); 
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
			
			<div id="fireBtn" onclick="closeAlert()">위치확인</div>			
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
			<div class="menuBtn" id="btnSensor">
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/sensor1')">
  					<span class="glyphicon glyphicon-tasks" ></span> Sensor Log1
				</button>
			</div>
			<div class="menuBtn" id="btnSensor">
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/sensor2')">
  					<span class="glyphicon glyphicon-tasks" ></span> Sensor Log2
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
			<div id="section1" style="height:400px;">
				<div id="con1">
					<div class="sensors" id="s0">
						<button class="btn btn-default btn-block" onclick="ss0()">sensor0</button>
					</div>
					<div class="sensors" id="s1">
						<button class="btn btn-default btn-block" onclick="ss1()">sensor1</button>
					</div>
					<div class="sensors" id="s2">
						<button class="btn btn-default btn-block" onclick="ss2()">sensor2</button>
					</div>
					<div class="sensors" id="s3">
						<button class="btn btn-default btn-block" onclick="ss3()">sensor3</button>
					</div>
					<div class="sensors" id="s4">
						<button class="btn btn-default btn-block" onclick="ss4()">sensor4</button>
					</div>
					<div class="sensors" id="s5">
						<button class="btn btn-default btn-block" onclick="ss5()">sensor5</button>
					</div>
					<div class="sensors" id="s6">
						<button class="btn btn-default btn-block" onclick="ss6()">sensor6</button>
					</div>
					<div class="sensors" id="s7">
						<button class="btn btn-default btn-block" onclick="ss7()">sensor7</button>
					</div>
					<div class="sensors" id="s8">
						<button class="btn btn-default btn-block" onclick="ss8()">sensor8</button>
					</div>
					<div class="sensors" id="s9">
						<button class="btn btn-default btn-block" onclick="ss9()">sensor9</button>
					</div>
					<div class="sensors" id="s10">
						<button class="btn btn-default btn-block" onclick="ss10()">sensor10</button>
					</div>
				</div>
			</div>
			<div id="section2" style="height:424px;">
				<div id="chartHolder10" class="chartHolder">
					<div id="cover10" class="cover" onclick="ss0()">
					</div>
				</div>
				<div id="chartHolder11" class="chartHolder">
					<div id="cover11" class="cover" onclick="ss1()">
					</div>
				</div>
				<div id="chartHolder12" class="chartHolder">
					<div id="cover12" class="cover" onclick="ss2()">
					</div>
				</div>
				<div id="chartHolder13" class="chartHolder">
					<div id="cover13" class="cover" onclick="ss3()">
					</div>
				</div>
				<div id="chartHolder14" class="chartHolder">
					<div id="cover14" class="cover" onclick="ss4()">
					</div>
				</div>
				<div id="chartHolder15" class="chartHolder">
					<div id="cover15" class="cover" onclick="ss5()">
					</div>
				</div>
				<div id="chartHolder16" class="chartHolder">
					<div id="cover16" class="cover" onclick="ss6()">
					</div>
				</div>
				<div id="chartHolder17" class="chartHolder">
					<div id="cover17" class="cover" onclick="ss7()">
					</div>
				</div>
				<div id="chartHolder18" class="chartHolder">
					<div id="cover18" class="cover" onclick="ss8()">
					</div>
				</div>
				<div id="chartHolder19" class="chartHolder">
					<div id="cover19" class="cover" onclick="ss9()">
					</div>
				</div>
				<div id="chartHolder20" class="chartHolder">
					<div id="cover20" class="cover" onclick="ss10()">
					</div>
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