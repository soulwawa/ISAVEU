var chartVars6 = "rMateOnLoadCallFunction=chartReadyHandler6";
var chartVars7 = "rMateOnLoadCallFunction=chartReadyHandler7";
var chartVars8 = "rMateOnLoadCallFunction=chartReadyHandler8";
var chartVars9 = "rMateOnLoadCallFunction=chartReadyHandler9";

rMateChartH5.create("chart6", "chartHolder6", chartVars6, "100%", "100%");
rMateChartH5.create("chart7", "chartHolder7", chartVars7, "100%", "100%");
rMateChartH5.create("chart8", "chartHolder8", chartVars8, "100%", "100%");
rMateChartH5.create("chart9", "chartHolder9", chartVars9, "100%", "100%");


function chartReadyHandler6(id) {
	document.getElementById(id).setLayout(layoutStr6);
	document.getElementById(id).setData(chartData3);
}

function chartReadyHandler7(id) {
	document.getElementById(id).setLayout(layoutStr7);
	document.getElementById(id).setData(chartData3);
}

function chartReadyHandler8(id) {
	document.getElementById(id).setLayout(layoutStr8);
	document.getElementById(id).setData(chartData3);
}

function chartReadyHandler9(id) {
	document.getElementById(id).setLayout(layoutStr9);
	document.getElementById(id).setData(chartData3);
}

var layoutStr6 = '<rMateChart backgroundColor="#FFFFFF"  borderStyle="none">'
				+'<Options>'
					+'<SubCaption text="Temperature" textAlign="center" />'
					+'<Legend defaultMouseOverAction="false" useVisibleCheck="true"/>'
				+'</Options>'
				+'<Line2DChart showDataTips="true" paddingTop="0">'
					+'<horizontalAxis>'
						+'<CategoryAxis categoryField="time" padding="0.2"/> '
					+'</horizontalAxis>'
					+'<verticalAxis>'
						+'<LinearAxis maximum="100" interval="10"/>'
					+'</verticalAxis>'
					+'<series>'
					
						+'<Line2DSeries labelPosition="up" yField="sensor0" form="curve" displayName="sensor0" itemRenderer="CircleItemRenderer" >'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'

						
						+'<Line2DSeries labelPosition="up" yField="sensor1" form="curve" displayName="sensor1" itemRenderer="CircleItemRenderer" >'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
					
					
						+'<Line2DSeries labelPosition="up" yField="sensor2" form="curve" displayName="sensor2" itemRenderer="CircleItemRenderer" >'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
						
						+'<Line2DSeries labelPosition="up" yField="sensor3" form="curve" displayName="sensor3" itemRenderer="CircleItemRenderer" >'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
	
						
						+'<Line2DSeries labelPosition="up" yField="sensor4" form="curve" displayName="sensor4" itemRenderer="CircleItemRenderer" >'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
					
					
						+'<Line2DSeries labelPosition="up" yField="sensor5" form="curve" displayName="sensor5" itemRenderer="CircleItemRenderer" >'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
						
						+'<Line2DSeries labelPosition="up" yField="sensor6" form="curve" displayName="sensor6" itemRenderer="CircleItemRenderer" >'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'

					
						+'<Line2DSeries labelPosition="up" yField="sensor7" form="curve" displayName="sensor7" itemRenderer="CircleItemRenderer" >'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
					
					
						+'<Line2DSeries labelPosition="up" yField="sensor8" form="curve" displayName="sensor8" itemRenderer="CircleItemRenderer" >'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
						
						+'<Line2DSeries labelPosition="up" yField="sensor9" form="curve" displayName="sensor9" itemRenderer="CircleItemRenderer" >'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
	
						
						+'<Line2DSeries labelPosition="up" yField="sensor10" form="curve" displayName="sensor10" itemRenderer="CircleItemRenderer" >'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'						
						
					+'</series>'
				+'</Line2DChart>'
			+'</rMateChart>';
var layoutStr7 = '<rMateChart backgroundColor="#FFFFFF"  borderStyle="none">'
	+'<Options>'
		+'<SubCaption text="Smoke" textAlign="center" />'
		+'<Legend defaultMouseOverAction="false" useVisibleCheck="true"/>'
	+'</Options>'
	+'<Line2DChart showDataTips="true" paddingTop="0">'
		+'<horizontalAxis>'
			+'<CategoryAxis categoryField="time" padding="0.2"/> '
		+'</horizontalAxis>'
		+'<verticalAxis>'
			+'<LinearAxis maximum="100" interval="10"/>'
		+'</verticalAxis>'
		+'<series>'
		
			+'<Line2DSeries labelPosition="up" yField="sensor0" form="curve" displayName="sensor0" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="sensor1" form="curve" displayName="sensor1" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="sensor2" form="curve" displayName="sensor2" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="sensor3" form="curve" displayName="sensor3" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="sensor4" form="curve" displayName="sensor4" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="sensor5" form="curve" displayName="sensor5" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="sensor6" form="curve" displayName="sensor6" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

		
			+'<Line2DSeries labelPosition="up" yField="sensor7" form="curve" displayName="sensor7" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="sensor8" form="curve" displayName="sensor8" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="sensor9" form="curve" displayName="sensor9" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="sensor10" form="curve" displayName="sensor10" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'						
			
		+'</series>'
	+'</Line2DChart>'
+'</rMateChart>';

var layoutStr8 = '<rMateChart backgroundColor="#FFFFFF"  borderStyle="none">'
	+'<Options>'
		+'<SubCaption text="Fire" textAlign="center" />'
		+'<Legend defaultMouseOverAction="false" useVisibleCheck="true"/>'
	+'</Options>'
	+'<Line2DChart showDataTips="true" paddingTop="0">'
		+'<horizontalAxis>'
			+'<CategoryAxis categoryField="time" padding="0.2"/> '
		+'</horizontalAxis>'
		+'<verticalAxis>'
			+'<LinearAxis maximum="100" interval="10"/>'
		+'</verticalAxis>'
		+'<series>'
		
			+'<Line2DSeries labelPosition="up" yField="sensor0" form="curve" displayName="sensor0" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="sensor1" form="curve" displayName="sensor1" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="sensor2" form="curve" displayName="sensor2" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="sensor3" form="curve" displayName="sensor3" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="sensor4" form="curve" displayName="sensor4" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="sensor5" form="curve" displayName="sensor5" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="sensor6" form="curve" displayName="sensor6" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

		
			+'<Line2DSeries labelPosition="up" yField="sensor7" form="curve" displayName="sensor7" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="sensor8" form="curve" displayName="sensor8" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="sensor9" form="curve" displayName="sensor9" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="sensor10" form="curve" displayName="sensor10" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'						
			
		+'</series>'
	+'</Line2DChart>'
+'</rMateChart>';

var layoutStr9 = '<rMateChart backgroundColor="#FFFFFF"  borderStyle="none">'
	+'<Options>'
		+'<SubCaption text="Gyro" textAlign="center" />'
		+'<Legend defaultMouseOverAction="false" useVisibleCheck="true"/>'
	+'</Options>'
	+'<Line2DChart showDataTips="true" paddingTop="0">'
		+'<horizontalAxis>'
			+'<CategoryAxis categoryField="time" padding="0.2"/> '
		+'</horizontalAxis>'
		+'<verticalAxis>'
			+'<LinearAxis maximum="100" interval="10"/>'
		+'</verticalAxis>'
		+'<series>'
		
			+'<Line2DSeries labelPosition="up" yField="sensor0" form="curve" displayName="sensor0" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="sensor1" form="curve" displayName="sensor1" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="sensor2" form="curve" displayName="sensor2" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="sensor3" form="curve" displayName="sensor3" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="sensor4" form="curve" displayName="sensor4" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="sensor5" form="curve" displayName="sensor5" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="sensor6" form="curve" displayName="sensor6" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

		
			+'<Line2DSeries labelPosition="up" yField="sensor7" form="curve" displayName="sensor7" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="sensor8" form="curve" displayName="sensor8" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="sensor9" form="curve" displayName="sensor9" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="sensor10" form="curve" displayName="sensor10" itemRenderer="CircleItemRenderer" >'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'						
			
		+'</series>'
	+'</Line2DChart>'
+'</rMateChart>';

var chartData3 =[{"time":"00:00:00","sensor0":20,"sensor1":10,"sensor2":30,"sensor3":20,"sensor4":10,"sensor5":30,"sensor6":20,"sensor7":10,"sensor8":30,"sensor9":20,"sensor10":30,"sensor9":20},
	{"time":"00:00:05","sensor0":20,"sensor1":10,"sensor2":30,"sensor3":20,"sensor4":10,"sensor5":30,"sensor6":20,"sensor7":10,"sensor8":30,"sensor9":20,"sensor10":30,"sensor9":20},
	{"time":"00:00:10","sensor0":20,"sensor1":10,"sensor2":30,"sensor3":20,"sensor4":10,"sensor5":30,"sensor6":20,"sensor7":10,"sensor8":30,"sensor9":20,"sensor10":30,"sensor9":20},
	{"time":"00:00:15","sensor0":20,"sensor1":10,"sensor2":30,"sensor3":20,"sensor4":10,"sensor5":30,"sensor6":20,"sensor7":10,"sensor8":30,"sensor9":20,"sensor10":30,"sensor9":20},
	{"time":"00:00:20","sensor0":20,"sensor1":10,"sensor2":30,"sensor3":20,"sensor4":10,"sensor5":30,"sensor6":20,"sensor7":10,"sensor8":30,"sensor9":20,"sensor10":30,"sensor9":20},
	{"time":"00:00:25","sensor0":20,"sensor1":10,"sensor2":30,"sensor3":20,"sensor4":10,"sensor5":30,"sensor6":20,"sensor7":10,"sensor8":30,"sensor9":20,"sensor10":30,"sensor9":20},
	{"time":"00:00:30","sensor0":20,"sensor1":10,"sensor2":30,"sensor3":20,"sensor4":10,"sensor5":30,"sensor6":20,"sensor7":10,"sensor8":30,"sensor9":20,"sensor10":30,"sensor9":20},
	{"time":"00:00:35","sensor0":20,"sensor1":10,"sensor2":30,"sensor3":20,"sensor4":10,"sensor5":30,"sensor6":20,"sensor7":10,"sensor8":30,"sensor9":20,"sensor10":30,"sensor9":20},
	{"time":"00:00:40","sensor0":20,"sensor1":10,"sensor2":30,"sensor3":20,"sensor4":10,"sensor5":30,"sensor6":20,"sensor7":10,"sensor8":30,"sensor9":20,"sensor10":30,"sensor9":20},
	{"time":"00:00:45","sensor0":20,"sensor1":10,"sensor2":30,"sensor3":20,"sensor4":10,"sensor5":30,"sensor6":20,"sensor7":10,"sensor8":30,"sensor9":20,"sensor10":30,"sensor9":20},
	{"time":"00:00:50","sensor0":20,"sensor1":10,"sensor2":30,"sensor3":20,"sensor4":10,"sensor5":30,"sensor6":20,"sensor7":10,"sensor8":30,"sensor9":20,"sensor10":30,"sensor9":20},
	{"time":"00:00:55","sensor0":20,"sensor1":10,"sensor2":30,"sensor3":20,"sensor4":10,"sensor5":30,"sensor6":20,"sensor7":10,"sensor8":30,"sensor9":20,"sensor10":30,"sensor9":20}];

rMateChartH5.registerTheme(rMateChartH5.themes);

function rMateChartH5ChangeTheme(theme){
	document.getElementById("chart1").setTheme(theme);
}

