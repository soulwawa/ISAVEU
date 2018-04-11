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
var pagenum = 0;
var obj;
var action;
var etime;	
var module;
var dept;
var iss;
var img;
setTimeout(function(){
	winload();
},1000);

function winload(){
    $.ajax({
      type: "GET",
      url: "http://192.168.0.35:9999/admin/event.do",
      dataType: "json",
      success: function(data) {
        obj = data;
        for(var i = 0; i < 20; i++){
        	
         	var counter = obj.list[i];
         	
         	if(counter.action_id != null){
 				action = counter.action_id;
         	}else{
         		action = "null";
         	}
         	
         	if(counter.time != null){
 				etime = counter.time;
         	}else{
         		etime = "null";
         	}
         	
         	if(counter.module_id != null){
 				module = counter.module_id;
         	}else{
         		module = "null";
         	}
         	
         	if(counter.dept_name != null){
 				dept = counter.dept_name;
         	}else{
         		dept = "null";
         	}
         	
         	if(counter.issue != null){
 				iss = counter.issue;
         	}else{
         		iss = "null";
         	}
         	
         	if(counter.url != null){
 				img = counter.url;
         	}else{
         		img = "null";
         	}
         	
         	document.getElementById("t"+i+"0").innerHTML=action;
         	document.getElementById("t"+i+"1").innerHTML=etime;
         	document.getElementById("t"+i+"2").innerHTML=module;
         	document.getElementById("t"+i+"3").innerHTML=dept;
         	
         	if(iss == 1){
        		document.getElementById("t"+i+"4").innerHTML="화재";
        	}else if(iss == 2){
        		document.getElementById("t"+i+"4").innerHTML="지진";
        	}else if(iss == 3){
        		document.getElementById("t"+i+"4").innerHTML="화재, 지진";
        	}else{
        		document.getElementById("t"+i+"4").innerHTML=iss;
        	}

        	document.getElementById("t"+i+"5").innerHTML = img;
      	}
      }
    });
}
    
function nextpage() {
	 for(var i = 0; i < 20; i++){
     	var k = (pagenum*19) + i;
     	var counter = obj.list[k];
     	
     	document.getElementById("t"+k+"0").innerHTML = ob[k].action_id;
     	document.getElementById("t"+k+"1").innerHTML = ob[k].time;
     	document.getElementById("t"+k+"2").innerHTML = ob[k].module_id;
     	document.getElementById("t"+k+"3").innerHTML = ob[k].dept_name;
     	
     	
     	console.log("t"+k+"0");
     	console.log("t"+k+"1");
     	console.log("t"+k+"2");
     	console.log("t"+k+"3");
     	console.log("t"+k+"4");
     }
}

function lastpage() {
	
}
    
$(window).on("unload", function(){
    clearInterval(alwayscheck);
}); 
</script>
<style>
#tb1{
	text-align:center;
	margin:0 !important;
}
th{
	text-align:center;
	
}
#controler{
	width:300px;
	height:40px;
	background:black;
	z-index:1200;
}
</style>
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
				<img src="/img/logo1.png" alt="logo" class="logo"/>
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
  					<span class="glyphicon glyphicon-alert" ></span> Envent Log
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/admin/stream')">
  					<span class="glyphicon glyphicon-play-circle" ></span> Striming
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
			<table class="table" id="tb1">
				<thead>
					<tr>
						<th scope="col">.no</th>
						<th scope="col">발생일시</th>
						<th scope="col">module_id</th>
						<th scope="col">부서명</th>
						<th scope="col">발생 상황</th>
						<th scope="col">img</th>
						
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row" id="t00"></th>
						<td id="t01"></td>
						<td id="t02"></td>
						<td id="t03"></td>
						<td id="t04"></td>
						<td id="t05"></td>
					</tr>
					<tr>
						<th scope="row" id="t10"></th>
						<td id="t11"></td>
						<td id="t12"></td>
						<td id="t13"></td>
						<td id="t14"></td>
						<td id="t15"></td>
					</tr>
					<tr>
						<th scope="row" id="t20"></th>
						<td id="t21"></td>
						<td id="t22"></td>
						<td id="t23"></td>
						<td id="t24"></td>
						<td id="t25"></td>
					</tr>
					<tr>
						<th scope="row" id="t30"></th>
						<td id="t31"></td>
						<td id="t32"></td>
						<td id="t33"></td>
						<td id="t34"></td>
						<td id="t35"></td>
					</tr>
					<tr>
						<th scope="row" id="t40"></th>
						<td id="t41"></td>
						<td id="t42"></td>
						<td id="t43"></td>
						<td id="t44"></td>
						<td id="t45"></td>
					</tr>
					<tr>
						<th scope="row" id="50"></th>
						<td id="t51"></td>
						<td id="t52"></td>
						<td id="t53"></td>
						<td id="t54"></td>
						<td id="t55"></td>
					</tr>
					<tr>
						<th scope="row" id="60"></th>
						<td id="t61"></td>
						<td id="t62"></td>
						<td id="t63"></td>
						<td id="t64"></td>
						<td id="t65"></td>
					</tr>
					<tr>
						<th scope="row" id="70"></th>
						<td id="t71"></td>
						<td id="t72"></td>
						<td id="t73"></td>
						<td id="t74"></td>
						<td id="t75"></td>
					</tr>
					<tr>
						<th scope="row" id="80"></th>
						<td id="t81"></td>
						<td id="t82"></td>
						<td id="t83"></td>
						<td id="t84"></td>
						<td id="t85"></td>
					</tr>
					<tr>
						<th scope="row" id="90"></th>
						<td id="t91"></td>
						<td id="t92"></td>
						<td id="t93"></td>
						<td id="t94"></td>
						<td id="t95"></td>
					</tr>
					<tr>
						<th scope="row" id="100"></th>
						<td id="t101"></td>
						<td id="t102"></td>
						<td id="t103"></td>
						<td id="t104"></td>
						<td id="t105"></td>
					</tr>
					<tr>
						<th scope="row" id="110"></th>
						<td id="t111"></td>
						<td id="t112"></td>
						<td id="t113"></td>
						<td id="t114"></td>
						<td id="t115"></td>
					</tr>
					<tr>
						<th scope="row" id="120"></th>
						<td id="t121"></td>
						<td id="t122"></td>
						<td id="t123"></td>
						<td id="t124"></td>
						<td id="t125"></td>
					</tr>
					<tr>
						<th scope="row" id="130"></th>
						<td id="t131"></td>
						<td id="t132"></td>
						<td id="t133"></td>
						<td id="t134"></td>
						<td id="t135"></td>
					</tr>
					<tr>
						<th scope="row" id="140"></th>
						<td id="t141"></td>
						<td id="t142"></td>
						<td id="t143"></td>
						<td id="t144"></td>
						<td id="t145"></td>
					</tr>
					<tr>
						<th scope="row" id="150"></th>
						<td id="t151"></td>
						<td id="t152"></td>
						<td id="t153"></td>
						<td id="t154"></td>
						<td id="t155"></td>
					</tr>
					<tr>
						<th scope="row" id="160"></th>
						<td id="t161"></td>
						<td id="t162"></td>
						<td id="t163"></td>
						<td id="t164"></td>
						<td id="t165"></td>
					</tr>
					<tr>
						<th scope="row" id="170"></th>
						<td id="t171"></td>
						<td id="t172"></td>
						<td id="t173"></td>
						<td id="t174"></td>
						<td id="t175"></td>
					</tr>
					<tr>
						<th scope="row" id="180"></th>
						<td id="t181"></td>
						<td id="t182"></td>
						<td id="t183"></td>
						<td id="t184"></td>
						<td id="t185"></td>
					</tr>
					<tr>
						<th scope="row" id="190"></th>
						<td id="t191"></td>
						<td id="t192"></td>
						<td id="t193"></td>
						<td id="t194"></td>
						<td id="t195"></td>
					</tr>
				</tbody>
			</table>
			<div id="controler"></div>
		</div>
		<div class="footer">
		</div>
	</div>
</body>
</html>