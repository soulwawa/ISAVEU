var chartVars = "rMateOnLoadCallFunction=chartReadyHandler";

rMateChartH5.create("chart1", "chartHolder1", chartVars, "35%", "100%");
rMateChartH5.create("chart2", "chartHolder2", chartVars, "35%", "100%");
rMateChartH5.create("chart3", "chartHolder3", chartVars, "35%", "100%");
rMateChartH5.create("chart4", "chartHolder4", chartVars, "35%", "100%");

function chartReadyHandler(id) {
	var num = id.replace(/\D/g, "");
	document.getElementById(id).setLayout(window["layoutStr" + num]);
	document.getElementById(id).setData(chartData1);
}
var layoutStr1 = 
	 '<rMateChart backgroundColor="#ffffff" marginTop="25" marginBottom="25" horizontalAlign="center" verticalScrollPolicy="off" verticalAlign="middle"  borderStyle="none">'
    +'<CurrencyFormatter id="cmt" precision="0" currencySymbol="\'C" alignSymbol="right"/>'
  +'<HLinearGauge backgroundColor="#ffffff" width="500" height="100" minimum="0" maximum="50" labels="[0,10,20,30,40,50]" tickInterval="10" formatter="{cmt}" targetMark="40" '
     +'targetMarkColor="[#ff0000,#ff0000,#ff0000]" targetMarkAlpha="[1,1,1]" targetMarkRatio="[0,125,255]" targetMarkThickness="3" targetMarkBorderColor="#ff0000" '
  +'linearAlpha="[1,1,1]" linearColor="[#1bcfc6,#34d9d5,#1a97d1]" linearRatio="[0,90,255]" linearBorderColor="#1a97d1" labelJsFunction="labelFunc1" '
   +'linearBgAlpha="[1,1,1]" linearBgColor="[#555555,#555555,#555555]" linearBgRatio="[0,125,255]" '
    +'valueLabelStyleName="valueLabel" valueChangeFunction="changeFunction1"/>'
   +'<Style>'
         +'.valueLabel{fontSize:20;color:0xffffff;fontWeight:bold;}'
  +'</Style>'
+'</rMateChart>';
var layoutStr2 = 
	 '<rMateChart backgroundColor="#ffffff" marginTop="25" marginBottom="25" horizontalAlign="center" verticalScrollPolicy="off" verticalAlign="middle"  borderStyle="none">'
    +'<CurrencyFormatter id="cmt" precision="0" currencySymbol="!" alignSymbol="right"/>'
  +'<HLinearGauge backgroundColor="#ffffff" width="500" height="100" minimum="100" maximum="600" labels="[100,200,300,400,500,600]" tickInterval="100" formatter="{cmt}" targetMark="450" '
     +'targetMarkColor="[#ff0000,#ff0000,#ff0000]" targetMarkAlpha="[1,1,1]" targetMarkRatio="[0,125,255]" targetMarkThickness="3" targetMarkBorderColor="#ff0000" '
  +'linearAlpha="[1,1,1]" linearColor="[#72db2b,#cef747,#2dba1a]" linearRatio="[0,90,255]" linearBorderColor="#2dba1a" labelJsFunction="labelFunc2" '
   +'linearBgAlpha="[1,1,1]" linearBgColor="[#555555,#555555,#555555]" linearBgRatio="[0,125,255]" '
    +'valueLabelStyleName="valueLabel" valueChangeFunction="changeFunction2"/>'
   +'<Style>'
         +'.valueLabel{fontSize:20;color:0xffffff;fontWeight:bold;}'
  +'</Style>'
+'</rMateChart>';
var layoutStr3 = 
	 '<rMateChart backgroundColor="#ffffff" marginTop="25" marginBottom="25" horizontalAlign="center" verticalScrollPolicy="off" verticalAlign="middle"  borderStyle="none">'
    +'<CurrencyFormatter id="cmt" precision="0" currencySymbol="@" alignSymbol="right"/>'
  +'<HLinearGauge backgroundColor="#ffffff" width="500" height="100" minimum="0" maximum="1600" labels="[0,200,400,600,800,1000,1200,1400,1600]" tickInterval="200" formatter="{cmt}" targetMark="1200" '
     +'targetMarkColor="[#ff0000,#ff0000,#ff0000]" targetMarkAlpha="[1,1,1]" targetMarkRatio="[0,125,255]" targetMarkThickness="3" targetMarkBorderColor="#ff0000" '
  +'linearAlpha="[1,1,1]" linearColor="[#ba1b9d,#cf1bb0,#8318d1]" linearRatio="[0,90,255]" linearBorderColor="#8318d1" labelJsFunction="labelFunc3" '
   +'linearBgAlpha="[1,1,1]" linearBgColor="[#555555,#555555,#555555]" linearBgRatio="[0,125,255]" '
    +'valueLabelStyleName="valueLabel" valueChangeFunction="changeFunction3"/>'
   +'<Style>'
         +'.valueLabel{fontSize:20;color:0xffffff;fontWeight:bold;}'
  +'</Style>'
+'</rMateChart>';
var layoutStr4 = 
	 '<rMateChart backgroundColor="#ffffff" marginTop="25" marginBottom="25" horizontalAlign="center" verticalScrollPolicy="off" verticalAlign="middle"  borderStyle="none">'
   +'<CurrencyFormatter id="cmt" precision="0" currencySymbol="@" alignSymbol="right"/>'
 +'<HLinearGauge backgroundColor="#ffffff" width="500" height="100" minimum="0" maximum="1600" labels="[0,200,400,600,800,1000,1200,1400,1600]" tickInterval="200" formatter="{cmt}" targetMark="1200" '
    +'targetMarkColor="[#ff0000,#ff0000,#ff0000]" targetMarkAlpha="[1,1,1]" targetMarkRatio="[0,125,255]" targetMarkThickness="3" targetMarkBorderColor="#ff0000" '
 +'linearAlpha="[1,1,1]" linearColor="[#ff8800,#ffa354,#c14315]" linearRatio="[0,90,255]" linearBorderColor="#c14315" labelJsFunction="labelFunc4" '
  +'linearBgAlpha="[1,1,1]" linearBgColor="[#555555,#555555,#555555]" linearBgRatio="[0,125,255]" '
   +'valueLabelStyleName="valueLabel" valueChangeFunction="changeFunction4"/>'
  +'<Style>'
        +'.valueLabel{fontSize:20;color:0xffffff;fontWeight:bold;}'
 +'</Style>'
+'</rMateChart>';
var chartData1 = [37];

function changeValue(){
	document.getElementById("chart1").setData([parseInt(Math.random()*100)]);
	document.getElementById("chart2").setData([parseInt(Math.random()*100)]);
	document.getElementById("chart3").setData([parseInt(Math.random()*100)]);
	document.getElementById("chart4").setData([parseInt(Math.random()*100)]);
}

var gaugeValue1, gaugeValue2, gaugeValue3, gaugeValue4;

function changeFunction1(value){
	gaugeValue1 = value;
}

function changeFunction2(value){
	gaugeValue2 = value;
}

function changeFunction3(value){
	gaugeValue3 = value;
}

function changeFunction4(value){
	gaugeValue4 = value;
}

function commitValue(){
	alert("chart1 : " + gaugeValue1 + "\nchart2 : " + gaugeValue2 + "\nchart3 : " + gaugeValue3+ "\nchart4 : " + gaugeValue4);
}

function labelFunc1(value){
	return value+"\'C";
}
function labelFunc2(value){
	return value+"%";
}
function labelFunc3(value){
	return value+"#";
}
function labelFunc4(value){
	return value+"#";
}

rMateChartH5.registerTheme(rMateChartH5.themes);

function rMateChartH5ChangeTheme(theme){
	document.getElementById("chart1").setTheme(theme);
}