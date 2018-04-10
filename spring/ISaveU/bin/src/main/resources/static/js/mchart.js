/// -----------------------차트 설정 시작-----------------------
var chartVars21 = "rMateOnLoadCallFunction=chartReadyHandler21";

rMateChartH5.create("chart21", "chartHolder21", chartVars21, "100%", "100%"); 
rMateChartH5.create("chart22", "chartHolder22", chartVars21, "100%", "100%"); 
rMateChartH5.create("chart23", "chartHolder23", chartVars21, "100%", "100%"); 
rMateChartH5.create("chart24", "chartHolder24", chartVars21, "100%", "100%"); 
rMateChartH5.create("chart25", "chartHolder25", chartVars21, "100%", "100%"); 
rMateChartH5.create("chart26", "chartHolder26", chartVars21, "100%", "100%"); 
rMateChartH5.create("chart27", "chartHolder27", chartVars21, "100%", "100%"); 
rMateChartH5.create("chart28", "chartHolder28", chartVars21, "100%", "100%"); 
rMateChartH5.create("chart29", "chartHolder29", chartVars21, "100%", "100%"); 
rMateChartH5.create("chart30", "chartHolder30", chartVars21, "100%", "100%"); 
rMateChartH5.create("chart31", "chartHolder31", chartVars21, "100%", "100%"); 

function chartReadyHandler21(id) {
	document.getElementById(id).setLayout(layoutStr21);
	document.getElementById(id).setData(chartData21);
}

var layoutStr21 = '<rMateChart backgroundColor="#FFFFFF"  borderStyle="none">'
	+'<Options>'
	+'<Legend defaultMouseOverAction="false" useVisibleCheck="true"/>'
	+'</Options>'
	+'<Line2DChart showDataTips="true" paddingTop="0">'
	+'<horizontalAxis>'
	+'<CategoryAxis categoryField="time" padding="0.2"/> '
	+'</horizontalAxis>'
	+'<verticalAxis>'
	+'<LinearAxis maximum="80" interval="10"/>'
	+'</verticalAxis>'
	+'<series>'


	+'<Line2DSeries labelPosition="up" yField="temp" form="curve" displayName="temp" itemRenderer="CircleItemRenderer">'
	+'<showDataEffect>'
	+'<SeriesInterpolate duration="1000"/> '
	+'</showDataEffect>'
	+'</Line2DSeries>'

	+'<Line2DSeries labelPosition="up" yField="smoke" form="curve" displayName="smoke" itemRenderer="CircleItemRenderer">'
	+'<showDataEffect>'
	+'<SeriesInterpolate duration="1000"/> '
	+'</showDataEffect>'
	+'</Line2DSeries>'

	+'<Line2DSeries labelPosition="up" yField="gyro" form="curve" displayName="gyro" itemRenderer="CircleItemRenderer">'
	+'<showDataEffect>'
	+'<SeriesInterpolate duration="1000"/> '
	+'</showDataEffect>'
	+'</Line2DSeries>'

	+'<Line2DSeries labelPosition="up" yField="fire" form="curve" displayName="fire" itemRenderer="CircleItemRenderer">'
	+'<showDataEffect>'
	+'<SeriesInterpolate duration="1000"/> '
	+'</showDataEffect>'
	+'</Line2DSeries>'


	+'</series>'
	+'</Line2DChart>'
	+'</rMateChart>';

var chartData21 = [{"time":"00:00:00","temp":10,"smoke":30,"gyro":20,"fire":20},
	{"time":"00:00:05","temp":25,"smoke":38,"gyro":20,"fire":21},
	{"time":"00:00:10","temp":10,"smoke":49,"gyro":25,"fire":22},
	{"time":"00:00:15","temp":25,"smoke":60,"gyro":42,"fire":23},
	{"time":"00:00:20","temp":10,"smoke":65,"gyro":45,"fire":24},
	{"time":"00:00:25","temp":25,"smoke":60,"gyro":60,"fire":25},
	{"time":"00:00:30","temp":10,"smoke":47,"gyro":37,"fire":26},
	{"time":"00:00:35","temp":30,"smoke":40,"gyro":25,"fire":27},
	{"time":"00:00:40","temp":10,"smoke":47,"gyro":20,"fire":28},
	{"time":"00:00:45","temp":30,"smoke":55,"gyro":25,"fire":29},
	{"time":"00:00:50","temp":10,"smoke":47,"gyro":20,"fire":30},
	{"time":"00:00:55","temp":10,"smoke":37,"gyro":20,"fire":31}];


rMateChartH5.registerTheme(rMateChartH5.themes);


//-----------------------차트 설정 끝 -----------------------