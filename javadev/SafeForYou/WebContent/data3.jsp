<%@ page language="java" contentType="application/xml; charget=UTF-8"
    pageEncoding="UTF-8"%><?xml version="1.0" encoding="utf-8"?>
<items> 			
	<item>
		<time>
			<%=request.getAttribute("now")%>
		</time> 
		<issue>
			<%=request.getAttribute("issue")%>
		</issue>
		<sensor>
			<%=request.getAttribute("sensorId")%>
		</sensor>
		<temp>
			97
		</temp>
		<smoke>
			<%=request.getAttribute("smoke")%>
		</smoke>
		<gyro>
			<%=request.getAttribute("smoke")%>
		</gyro>
		<fire>
			<%=request.getAttribute("fire")%>
		</fire>
	</item>
</items>