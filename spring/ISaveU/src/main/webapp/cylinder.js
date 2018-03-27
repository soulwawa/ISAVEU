var chartVars1 = "rMateOnLoadCallFunction=chartReadyHandler1";
var chartVars2 = "rMateOnLoadCallFunction=chartReadyHandler2";
 
rMateChartH5.create("chart1", "chartHolder1", chartVars1, "80%", "80%");
rMateChartH5.create("chart2", "chartHolder2", chartVars2, "80%", "80%");

function chartReadyHandler1(id) {
	document.getElementById(id).setLayout(layoutStr1);
	document.getElementById(id).setData(chartData1);
}

function chartReadyHandler2(id) {
	document.getElementById(id).setLayout(layoutStr2);
	document.getElementById(id).setData(chartData2);
} 
var layoutStr1 = 
                '<rMateChart backgroundColor="#FFFFFF"  horizontalAlign="center" verticalAlign="middle" borderStyle="none">'
                  +'<CurrencyFormatter id="cft" currencySymbol="%" alignSymbol="right"/>'
                   +'<VCylinderGauge width="150" height="350" minimum="0" maximum="200" '
                   +'labels="[0,5,10,15,20,25,30,35,40,45,50]" tickInterval="5" value="25" '
                  +'cylinderColor="[#ff842e,#ffd44a,#ff842e]" cylinderAlpha="[1,1,1]" cylinderRatio="[0,100,255]" '
                   +'targetMark="120" snapInterval="1" labelJsFunction="labelFunc" valueLabelStyleName="valueLabel" valueChangeFunction="changeFunction"/>'
                 +'<Style>'
                        +'.valueLabel{fontSize:11;fontWeight:bold;}'
                    +'</Style>'
               +'</rMateChart>';
var layoutStr2 = 
			    '<rMateChart backgroundColor="#FFFFFF"  horizontalAlign="center" verticalAlign="middle" borderStyle="none">'
			      +'<CurrencyFormatter id="cft" currencySymbol="%" alignSymbol="right"/>'
			       +'<VCylinderGauge width="150" height="350" minimum="0" maximum="200" '
			       +'labels="[-20,-10,0,10,20,30,40,50,60,70,80]" tickInterval="10" value="25" '
			      +'cylinderColor="[#ff842e,#ffd44a,#ff842e]" cylinderAlpha="[1,1,1]" cylinderRatio="[0,100,255]" '
			       +'targetMark="120" snapInterval="1" labelJsFunction="labelFunc" valueLabelStyleName="valueLabel" valueChangeFunction="changeFunction"/>'
			     +'<Style>'
			            +'.valueLabel{fontSize:11;fontWeight:bold;}'
			        +'</Style>'
			   +'</rMateChart>';
 
var chartData1 = [20];
var chartData2 = [40];
 
function changeValue1()
{
 document.getElementById("chart1").setData([parseInt(Math.random()*200)]);
}
function changeValue2()
{
 document.getElementById("chart2").setData([parseInt(Math.random()*200)]);
}

var gaugeValue1, gaugeValue2;
 
function changeFunction1(value)
{
 gaugeValue1 = value;
}

function changeFunction2(value)
{
 gaugeValue2 = value;
}
 
function commitValue()
{
    alert(gaugeValue1 + "," + gaugeValue2);
}
 
function labelFunc(value)
{
   return value+"'C";
}
   
rMateChartH5.registerTheme(rMateChartH5.themes);
 
function rMateChartH5ChangeTheme(theme){
    document.getElementById("chart1").setTheme(theme);
}
 