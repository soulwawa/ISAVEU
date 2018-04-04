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

var chartData3 =   [{"time":"00:00:00","sensor0":5,"sensor1":10,"sensor2":15,"sensor3":20,"sensor4":25,"sensor5":30,"sensor6":35,"sensor7":40,"sensor8":45,"sensor9":50,"sensor10":55},
					{"time":"00:00:05","sensor0":10,"sensor1":15,"sensor2":20,"sensor3":25,"sensor4":30,"sensor5":35,"sensor6":40,"sensor7":45,"sensor8":50,"sensor9":55,"sensor10":60},
					{"time":"00:00:10","sensor0":15,"sensor1":20,"sensor2":25,"sensor3":30,"sensor4":35,"sensor5":40,"sensor6":45,"sensor7":50,"sensor8":55,"sensor9":60,"sensor10":55},
					{"time":"00:00:15","sensor0":20,"sensor1":25,"sensor2":30,"sensor3":35,"sensor4":40,"sensor5":45,"sensor6":50,"sensor7":55,"sensor8":60,"sensor9":55,"sensor10":50},
					{"time":"00:00:20","sensor0":25,"sensor1":30,"sensor2":35,"sensor3":40,"sensor4":45,"sensor5":50,"sensor6":55,"sensor7":60,"sensor8":55,"sensor9":50,"sensor10":45},
					{"time":"00:00:25","sensor0":30,"sensor1":35,"sensor2":40,"sensor3":45,"sensor4":50,"sensor5":55,"sensor6":60,"sensor7":55,"sensor8":50,"sensor9":45,"sensor10":40},
					{"time":"00:00:30","sensor0":35,"sensor1":40,"sensor2":45,"sensor3":50,"sensor4":55,"sensor5":60,"sensor6":55,"sensor7":50,"sensor8":45,"sensor9":40,"sensor10":35},
					{"time":"00:00:35","sensor0":40,"sensor1":45,"sensor2":50,"sensor3":55,"sensor4":60,"sensor5":55,"sensor6":50,"sensor7":45,"sensor8":40,"sensor9":35,"sensor10":30},
					{"time":"00:00:40","sensor0":45,"sensor1":50,"sensor2":55,"sensor3":60,"sensor4":55,"sensor5":50,"sensor6":45,"sensor7":40,"sensor8":35,"sensor9":30,"sensor10":25},
					{"time":"00:00:45","sensor0":50,"sensor1":55,"sensor2":60,"sensor3":55,"sensor4":50,"sensor5":45,"sensor6":40,"sensor7":35,"sensor8":30,"sensor9":25,"sensor10":20},
					{"time":"00:00:50","sensor0":55,"sensor1":60,"sensor2":55,"sensor3":50,"sensor4":45,"sensor5":40,"sensor6":35,"sensor7":30,"sensor8":25,"sensor9":20,"sensor10":15},
					{"time":"00:00:55","sensor0":60,"sensor1":55,"sensor2":50,"sensor3":45,"sensor4":40,"sensor5":35,"sensor6":30,"sensor7":25,"sensor8":20,"sensor9":15,"sensor10":10}];

rMateChartH5.registerTheme(rMateChartH5.themes);

function rMateChartH5ChangeTheme(theme){
	document.getElementById("chart1").setTheme(theme);
}

