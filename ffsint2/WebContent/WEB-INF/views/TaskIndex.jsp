<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <jsp:include page="_TaskHeader.jsp"></jsp:include>
        
   

            <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
            <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
            <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <style type="text/css">
                #mask {
                    display: none;
                    background: #000; 
                    position: fixed; left: 0; top: 0; 
                    z-index: 10;
                    width: 100%; height: 100%;
                    opacity: 0.8;
                    z-index: 999;
                }

                .login-popup{
                    display:none;
                    background: #fff;
                    padding: 10px; 	
                    border: 2px solid #ddd;
                    float: left;
                    font-size: 1.2em;
                    position: fixed;
                    top: 40%; left: 40%;
                    z-index: 99999;
                    box-shadow: 0px 0px 20px #999;
                    -moz-box-shadow: 0px 0px 20px #999; /* Firefox */
                    -webkit-box-shadow: 0px 0px 20px #999; /* Safari, Chrome */
                    border-radius:3px 3px 3px 3px;
                    -moz-border-radius: 3px; /* Firefox */
                    -webkit-border-radius: 3px; /* Safari, Chrome */
                }

                img.btn_close {
                    float: right; 
                    margin: -20px -20px 0 0;
                }

                fieldset { 
                    border:none; 
                }

                form.signin .textbox label { 
                    display:block; 
                    padding-bottom:7px; 
                }

                form.signin .textbox span { 
                    display:block;
                }
                form.signin input:-moz-placeholder { color:#bbb; text-shadow:0 0 2px #000; }
                form.signin input::-webkit-input-placeholder { color:#bbb; text-shadow:0 0 2px #000;  }

            </style> 
            
<style type="text/css">
html {
    font-family: verdana;
    font-size: 10pt;
    line-height: 25px;
}
table {
    border-collapse: collapse;
    width: 50%;
    overflow-x: scroll;
    display: block;
}
thead {
    background-color: #EFEFEF;
}
thead, tbody {
    display: block;
}
td, th {
    min-width: 100px;
    height: 25px;
    border: dashed 1px lightblue;
}
tbody {
    overflow-y: scroll;
    overflow-x: hidden;
    height: 45%;
}
</style> 
            
            <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
            <style type="text/css">
                table, td, th
                {
                    border:1px solid black;
                    width:60%;

                    font-family: 'Oxygen', sans-serif;
                }
                th
                {
                    background-color:white;
                    color:black;
                }
                body
                {
                    text-align: left;
                }
                .container
                {
                    margin-left: auto;
                    margin-right: 20px;

                }
                h4
                {
                    font-family: 'Oxygen', sans-serif;
                    color:#1E90FF;
                }
            </style>
                      

            <script src="resources/dhtmlxcalendar.js"></script>
            <link rel="stylesheet" type="text/css" href="resources/dhtmlxcalendar_1.css"/>
           
 <script>
                var myCalendar;
                function doOnLoad() {
                    myCalendar = new dhtmlXCalendarObject("calendarHere");
                    //		myCalendar.setSkin("material");
                    myCalendar.setDate(new Date(2016, 7, 7, 16, 0));
                    myCalendar.show();
                    myCalendar.hideTime();
                    myCalendar.showToday();
                    myCalendar.setHolidays(["2012-04-28", "2012-05-09", "2012-05-01", "2012-05-27", "2012-05-21", "2012-05-28", "2012-06-03", "2012-06-04"]);
                    //  myCalendar.setInsensitiveRange(null, "2012-05-04");
                    myCalendar._drawMonth(new Date(2016, 7, 1));
                    myCalendar.attachEvent("onClick", function (side, d) {
                        //	writeLog("onClick event called, "+side+" calendar, date "+myCalendar.getFormatedDate(null,d));


                    });
                }
            </script>
            <script>
                
                
           
                 $(document).ready(function () {
                    $("#TrainingTasks").click(function (event) {
                        document.getElementById("ToMeInProg").checked = false;
                         document.getElementById("ByMeInProg").checked = false;
                         document.getElementById("NewTask").checked = false;
                         document.getElementById("TaskInFuture").checked = false;
                         document.getElementById("ByMeComp").checked = false;
                         document.getElementById("ToMeComp").checked = false;
                         document.getElementById("UpdatedTasks").checked = false;
                         document.getElementById("UrgentTasks").checked = false;
                        $.get('TrainingTask', function (responseJson) {
                            $("#countrytable").find("tr:gt(0)").remove();
                            if (responseJson != null) {
                                
                                var table1 = $("#countrytable");
                                $.each(responseJson, function (key, value) {
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:120px; width:120px;'> </td> <td style='min-width:150px; width:150px;'> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>");
                                    rowNew.children().eq(0).text(value['tranid']);
                                    rowNew.children().eq(1).text(value['taskfrom']);
                                    rowNew.children().eq(2).text(value['description']);
                                    rowNew.children().eq(3).text(value['revdate']);
                                    rowNew.children().eq(4).text(value['enddate']);
                                    rowNew.children().eq(5).text(value['taskstat']);
                                rowNew.children().eq(6).text(value['startdate']);
                                    rowNew.appendTo(table1);
                                });
                                document.getElementsById("countrytable")[0].style.width = '20px';
                            }
                            else
                            {
                                  var rowNew = $("   <tr> <td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>");
                                    rowNew.children().eq(0).text("No Entries Found!")
                                    rowNew.appendTo(table1);
                            }
                        });
                    });
                });
                
                
                
                 $(document).ready(function () {
                    $("#UrgentTasks").click(function (event) {
                        document.getElementById("ToMeInProg").checked = false;
                         document.getElementById("ByMeInProg").checked = false;
                         document.getElementById("NewTask").checked = false;
                         document.getElementById("TaskInFuture").checked = false;
                         document.getElementById("ByMeComp").checked = false;
                         document.getElementById("ToMeComp").checked = false;
                         document.getElementById("UpdatedTasks").checked = false;
                         document.getElementById("TrainingTasks").checked = false;
                        $.get('UrgentTasks', function (responseJson) {
                            $("#countrytable").find("tr:gt(0)").remove();
                            if (responseJson != null) {
                                
                                var table1 = $("#countrytable");
                                $.each(responseJson, function (key, value) {
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:120px; width:120px;'> </td> <td style='min-width:150px; width:150px;'> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>");
                                    rowNew.children().eq(0).text(value['tranid']);
                                    rowNew.children().eq(1).text(value['taskfrom']);
                                    rowNew.children().eq(2).text(value['description']);
                                    rowNew.children().eq(3).text(value['revdate']);
                                    rowNew.children().eq(4).text(value['enddate']);
                                    rowNew.children().eq(5).text(value['taskstat']);
                                rowNew.children().eq(6).text(value['startdate']);
                                    rowNew.appendTo(table1);
                                });
                                document.getElementsById("countrytable")[0].style.width = '20px';
                            }
                            else
                            {
                                  var rowNew = $("   <tr> <td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>");
                                    rowNew.children().eq(0).text("No Entries Found!")
                                    rowNew.appendTo(table1);
                            }
                        });
                    });
                });
                
                
                
                 $(document).ready(function () {
                    $("#UpdatedTasks").click(function (event) {
                        document.getElementById("ToMeInProg").checked = false;
                         document.getElementById("ByMeInProg").checked = false;
                         document.getElementById("NewTask").checked = false;
                         document.getElementById("TaskInFuture").checked = false;
                         document.getElementById("ByMeComp").checked = false;
                         document.getElementById("ToMeComp").checked = false;
                         document.getElementById("UrgentTasks").checked = false;
                         document.getElementById("TrainingTasks").checked = false;
                        $.get('UpdatedTasks', function (responseJson) {
                                $("#countrytable").find("tr:gt(0)").remove();
                            if (responseJson != null) {
                            
                                var table1 = $("#countrytable");
                                $.each(responseJson, function (key, value) {
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:120px; width:120px;'> </td> <td style='min-width:150px; width:150px;'> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>");
                                    rowNew.children().eq(0).text(value['tranid']);
                                    rowNew.children().eq(1).text(value['taskfrom']);
                                    rowNew.children().eq(2).text(value['description']);
                                    rowNew.children().eq(3).text(value['revdate']);
                                    rowNew.children().eq(4).text(value['enddate']);
                                    rowNew.children().eq(5).text(value['taskstat']);
                                rowNew.children().eq(6).text(value['startdate']);
                                    rowNew.appendTo(table1);
                                });
                                document.getElementsById("countrytable")[0].style.width = '20px';
                            }
                            else
                                 {
                                  var rowNew = $("   <tr> <td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>");
                                    rowNew.children().eq(0).text("No Entries Found!")
                                    rowNew.appendTo(table1);
                            }
                        });
                    });
                });
                
                
                
                $(document).ready(function () {
                    $("#ToMeComp").click(function (event) {
                         document.getElementById("ToMeInProg").checked = false;
                         document.getElementById("ByMeInProg").checked = false;
                         document.getElementById("NewTask").checked = false;
                         document.getElementById("TaskInFuture").checked = false;
                         document.getElementById("ByMeComp").checked = false;
                         document.getElementById("UpdatedTasks").checked = false;
                         document.getElementById("UrgentTasks").checked = false;
                         document.getElementById("TrainingTasks").checked = false;
                        $.get('TaskToMeComp', function (responseJson) {
                               $("#countrytable").find("tr:gt(0)").remove();
                            if (responseJson != null) {
                             
                                var table1 = $("#countrytable");
                                $.each(responseJson, function (key, value) {
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:120px; width:120px;'> </td> <td style='min-width:150px; width:150px;'> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>");
                                    rowNew.children().eq(0).text(value['tranid']);
                                    rowNew.children().eq(1).text(value['taskfrom']);
                                    rowNew.children().eq(2).text(value['description']);
                                    rowNew.children().eq(3).text(value['revdate']);
                                    rowNew.children().eq(4).text(value['enddate']);
                                    rowNew.children().eq(5).text(value['taskstat']);
                                rowNew.children().eq(6).text(value['startdate']);
                                    rowNew.appendTo(table1);
                                });
                                document.getElementsById("countrytable")[0].style.width = '20px';
                            }
                        });
                    });
                });
                
                
                
                  $(document).ready(function () {
                    $("#NewTask").click(function (event) {
                        document.getElementById("ToMeInProg").checked = false;
                         document.getElementById("ByMeInProg").checked = false;
                         document.getElementById("ToMeComp").checked = false;
                         document.getElementById("TaskInFuture").checked = false;
                         document.getElementById("ByMeComp").checked = false;
                         document.getElementById("UpdatedTasks").checked = false;
                         document.getElementById("UrgentTasks").checked = false;
                         document.getElementById("TrainingTasks").checked = false;
                        $.get('NewTask', function (responseJson) {
                                $("#countrytable").find("tr:gt(0)").remove();
                            if (responseJson != null) {
                            
                                var table1 = $("#countrytable");
                                $.each(responseJson, function (key, value) {
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:120px; width:120px;'> </td> <td style='min-width:150px; width:150px;'> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>");
                                    rowNew.children().eq(0).text(value['tranid']);
                                    rowNew.children().eq(1).text(value['taskfrom']);
                                    rowNew.children().eq(2).text(value['description']);
                                    rowNew.children().eq(3).text(value['revdate']);
                                    rowNew.children().eq(4).text(value['enddate']);
                                    rowNew.children().eq(5).text(value['taskstat']);
                                rowNew.children().eq(6).text(value['startdate']);
                                    rowNew.appendTo(table1);
                                });
                                document.getElementsById("countrytable")[0].style.width = '20px';
                            }
                        });
                    });
                });
                
                
                
                $(document).ready(function () {
                    $("#ByMeComp").click(function (event) {
                        document.getElementById("ToMeInProg").checked = false;
                         document.getElementById("ByMeInProg").checked = false;
                         document.getElementById("ToMeComp").checked = false;
                         document.getElementById("TaskInFuture").checked = false;
                         document.getElementById("NewTask").checked = false;
                         document.getElementById("UpdatedTasks").checked = false;
                         document.getElementById("UrgentTasks").checked = false;
                         document.getElementById("TrainingTasks").checked = false;
                        $.get('TaskByMeComp', function (responseJson) {
                               $("#countrytable").find("tr:gt(0)").remove();
                            if (responseJson != null) {
                             
                                var table1 = $("#countrytable");
                                $.each(responseJson, function (key, value) {
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:120px; width:120px;'> </td> <td style='min-width:150px; width:150px;'> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>");
                                    rowNew.children().eq(0).text(value['tranid']);
                                    rowNew.children().eq(1).text(value['taskfrom']);
                                    rowNew.children().eq(2).text(value['description']);
                                    rowNew.children().eq(3).text(value['revdate']);
                                    rowNew.children().eq(4).text(value['enddate']);
                                    rowNew.children().eq(5).text(value['taskstat']);
                                rowNew.children().eq(6).text(value['startdate']);
                                    rowNew.appendTo(table1);
                                });
                                document.getElementsById("countrytable")[0].style.width = '20px';
                            }
                        });
                    });
                });
                
                
                 $(document).ready(function () {
                    $("#TaskInFuture").click(function (event) {
                        document.getElementById("ToMeInProg").checked = false;
                         document.getElementById("ByMeInProg").checked = false;
                         document.getElementById("ToMeComp").checked = false;
                         document.getElementById("ByMeComp").checked = false;
                         document.getElementById("NewTask").checked = false;
                         document.getElementById("UpdatedTasks").checked = false;
                         document.getElementById("UrgentTasks").checked = false;
                         document.getElementById("TrainingTasks").checked = false;
                        $.get('TaskInFuture', function (responseJson) {
                              $("#countrytable").find("tr:gt(0)").remove();
                            if (responseJson != null) {
                              
                                var table1 = $("#countrytable");
                                $.each(responseJson, function (key, value) {
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:120px; width:120px;'> </td> <td style='min-width:150px; width:150px;'> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>");
                                    rowNew.children().eq(0).text(value['tranid']);
                                    rowNew.children().eq(1).text(value['taskfrom']);
                                    rowNew.children().eq(2).text(value['description']);
                                    rowNew.children().eq(3).text(value['revdate']);
                                    rowNew.children().eq(4).text(value['enddate']);
                                    rowNew.children().eq(5).text(value['taskstat']);
                                rowNew.children().eq(6).text(value['startdate']);
                                    rowNew.appendTo(table1);
                                });
                                document.getElementsById("countrytable")[0].style.width = '20px';
                            }
                        });
                    });
                });
                
                
                
                 $(document).ready(function () {
                    $("#ByMeInProg").click(function (event) {
                        document.getElementById("ToMeInProg").checked = false;
                         document.getElementById("TaskInFuture").checked = false;
                         document.getElementById("ToMeComp").checked = false;
                         document.getElementById("ByMeComp").checked = false;
                         document.getElementById("NewTask").checked = false;
                         document.getElementById("UpdatedTasks").checked = false;
                         document.getElementById("UrgentTasks").checked = false;
                         document.getElementById("TrainingTasks").checked = false;
                        $.get('TaskByMe', function (responseJson) {
                               $("#countrytable").find("tr:gt(0)").remove();
                            if (responseJson != null) {
                             
                                var table1 = $("#countrytable");
                                $.each(responseJson, function (key, value) {
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:120px; width:120px;'> </td> <td style='min-width:150px; width:150px;'> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>");
                                    rowNew.children().eq(0).text(value['tranid']);
                                    rowNew.children().eq(1).text(value['taskfrom']);
                                    rowNew.children().eq(2).text(value['description']);
                                    rowNew.children().eq(3).text(value['revdate']);
                                    rowNew.children().eq(4).text(value['enddate']);
                                    rowNew.children().eq(5).text(value['taskstat']);
                                rowNew.children().eq(6).text(value['startdate']);
                                    rowNew.appendTo(table1);
                                });
                                document.getElementsById("countrytable")[0].style.width = '20px';
                            }
                        });
                    });
                });
                
                
                $(document).ready(function () {
                    $("#ToMeInProg").click(function (event) {
                         document.getElementById("ByMeInProg").checked = false;
                         document.getElementById("TaskInFuture").checked = false;
                         document.getElementById("ToMeComp").checked = false;
                         document.getElementById("ByMeComp").checked = false;
                         document.getElementById("NewTask").checked = false;
                         document.getElementById("UpdatedTasks").checked = false;
                         document.getElementById("UrgentTasks").checked = false;
                         document.getElementById("TrainingTasks").checked = false;
                        $.get('TaskServlet', function (responseJson) {
                             $("#countrytable").find("tr:gt(0)").remove();
                            if (responseJson != null) {
                               
                                var table1 = $("#countrytable");
                                $.each(responseJson, function (key, value) {
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:120px; width:120px;'> </td> <td style='min-width:150px; width:150px;'> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>");
                                    rowNew.children().eq(0).text(value['tranid']);
                                    rowNew.children().eq(1).text(value['taskfrom']);
                                    rowNew.children().eq(2).text(value['description']);
                                    rowNew.children().eq(3).text(value['revdate']);
                                    rowNew.children().eq(4).text(value['enddate']);
                                    rowNew.children().eq(5).text(value['taskstat']);
                                    rowNew.children().eq(6).text(value['startdate']);
                                    rowNew.appendTo(table1);
                                });
                                document.getElementsById("countrytable")[0].style.width = '20px';
                            }
                        });
                    });
                });
                
                
                
                
            </script>
           


            

        </head>

        <body onload="doOnLoad();" class="container">
            <h2></h2>
             <b>Tasks In Progress :</b><input type="checkbox" id="ToMeInProg" value="ToMe" onclick="selectOnlyThis(this.id)">Assigned To Me
                               <input type="checkbox" id="ByMeInProg" value="ByMe" onclick="selectOnlyThis(this.id)">Assigned By Me
                               <input type="checkbox" id="TaskInFuture" value="InFuture" onclick="selectOnlyThis(this.id)">Tasks In The Future<br>
             <b>Tasks Completed :</b><input type="checkbox" id="ToMeComp" value="CompToMe"onclick="selectOnlyThis(this.id)">Assigned To Me
                               <input type="checkbox" id="ByMeComp" value="CompByMe"onclick="selectOnlyThis(this.id)" >Assigned By Me<br>
                               <input type="checkbox" id="NewTask" value="ByMe" onclick="selectOnlyThis(this.id)">New Tasks
                               <input type="checkbox" id="UpdatedTasks" value="ToMe" onclick="selectOnlyThis(this.id)">Updated Tasks
                               <input type="checkbox" id="UrgentTasks" value="ByMe" onclick="selectOnlyThis(this.id)">Urgent Tasks
                               <input type="checkbox" id="TrainingTasks" value="ToMe"onclick="selectOnlyThis(this.id)">Training Tasks
                            
                               
        
        <div style="margin-bottom: 20px;">
        </div>
        <div id="calendarHere" style="position:relative;height:320px; float:right;margin-right: 250px"></div>

        <div id="tablediv">

            <table cellspacing="0" id="countrytable" margin-right:20px > 
<thead>
                <tr> 
                    <th style="min-width:50px; width:50px;" scope="col">ID</th> 
                    <th style="min-width:120px; width:120px;" scope="col">To</th> 
                    <th style="min-width:150px; width:150px;"scope="col">Description</th> 
                    <th scope="col">Review Date</th> 
                    <th scope="col">End Date</th> 
                    <th scope="col">Status</th> 
                    <th scope="col">Start Date</th> 
                </tr>
           </thead>      
           <tbody>
                <p style="color: red;">${errorString}</p>
<!--                <tr>  <td>11111 </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                <tr> <td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
               <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                 <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                 <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                  <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                  <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                  <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                 <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                 <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                 <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                 <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                  <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                  <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                 <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
                  <tr><td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td>
                  
                  </tr>-->
           </tbody>

            </table>
        </div>
        <br>
        <br>
        <br>
        <br>
<script>
 $('table').on('scroll', function () {
    $("table > *").width($("table").width() + $("table").scrollLeft());
});
    </script>
  
            
    
    
        


        


    


    </body>
    <jsp:include page="_footer.jsp"></jsp:include>
</html>
