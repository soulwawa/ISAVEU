<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
var obj = {
	    "floor": 6 
	    ,
	    "list": [
	        {
	            "location_id": 1,
	            "location": "600",
	            "dept_name": "복도",
	            "manager": null,
	            "dept_tel": "",
	            "fire_ex_id": 1,
	            "fire_ex_name": "FE-01",
	            "fire_ex_mac": "18:93:D7:46:14:D6",
	            "fire_ex_status": "0",
	            "fire_ex_make": "2014-06-01",
	            "next_check": null,
	            "check_date": "2018-03-07 00:00:00.0"
	        },
	        {
	            "location_id": 2,
	            "location": "601",
	            "dept_name": "교수대기실",
	            "manager": null,
	            "dept_tel": "070-0000-0001",
	            "fire_ex_id": 2,
	            "fire_ex_name": "FE-02",
	            "fire_ex_mac": "B8:27:EB:18:9B:B3",
	            "fire_ex_status": "1",
	            "fire_ex_make": "2014-06-01",
	            "next_check": null,
	            "check_date": "2018-03-10 00:00:00.0"
	        },
	        {
	            "location_id": 3,
	            "location": "602",
	            "dept_name": "회계팀",
	            "manager": null,
	            "dept_tel": "070-0000-0002",
	            "fire_ex_id": 3,
	            "fire_ex_name": "FE-03",
	            "fire_ex_mac": "45:32:04:DB:18:3B",
	            "fire_ex_status": "1",
	            "fire_ex_make": "2014-06-01",
	            "next_check": null,
	            "check_date": "2018-03-15 00:00:00.0"
	        },
	        {
	            "location_id": 4,
	            "location": "603",
	            "dept_name": "인사팀",
	            "manager": null,
	            "dept_tel": "070-0000-0003",
	            "fire_ex_id": 4,
	            "fire_ex_name": "FE-04",
	            "fire_ex_mac": "7C:DF:13:27:77:F8",
	            "fire_ex_status": "1",
	            "fire_ex_make": "2014-06-01",
	            "next_check": null,
	            "check_date": "2018-03-07 00:00:00.0"
	        },
	        {
	            "location_id": 5,
	            "location": "604",
	            "dept_name": "기획팀",
	            "manager": null,
	            "dept_tel": "070-0000-0004",
	            "fire_ex_id": 5,
	            "fire_ex_name": "FE-05",
	            "fire_ex_mac": "8C:85:90:8B:A8:98",
	            "fire_ex_status": "1",
	            "fire_ex_make": "2014-06-01",
	            "next_check": null,
	            "check_date": "2018-03-07 00:00:00.0"
	        },
	        {
	            "location_id": 6,
	            "location": "605",
	            "dept_name": "605호",
	            "manager": null,
	            "dept_tel": "070-0000-0005",
	            "fire_ex_id": 6,
	            "fire_ex_name": "FE-06",
	            "fire_ex_mac": "6C:4A:59:95:1A:56",
	            "fire_ex_status": "1",
	            "fire_ex_make": "2014-06-01",
	            "next_check": null,
	            "check_date": "2018-03-10 00:00:00.0"
	        },
	        {
	            "location_id": 7,
	            "location": "606",
	            "dept_name": "606호",
	            "manager": null,
	            "dept_tel": "070-0000-0006",
	            "fire_ex_id": 7,
	            "fire_ex_name": "FE-07",
	            "fire_ex_mac": "47:DF:5C:42:1D:10",
	            "fire_ex_status": "1",
	            "fire_ex_make": "2014-06-01",
	            "next_check": null,
	            "check_date": "2018-03-07 00:00:00.0"
	        },
	        {
	            "location_id": 8,
	            "location": "607",
	            "dept_name": "지식경영팀",
	            "manager": null,
	            "dept_tel": "070-0000-0007",
	            "fire_ex_id": 8,
	            "fire_ex_name": "FE-08",
	            "fire_ex_mac": "42:CA:74:A5:27:93",
	            "fire_ex_status": "1",
	            "fire_ex_make": "2014-06-01",
	            "next_check": null,
	            "check_date": "2018-03-07 00:00:00.0"
	        },
	        {
	            "location_id": 9,
	            "location": "608",
	            "dept_name": "608호",
	            "manager": null,
	            "dept_tel": "070-0000-0008",
	            "fire_ex_id": 9,
	            "fire_ex_name": "FE-09",
	            "fire_ex_mac": "51:3D:2E:7D:17:68",
	            "fire_ex_status": "1",
	            "fire_ex_make": "2014-06-01",
	            "next_check": null,
	            "check_date": "2018-03-13 00:00:00.0"
	        },
	        {
	            "location_id": 10,
	            "location": "609",
	            "dept_name": "609호",
	            "manager": null,
	            "dept_tel": "070-0000-0009",
	            "fire_ex_id": 10,
	            "fire_ex_name": "FE-10",
	            "fire_ex_mac": "6B:77:29:7E:D4:15",
	            "fire_ex_status": "1",
	            "fire_ex_make": "2014-06-01",
	            "next_check": null,
	            "check_date": "2018-03-07 00:00:00.0"
	        },
	        {
	            "location_id": 11,
	            "location": "610",
	            "dept_name": "교육생휴게실",
	            "manager": null,
	            "dept_tel": "070-0000-0010",
	            "fire_ex_id": 11,
	            "fire_ex_name": "FE-11",
	            "fire_ex_mac": "61:W2:4F:5G:6H:1S",
	            "fire_ex_status": "1",
	            "fire_ex_make": "2014-06-01",
	            "next_check": null,
	            "check_date": "2018-03-07 00:00:00.0"
	        }
	    ]
	};
	

document.write(obj.list.length);

for (var i = 0; i < obj.list.length; i++) {
    var counter = obj.list[i];
    console.log(counter.dept_name);
    document.write("<br></n> location_id : " + counter.location_id + "<br></n> location : " + counter.location + "<br></n> dept_name : " + counter.dept_name + "<br></n> manager : " + counter.manager + "<br></n> dept_tel : " + counter.dept_tel + "<br></n> fire_ex_id : " + counter.fire_ex_id + "<br></n> fire_ex_name : " + counter.fire_ex_name + "<br></n> fire_ex_mac : " + counter.fire_ex_mac + "<br></n> fire_ex_status : " + counter.fire_ex_status + "<br></n> fire_ex_make : " + counter.fire_ex_make + "<br></n> next_check : " + counter.next_check + "<br></n> check_date : " + counter.check_date);
    
}
</script>
<title>Insert title here</title>
</head>
<body>
	<div id="result">
	</div>
	<div id="result0">
	</div>
	<div id="result1">
	</div>
	<div id="result2">
	</div>
	<div id="result3">
	</div>
	<div id="result4">
	</div>
	<div id="result5">
	</div>
	<div id="result6">
	</div>
	<div id="result7">
	</div>
	<div id="result8">
	</div>
	<div id="result9">
	</div>
	<div id="result10">
	</div>
	<div id="result11">
	</div>
	<div id="result12">
	</div>
</body>
</html>