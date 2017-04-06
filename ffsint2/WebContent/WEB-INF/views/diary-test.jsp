
<html>
<head>


<link rel="stylesheet" type="text/css" href="dhtmlxcalendar.css"/>
	
<script src="dhtmlxcalendar.js"></script>
	<script>
		var myCalendar;
		function doOnLoad() {
			myCalendar = new dhtmlXCalendarObject("calendarHere");
			myCalendar.setSkin("material");
			myCalendar.setDate(new Date(2012,4,17));
			myCalendar.show();
			myCalendar.setHolidays(["2012-04-28","2012-05-09","2012-05-01","2012-05-27","2012-05-21","2012-05-28","2012-06-03","2012-06-04"]);
			myCalendar.setInsensitiveRange(null,"2012-05-04");
			myCalendar._drawMonth(new Date(2012,4,1));
		}
	</script>

</head>
<body onload="doOnLoad();">
	<div style="margin-bottom: 20px;">
	</div>
	<div id="calendarHere" style="position:relative;height:320px;"></div>
</body>
</html>