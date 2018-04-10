<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사건 목록 열람</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="/css/style2.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script language="javascript" type="text/javascript" src="/js/js1.js"></script>
<script>
var ev = setInterval(function () {
    $.ajax({
      type: "GET",
      url: "http://192.168.0.35:9999/admin/event.do",
      dataType: "json",
      success: function(data) {
        ob = data;
      }
    });
  }, 9900);
$(window).on("unload", function(){
    alert("call");
    console.log("this will be triggered");
    clearInterval(interval1);
    clearInterval(interval2);
    clearInterval(alwayscheck);
    clearInterval(ev);
}); 
</script>
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
				<img src="/img/logo1.png" alt="logo" class="logo"/>
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
			<table class="table" id="tb1">
				<thead>
					<tr>
						<th scope="col">소화기</th>
						<th scope="col">장소</th>
						<th scope="col">부서</th>
						<th scope="col">사용가능 여부</th>
						<th scope="col">소화기 제조일</th>
						<th scope="col">소화기 점검일</th>
						<th scope="col">점검 예정일</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">FE-01</th>
						<td id="01"></td>
						<td id="02"></td>
						<td id="03"></td>
						<td id="04"></td>
						<td id="05"></td>
						<td id="06"></td>
					</tr>
					<tr>
						<th scope="row">FE-02</th>
						<td id="11"></td>
						<td id="12"></td>
						<td id="13"></td>
						<td id="14"></td>
						<td id="15"></td>
						<td id="16"></td>
					</tr>
					<tr>
						<th scope="row">FE-03</th>
						<td id="21"></td>
						<td id="22"></td>
						<td id="23"></td>
						<td id="24"></td>
						<td id="25"></td>
						<td id="26"></td>
					</tr>
					<tr>
						<th scope="row">FE-04</th>
						<td id="31"></td>
						<td id="32"></td>
						<td id="33"></td>
						<td id="34"></td>
						<td id="35"></td>
						<td id="36"></td>
					</tr>
					<tr>
						<th scope="row">FE-05</th>
						<td id="41"></td>
						<td id="42"></td>
						<td id="43"></td>
						<td id="44"></td>
						<td id="45"></td>
						<td id="46"></td>
					</tr>
					<tr>
						<th scope="row">FE-06</th>
						<td id="51"></td>
						<td id="52"></td>
						<td id="53"></td>
						<td id="54"></td>
						<td id="55"></td>
						<td id="56"></td>
					</tr>
					<tr>
						<th scope="row">FE-07</th>
						<td id="61"></td>
						<td id="62"></td>
						<td id="63"></td>
						<td id="64"></td>
						<td id="65"></td>
						<td id="66"></td>
					</tr>
					<tr>
						<th scope="row">FE-08</th>
						<td id="71"></td>
						<td id="72"></td>
						<td id="73"></td>
						<td id="74"></td>
						<td id="75"></td>
						<td id="76"></td>
					</tr>
					<tr>
						<th scope="row">FE-09</th>
						<td id="81"></td>
						<td id="82"></td>
						<td id="83"></td>
						<td id="84"></td>
						<td id="85"></td>
						<td id="86"></td>
					</tr>
					<tr>
						<th scope="row">FE-10</th>
						<td id="91"></td>
						<td id="92"></td>
						<td id="93"></td>
						<td id="94"></td>
						<td id="95"></td>
						<td id="96"></td>
					</tr>
					<tr>
						<th scope="row">FE-11</th>
						<td id="101"></td>
						<td id="102"></td>
						<td id="103"></td>
						<td id="104"></td>
						<td id="105"></td>
						<td id="106"></td>
					</tr>
					
				</tbody>
			</table>
		</div>
		<div class="footer">
		</div>
	</div>
</body>
</html>