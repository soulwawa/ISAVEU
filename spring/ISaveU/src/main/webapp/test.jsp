<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>

	var obj = [ {
		"module_id" : "0",
		"value" : [ {
			"event_id" : 44451,
			"module_id" : "0",
			"time" : "2018-04-09 14:50:27.0",
			"temp" : 26.73,
			"smoke" : 43.76,
			"gyro" : 2.51,
			"fire" : 3.74,
			"issue" : "0"
		}, {
			"event_id" : 44440,
			"module_id" : "0",
			"time" : "2018-04-09 14:50:17.0",
			"temp" : 26.47,
			"smoke" : 44.05,
			"gyro" : 2.91,
			"fire" : 3.68,
			"issue" : "0"
		}, {
			"event_id" : 44429,
			"module_id" : "0",
			"time" : "2018-04-09 14:50:06.0",
			"temp" : 26.88,
			"smoke" : 44.07,
			"gyro" : 2.03,
			"fire" : 3.72,
			"issue" : "0"
		}, {
			"event_id" : 44418,
			"module_id" : "0",
			"time" : "2018-04-09 14:49:56.0",
			"temp" : 26.8,
			"smoke" : 44.22,
			"gyro" : 2.65,
			"fire" : 4.19,
			"issue" : "0"
		}, {
			"event_id" : 44407,
			"module_id" : "0",
			"time" : "2018-04-09 14:49:46.0",
			"temp" : 26.44,
			"smoke" : 43.65,
			"gyro" : 2.22,
			"fire" : 4.06,
			"issue" : "0"
		}, {
			"event_id" : 44396,
			"module_id" : "0",
			"time" : "2018-04-09 14:49:35.0",
			"temp" : 27.21,
			"smoke" : 44.14,
			"gyro" : 1.93,
			"fire" : 3.85,
			"issue" : "0"
		}, {
			"event_id" : 44385,
			"module_id" : "0",
			"time" : "2018-04-09 14:49:25.0",
			"temp" : 27.04,
			"smoke" : 44.38,
			"gyro" : 3.33,
			"fire" : 3.63,
			"issue" : "0"
		}, {
			"event_id" : 44374,
			"module_id" : "0",
			"time" : "2018-04-09 14:49:18.0",
			"temp" : 27.14,
			"smoke" : 43.93,
			"gyro" : 1.63,
			"fire" : 3.63,
			"issue" : "0"
		}, {
			"event_id" : 44363,
			"module_id" : "0",
			"time" : "2018-04-09 14:49:05.0",
			"temp" : 26.4,
			"smoke" : 43.8,
			"gyro" : 2.91,
			"fire" : 3.99,
			"issue" : "0"
		}, {
			"event_id" : 44352,
			"module_id" : "0",
			"time" : "2018-04-09 14:48:54.0",
			"temp" : 27.24,
			"smoke" : 43.94,
			"gyro" : 2.08,
			"fire" : 3.93,
			"issue" : "0"
		}, {
			"event_id" : 44341,
			"module_id" : "0",
			"time" : "2018-04-09 14:39:03.0",
			"temp" : 26.33,
			"smoke" : 44.15,
			"gyro" : 1.91,
			"fire" : 3.76,
			"issue" : "0"
		}, {
			"event_id" : 44330,
			"module_id" : "0",
			"time" : "2018-04-09 14:38:52.0",
			"temp" : 26.53,
			"smoke" : 43.81,
			"gyro" : 3.05,
			"fire" : 3.44,
			"issue" : "0"
		} ]
	}, {
		"module_id" : "1",
		"value" : [ {
			"event_id" : 44452,
			"module_id" : "1",
			"time" : "2018-04-09 14:50:27.0",
			"temp" : 26.77,
			"smoke" : 43.76,
			"gyro" : 2.51,
			"fire" : 3.74,
			"issue" : "0"
		}, {
			"event_id" : 44441,
			"module_id" : "1",
			"time" : "2018-04-09 14:50:17.0",
			"temp" : 26.87,
			"smoke" : 44.07,
			"gyro" : 2.88,
			"fire" : 3.65,
			"issue" : "0"
		}, {
			"event_id" : 44430,
			"module_id" : "1",
			"time" : "2018-04-09 14:50:06.0",
			"temp" : 26.46,
			"smoke" : 44.05,
			"gyro" : 2.06,
			"fire" : 3.76,
			"issue" : "0"
		}, {
			"event_id" : 44419,
			"module_id" : "1",
			"time" : "2018-04-09 14:49:56.0",
			"temp" : 26.89,
			"smoke" : 44.23,
			"gyro" : 2.64,
			"fire" : 4.18,
			"issue" : "0"
		}, {
			"event_id" : 44408,
			"module_id" : "1",
			"time" : "2018-04-09 14:49:46.0",
			"temp" : 27.01,
			"smoke" : 43.68,
			"gyro" : 2.17,
			"fire" : 4.02,
			"issue" : "0"
		}, {
			"event_id" : 44397,
			"module_id" : "1",
			"time" : "2018-04-09 14:49:35.0",
			"temp" : 26.67,
			"smoke" : 44.11,
			"gyro" : 1.97,
			"fire" : 3.89,
			"issue" : "0"
		}, {
			"event_id" : 44386,
			"module_id" : "1",
			"time" : "2018-04-09 14:49:25.0",
			"temp" : 26.44,
			"smoke" : 44.35,
			"gyro" : 3.37,
			"fire" : 3.68,
			"issue" : "0"
		}, {
			"event_id" : 44375,
			"module_id" : "1",
			"time" : "2018-04-09 14:49:18.0",
			"temp" : 26.61,
			"smoke" : 43.91,
			"gyro" : 1.67,
			"fire" : 3.67,
			"issue" : "0"
		}, {
			"event_id" : 44364,
			"module_id" : "1",
			"time" : "2018-04-09 14:49:05.0",
			"temp" : 26.78,
			"smoke" : 43.82,
			"gyro" : 2.88,
			"fire" : 3.96,
			"issue" : "0"
		}, {
			"event_id" : 44353,
			"module_id" : "1",
			"time" : "2018-04-09 14:48:54.0",
			"temp" : 27.04,
			"smoke" : 43.93,
			"gyro" : 2.1,
			"fire" : 3.94,
			"issue" : "0"
		}, {
			"event_id" : 44342,
			"module_id" : "1",
			"time" : "2018-04-09 14:39:03.0",
			"temp" : 27.1,
			"smoke" : 44.19,
			"gyro" : 1.85,
			"fire" : 3.7,
			"issue" : "0"
		}, {
			"event_id" : 44331,
			"module_id" : "1",
			"time" : "2018-04-09 14:38:52.0",
			"temp" : 27.08,
			"smoke" : 43.84,
			"gyro" : 3.01,
			"fire" : 3.39,
			"issue" : "0"
		} ]
	}, {
		"module_id" : "2",
		"value" : [ {
			"event_id" : 44453,
			"module_id" : "2",
			"time" : "2018-04-09 14:50:27.0",
			"temp" : 26.72,
			"smoke" : 43.76,
			"gyro" : 2.51,
			"fire" : 3.74,
			"issue" : "0"
		}, {
			"event_id" : 44442,
			"module_id" : "2",
			"time" : "2018-04-09 14:50:17.0",
			"temp" : 26.7,
			"smoke" : 44.06,
			"gyro" : 2.89,
			"fire" : 3.66,
			"issue" : "0"
		}, {
			"event_id" : 44431,
			"module_id" : "2",
			"time" : "2018-04-09 14:50:06.0",
			"temp" : 26.78,
			"smoke" : 44.07,
			"gyro" : 2.04,
			"fire" : 3.73,
			"issue" : "0"
		}, {
			"event_id" : 44420,
			"module_id" : "2",
			"time" : "2018-04-09 14:49:56.0",
			"temp" : 26.67,
			"smoke" : 44.21,
			"gyro" : 2.66,
			"fire" : 4.2,
			"issue" : "0"
		}, {
			"event_id" : 44409,
			"module_id" : "2",
			"time" : "2018-04-09 14:49:46.0",
			"temp" : 26.55,
			"smoke" : 43.66,
			"gyro" : 2.21,
			"fire" : 4.06,
			"issue" : "0"
		}, {
			"event_id" : 44398,
			"module_id" : "2",
			"time" : "2018-04-09 14:49:36.0",
			"temp" : 27.05,
			"smoke" : 44.13,
			"gyro" : 1.94,
			"fire" : 3.86,
			"issue" : "0"
		}, {
			"event_id" : 44387,
			"module_id" : "2",
			"time" : "2018-04-09 14:49:25.0",
			"temp" : 27.06,
			"smoke" : 44.38,
			"gyro" : 3.32,
			"fire" : 3.63,
			"issue" : "0"
		}, {
			"event_id" : 44376,
			"module_id" : "2",
			"time" : "2018-04-09 14:49:18.0",
			"temp" : 26.98,
			"smoke" : 43.93,
			"gyro" : 1.64,
			"fire" : 3.64,
			"issue" : "0"
		}, {
			"event_id" : 44365,
			"module_id" : "2",
			"time" : "2018-04-09 14:49:05.0",
			"temp" : 26.73,
			"smoke" : 43.82,
			"gyro" : 2.88,
			"fire" : 3.96,
			"issue" : "0"
		}, {
			"event_id" : 44354,
			"module_id" : "2",
			"time" : "2018-04-09 14:48:54.0",
			"temp" : 26.67,
			"smoke" : 43.91,
			"gyro" : 2.12,
			"fire" : 3.97,
			"issue" : "0"
		}, {
			"event_id" : 44343,
			"module_id" : "2",
			"time" : "2018-04-09 14:39:03.0",
			"temp" : 26.79,
			"smoke" : 44.17,
			"gyro" : 1.87,
			"fire" : 3.72,
			"issue" : "0"
		}, {
			"event_id" : 44332,
			"module_id" : "2",
			"time" : "2018-04-09 14:38:52.0",
			"temp" : 26.32,
			"smoke" : 43.8,
			"gyro" : 3.07,
			"fire" : 3.45,
			"issue" : "0"
		} ]
	}, {
		"module_id" : "3",
		"value" : [ {
			"event_id" : 44454,
			"module_id" : "3",
			"time" : "2018-04-09 14:50:27.0",
			"temp" : 26.44,
			"smoke" : 43.75,
			"gyro" : 2.53,
			"fire" : 3.76,
			"issue" : "0"
		}, {
			"event_id" : 44443,
			"module_id" : "3",
			"time" : "2018-04-09 14:50:17.0",
			"temp" : 26.87,
			"smoke" : 44.07,
			"gyro" : 2.88,
			"fire" : 3.65,
			"issue" : "0"
		}, {
			"event_id" : 44432,
			"module_id" : "3",
			"time" : "2018-04-09 14:50:06.0",
			"temp" : 27.22,
			"smoke" : 44.09,
			"gyro" : 2.01,
			"fire" : 3.7,
			"issue" : "0"
		}, {
			"event_id" : 44421,
			"module_id" : "3",
			"time" : "2018-04-09 14:49:56.0",
			"temp" : 26.95,
			"smoke" : 44.23,
			"gyro" : 2.64,
			"fire" : 4.17,
			"issue" : "0"
		}, {
			"event_id" : 44410,
			"module_id" : "3",
			"time" : "2018-04-09 14:49:46.0",
			"temp" : 26.47,
			"smoke" : 43.65,
			"gyro" : 2.22,
			"fire" : 4.06,
			"issue" : "0"
		}, {
			"event_id" : 44399,
			"module_id" : "3",
			"time" : "2018-04-09 14:49:36.0",
			"temp" : 26.43,
			"smoke" : 44.1,
			"gyro" : 1.99,
			"fire" : 3.91,
			"issue" : "0"
		}, {
			"event_id" : 44388,
			"module_id" : "3",
			"time" : "2018-04-09 14:49:25.0",
			"temp" : 26.4,
			"smoke" : 44.35,
			"gyro" : 3.38,
			"fire" : 3.68,
			"issue" : "0"
		}, {
			"event_id" : 44377,
			"module_id" : "3",
			"time" : "2018-04-09 14:49:18.0",
			"temp" : 27.18,
			"smoke" : 43.94,
			"gyro" : 1.62,
			"fire" : 3.62,
			"issue" : "0"
		}, {
			"event_id" : 44366,
			"module_id" : "3",
			"time" : "2018-04-09 14:49:05.0",
			"temp" : 26.83,
			"smoke" : 43.82,
			"gyro" : 2.88,
			"fire" : 3.95,
			"issue" : "0"
		}, {
			"event_id" : 44355,
			"module_id" : "3",
			"time" : "2018-04-09 14:48:54.0",
			"temp" : 27.33,
			"smoke" : 43.94,
			"gyro" : 2.07,
			"fire" : 3.92,
			"issue" : "0"
		}, {
			"event_id" : 44344,
			"module_id" : "3",
			"time" : "2018-04-09 14:39:03.0",
			"temp" : 26.34,
			"smoke" : 44.15,
			"gyro" : 1.91,
			"fire" : 3.76,
			"issue" : "0"
		}, {
			"event_id" : 44333,
			"module_id" : "3",
			"time" : "2018-04-09 14:38:52.0",
			"temp" : 26.88,
			"smoke" : 43.83,
			"gyro" : 3.02,
			"fire" : 3.41,
			"issue" : "0"
		} ]
	}, {
		"module_id" : "4",
		"value" : [ {
			"event_id" : 44455,
			"module_id" : "4",
			"time" : "2018-04-09 14:50:27.0",
			"temp" : 26.74,
			"smoke" : 43.76,
			"gyro" : 2.51,
			"fire" : 3.74,
			"issue" : "0"
		}, {
			"event_id" : 44444,
			"module_id" : "4",
			"time" : "2018-04-09 14:50:17.0",
			"temp" : 26.47,
			"smoke" : 44.05,
			"gyro" : 2.91,
			"fire" : 3.68,
			"issue" : "0"
		}, {
			"event_id" : 44433,
			"module_id" : "4",
			"time" : "2018-04-09 14:50:06.0",
			"temp" : 26.5,
			"smoke" : 44.05,
			"gyro" : 2.06,
			"fire" : 3.75,
			"issue" : "0"
		}, {
			"event_id" : 44422,
			"module_id" : "4",
			"time" : "2018-04-09 14:49:56.0",
			"temp" : 26.9,
			"smoke" : 44.23,
			"gyro" : 2.64,
			"fire" : 4.18,
			"issue" : "0"
		}, {
			"event_id" : 44411,
			"module_id" : "4",
			"time" : "2018-04-09 14:49:46.0",
			"temp" : 26.39,
			"smoke" : 43.65,
			"gyro" : 2.22,
			"fire" : 4.07,
			"issue" : "0"
		}, {
			"event_id" : 44400,
			"module_id" : "4",
			"time" : "2018-04-09 14:49:36.0",
			"temp" : 27.06,
			"smoke" : 44.13,
			"gyro" : 1.94,
			"fire" : 3.86,
			"issue" : "0"
		}, {
			"event_id" : 44389,
			"module_id" : "4",
			"time" : "2018-04-09 14:49:25.0",
			"temp" : 26.38,
			"smoke" : 44.35,
			"gyro" : 3.38,
			"fire" : 3.68,
			"issue" : "0"
		}, {
			"event_id" : 44378,
			"module_id" : "4",
			"time" : "2018-04-09 14:49:18.0",
			"temp" : 26.45,
			"smoke" : 43.9,
			"gyro" : 1.68,
			"fire" : 3.68,
			"issue" : "0"
		}, {
			"event_id" : 44367,
			"module_id" : "4",
			"time" : "2018-04-09 14:49:05.0",
			"temp" : 26.87,
			"smoke" : 43.82,
			"gyro" : 2.87,
			"fire" : 3.95,
			"issue" : "0"
		}, {
			"event_id" : 44356,
			"module_id" : "4",
			"time" : "2018-04-09 14:48:54.0",
			"temp" : 27.06,
			"smoke" : 43.93,
			"gyro" : 2.09,
			"fire" : 3.94,
			"issue" : "0"
		}, {
			"event_id" : 44345,
			"module_id" : "4",
			"time" : "2018-04-09 14:39:03.0",
			"temp" : 26.77,
			"smoke" : 44.17,
			"gyro" : 1.88,
			"fire" : 3.72,
			"issue" : "0"
		}, {
			"event_id" : 44334,
			"module_id" : "4",
			"time" : "2018-04-09 14:38:52.0",
			"temp" : 26.3,
			"smoke" : 43.8,
			"gyro" : 3.07,
			"fire" : 3.45,
			"issue" : "0"
		} ]
	}, {
		"module_id" : "5",
		"value" : [ {
			"event_id" : 44456,
			"module_id" : "5",
			"time" : "2018-04-09 14:50:27.0",
			"temp" : 27.26,
			"smoke" : 43.79,
			"gyro" : 2.47,
			"fire" : 3.7,
			"issue" : "0"
		}, {
			"event_id" : 44445,
			"module_id" : "5",
			"time" : "2018-04-09 14:50:17.0",
			"temp" : 27.03,
			"smoke" : 44.08,
			"gyro" : 2.87,
			"fire" : 3.64,
			"issue" : "0"
		}, {
			"event_id" : 44434,
			"module_id" : "5",
			"time" : "2018-04-09 14:50:06.0",
			"temp" : 27.06,
			"smoke" : 44.08,
			"gyro" : 2.02,
			"fire" : 3.71,
			"issue" : "0"
		}, {
			"event_id" : 44423,
			"module_id" : "5",
			"time" : "2018-04-09 14:49:56.0",
			"temp" : 26.98,
			"smoke" : 44.23,
			"gyro" : 2.63,
			"fire" : 4.17,
			"issue" : "0"
		}, {
			"event_id" : 44412,
			"module_id" : "5",
			"time" : "2018-04-09 14:49:46.0",
			"temp" : 26.52,
			"smoke" : 43.65,
			"gyro" : 2.21,
			"fire" : 4.06,
			"issue" : "0"
		}, {
			"event_id" : 44401,
			"module_id" : "5",
			"time" : "2018-04-09 14:49:36.0",
			"temp" : 27.03,
			"smoke" : 44.13,
			"gyro" : 1.94,
			"fire" : 3.87,
			"issue" : "0"
		}, {
			"event_id" : 44390,
			"module_id" : "5",
			"time" : "2018-04-09 14:49:25.0",
			"temp" : 26.86,
			"smoke" : 44.37,
			"gyro" : 3.34,
			"fire" : 3.65,
			"issue" : "0"
		}, {
			"event_id" : 44379,
			"module_id" : "5",
			"time" : "2018-04-09 14:49:18.0",
			"temp" : 27.34,
			"smoke" : 43.94,
			"gyro" : 1.61,
			"fire" : 3.61,
			"issue" : "0"
		}, {
			"event_id" : 44368,
			"module_id" : "5",
			"time" : "2018-04-09 14:49:05.0",
			"temp" : 27.23,
			"smoke" : 43.84,
			"gyro" : 2.85,
			"fire" : 3.92,
			"issue" : "0"
		}, {
			"event_id" : 44357,
			"module_id" : "5",
			"time" : "2018-04-09 14:48:54.0",
			"temp" : 27.27,
			"smoke" : 43.94,
			"gyro" : 2.08,
			"fire" : 3.92,
			"issue" : "0"
		}, {
			"event_id" : 44346,
			"module_id" : "5",
			"time" : "2018-04-09 14:39:03.0",
			"temp" : 27.06,
			"smoke" : 44.19,
			"gyro" : 1.85,
			"fire" : 3.7,
			"issue" : "0"
		}, {
			"event_id" : 44335,
			"module_id" : "5",
			"time" : "2018-04-09 14:38:52.0",
			"temp" : 26.37,
			"smoke" : 43.8,
			"gyro" : 3.06,
			"fire" : 3.45,
			"issue" : "0"
		} ]
	}, {
		"module_id" : "6",
		"value" : [ {
			"event_id" : 44457,
			"module_id" : "6",
			"time" : "2018-04-09 14:50:27.0",
			"temp" : 26.68,
			"smoke" : 43.76,
			"gyro" : 2.51,
			"fire" : 3.74,
			"issue" : "0"
		}, {
			"event_id" : 44446,
			"module_id" : "6",
			"time" : "2018-04-09 14:50:17.0",
			"temp" : 27.19,
			"smoke" : 44.09,
			"gyro" : 2.85,
			"fire" : 3.62,
			"issue" : "0"
		}, {
			"event_id" : 44435,
			"module_id" : "6",
			"time" : "2018-04-09 14:50:06.0",
			"temp" : 26.89,
			"smoke" : 44.07,
			"gyro" : 2.03,
			"fire" : 3.72,
			"issue" : "0"
		}, {
			"event_id" : 44424,
			"module_id" : "6",
			"time" : "2018-04-09 14:49:56.0",
			"temp" : 26.82,
			"smoke" : 44.22,
			"gyro" : 2.65,
			"fire" : 4.18,
			"issue" : "0"
		}, {
			"event_id" : 44413,
			"module_id" : "6",
			"time" : "2018-04-09 14:49:46.0",
			"temp" : 26.88,
			"smoke" : 43.67,
			"gyro" : 2.18,
			"fire" : 4.03,
			"issue" : "0"
		}, {
			"event_id" : 44402,
			"module_id" : "6",
			"time" : "2018-04-09 14:49:36.0",
			"temp" : 26.35,
			"smoke" : 44.1,
			"gyro" : 1.99,
			"fire" : 3.92,
			"issue" : "0"
		}, {
			"event_id" : 44391,
			"module_id" : "6",
			"time" : "2018-04-09 14:49:25.0",
			"temp" : 26.68,
			"smoke" : 44.36,
			"gyro" : 3.35,
			"fire" : 3.66,
			"issue" : "0"
		}, {
			"event_id" : 44380,
			"module_id" : "6",
			"time" : "2018-04-09 14:49:18.0",
			"temp" : 26.45,
			"smoke" : 43.9,
			"gyro" : 1.68,
			"fire" : 3.68,
			"issue" : "0"
		}, {
			"event_id" : 44369,
			"module_id" : "6",
			"time" : "2018-04-09 14:49:05.0",
			"temp" : 27.21,
			"smoke" : 43.84,
			"gyro" : 2.85,
			"fire" : 3.92,
			"issue" : "0"
		}, {
			"event_id" : 44358,
			"module_id" : "6",
			"time" : "2018-04-09 14:48:54.0",
			"temp" : 26.89,
			"smoke" : 43.92,
			"gyro" : 2.11,
			"fire" : 3.95,
			"issue" : "0"
		}, {
			"event_id" : 44347,
			"module_id" : "6",
			"time" : "2018-04-09 14:39:03.0",
			"temp" : 26.29,
			"smoke" : 44.15,
			"gyro" : 1.91,
			"fire" : 3.76,
			"issue" : "0"
		}, {
			"event_id" : 44336,
			"module_id" : "6",
			"time" : "2018-04-09 14:38:52.0",
			"temp" : 27.21,
			"smoke" : 43.84,
			"gyro" : 3.0,
			"fire" : 3.38,
			"issue" : "0"
		} ]
	}, {
		"module_id" : "7",
		"value" : [ {
			"event_id" : 44458,
			"module_id" : "7",
			"time" : "2018-04-09 14:50:27.0",
			"temp" : 26.71,
			"smoke" : 43.76,
			"gyro" : 2.51,
			"fire" : 3.74,
			"issue" : "0"
		}, {
			"event_id" : 44447,
			"module_id" : "7",
			"time" : "2018-04-09 14:50:17.0",
			"temp" : 26.97,
			"smoke" : 44.08,
			"gyro" : 2.87,
			"fire" : 3.64,
			"issue" : "0"
		}, {
			"event_id" : 44436,
			"module_id" : "7",
			"time" : "2018-04-09 14:50:06.0",
			"temp" : 26.88,
			"smoke" : 44.07,
			"gyro" : 2.03,
			"fire" : 3.72,
			"issue" : "0"
		}, {
			"event_id" : 44425,
			"module_id" : "7",
			"time" : "2018-04-09 14:49:56.0",
			"temp" : 27.19,
			"smoke" : 44.24,
			"gyro" : 2.62,
			"fire" : 4.16,
			"issue" : "0"
		}, {
			"event_id" : 44414,
			"module_id" : "7",
			"time" : "2018-04-09 14:49:46.0",
			"temp" : 27.0,
			"smoke" : 43.68,
			"gyro" : 2.18,
			"fire" : 4.02,
			"issue" : "0"
		}, {
			"event_id" : 44403,
			"module_id" : "7",
			"time" : "2018-04-09 14:49:36.0",
			"temp" : 27.06,
			"smoke" : 44.13,
			"gyro" : 1.94,
			"fire" : 3.86,
			"issue" : "0"
		}, {
			"event_id" : 44392,
			"module_id" : "7",
			"time" : "2018-04-09 14:49:26.0",
			"temp" : 27.29,
			"smoke" : 44.39,
			"gyro" : 3.31,
			"fire" : 3.61,
			"issue" : "0"
		}, {
			"event_id" : 44381,
			"module_id" : "7",
			"time" : "2018-04-09 14:49:18.0",
			"temp" : 27.2,
			"smoke" : 43.94,
			"gyro" : 1.62,
			"fire" : 3.62,
			"issue" : "0"
		}, {
			"event_id" : 44370,
			"module_id" : "7",
			"time" : "2018-04-09 14:49:05.0",
			"temp" : 27.05,
			"smoke" : 43.83,
			"gyro" : 2.86,
			"fire" : 3.94,
			"issue" : "0"
		}, {
			"event_id" : 44359,
			"module_id" : "7",
			"time" : "2018-04-09 14:48:54.0",
			"temp" : 26.87,
			"smoke" : 43.92,
			"gyro" : 2.11,
			"fire" : 3.95,
			"issue" : "0"
		}, {
			"event_id" : 44348,
			"module_id" : "7",
			"time" : "2018-04-09 14:39:03.0",
			"temp" : 26.45,
			"smoke" : 44.16,
			"gyro" : 1.9,
			"fire" : 3.75,
			"issue" : "0"
		}, {
			"event_id" : 44337,
			"module_id" : "7",
			"time" : "2018-04-09 14:38:52.0",
			"temp" : 26.62,
			"smoke" : 43.81,
			"gyro" : 3.04,
			"fire" : 3.43,
			"issue" : "0"
		} ]
	}, {
		"module_id" : "8",
		"value" : [ {
			"event_id" : 44459,
			"module_id" : "8",
			"time" : "2018-04-09 14:50:27.0",
			"temp" : 27.39,
			"smoke" : 43.79,
			"gyro" : 2.46,
			"fire" : 3.69,
			"issue" : "0"
		}, {
			"event_id" : 44448,
			"module_id" : "8",
			"time" : "2018-04-09 14:50:17.0",
			"temp" : 26.8,
			"smoke" : 44.07,
			"gyro" : 2.88,
			"fire" : 3.65,
			"issue" : "0"
		}, {
			"event_id" : 44437,
			"module_id" : "8",
			"time" : "2018-04-09 14:50:06.0",
			"temp" : 26.85,
			"smoke" : 44.07,
			"gyro" : 2.03,
			"fire" : 3.73,
			"issue" : "0"
		}, {
			"event_id" : 44426,
			"module_id" : "8",
			"time" : "2018-04-09 14:49:56.0",
			"temp" : 26.29,
			"smoke" : 44.2,
			"gyro" : 2.69,
			"fire" : 4.23,
			"issue" : "0"
		}, {
			"event_id" : 44415,
			"module_id" : "8",
			"time" : "2018-04-09 14:49:46.0",
			"temp" : 26.75,
			"smoke" : 43.67,
			"gyro" : 2.19,
			"fire" : 4.04,
			"issue" : "0"
		}, {
			"event_id" : 44404,
			"module_id" : "8",
			"time" : "2018-04-09 14:49:36.0",
			"temp" : 26.71,
			"smoke" : 44.11,
			"gyro" : 1.97,
			"fire" : 3.89,
			"issue" : "0"
		}, {
			"event_id" : 44393,
			"module_id" : "8",
			"time" : "2018-04-09 14:49:26.0",
			"temp" : 26.76,
			"smoke" : 44.37,
			"gyro" : 3.35,
			"fire" : 3.66,
			"issue" : "0"
		}, {
			"event_id" : 44382,
			"module_id" : "8",
			"time" : "2018-04-09 14:49:18.0",
			"temp" : 27.11,
			"smoke" : 43.93,
			"gyro" : 1.63,
			"fire" : 3.63,
			"issue" : "0"
		}, {
			"event_id" : 44371,
			"module_id" : "8",
			"time" : "2018-04-09 14:49:05.0",
			"temp" : 26.99,
			"smoke" : 43.83,
			"gyro" : 2.86,
			"fire" : 3.94,
			"issue" : "0"
		}, {
			"event_id" : 44360,
			"module_id" : "8",
			"time" : "2018-04-09 14:48:54.0",
			"temp" : 26.84,
			"smoke" : 43.92,
			"gyro" : 2.11,
			"fire" : 3.96,
			"issue" : "0"
		}, {
			"event_id" : 44349,
			"module_id" : "8",
			"time" : "2018-04-09 14:39:03.0",
			"temp" : 26.4,
			"smoke" : 44.15,
			"gyro" : 1.9,
			"fire" : 3.75,
			"issue" : "0"
		}, {
			"event_id" : 44338,
			"module_id" : "8",
			"time" : "2018-04-09 14:38:52.0",
			"temp" : 26.8,
			"smoke" : 43.82,
			"gyro" : 3.03,
			"fire" : 3.42,
			"issue" : "0"
		} ]
	}, {
		"module_id" : "9",
		"value" : [ {
			"event_id" : 44460,
			"module_id" : "9",
			"time" : "2018-04-09 14:50:27.0",
			"temp" : 27.39,
			"smoke" : 43.79,
			"gyro" : 2.46,
			"fire" : 3.69,
			"issue" : "0"
		}, {
			"event_id" : 44449,
			"module_id" : "9",
			"time" : "2018-04-09 14:50:17.0",
			"temp" : 26.49,
			"smoke" : 44.05,
			"gyro" : 2.91,
			"fire" : 3.68,
			"issue" : "0"
		}, {
			"event_id" : 44438,
			"module_id" : "9",
			"time" : "2018-04-09 14:50:06.0",
			"temp" : 27.1,
			"smoke" : 44.08,
			"gyro" : 2.02,
			"fire" : 3.71,
			"issue" : "0"
		}, {
			"event_id" : 44427,
			"module_id" : "9",
			"time" : "2018-04-09 14:49:56.0",
			"temp" : 26.78,
			"smoke" : 44.22,
			"gyro" : 2.65,
			"fire" : 4.19,
			"issue" : "0"
		}, {
			"event_id" : 44416,
			"module_id" : "9",
			"time" : "2018-04-09 14:49:46.0",
			"temp" : 26.73,
			"smoke" : 43.66,
			"gyro" : 2.2,
			"fire" : 4.04,
			"issue" : "0"
		}, {
			"event_id" : 44405,
			"module_id" : "9",
			"time" : "2018-04-09 14:49:36.0",
			"temp" : 26.96,
			"smoke" : 44.13,
			"gyro" : 1.95,
			"fire" : 3.87,
			"issue" : "0"
		}, {
			"event_id" : 44394,
			"module_id" : "9",
			"time" : "2018-04-09 14:49:26.0",
			"temp" : 27.0,
			"smoke" : 44.38,
			"gyro" : 3.33,
			"fire" : 3.64,
			"issue" : "0"
		}, {
			"event_id" : 44383,
			"module_id" : "9",
			"time" : "2018-04-09 14:49:18.0",
			"temp" : 26.64,
			"smoke" : 43.91,
			"gyro" : 1.67,
			"fire" : 3.67,
			"issue" : "0"
		}, {
			"event_id" : 44372,
			"module_id" : "9",
			"time" : "2018-04-09 14:49:05.0",
			"temp" : 27.21,
			"smoke" : 43.84,
			"gyro" : 2.85,
			"fire" : 3.92,
			"issue" : "0"
		}, {
			"event_id" : 44361,
			"module_id" : "9",
			"time" : "2018-04-09 14:48:54.0",
			"temp" : 26.75,
			"smoke" : 43.92,
			"gyro" : 2.12,
			"fire" : 3.96,
			"issue" : "0"
		}, {
			"event_id" : 44350,
			"module_id" : "9",
			"time" : "2018-04-09 14:39:03.0",
			"temp" : 26.47,
			"smoke" : 44.16,
			"gyro" : 1.9,
			"fire" : 3.75,
			"issue" : "0"
		}, {
			"event_id" : 44339,
			"module_id" : "9",
			"time" : "2018-04-09 14:38:52.0",
			"temp" : 27.1,
			"smoke" : 43.84,
			"gyro" : 3.01,
			"fire" : 3.39,
			"issue" : "0"
		} ]
	}, {
		"module_id" : "10",
		"value" : [ {
			"event_id" : 44461,
			"module_id" : "10",
			"time" : "2018-04-09 14:50:27.0",
			"temp" : 26.82,
			"smoke" : 43.77,
			"gyro" : 2.5,
			"fire" : 3.73,
			"issue" : "0"
		}, {
			"event_id" : 44450,
			"module_id" : "10",
			"time" : "2018-04-09 14:50:17.0",
			"temp" : 26.83,
			"smoke" : 44.07,
			"gyro" : 2.88,
			"fire" : 3.65,
			"issue" : "0"
		}, {
			"event_id" : 44439,
			"module_id" : "10",
			"time" : "2018-04-09 14:50:06.0",
			"temp" : 26.76,
			"smoke" : 44.06,
			"gyro" : 2.04,
			"fire" : 3.73,
			"issue" : "0"
		}, {
			"event_id" : 44428,
			"module_id" : "10",
			"time" : "2018-04-09 14:49:56.0",
			"temp" : 27.04,
			"smoke" : 44.23,
			"gyro" : 2.63,
			"fire" : 4.17,
			"issue" : "0"
		}, {
			"event_id" : 44417,
			"module_id" : "10",
			"time" : "2018-04-09 14:49:46.0",
			"temp" : 26.95,
			"smoke" : 43.68,
			"gyro" : 2.18,
			"fire" : 4.03,
			"issue" : "0"
		}, {
			"event_id" : 44406,
			"module_id" : "10",
			"time" : "2018-04-09 14:49:36.0",
			"temp" : 27.2,
			"smoke" : 44.14,
			"gyro" : 1.93,
			"fire" : 3.85,
			"issue" : "0"
		}, {
			"event_id" : 44395,
			"module_id" : "10",
			"time" : "2018-04-09 14:49:26.0",
			"temp" : 27.0,
			"smoke" : 44.38,
			"gyro" : 3.33,
			"fire" : 3.64,
			"issue" : "0"
		}, {
			"event_id" : 44384,
			"module_id" : "10",
			"time" : "2018-04-09 14:49:18.0",
			"temp" : 27.01,
			"smoke" : 43.93,
			"gyro" : 1.64,
			"fire" : 3.64,
			"issue" : "0"
		}, {
			"event_id" : 44373,
			"module_id" : "10",
			"time" : "2018-04-09 14:49:05.0",
			"temp" : 26.65,
			"smoke" : 43.81,
			"gyro" : 2.89,
			"fire" : 3.97,
			"issue" : "0"
		}, {
			"event_id" : 44362,
			"module_id" : "10",
			"time" : "2018-04-09 14:48:54.0",
			"temp" : 26.53,
			"smoke" : 43.9,
			"gyro" : 2.13,
			"fire" : 3.98,
			"issue" : "0"
		}, {
			"event_id" : 44351,
			"module_id" : "10",
			"time" : "2018-04-09 14:39:03.0",
			"temp" : 26.57,
			"smoke" : 44.16,
			"gyro" : 1.89,
			"fire" : 3.74,
			"issue" : "0"
		}, {
			"event_id" : 44340,
			"module_id" : "10",
			"time" : "2018-04-09 14:38:52.0",
			"temp" : 26.39,
			"smoke" : 43.8,
			"gyro" : 3.06,
			"fire" : 3.45,
			"issue" : "0"
		} ]
	} ];

	document.write(obj.length);

	for (var i = 0; i < obj.length; i++) {
		var counter = obj[i];
		var cv = obj[i].value;
		
		
		document.write("<br></n> ------------------------------------------------------- <br></n> module_id :" + counter.module_id);
		
		console.log(counter.module_id);
		console.log(cv);
		for (var j = 0; j < cv.length; j++){
			var result = cv[j];
			document.write("<br></n> time : " + result.time
					+ "<br></n> temp : " + result.temp
					+ "<br></n> smoke : " + result.smoke
					+ "<br></n> fire : " + result.fire
					+ "<br></n> gyro : " + result.gyro);
		}
		

	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div id="result"></div>
	<div id="result0"></div>
	<div id="result1"></div>
	<div id="result2"></div>
	<div id="result3"></div>
	<div id="result4"></div>
	<div id="result5"></div>
	<div id="result6"></div>
	<div id="result7"></div>
	<div id="result8"></div>
	<div id="result9"></div>
	<div id="result10"></div>
	<div id="result11"></div>
	<div id="result12"></div>
</body>
</html>