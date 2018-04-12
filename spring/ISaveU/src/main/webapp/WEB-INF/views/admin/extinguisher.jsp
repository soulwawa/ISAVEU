<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<% String root = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script language="javascript" type="text/javascript" src="/js/js1.js"></script>
<style>
#exts1{
	width:456px;
	height:624px;
	position:relative;
	z-index:1250;
}
.result{
	float:left;
}
#ext0{
	display:none;
	position:relative;
	left:200px;
	top:205px;
}
#ext1{
	display:none;
	position:relative;
	left:120px;
	top:80px;
}
#ext2{
	display:none;
	position:relative;
	left:120px;
	top:145px;
}
#ext3{
	display:none;
	position:relative;
	left:120px;
	top:250px;
}
#ext4{
	display:none;
	position:relative;
	left:120px;
	top:375px;
}
#ext5{
	display:none;
	position:relative;
	left:165px;
	top:513px;
}
#ext6{
	display:none;
	position:relative;
	left:290px;
	bottom:80px;
}
#ext7{
	display:none;
	position:relative;
	left:290px;
	top:50px;
}
#ext8{
	display:none;
	position:relative;
	left:320px;
	top:190px;
}
#ext9{
	display:none;
	position:relative;
	left:395px;
	top:345px;
}
#ext10{
	display:none;
	position:relative;
	left:395px;
	top:410px;
}
#tb1{
	top:0px;
	left:470px;
	position:absolute;
	width:1200px;
	height:730px;
}
#ttcase{
	top:730px;
	left:470px;
	position:absolute;
	width:1200px;
	height:80px;
	border-top:1px solid #ddd;
}
.tht{
	padding-left:8px !important;
	padding-top:17px !important;
}
td{
	padding-left:8px !important;
	padding-top:17px !important;
}
#exresetbtn{
	position:relative;
	left:530px;
	width:120px;
	height:60px;
	margin:7px auto;
	border:solid 1px #555;
	border-radius:7px;
	background-color:#eee !important;
	text-align:center;
	margin-top:15px;
}
p{
	margin:0 auto !important;
	padding:0 !important;
	text-align:center;
	font-size:17px;
}

</style>
<script>
$(window).on("load", function(){
	checkex1();
});

setTimeout(function(){
	checkex1();
},5000);

var interval5 = setInterval(function () {
	checkex1();
}, 5000);
function checkex1(){
	$.ajax({
	      type: "GET",
	      url: "http://192.168.0.35:9999/admin/locationFireEx.do?loc=6",
	      dataType: "json",
	      success: function(data2) {
	        obj = data2;
	        for (var i = 0; i < 11; i++){
	        	var counter = obj.value[i];
	        	if(counter.fire_ex_status == 0){
	        		document.getElementById("ext"+i).style.display="none";
	        		document.getElementById(i+"3").innerHTML="불가능";
	        	}
	        	if(counter.fire_ex_status == 1){
	        		document.getElementById("ext"+i).style.display="block";
	        		document.getElementById(i+"3").innerHTML="가능";
	        	}
	        	document.getElementById(i+"1").innerHTML=counter.location;
	        	document.getElementById(i+"2").innerHTML=counter.dept_name;
	        	document.getElementById(i+"4").innerHTML=counter.fire_ex_make;
	        	document.getElementById(i+"5").innerHTML=counter.check_date;
	        	document.getElementById(i+"6").innerHTML=counter.next_check;
	        }
	      }
	    });
	
}
function checkex2(){
	$.ajax({
	      type: "GET",
	      url: "http://192.168.0.35:9999/Android/feRestart.do?loc=600",
	      dataType: "json",
	      success: function(data3) {
	    	  alert("reset success");
	    	  console.log("소화기 테이블 재설정 완료");
	        }
	    });
}
function reset(){
	  $.ajax({
	      type: "GET",
	      url: "http://192.168.0.61:5002/feRestart/",
	      dataType: "json",
	      success: function(data) {
	    	  	checkex2();
	        	alert("reset success");
	        }
	    });	 
	  
}
$(window).on("unload", function(){
    alert("call");
    console.log("this will be triggered");
    clearInterval(interval5);
    clearInterval(alwayscheck);
}); 
</script>
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
				<img src="<%=root%>/img/logo1.png" alt="logo" class="logo"/>
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
			<div class="map">
			</div>
			<div id="exts1">
				<div class="shake-freeze" id="ext0">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext1">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext2">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext3">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext4">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext5">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext6">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext7">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext8">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext9">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext10">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
			</div>
			<div id="tcase">
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
							<th class="tht" scope="row">FE-01</th>
							<td id="01"></td>
							<td id="02"></td>
							<td id="03"></td>
							<td id="04"></td>
							<td id="05"></td>
							<td id="06"></td>
						</tr>
						<tr>
							<th class="tht" scope="row">FE-02</th>
							<td id="11"></td>
							<td id="12"></td>
							<td id="13"></td>
							<td id="14"></td>
							<td id="15"></td>
							<td id="16"></td>
						</tr>
						<tr>
							<th class="tht" scope="row">FE-03</th>
							<td id="21"></td>
							<td id="22"></td>
							<td id="23"></td>
							<td id="24"></td>
							<td id="25"></td>
							<td id="26"></td>
						</tr>
						<tr>
							<th class="tht" scope="row">FE-04</th>
							<td id="31"></td>
							<td id="32"></td>
							<td id="33"></td>
							<td id="34"></td>
							<td id="35"></td>
							<td id="36"></td>
						</tr>
						<tr>
							<th class="tht" scope="row">FE-05</th>
							<td id="41"></td>
							<td id="42"></td>
							<td id="43"></td>
							<td id="44"></td>
							<td id="45"></td>
							<td id="46"></td>
						</tr>
						<tr>
							<th class="tht" scope="row">FE-06</th>
							<td id="51"></td>
							<td id="52"></td>
							<td id="53"></td>
							<td id="54"></td>
							<td id="55"></td>
							<td id="56"></td>
						</tr>
						<tr>
							<th class="tht" scope="row">FE-07</th>
							<td id="61"></td>
							<td id="62"></td>
							<td id="63"></td>
							<td id="64"></td>
							<td id="65"></td>
							<td id="66"></td>
						</tr>
						<tr>
							<th class="tht" scope="row">FE-08</th>
							<td id="71"></td>
							<td id="72"></td>
							<td id="73"></td>
							<td id="74"></td>
							<td id="75"></td>
							<td id="76"></td>
						</tr>
						<tr>
							<th class="tht" scope="row">FE-09</th>
							<td id="81"></td>
							<td id="82"></td>
							<td id="83"></td>
							<td id="84"></td>
							<td id="85"></td>
							<td id="86"></td>
						</tr>
						<tr>
							<th class="tht" scope="row">FE-10</th>
							<td id="91"></td>
							<td id="92"></td>
							<td id="93"></td>
							<td id="94"></td>
							<td id="95"></td>
							<td id="96"></td>
						</tr>
						<tr>
							<th class="tht" scope="row">FE-11</th>
							<td id="101"></td>
							<td id="102"></td>
							<td id="103"></td>
							<td id="104"></td>
							<td id="105"></td>
							<td id="106"></td>
						</tr>
					</tbody>
				</table>
				<div id="ttcase">
					<button id="exresetbtn" onclick="reset()">
						<p>FE RESET</p>
					</button>
				</div>
			</div>
		</div>
		<div class="footer">
		</div>
	</div>
</body>
</html>