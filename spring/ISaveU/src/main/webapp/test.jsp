<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-W3CDTD HTML 4.01 TransitionalEN" "http:\/\/www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
 var obj = { "list": [ 
						{
							"action_id":814,
							"module_id":0,
							"time":"2018-04-10 19:46:58.0",
							"url":"http:\/\/192.168.0.35:9999/eventImage/20180410_194647.png",
							"issue":"1",
							"dept_name":"복도"
						},
						
						{ 
							"action_id":813,
							"module_id":0,
							"time":"2018-04-10 19:46:53.0",
							"url":"http:\/\/192.168.0.35:9999/eventImage/20180410_194642.png",
							"issue":"1",
							"dept_name":"복도"
						},
						
						{
							"action_id":812,
							"module_id":0,
							"time":"2018-04-10 19:46:48.0",
							"url":"http:\/\/192.168.0.35:9999/eventImage/20180410_194638.png",
							"issue":"1",
							"dept_name":"복도"
						},
						
						{	
							"action_id":811,
							"module_id":0,
							"time":"2018-04-10 19:46:45.0",
							"url":"http:\/\/192.168.0.35:9999/eventImage/20180410_194634.png",
							"issue":"1",
							"dept_name":"복도"
						}
					]
 				};
 document.write(obj.list.length + "</br>");
 for(var i = 0; i < 4; i++){
	 var counter = obj.list[i];
	document.write("  action_id :	" + counter.action_id);
	document.write("  module_id :	" + counter.module_id);
	document.write("  time :	" + counter.time);
	document.write("  url :	" + counter.url);
	document.write("  issue :	" + counter.issue);
	document.write("  dept_name :	" + counter.dept_name);
	document.write("</br>");
	
	document.getElementById("t"+k+"0").innerHTML = ob[i].action_id;
	document.getElementById("t"+k+"1").innerHTML = ob[i].time;
	document.getElementById("t"+k+"2").innerHTML = ob[i].module_id;
	document.getElementById("t"+k+"3").innerHTML = ob[i].dept_name;
	if(ob[i].issue == 1){
		document.getElementById("t"+k+"4").innerHTML = "화재";
	}else if(ob[i].issue == 2){
		document.getElementById("t"+k+"4").innerHTML = "지진";
	}else if(ob[i].issue == 3){
		document.getElementById("t"+k+"4").innerHTML = "화재, 지진";
	}
	document.getElementById("t"+k+"5").innerHTML = ob[i].url;
 }
	</script>
 </head>
<body>


</body>
</html>