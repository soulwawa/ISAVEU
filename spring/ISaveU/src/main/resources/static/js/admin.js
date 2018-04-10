// -----------------------차트 설정 시작-----------------------
var chartVars10 = "rMateOnLoadCallFunction=chartReadyHandler10";
 
rMateChartH5.create("chart10", "chartHolder10", chartVars10, "100%", "100%"); 
rMateChartH5.create("chart11", "chartHolder11", chartVars10, "100%", "100%"); 
rMateChartH5.create("chart12", "chartHolder12", chartVars10, "100%", "100%"); 
rMateChartH5.create("chart13", "chartHolder13", chartVars10, "100%", "100%"); 
rMateChartH5.create("chart14", "chartHolder14", chartVars10, "100%", "100%"); 
rMateChartH5.create("chart15", "chartHolder15", chartVars10, "100%", "100%"); 
rMateChartH5.create("chart16", "chartHolder16", chartVars10, "100%", "100%"); 
rMateChartH5.create("chart17", "chartHolder17", chartVars10, "100%", "100%"); 
rMateChartH5.create("chart18", "chartHolder18", chartVars10, "100%", "100%"); 
rMateChartH5.create("chart19", "chartHolder19", chartVars10, "100%", "100%"); 
rMateChartH5.create("chart20", "chartHolder20", chartVars10, "100%", "100%"); 
 
function chartReadyHandler10(id) {
 document.getElementById(id).setLayout(layoutStr10);
   document.getElementById(id).setData(chartData10);
}
 
var layoutStr10 = '<rMateChart backgroundColor="#FFFFFF"  borderStyle="none">'
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
 
var chartData10 = [{"time":"00:00:00","temp":10,"smoke":30,"gyro":20,"fire":20},
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

function rMateChartH5ChangeTheme(theme){
   document.getElementById("chart1").setTheme(theme);
}
 
// -----------------------차트 설정 끝 -----------------------
$(window).on("load", function(){
	ss0();
}); 

function refresh() {
	for(var i = 10; i < 21; i ++ ){
		document.getElementById("chart"+i).resize();
		document.getElementById("chart"+i).resize();
		document.getElementById("chart"+i).resize();
		document.getElementById("chart"+i).resize();
		document.getElementById("chart"+i).resize();
	}
}

var show = 10;	
function ss0(){
	var a = 10;
	show = 10;
	 
	
	setTimeout(function(){
		document.getElementById("chartHolder10").style.width = 1480 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.height = 390 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.left = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.top = 5 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder11").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder12").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder13").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder14").style.width = 326+ "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.top = 407 + "px";
	},a+=2);
	

	setTimeout(function(){
		document.getElementById("chartHolder15").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder16").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder17").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder18").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder19").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder20").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.top = 617 + "px";
	},a+=2);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		document.getElementById("cover10").style.width = 1480+"px";
		document.getElementById("cover10").style.height = 390+"px";
		document.getElementById("cover10").style.width = 1480+"px";
		document.getElementById("cover10").style.height = 390+"px";
		document.getElementById("cover10").style.width = 1480+"px";
		document.getElementById("cover10").style.height = 390+"px";
		document.getElementById("cover10").style.display = "none";
		document.getElementById("cover10").style.display = "none";
		document.getElementById("cover10").style.display = "none";
	},a-50);
	
	refresh();
}

function ss1(){
	var a = 10;
	show = 11;
	 
	
	setTimeout(function(){
		document.getElementById("chartHolder11").style.width = 1480 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.height = 390 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.left = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.top = 5 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder10").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder12").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder13").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder14").style.width = 326+ "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.top = 407 + "px";
	},a+=2);
	

	setTimeout(function(){
		document.getElementById("chartHolder15").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder16").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder17").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder18").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder19").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder20").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.top = 617 + "px";
	},a+=2);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		document.getElementById("cover11").style.width = 1480+"px";
		document.getElementById("cover11").style.height = 390+"px";
		document.getElementById("cover11").style.width = 1480+"px";
		document.getElementById("cover11").style.height = 390+"px";
		document.getElementById("cover11").style.width = 1480+"px";
		document.getElementById("cover11").style.height = 390+"px";
		document.getElementById("cover11").style.display = "none";
		document.getElementById("cover11").style.display = "none";
		document.getElementById("cover11").style.display = "none";
	},a-50);
	refresh();
}
function ss2(){
	var a = 10;
	show = 12;
	
	setTimeout(function(){
		document.getElementById("chartHolder12").style.width = 1480 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.height = 390 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.left = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.top = 5 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder10").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder11").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder13").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder14").style.width = 326+ "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.top = 407 + "px";
	},a+=2);
	

	setTimeout(function(){
		document.getElementById("chartHolder15").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder16").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder17").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder18").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder19").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder20").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.top = 617 + "px";
	},a+=2);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		document.getElementById("cover12").style.width = 1480+"px";
		document.getElementById("cover12").style.height = 390+"px";
		document.getElementById("cover12").style.width = 1480+"px";
		document.getElementById("cover12").style.height = 390+"px";
		document.getElementById("cover12").style.width = 1480+"px";
		document.getElementById("cover12").style.height = 390+"px";
		document.getElementById("cover12").style.display = "none";
		document.getElementById("cover12").style.display = "none";
		document.getElementById("cover12").style.display = "none";
	},a-50);
	refresh();
}
function ss3(){
	var a = 10;
	show = 13;
	 
	
	setTimeout(function(){
		document.getElementById("chartHolder13").style.width = 1480 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.height = 390 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.left = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.top = 5 + "px";
	},a+=2);
	

	
	setTimeout(function(){
		document.getElementById("chartHolder10").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder11").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder12").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder14").style.width = 326+ "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.top = 407 + "px";
	},a+=2);
	

	setTimeout(function(){
		document.getElementById("chartHolder15").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder16").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder17").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder18").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder19").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder20").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.top = 617 + "px";
	},a+=2);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		document.getElementById("cover13").style.width = 1480+"px";
		document.getElementById("cover13").style.height = 390+"px";
		document.getElementById("cover13").style.width = 1480+"px";
		document.getElementById("cover13").style.height = 390+"px";
		document.getElementById("cover13").style.width = 1480+"px";
		document.getElementById("cover13").style.height = 390+"px";
		document.getElementById("cover13").style.display = "none";
		document.getElementById("cover13").style.display = "none";
		document.getElementById("cover13").style.display = "none";
	},a-50);
	refresh();
}
function ss4(){
	var a = 10;
	show = 14;
	 
	
	setTimeout(function(){
		document.getElementById("chartHolder14").style.width = 1480 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.height = 390 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.left = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.top = 5 + "px";
	},a+=2);
	

	
	setTimeout(function(){
		document.getElementById("chartHolder10").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder11").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder12").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder13").style.width = 326+ "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.top = 407 + "px";
	},a+=2);
	

	setTimeout(function(){
		document.getElementById("chartHolder15").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder16").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder17").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder18").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder19").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder20").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.top = 617 + "px";
	},a+=2);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		document.getElementById("cover14").style.width = 1480+"px";
		document.getElementById("cover14").style.height = 390+"px";
		document.getElementById("cover14").style.width = 1480+"px";
		document.getElementById("cover14").style.height = 390+"px";
		document.getElementById("cover14").style.width = 1480+"px";
		document.getElementById("cover14").style.height = 390+"px";
		document.getElementById("cover14").style.display = "none";
		document.getElementById("cover14").style.display = "none";
		document.getElementById("cover14").style.display = "none";
	},a-50);
	refresh();
}
function ss5(){
	var a = 10;
	show = 15;
	 
	
	setTimeout(function(){
		document.getElementById("chartHolder15").style.width = 1480 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.height = 390 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.left = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.top = 5 + "px";
	},a+=2);
	

	
	setTimeout(function(){
		document.getElementById("chartHolder10").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder11").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder12").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder13").style.width = 326+ "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.top = 407 + "px";
	},a+=2);
	

	setTimeout(function(){
		document.getElementById("chartHolder14").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder16").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder17").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder18").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder19").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder20").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.top = 617 + "px";
	},a+=2);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		document.getElementById("cover15").style.width = 1480+"px";
		document.getElementById("cover15").style.height = 390+"px";
		document.getElementById("cover15").style.width = 1480+"px";
		document.getElementById("cover15").style.height = 390+"px";
		document.getElementById("cover15").style.width = 1480+"px";
		document.getElementById("cover15").style.height = 390+"px";
		document.getElementById("cover15").style.display = "none";
		document.getElementById("cover15").style.display = "none";
		document.getElementById("cover15").style.display = "none";
	},a-50);
	refresh();
}
function ss6(){
	var a = 10;
	show = 16;
	 
	
	setTimeout(function(){
		document.getElementById("chartHolder16").style.width = 1480 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.height = 390 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.left = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.top = 5 + "px";
	},a+=2);
	

	
	setTimeout(function(){
		document.getElementById("chartHolder10").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder11").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder12").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder13").style.width = 326+ "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.top = 407 + "px";
	},a+=2);
	

	setTimeout(function(){
		document.getElementById("chartHolder14").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder15").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder17").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder18").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder19").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder20").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.top = 617 + "px";
	},a+=2);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		document.getElementById("cover16").style.width = 1480+"px";
		document.getElementById("cover16").style.height = 390+"px";
		document.getElementById("cover16").style.width = 1480+"px";
		document.getElementById("cover16").style.height = 390+"px";
		document.getElementById("cover16").style.width = 1480+"px";
		document.getElementById("cover16").style.height = 390+"px";
		document.getElementById("cover16").style.display = "none";
		document.getElementById("cover16").style.display = "none";
		document.getElementById("cover16").style.display = "none";
	},a-50);
	refresh();
}
function ss7(){
	var a = 10;
	show = 17;
	 
	
	setTimeout(function(){
		document.getElementById("chartHolder17").style.width = 1480 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.height = 390 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.left = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.top = 5 + "px";
	},a+=2);
	

	
	setTimeout(function(){
		document.getElementById("chartHolder10").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder11").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder12").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder13").style.width = 326+ "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.top = 407 + "px";
	},a+=2);
	

	setTimeout(function(){
		document.getElementById("chartHolder14").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder15").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder16").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder18").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder19").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder20").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.top = 617 + "px";
	},a+=2);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		document.getElementById("cover17").style.width = 1480+"px";
		document.getElementById("cover17").style.height = 390+"px";
		document.getElementById("cover17").style.width = 1480+"px";
		document.getElementById("cover17").style.height = 390+"px";
		document.getElementById("cover17").style.width = 1480+"px";
		document.getElementById("cover17").style.height = 390+"px";
		document.getElementById("cover17").style.display = "none";
		document.getElementById("cover17").style.display = "none";
		document.getElementById("cover17").style.display = "none";
	},a-50);
	refresh();
}
function ss8(){
	var a = 10;
	show = 18;
	 
	
	setTimeout(function(){
		document.getElementById("chartHolder18").style.width = 1480 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.height = 390 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.left = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.top = 5 + "px";
	},a+=2);
	

	
	setTimeout(function(){
		document.getElementById("chartHolder10").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder11").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder12").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder13").style.width = 326+ "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.top = 407 + "px";
	},a+=2);
	

	setTimeout(function(){
		document.getElementById("chartHolder14").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder15").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder16").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder17").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder19").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder20").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.top = 617 + "px";
	},a+=2);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		document.getElementById("cover18").style.width = 1480+"px";
		document.getElementById("cover18").style.height = 390+"px";
		document.getElementById("cover18").style.width = 1480+"px";
		document.getElementById("cover18").style.height = 390+"px";
		document.getElementById("cover18").style.width = 1480+"px";
		document.getElementById("cover18").style.height = 390+"px";
		document.getElementById("cover18").style.display = "none";
		document.getElementById("cover18").style.display = "none";
		document.getElementById("cover18").style.display = "none";
	},a-50);
	refresh();
}
function ss9(){
	var a = 10;
	show = 19;
	 
	
	setTimeout(function(){
		document.getElementById("chartHolder19").style.width = 1480 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.height = 390 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.left = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.top = 5 + "px";
	},a+=2);
	

	
	setTimeout(function(){
		document.getElementById("chartHolder10").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder11").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder12").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder13").style.width = 326+ "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.top = 407 + "px";
	},a+=2);
	

	setTimeout(function(){
		document.getElementById("chartHolder14").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder15").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder16").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder17").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder18").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder20").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.top = 617 + "px";
	},a+=2);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		document.getElementById("cover19").style.width = 1480+"px";
		document.getElementById("cover19").style.height = 390+"px";
		document.getElementById("cover19").style.width = 1480+"px";
		document.getElementById("cover19").style.height = 390+"px";
		document.getElementById("cover19").style.width = 1480+"px";
		document.getElementById("cover19").style.height = 390+"px";
		document.getElementById("cover19").style.display = "none";
		document.getElementById("cover19").style.display = "none";
		document.getElementById("cover19").style.display = "none";
	},a-50);
	refresh();
}
function ss10(){
	var a = 10;
	show = 20;
	 
	
	setTimeout(function(){
		document.getElementById("chartHolder20").style.width = 1480 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.height = 390 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.left = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder20").style.top = 5 + "px";
	},a+=2);
	

	
	setTimeout(function(){
		document.getElementById("chartHolder10").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder10").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder11").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder11").style.top = 407 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder12").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder12").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder13").style.width = 326+ "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder13").style.top = 407 + "px";
	},a+=2);
	

	setTimeout(function(){
		document.getElementById("chartHolder14").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder14").style.top = 407 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder15").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.left = 10 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder15").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder16").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.left = 346 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder16").style.top = 617 + "px";
	},a+=2);
	
	
	
	setTimeout(function(){
		document.getElementById("chartHolder17").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.left = 682 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder17").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder18").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.left = 1018 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder18").style.top = 617 + "px";
	},a+=2);
	
	
	setTimeout(function(){
		document.getElementById("chartHolder19").style.width = 326 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.height = 200 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.left = 1354 + "px";
	},a+=2);
	setTimeout(function(){
		document.getElementById("chartHolder19").style.top = 617 + "px";
	},a+=2);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var j = 0; j < 10; j++){
			for(var i = 10; i < 21; i++){
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
				document.getElementById("chart"+i).resize();
			}
		}
	},a+=20);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		for(var i = 10; i < 21; i ++ ){
			document.getElementById("cover"+i).style.width = 326+"px";
			document.getElementById("cover"+i).style.height = 200+"px";
			document.getElementById("cover"+i).style.display = "block";
		}
	},a-50);
	setTimeout(function(){
		document.getElementById("cover20").style.width = 1480+"px";
		document.getElementById("cover20").style.height = 390+"px";
		document.getElementById("cover20").style.width = 1480+"px";
		document.getElementById("cover20").style.height = 390+"px";
		document.getElementById("cover20").style.width = 1480+"px";
		document.getElementById("cover20").style.height = 390+"px";
		document.getElementById("cover20").style.display = "none";
		document.getElementById("cover20").style.display = "none";
		document.getElementById("cover20").style.display = "none";
	},a-50);
	refresh();
	document.getElementById("chart20").resize();
	document.getElementById("chart20").resize();
}