<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String root = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!--  Fullcalendar 차트 -->
<link href='https://use.fontawesome.com/releases/v5.0.6/css/all.css'
	rel='stylesheet'>
<link href='<%=root%>/css/fullcalendar.min.css' rel='stylesheet' />
<link href='<%=root%>/css/fullcalendar.print.min.css' rel='stylesheet'
	media='print' />
<script src='<%=root%>/js/moment.min.js'></script>
<script src='<%=root%>/js/jquery.min.js'></script>
<script src='<%=root%>/js/fullcalendar.min.js'></script>
<script src='<%=root%>/js/theme-chooser.js'></script>

<script>

  $(document).ready(function() {

    initThemeChooser({

      init: function(themeSystem) {
        $('#calendar').fullCalendar({
          themeSystem: themeSystem,
          header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listMonth'
          },
          defaultDate: '2018-03-12',
          weekNumbers: true,
          navLinks: true, // can click day/week names to navigate views
          editable: true,
          eventLimit: true, // allow "more" link when too many events
          events: [
            {
              title: 'All Day Event',
              start: '2018-03-01'
            },
            {
              title: 'Long Event',
              start: '2018-03-07',
              end: '2018-03-10'
            },
            {
              id: 999,
              title: 'Repeating Event',
              start: '2018-03-09T16:00:00'
            },
            {
              id: 999,
              title: 'Repeating Event',
              start: '2018-03-16T16:00:00'
            },
            {
              title: 'Conference',
              start: '2018-03-11',
              end: '2018-03-13'
            },
            {
              title: 'Meeting',
              start: '2018-03-12T10:30:00',
              end: '2018-03-12T12:30:00'
            },
            {
              title: 'Lunch',
              start: '2018-03-12T12:00:00'
            },
            {
              title: 'Meeting',
              start: '2018-03-12T14:30:00'
            },
            {
              title: 'Happy Hour',
              start: '2018-03-12T17:30:00'
            },
            {
              title: 'Dinner',
              start: '2018-03-12T20:00:00'
            },
            {
              title: 'Birthday Party',
              start: '2018-03-13T07:00:00'
            },
            {
              title: 'Click for Google',
              url: 'http://google.com/',
              start: '2018-03-28'
            }
          ]
        });
      },

      change: function(themeSystem) {
        $('#calendar').fullCalendar('option', 'themeSystem', themeSystem);
      }

    });

  });

</script>

<style>
body {
	margin: 0;
	padding: 0;
	font-size: 14px;
}

#top, #calendar.fc-unthemed {
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
}

#top {
	background: #eee;
	border-bottom: 1px solid #ddd;
	padding: 0 10px;
	line-height: 40px;
	font-size: 12px;
	color: #000;
}

#top .selector {
	display: inline-block;
	margin-right: 10px;
}

#top select {
	font: inherit; /* mock what Boostrap does, don't compete  */
}

.left {
	float: left
}

.right {
	float: right
}

.clear {
	clear: both
}

#calendar {
	max-width: 900px;
	margin: 40px auto;
	padding: 0 10px;
}
</style>

<!--  Fullcalendar 차트 -->
<title>Schedule</title>
</head>
<body>
	<div class="wrapper">
		<div class="alert" id="art">
			화재 발생
			<div id="fireBtn" onclick="closeAlert()">위치확인</div>
		</div>
		<div class="location" id="lct" onclick="closeLocation()">
			<div id="fire">
				<div id="exts1">
					<div class="shake-freeze" id="ex0">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex1">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex2">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex3">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex4">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex5">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex6">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex7">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex8">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex9">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex10">
						<img src="./img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
				</div>
			</div>
		</div>
		<div class="header">
			<div class="case" onclick="goReplace('/admin')">
				<img src="<%=root%>/img/logo1.png" alt="logo" class="logo" />
			</div>
		</div>
		<div class="sidebar">
			<div class="menuBtn">
				<button type="button" class="btn btn-default btn-lg btn-block"
					onclick="goReplace('/sensor')">
					<span class="glyphicon glyphicon-tasks"></span> Sensor Log
				</button>
			</div>
			<div class="menuBtn">
				<button type="button" class="btn btn-default btn-lg btn-block"
					onclick="goReplace('/event')">
					<span class="glyphicon glyphicon-alert"></span> Envent Log
				</button>
			</div>
			<div class="menuBtn">
				<button type="button" class="btn btn-default btn-lg btn-block"
					onclick="goReplace('/stream')">
					<span class="glyphicon glyphicon-play-circle"></span> Striming
				</button>
			</div>
			<div class="menuBtn">
				<button type="button" class="btn btn-default btn-lg btn-block"
					onclick="goReplace('/hr')">
					<span class="glyphicon glyphicon-user"></span> H.R
				</button>
			</div>
			<div class="menuBtn">
				<button type="button" class="btn btn-default btn-lg btn-block"
					onclick="goReplace('/ex')">
					<span class="glyphicon glyphicon-map-marker"></span> Map
				</button>
			</div>
			<input type="button" value="불내기" onclick="showAlert()" />
		</div>
		<div class="contents">
		<div id='top'>
<div id='calendar'></div>
			<!-- 
			<div class='left'>

				<div id='theme-system-selector' class='selector'>
					Theme System: <select>
						<option value='bootstrap4' selected>Bootstrap 4</option>
						<option value='bootstrap3'>Bootstrap 3</option>
						<option value='jquery-ui'>jQuery UI</option>
						<option value='standard'>unthemed</option>
					</select>
				</div>

				<div data-theme-system="bootstrap3" class='selector'
					style='display: none'>
					Theme Name: <select>
						<option value='' selected>Default</option>
						<option value='cosmo'>Cosmo</option>
						<option value='cyborg'>Cyborg</option>
						<option value='darkly'>Darkly</option>
						<option value='flatly'>Flatly</option>
						<option value='journal'>Journal</option>
						<option value='lumen'>Lumen</option>
						<option value='paper'>Paper</option>
						<option value='readable'>Readable</option>
						<option value='sandstone'>Sandstone</option>
						<option value='simplex'>Simplex</option>
						<option value='slate'>Slate</option>
						<option value='solar'>Solar</option>
						<option value='spacelab'>Spacelab</option>
						<option value='superhero'>Superhero</option>
						<option value='united'>United</option>
						<option value='yeti'>Yeti</option>
					</select>
				</div>

				<div data-theme-system="bootstrap4" class='selector'
					style='display: none'>
					Theme Name: <select>
						<option value='' selected>Default</option>
						<option value='cerulean'>Cerulean</option>
						<option value='cosmo'>Cosmo</option>
						<option value='cyborg'>Cyborg</option>
						<option value='darkly'>Darkly</option>
						<option value='flatly'>Flatly</option>
						<option value='journal'>Journal</option>
						<option value='litera'>Litera</option>
						<option value='lumen'>Lumen</option>
						<option value='lux'>Lux</option>
						<option value='materia'>Materia</option>
						<option value='minty'>Minty</option>
						<option value='pulse'>Pulse</option>
						<option value='sandstone'>Sandstone</option>
						<option value='simplex'>Simplex</option>
						<option value='sketchy'>Sketchy</option>
						<option value='slate'>Slate</option>
						<option value='solar'>Solar</option>
						<option value='spacelab'>Spacelab</option>
						<option value='superhero'>Superhero</option>
						<option value='united'>United</option>
						<option value='yeti'>Yeti</option>
					</select>
				</div>

				<div data-theme-system="jquery-ui" class='selector'
					style='display: none'>
					Theme Name: <select>
						<option value='black-tie'>Black Tie</option>
						<option value='blitzer'>Blitzer</option>
						<option value='cupertino' selected>Cupertino</option>
						<option value='dark-hive'>Dark Hive</option>
						<option value='dot-luv'>Dot Luv</option>
						<option value='eggplant'>Eggplant</option>
						<option value='excite-bike'>Excite Bike</option>
						<option value='flick'>Flick</option>
						<option value='hot-sneaks'>Hot Sneaks</option>
						<option value='humanity'>Humanity</option>
						<option value='le-frog'>Le Frog</option>
						<option value='mint-choc'>Mint Choc</option>
						<option value='overcast'>Overcast</option>
						<option value='pepper-grinder'>Pepper Grinder</option>
						<option value='redmond'>Redmond</option>
						<option value='smoothness'>Smoothness</option>
						<option value='south-street'>South Street</option>
						<option value='start'>Start</option>
						<option value='sunny'>Sunny</option>
						<option value='swanky-purse'>Swanky Purse</option>
						<option value='trontastic'>Trontastic</option>
						<option value='ui-darkness'>UI Darkness</option>
						<option value='ui-lightness'>UI Lightness</option>
						<option value='vader'>Vader</option>
					</select>
				</div>

				<span id='loading' style='display: none'>loading theme...</span>

			</div>
 			-->
			<div class='right'>
				<span class='credits' data-credit-id='bootstrap-standard'
					style='display: none'> <a
					href='https://getbootstrap.com/docs/3.3/' target='_blank'>Theme
						by Bootstrap</a>
				</span> <span class='credits' data-credit-id='bootstrap-custom'
					style='display: none'> <a href='https://bootswatch.com/'
					target='_blank'>Theme by Bootswatch</a>
				</span> <span class='credits' data-credit-id='jquery-ui'
					style='display: none'> <a
					href='http://jqueryui.com/themeroller/' target='_blank'>Theme
						by jQuery UI</a>
				</span>
			</div>

			<div class='clear'></div>
		</div>
</div>
		


		<div class="footer">
			<div style="padding: 7px;">Copyright © 2018 HSB Inc.</div>
		</div>
	</div>
</body>
</html>