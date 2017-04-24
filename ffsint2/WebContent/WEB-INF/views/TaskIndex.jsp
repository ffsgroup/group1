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
                $(function () {
                    $("#tabs").tabs();
                });
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
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:200px; width:200px;'> </td> <td style='min-width:220px; width:220px;'> </td > <td style='min-width:130px; width:130px;'> </td> <td style='min-width:130px; width:130px;'> </td> <td style='min-width:90px; width:90px;'> </td> <td style='min-width:130px; width:130px;'> </td></tr>");
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
                            } else
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
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:200px; width:200px;'> </td> <td style='min-width:220px; width:220px;'> </td > <td style='min-width:130px; width:130px;'> </td> <td style='min-width:130px; width:130px;'> </td> <td style='min-width:90px; width:90px;'> </td> <td style='min-width:130px; width:130px;'> </td></tr>");
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
                            } else
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
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:200px; width:200px;'> </td> <td style='min-width:220px; width:220px;'> </td > <td style='min-width:130px; width:130px;'> </td> <td style='min-width:130px; width:130px;'> </td> <td style='min-width:90px; width:90px;'> </td> <td style='min-width:130px; width:130px;'> </td></tr>");
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
                            } else
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
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:200px; width:200px;'> </td> <td style='min-width:220px; width:220px;'> </td > <td style='min-width:130px; width:130px;'> </td> <td style='min-width:130px; width:130px;'> </td> <td style='min-width:90px; width:90px;'> </td> <td style='min-width:130px; width:130px;'> </td></tr>");
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
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:200px; width:200px;'> </td> <td style='min-width:220px; width:220px;'> </td > <td style='min-width:130px; width:130px;'> </td> <td style='min-width:130px; width:130px;'> </td> <td style='min-width:90px; width:90px;'> </td> <td style='min-width:130px; width:130px;'> </td></tr>");
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
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:200px; width:200px;'> </td> <td style='min-width:220px; width:220px;'> </td > <td style='min-width:130px; width:130px;'> </td> <td style='min-width:130px; width:130px;'> </td> <td style='min-width:90px; width:90px;'> </td> <td style='min-width:130px; width:130px;'> </td></tr>");
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
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:200px; width:200px;'> </td> <td style='min-width:220px; width:220px;'> </td > <td style='min-width:130px; width:130px;'> </td> <td style='min-width:130px; width:130px;'> </td> <td style='min-width:90px; width:90px;'> </td> <td style='min-width:130px; width:130px;'> </td></tr>");
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
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:200px; width:200px;'> </td> <td style='min-width:220px; width:220px;'> </td > <td style='min-width:130px; width:130px;'> </td> <td style='min-width:130px; width:130px;'> </td> <td style='min-width:90px; width:90px;'> </td> <td style='min-width:130px; width:130px;'> </td></tr>");
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
                                    var rowNew = $("   <tr> <td style='min-width:50px; width:50px;'></td> <td style='min-width:200px; width:200px;'> </td> <td style='min-width:220px; width:220px;'> </td > <td style='min-width:130px; width:130px;'> </td> <td style='min-width:130px; width:130px;'> </td> <td style='min-width:90px; width:90px;'> </td> <td style='min-width:130px; width:130px;'> </td></tr>");
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

            <div class="container">
                <div id="content">

                    <div class="post">
                        
                    </div>

                    <div id="login-box" class="login-popup" style="width:40%; height:620px " >
                        <a href="#" class="close"><img src="close_pop.png" class="btn_close" title="Close Window" alt="Close" /></a>
                        <form method="post" class="signin" action="#">

                            <div id="tabs" style="width:98%;  height:599px; float:right;">
                                <ul>
                                    <li><a href="#tabs-1">Details</a></li>
                                    <li><a href="#tabs-2">Notes</a></li>
                                    <li><a href="#tabs-3">People</a></li>
                                    <li><a href="#tabs-4">Images</a></li>
                                </ul>

                                <div id="tabs-1">
                                    <p>
                                    <div style="float: Left; text-align: left;">
                                        Task :  <label id="TaskId"/>0</label>
                                    </div>     
                                    <br>
                                    <label id="TaskFromLabel" style="float:left">Task From :</label>
                                    <select name="FromUser" id = "FromUser1" style=" margin-left: 50px; width: 180px" >
                                        <option value="" </option>
                                    </select>
                                    <select name="FromUser2" id = "FromUser3" style=" margin-left: 40px; width: 180px" >
                                        <option value="" </option>
                                    </select>
                                    <br>
                                    <div style="float: right; text-align: right; margin-right:50px;">
                                        Task Created :  <label id="TaskCreated"/>06/04/2017 3:15:32PM</label>
                                    </div> 
                                    <br/>
                                    Task Summary :<label> <input type="text" id="Tasksumm" style="margin-left:15px" /> </label> 
                                    <br>
                                    IR Nr : <label> <input type="text" id="IRNr" style="width: 60px; margin-left:83px" /> </label> 
                                    <input type="checkbox" id="RequestIR" value="ReqIR">Request IR Nr
                                    <br>
                                    <label><input type="checkbox" id="RecurTask" value="Recur" onclick="selectOnlyThis(this.id)">Recurrence</label>
                                    <br>
                                    <label><input type="checkbox" id="RecurTask" value="Recur" onclick="selectOnlyThis(this.id)">Every Day</label>
                                    <label><input type="checkbox" id="RecurTask" value="Recur" onclick="selectOnlyThis(this.id)">Day</label>
                                    <label> <input type="text" id="RecurMonth" style="width:35px;" /> of every month.</label> 
                                    <label><input type="checkbox" id="RecurTask" value="Recur" onclick="selectOnlyThis(this.id)">Weekly</label>
                                    <br>
                                    <label><input type="checkbox" id="RecurTask" value="Recur" onclick="selectOnlyThis(this.id)">Every Weekday</label>
                                    <label><input type="checkbox" id="RecurTask" value="Recur" onclick="selectOnlyThis(this.id)">last day of every month</label>
                                    <label><input type="checkbox" id="RecurTask" value="Recur" onclick="selectOnlyThis(this.id)">Monthly</label>
                                    <br>
                                    <label><input type="checkbox" id="RecurTask" value="Recur" onclick="selectOnlyThis(this.id)">Every Day Except Sunday</label>
                                    <label><input type="checkbox" id="RecurTask" value="Recur" onclick="selectOnlyThis(this.id)">Every</label>
                                    <select name="RecurDay" id = "RecurDay1" style=" margin-left: 10px; width: 80px;" >
                                        <option value="" </option>
                                    </select>
                                    <br>
                                    <label><input type="checkbox" id="RecurTask" value="Recur" onclick="selectOnlyThis(this.id)">Every</label>
                                    <label> <input type="text" id="RecurMonth" style="width:55px;" /> Months</label> 
                                    <br>
                                    <label> <textarea name="notes" id="tasknotes" cols="60" rows="5" ></textarea> </label>    
                                    <br>
                                    <label id="linkedTasks" style="color:blue; float: right; text-align: right; margin-right:100px;"/>Linked Tasks</label>
                              
                                    Start Date :<label> <input type="text" id = "startdate" style="margin-left:27px; position: relative; z-index:99 !important;"/> </label> 
                                    <br> 
                                    Review Date :<label> <input type="text" id = "Reviewdate" style="margin-left:10px"/> </label>
                                    <br>
                                    End Date :<label> <input type="text" id = "enddate" style="margin-left:32px"/> </label>
                                        <script>
                                        var myCalendar1 = new dhtmlXCalendarObject(["startdate"]);
                                        myCalendar1.setDateFormat("%Y/%m/%d %H:%i");
                                    </script>
                                    <script>
                                        var myCalendar2 = new dhtmlXCalendarObject(["Reviewdate"]);
                                        myCalendar2.setDateFormat("%Y/%m/%d %H:%i");
                                    </script>
                                    <script>
                                        var myCalendar2 = new dhtmlXCalendarObject(["enddate"]);
                                        myCalendar2.setDateFormat("%Y/%m/%d %H:%i");
                                    </script>
                                    <br>
                                    <label id="Priority" style="float:left; ">Priority :</label>
                                    <select name="Priority" id = "Priority1" style=" width: 100px; margin-left:50px;" >
                                        <option value="" </option>
                                    </select>
                                    <label id="TaskDate" style=" margin-left:30px;"/>06/04/2017 3:15:32PM</label>
                                    <br>
                                      <label id="Status" style="float:left; ">Status :</label>
                                    <select name="Status" id = "Status1" style=" width: 100px; margin-left:55px;" >
                                        <option value="" </option>
                                    </select>
                                   
                                  
                                    <input type ="button" value ="Save" id="Tasksave" style="width:75px; float:right;"/>

                                    </p>
                                </div>
                        </form>
                    </div>

                </div>
            </div>

            <div style="margin-bottom: 20px;">
            </div>
            <div id="calendarHere" style="position:relative;height:320px; float:right;margin-right: 250px"></div>

            <a id="tablediv" href="#login-box" class="login-window" >

                <table cellspacing="0" id="countrytable" margin-right:20px > 
                    <thead>
                        <tr> 
                            <th style="min-width:50px; width:50px;" scope="col">ID</th> 
                            <th style="min-width:200px; width:200px;" scope="col">To</th> 
                            <th style="min-width:220px; width:220px;"scope="col">Description</th> 
                            <th style="min-width:130px; width:130px;" scope="col">Review Date</th> 
                            <th style="min-width:130px; width:130px;" scope="col">End Date</th> 
                            <th style="min-width:90px; width:90px;"scope="col">Status</th> 
                            <th style="min-width:130px; width:130px;" scope="col">Start Date</th> 
                        </tr>
                    </thead>      
                    <tbody>
                    <p style="color: red;">${errorString}</p>

                </tbody>

            </table>
        </a>

        <br>
        <br>
        <br>
        <script>
            $('table').on('scroll', function () {
                $("table > *").width($("table").width() + $("table").scrollLeft());
            });
        </script>

        <script type="text/javascript">
            $(document).ready(function () {
                $('a.login-window').click(function () {

                    // Getting the variable's value from a link 
                    var loginBox = $(this).attr('href');

                    //Fade in the Popup and add close button
                    $(loginBox).fadeIn(300);

                    //Set the center alignment padding + border
                    var popMargTop = ($(loginBox).height() + 24) / 2;
                    var popMargLeft = ($(loginBox).width() + 24) / 2;

                    $(loginBox).css({
                        'margin-top': -popMargTop,
                        'margin-left': -popMargLeft
                    });

                    // Add the mask to body
                    $('body').append('<div id="mask"></div>');
                    $('#mask').fadeIn(300);
                    // update diary settings
                    var count = $("#dsee1 option").length;
                    if (count.valueOf() < 3) {

                    }





                    return false;

                });

                // When clicking on the button close or the mask layer the popup closed
                $('a.close, #mask').click(function () {
                    $('#mask , .login-popup').fadeOut(300, function () {
                        $('#mask').remove();
                    });
                    return false;
                });

                $('#diarySettClose').click(function () {
                    $('#mask , .login-popup').fadeOut(300, function () {
                        $('#mask').remove();
                    });
                    return false;
                });
            });
        </script>











    </body>
    <jsp:include page="_footer.jsp"></jsp:include>
</html>
