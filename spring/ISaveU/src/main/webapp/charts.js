// -----------------------차트 설정 시작-----------------------
 
/* 
rMateChartH5.create함수는 JQuery의 ready함수와 같은 용도로 사용할 수 있습니다.
차트 내부적으로 HTML Dom이 모두 완성되기까지 대기 하다가 Dom이 완료 되면 설정해두었던 readyHandler를 실행하게 됩니다.
ready함수에 rMateChartH5.create를 실행하여도 되지만 꼭 넣으실 필요는 없습니다. 
*/
$(document).ready(function(){
  $("#jqueryTabs").tabs();
    $("#jqueryTabs > ul").click(function(event){
     var i, a, as, content,
          tagName = event.target.tagName.toLowerCase();
       if(tagName == "a" || tagName == "li"){
          as = $("#jqueryTabs a");
            for(i = 0 ; i < as.length ; i += 1){
             a = as[i];
              $(a.parentNode).removeClass("li_select");
               content = a.innerHTML;
 
              if(content == event.target.innerHTML){
                  $(a.parentNode).addClass("li_select");
                   
                    /*
                  차트가 만들어졌는지 조사 아니라면 생성하기
                 탭안의 차트를 처음부터 만들지 않는 이유는 JQuery 탭 사용시 화면에 보여지지 않는 tab은 css속성 display가 none상태가 되어집니다.
                 display가 none인 상태인 경우는 Dom 요소들의 크기를 정확히 가져오지 못할 수 있습니다.
                 크기를 정확히 가져오지 못하면 차트 요소들 중 이상하게 출력되는 경우가 발생할 수 있습니다.
                 그로 인해 탭을 눌렀을 경우 차트가 생성이 되었는지 확인 후 create를 실행해주는 방향으로 설정하셔야 합니다.
                 */
                  if(!document.getElementById(content))
                       rMateChartH5.create(content, "chartHolder" + content.replace(/\D/g, ""), chartVars, "100%", "100%");
                }
           }
       }
   });
});
 
// rMate 차트 생성 준비가 완료된 상태 시 호출할 함수를 지정합니다.
var chartVars = "rMateOnLoadCallFunction=chartReadyHandler";
 
// rMateChart 를 생성합니다.
// 파라메터 (순서대로) 
//  1. 차트의 id ( 임의로 지정하십시오. ) 
//  2. 차트가 위치할 div 의 id (즉, 차트의 부모 div 의 id 입니다.)
//  3. 차트 생성 시 필요한 환경 변수들의 묶음인 chartVars
//  4. 차트의 가로 사이즈 (생략 가능, 생략 시 100%)
//  5. 차트의 세로 사이즈 (생략 가능, 생략 시 100%)
rMateChartH5.create("chart1", "chartHolder1", chartVars, "100%", "100%");
 
// 차트의 속성인 rMateOnLoadCallFunction 으로 설정된 함수.
// rMate 차트 준비가 완료된 경우 이 함수가 호출됩니다.
// 이 함수를 통해 차트에 레이아웃과 데이터를 삽입합니다.
// 파라메터 : id - rMateChartH5.create() 사용 시 사용자가 지정한 id 입니다.
function chartReadyHandler(id) {
    document.getElementById(id).setLayout(window["layoutStr" + id.replace(/\D/g, "")]);
 document.getElementById(id).setData(chartData);
 
 document.getElementById(id).resize();
}
 
// 스트링 형식으로 레이아웃 정의.
var layoutStr1 = 
 '<rMateChart backgroundColor="#FFFFFF"  borderStyle="none">'
      +'<Options>'
          +'<Caption text="Rainfall" />'
            +'<SubCaption text="( mm )" textAlign="right" />'
         +'<Legend />'
     +'</Options>'
     +'<Column2DChart showDataTips="true">'
            +'<horizontalAxis>'
               +'<CategoryAxis categoryField="Month" padding="0.5"/>'
           +'</horizontalAxis>'
          +'<series>'
               +'<Column2DSeries yField="Vancouver" displayName="Vancouver" labelPosition="inside" color="#FFFFFF">'
                 +'<showDataEffect>'
                       +'<SeriesInterpolate/>'
                  +'</showDataEffect>'
              +'</Column2DSeries>'
          +'</series>'
      +'</Column2DChart>'
   +'</rMateChart>';
 
var layoutStr2 = 
    '<rMateChart backgroundColor="#FFFFFF"  borderStyle="none">'
      +'<Options>'
          +'<Caption text="Rainfall" />'
            +'<SubCaption text="( mm )" textAlign="right" />'
         +'<Legend />'
     +'</Options>'
     +'<Bar2DChart showDataTips="true">'
           +'<verticalAxis>'
             +'<CategoryAxis categoryField="Month" padding="0.5"/>'
           +'</verticalAxis>'
            +'<series>'
               +'<Bar2DSeries xField="Vancouver" displayName="Vancouver" labelPosition="inside" color="#FFFFFF">'
                    +'<showDataEffect>'
                       +'<SeriesInterpolate/>'
                  +'</showDataEffect>'
              +'</Bar2DSeries>'
         +'</series>'
      +'</Bar2DChart>'
  +'</rMateChart>';
 
var layoutStr3 = 
    '<rMateChart backgroundColor="#FFFFFF"  borderStyle="none">'
      +'<Options>'
          +'<Caption text="Rainfall" />'
            +'<SubCaption text="( mm )" textAlign="right" />'
     +'</Options>'
     +'<Pie2DChart showDataTips="true" padding="20">'
          +'<series>'
               +'<Pie2DSeries field="Vancouver" nameField="Month" labelPosition="inside" color="#FFFFFF">'
                   +'<showDataEffect>'
                       +'<SeriesInterpolate/>'
                  +'</showDataEffect>'
              +'</Pie2DSeries>'
         +'</series>'
      +'</Pie2DChart>'
  +'</rMateChart>';
 
// 차트 데이터
var chartData = [{"Month":"Jan", "Vancouver":23},
               {"Month":"Feb", "Vancouver":33},
                {"Month":"Mar", "Vancouver":55},
                {"Month":"Apr", "Vancouver":48},
                {"Month":"May", "Vancouver":65},
                {"Month":"Jun", "Vancouver":83},
                {"Month":"Jul", "Vancouver":45},
                {"Month":"Aug", "Vancouver":38},
                {"Month":"Sep", "Vancouver":61},
                {"Month":"Oct", "Vancouver":42}];
 
/**
 * rMateChartH5 3.0이후 버전에서 제공하고 있는 테마기능을 사용하시려면 아래 내용을 설정하여 주십시오.
 * 테마 기능을 사용하지 않으시려면 아래 내용은 삭제 혹은 주석처리 하셔도 됩니다.
 *
 * -- _rMateChartH5Theme에 등록되어있는 테마 목록 --
 * - simple
 * - cyber
 * - modern
 * - lovely
 * - pastel
 * -------------------------------------------------
 *
 * _rMateChartH5Theme 변수는 theme.js에서 정의하고 있습니다.
 */
rMateChartH5.registerTheme(rMateChartH5.themes);
 
/**
 * 샘플 내의 테마 버튼 클릭 시 호출되는 함수입니다.
 * 접근하는 차트 객체의 테마를 변경합니다.
 * 파라메터로 넘어오는 값
 * - simple
 * - cyber
 * - modern
 * - lovely
 * - pastel
 * - default
 *
 * default : 테마를 적용하기 전 기본 형태를 출력합니다.
 */
function rMateChartH5ChangeTheme(theme){
 var chart,
      i = 0, n = 3;
   for( ; i < n ; i += 1){
      chart = document.getElementById("chart" + i);
       if(chart)
           chart.setTheme(theme);
  }
}
 
// -----------------------차트 설정 끝 -----------------------