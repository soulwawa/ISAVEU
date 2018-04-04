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
						+'<LinearAxis minimum="28" maximum="30" interval="0.2"/>'
					+'</verticalAxis>'
					+'<series>'
					
						+'<Line2DSeries labelPosition="up" yField="0" form="curve" displayName="0" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'

						
						+'<Line2DSeries labelPosition="up" yField="1" form="curve" displayName="1" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
					
					
						+'<Line2DSeries labelPosition="up" yField="2" form="curve" displayName="2" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
						
						+'<Line2DSeries labelPosition="up" yField="3" form="curve" displayName="3" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
	
						
						+'<Line2DSeries labelPosition="up" yField="4" form="curve" displayName="4" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
					
					
						+'<Line2DSeries labelPosition="up" yField="5" form="curve" displayName="5" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
						
						+'<Line2DSeries labelPosition="up" yField="6" form="curve" displayName="6" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'

					
						+'<Line2DSeries labelPosition="up" yField="7" form="curve" displayName="7" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
					
					
						+'<Line2DSeries labelPosition="up" yField="8" form="curve" displayName="8" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
						
						+'<Line2DSeries labelPosition="up" yField="9" form="curve" displayName="9" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
							+'<showDataEffect>'
								+'<SeriesInterpolate duration="1000"/> '
							+'</showDataEffect>'
						+'</Line2DSeries>'
	
						
						+'<Line2DSeries labelPosition="up" yField="10" form="curve" displayName="10" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
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
		
			+'<Line2DSeries labelPosition="up" yField="0" form="curve" displayName="0" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="1" form="curve" displayName="1" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="2" form="curve" displayName="2" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="3" form="curve" displayName="3" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="4" form="curve" displayName="4" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="5" form="curve" displayName="5" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="6" form="curve" displayName="6" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

		
			+'<Line2DSeries labelPosition="up" yField="7" form="curve" displayName="7" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="8" form="curve" displayName="8" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="9" form="curve" displayName="9" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="10" form="curve" displayName="10" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
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
		
			+'<Line2DSeries labelPosition="up" yField="0" form="curve" displayName="0" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="1" form="curve" displayName="1" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="2" form="curve" displayName="2" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="3" form="curve" displayName="3" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="4" form="curve" displayName="4" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="5" form="curve" displayName="5" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="6" form="curve" displayName="6" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

		
			+'<Line2DSeries labelPosition="up" yField="7" form="curve" displayName="7" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="8" form="curve" displayName="8" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="9" form="curve" displayName="9" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="10" form="curve" displayName="10" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
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
		
			+'<Line2DSeries labelPosition="up" yField="0" form="curve" displayName="0" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="1" form="curve" displayName="1" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="2" form="curve" displayName="2" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="3" form="curve" displayName="3" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="4" form="curve" displayName="4" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="5" form="curve" displayName="5" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="6" form="curve" displayName="6" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

		
			+'<Line2DSeries labelPosition="up" yField="7" form="curve" displayName="7" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
		
		
			+'<Line2DSeries labelPosition="up" yField="8" form="curve" displayName="8" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'
			
			+'<Line2DSeries labelPosition="up" yField="9" form="curve" displayName="9" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'

			
			+'<Line2DSeries labelPosition="up" yField="10" form="curve" displayName="10" itemRenderer="CircleItemRenderer" showValueLabels="[13]">'
				+'<showDataEffect>'
					+'<SeriesInterpolate duration="1000"/> '
				+'</showDataEffect>'
			+'</Line2DSeries>'						
			
		+'</series>'
	+'</Line2DChart>'
+'</rMateChart>';

var chartData3 =   [{"time":"00:00:00","0":5,"1":10,"2":15,"3":20,"4":25,"5":30,"6":35,"7":40,"8":45,"9":50,"10":55},
					{"time":"00:00:05","0":10,"1":15,"2":20,"3":25,"4":30,"5":35,"6":40,"7":45,"8":50,"9":55,"10":60},
					{"time":"00:00:10","0":15,"1":20,"2":25,"3":30,"4":35,"5":40,"6":45,"7":50,"8":55,"9":60,"10":55},
					{"time":"00:00:15","0":20,"1":25,"2":30,"3":35,"4":40,"5":45,"6":50,"7":55,"8":60,"9":55,"10":50},
					{"time":"00:00:20","0":25,"1":30,"2":35,"3":40,"4":45,"5":50,"6":55,"7":60,"8":55,"9":50,"10":45},
					{"time":"00:00:25","0":30,"1":35,"2":40,"3":45,"4":50,"5":55,"6":60,"7":55,"8":50,"9":45,"10":40},
					{"time":"00:00:30","0":35,"1":40,"2":45,"3":50,"4":55,"5":60,"6":55,"7":50,"8":45,"9":40,"10":35},
					{"time":"00:00:35","0":40,"1":45,"2":50,"3":55,"4":60,"5":55,"6":50,"7":45,"8":40,"9":35,"10":30},
					{"time":"00:00:40","0":45,"1":50,"2":55,"3":60,"4":55,"5":50,"6":45,"7":40,"8":35,"9":30,"10":25},
					{"time":"00:00:45","0":50,"1":55,"2":60,"3":55,"4":50,"5":45,"6":40,"7":35,"8":30,"9":25,"10":20},
					{"time":"00:00:50","0":55,"1":60,"2":55,"3":50,"4":45,"5":40,"6":35,"7":30,"8":25,"9":20,"10":15},
					{"time":"00:00:55","0":60,"1":55,"2":50,"3":45,"4":40,"5":35,"6":30,"7":25,"8":20,"9":15,"10":10}];

rMateChartH5.registerTheme(rMateChartH5.themes);

function rMateChartH5ChangeTheme(theme){
	document.getElementById("chart1").setTheme(theme);
}

