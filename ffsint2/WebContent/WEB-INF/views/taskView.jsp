<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="true" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Task Details</title>
        <jsp:include page="_TaskViewHeader.jsp"></jsp:include>
            <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
            <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
            <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
            <script src="resources/dhtmlxcalendar.js"></script>
            <link rel="stylesheet" type="text/css" href="resources/dhtmlxcalendar_1.css"/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Task</title>
            <script>
                $(document).ready(function () {
                    $("#sendemail").click(function (event) {
                        $.get('TaskSendEmail', {tranid: document.getElementById("taskid").innerHTML, mailto: document.getElementById("mailto").value, mailcontent: document.getElementById("mailcontent").value }, function (responseJson) {
                            if (responseJson !== null) {
                                $.each(responseJson, function (key, value) {
                                    var t1 = value['GenericDescriptionEng'];
                                    document.getElementById("tasknotes").value = value['GenericDescriptionAfr'].replace(/~/g, "\n");
                                    if (t1 == "success") {
                                        alert("success");
                                    } else {
                                        alert("failed : " + value['GenericDescriptionAfr'] );
                                    }
                                });
                            } else {
                                alert("no response");
                            }
                        });
                    });
                });
            </script>   
            <script>
                var myCalendar;
                function doOnLoad() {
                    myCalendar = new dhtmlXCalendarObject("calendarHere");
                    myCalendar.setDate(new Date);
                    myCalendar.show();
                    myCalendar.hideTime();
                    myCalendar.showToday();
                    myCalendar.setHolidays(["2017-01-01", "2017-01-02", "2017-03-21", "2017-04-14", "2017-04-17", "2017-04-27", "2017-05-01", "2017-06-16", "2017-08-09", "2017-09-24", "2017-09-25", "2017-12-16", "2017-12-25", "2017-12-26", "2018-01-01", "2018-03-21", "2018-03-30", "2018-04-02", "2018-04-27", "2018-05-01", "2018-06-16", "2018-08-09", "2018-09-24", "2018-12-16", "2018-12-17", "2018-12-25", "2018-12-26"]);
                    myCalendar.setTooltip("2017-01-01", "New Year's Day", true, true);
                    myCalendar.setTooltip("2017-01-02", "Public HoliDay", true, true);
                    myCalendar.setTooltip("2017-03-21", "Human Rights Day", true, true);
                    myCalendar.setTooltip("2017-04-14", "Good Friday", true, true);
                    myCalendar.setTooltip("2017-04-17", "Family Day", true, true);
                    myCalendar.setTooltip("2017-04-27", "Freedom Day", true, true);
                    myCalendar.setTooltip("2017-05-01", "Workers Day", true, true);
                    myCalendar.setTooltip("2017-06-16", "Youth Day", true, true);
                    myCalendar.setTooltip("2017-08-09", "National Womens Day", true, true);
                    myCalendar.setTooltip("2017-09-24", "Heritage Day", true, true);
                    myCalendar.setTooltip("2017-09-25", "Public Holiday", true, true);
                    myCalendar.setTooltip("2017-12-16", "Day of Reconciliation", true, true);
                    myCalendar.setTooltip("2017-12-25", "Christmas Day", true, true);
                    myCalendar.setTooltip("2017-12-26", "Day of Good Will", true, true);
                    myCalendar.setTooltip("2018-01-01", "New Years Day", true, true);
                    myCalendar.setTooltip("2018-03-21", "Human Rights Day", true, true);
                    myCalendar.setTooltip("2018-03-30", "Good Friday", true, true);
                    myCalendar.setTooltip("2018-04-02", "Family Day", true, true);
                    myCalendar.setTooltip("2018-04-27", "Freedom Day", true, true);
                    myCalendar.setTooltip("2018-05-01", "Labour Day", true, true);
                    myCalendar.setTooltip("2018-06-16", "Youth Day", true, true);
                    myCalendar.setTooltip("2018-08-09", "National Womens Day", true, true);
                    myCalendar.setTooltip("2018-09-24", "Heritage Day", true, true);
                    myCalendar.setTooltip("2018-12-16", "Day Of Reconciliation", true, true);
                    myCalendar.setTooltip("2018-12-17", "Public Holiday", true, true);
                    myCalendar.setTooltip("2018-12-25", "Christmas Day", true, true);
                    myCalendar.setTooltip("2018-12-26", "Day Of Good Will", true, true);
                    myCalendar._drawMonth(new Date);
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

            <script type="text/javascript">

                $(document).ready(function () {
                    $('#Diarylink').click(function (event) {
                        window.location = "DiaryFromTask?key=" + encodeURIComponent(document.getElementById("taskid").innerHTML);
                    });
                });
                $(document).ready(function () {
                    $("#link1").click(function (event) {
                        window.location = "TaskView.jsp?key=" + encodeURIComponent(document.getElementById("link1").innerHTML);
                    });
                });

                $(document).ready(function () {
                    $("#link2").click(function (event) {
                        window.location = "TaskView.jsp?key=" + encodeURIComponent(document.getElementById("link2").innerHTML);
                    });
                });

                $(document).ready(function () {
                    $("#link3").click(function (event) {
                        window.location = "TaskView.jsp?key=" + encodeURIComponent(document.getElementById("link3").innerHTML);
                    });
                });

                $(document).ready(function () {
                    $("#link4").click(function (event) {
                        window.location = "TaskView.jsp?key=" + encodeURIComponent(document.getElementById("link4").innerHTML);
                    });
                });

                $(document).ready(function () {
                    $("#link5").click(function (event) {
                        window.location = "TaskView.jsp?key=" + encodeURIComponent(document.getElementById("link5").innerHTML);
                    });
                });

                $(document).ready(function () {
                    $("#link6").click(function (event) {
                        window.location = "TaskView.jsp?key=" + encodeURIComponent(document.getElementById("link6").innerHTML);
                    });
                });

                $(document).ready(function () {
                    $("#Tasklink").click(function (event) {
                        window.location = "TaskView.jsp?link=" + encodeURIComponent(document.getElementById("taskid").innerHTML);
                    });
                });

                $(document).ready(function () {
                    $("#diaryimag").click(function (event) {
                        var target = $(event.target);
                        $td = target.closest('td');
                        var col = $td.index();
                        var row = $td.closest('tr').index();
                        $.get('TaskViewImage', {diaryid: document.getElementById("diaryimag").rows[row].cells[3].innerHTML, tranid: document.getElementById("taskid").innerHTML}, function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    if (value['taskfrom'].length > 1) {
                                        // window.location = "resources/" + value['locat']; 
                                        var url = "resources/" + value['taskfrom'];
                                        // var url = value['taskfrom'];
                                        window.open(url, 'Download');
                                    } else {
                                        alert("failed");
                                    }
                                });
                            }
                        });
                    });
                });
            </script>            

            <script>
                function loadMember() {
                    var count = $("#dsee1 option").length;
                    if (count.valueOf() < 2) {
                        $.get('SecurityGetActiveUser', function (responseJson) {
                            if (responseJson != null) {
                                $('#dsee1').append('<option value=""></option>');
                                $('#dsee2').append('<option value=""></option>');
                                $('#dsee3').append('<option value=""></option>');
                                $('#dsee4').append('<option value=""></option>');
                                $('#dsee5').append('<option value=""></option>');
                                $('#dsee6').append('<option value=""></option>');
                                $('#dsee7').append('<option value=""></option>');
                                $('#dsee8').append('<option value=""></option>');
                                $('#dsee9').append('<option value=""></option>');
                                $('#dsee10').append('<option value=""></option>');
                                $('#dsee11').append('<option value=""></option>');
                                $('#dsee12').append('<option value=""></option>');
                                $('#dsee13').append('<option value=""></option>');
                                $('#dsee14').append('<option value=""></option>');
                                $('#dsee15').append('<option value=""></option>');
                                $.each(responseJson, function (key, value) {
                                    $('#dsee1').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee2').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee3').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee4').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee5').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee6').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee7').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee8').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee9').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee10').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee11').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee12').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee13').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee14').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee15').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                });
                            }
                        });
                    }
                }
            </script>    

            <script type="text/javascript">
                $(document).ready(function () {
                    $("#recur").click(function (event) {
                        if (document.getElementById("recur").checked == true) {
                            $("#recureveryday").css("visibility", "visible");
                            $("#Recurlabel1").css("visibility", "visible");
                            $("#dayr7").css("visibility", "visible");
                            $("#Recurlabel2").css("visibility", "visible");
                            $("#recurofeverymonth").css("visibility", "visible");
                            $("#Recurlabel3").css("visibility", "visible");
                            $("#RecurWeekly").css("visibility", "visible");
                            $("#Recurlabel4").css("visibility", "visible");
                            $("#recureveryweekday").css("visibility", "visible");
                            $("#Recurlabel5").css("visibility", "visible");
                            $("#recurlastday").css("visibility", "visible");
                            $("#Recurlabel6").css("visibility", "visible");
                            $("#recurmonthly").css("visibility", "visible");
                            $("#Recurlabel7").css("visibility", "visible");
                            $("#recurexceptsun").css("visibility", "visible");
                            $("#Recurlabel8").css("visibility", "visible");
                            $("#recurevery").css("visibility", "visible");
                            $("#Recurlabel9").css("visibility", "visible");
                            $("#dayr5").css("visibility", "visible");
                            $("#monthr3").css("visibility", "visible");
                            $("#Recurlabel10").css("visibility", "visible");
                            $("#rmonth1").css("visibility", "visible");
                            $("#Recurlabel11").css("visibility", "visible");
                        } else
                        {
                            $("#recureveryday").css("visibility", "hidden");
                            $("#Recurlabel1").css("visibility", "hidden");
                            $("#dayr7").css("visibility", "hidden");
                            $("#Recurlabel2").css("visibility", "hidden");
                            $("#recurofeverymonth").css("visibility", "hidden");
                            $("#Recurlabel3").css("visibility", "hidden");
                            $("#recurWeekly").css("visibility", "hidden");
                            $("#Recurlabel4").css("visibility", "hidden");
                            $("#recureveryweekday").css("visibility", "hidden");
                            $("#Recurlabel5").css("visibility", "hidden");
                            $("#recurlastday").css("visibility", "hidden");
                            $("#Recurlabel6").css("visibility", "hidden");
                            $("#recurmonthly").css("visibility", "hidden");
                            $("#Recurlabel7").css("visibility", "hidden");
                            $("#recurexceptsun").css("visibility", "hidden");
                            $("#Recurlabel8").css("visibility", "hidden");
                            $("#recurevery").css("visibility", "hidden");
                            $("#Recurlabel9").css("visibility", "hidden");
                            $("#dayr5").css("visibility", "hidden");
                            $("#monthr3").css("visibility", "hidden");
                            $("#Recurlabel10").css("visibility", "hidden");
                            $("#rmonth1").css("visibility", "hidden");
                            $("#Recurlabel11").css("visibility", "hidden");
                        }

                    });
                });
            </script>        
            <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
            <script type="text/javascript">
                $(document).ready(function () {
                    $("#Tasksavecomm").click(function (event) {
                        var a11 = "1";
                        var b11 = "2";
                        if (navigator.geolocation) {
                            navigator.geolocation.getCurrentPosition(function (p) {
                                var LatLng = new google.maps.LatLng(p.coords.latitude, p.coords.longitude);
                                document.getElementById("coord").innerHTML = p.coords.latitude + "," + p.coords.longitude;
                                a11 = String(p.coords.latitude);
                                b11 = String(p.coords.longitude);
                                $.get('TaskSaveComm', {comment: document.getElementById("tasknotes").value, tranid: document.getElementById("taskid").innerHTML, coordsa: a11, coordsb: b11}, function (responseJson) {
                                    if (responseJson != null) {
                                        $.each(responseJson, function (key, value) {
                                            document.getElementById("tasknotes").value = value['tasknote'];
                                            if (document.getElementById("tasknotes").value == "undefined") {
                                                document.getElementById("tasknotes").value = "";
                                            }
                                            if (document.getElementById("tasknotes").value.length > 0) {
                                                //   document.getElementById("tasknotes").value = "2"; 
                                                document.getElementById("tasknotes").value = value['tasknote'].replace(/~/g, "\n");
                                            }

                                        });
                                    }
                                });
                            });
                        } else {
                            a11 = "0";
                            b11 = "0";
                            $.get('TaskSaveComm', {comment: document.getElementById("tasknotes").value, tranid: document.getElementById("taskid").innerHTML, coordsa: a11, coordsb: b11}, function (responseJson) {
                                if (responseJson != null) {
                                    $.each(responseJson, function (key, value) {
                                        document.getElementById("tasknotes").value = value['tasknote'];
                                        if (document.getElementById("tasknotes").value == "undefined") {
                                            document.getElementById("tasknotes").value = "";
                                        }
                                        if (document.getElementById("tasknotes").value.length > 0) {
                                            //   document.getElementById("tasknotes").value = "2"; 
                                            document.getElementById("tasknotes").value = value['tasknote'].replace(/~/g, "\n");
                                        }

                                    });
                                }
                            });
                        }
                        $("#Taskupdatecomm").css("visibility", "visible");
                        $("#Tasksavecomm").css("visibility", "hidden");
                    });
                });
            </script>

            <script>
                $(document).ready(function () {
                    $("#Taskupdatepeople").click(function (event) {
                        $.get('TaskUpdatePeople', {tranid: document.getElementById("taskid").innerHTML, user1: document.getElementById("dsee1").value, user2: document.getElementById("dsee2").value, user3: document.getElementById("dsee3").value, user4: document.getElementById("dsee4").value, user5: document.getElementById("dsee5").value, user6: document.getElementById("dsee6").value, user7: document.getElementById("dsee7").value, user8: document.getElementById("dsee8").value, user9: document.getElementById("dsee9").value, user10: document.getElementById("dsee10").value, user11: document.getElementById("dsee11").value, user12: document.getElementById("dsee12").value, user13: document.getElementById("dsee13").value, user14: document.getElementById("dsee14").value, user15: document.getElementById("dsee15").value}, function (responseJson) {
                            if (responseJson !== null) {
                                $.each(responseJson, function (key, value) {
                                    var t1 = value['GenericDescriptionEng'];
                                    if (t1 == "success") {
                                        alert("success");
                                    } else {
                                        alert("failed");
                                    }
                                });
                            } else {
                                alert("no response");
                            }
                        });
                    });
                });

                $(document).ready(function () {
                    $("#Tasksave").click(function (event) {
                        if (document.getElementById("trainingtask").checked == true) {
                            training = "Y";
                        } else {
                            training = "N";
                        }
                        $.get('TaskUpdate', {tranid: document.getElementById("taskid").innerHTML, recur1: document.getElementById("recur").checked, recur3: document.getElementById("recureveryday").checked, recur4: document.getElementById("recurofeverymonth").value, recur5: document.getElementById("recurweekly").checked, recur6: document.getElementById("recureveryweekday").checked, recur7: document.getElementById("recurlastday").checked, recur8: document.getElementById("recurmonthly").checked, recur9: document.getElementById("recurexceptsun").checked, recur10: document.getElementById("recurevery").checked, ir: document.getElementById("requestir").checked, tasksumm: document.getElementById("tasksumm").value, taskfull: document.getElementById("taskfull").value, recur13: document.getElementById("rmonth1").value, recur11: document.getElementById("dayr5").value, recur12: document.getElementById("monthr3").checked, sdate: document.getElementById("startdate").value, rdate: document.getElementById("reviewdate").value, edate: document.getElementById("enddate").value, prior: document.getElementById("Priority1").value, stats: document.getElementById("Status1").value, recur2: document.getElementById("dayr7").checked, taskto1: document.getElementById("dsee1").value, taskto2: document.getElementById("dsee2").value, taskto3: document.getElementById("dsee3").value, taskto4: document.getElementById("dsee4").value, taskto5: document.getElementById("dsee5").value, taskto6: document.getElementById("dsee6").value, taskto7: document.getElementById("dsee7").value, taskto8: document.getElementById("dsee8").value, taskto9: document.getElementById("dsee9").value, taskto10: document.getElementById("dsee10").value, taskto11: document.getElementById("dsee11").value, taskto12: document.getElementById("dsee12").value, taskto13: document.getElementById("dsee13").value, taskto14: document.getElementById("dsee14").value, taskto15: document.getElementById("dsee15").value, fromUser: document.getElementById("FromUser1").value, train: training, link1: document.getElementById("linktask1").innerHTML}, function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    if (value['GenericDescriptionEng'] == "success") {
                                        alert("Task updated")
                                    }
                                    if (value['GenericDescriptionEng'] == "task created") {
                                        alert("New task created")
                                    }
                                    if (!value['GenericDescriptionEng'] == "success" && !value['GenericDescriptionEng'] == "task created") {
                                        alert("Failed")
                                    }

                                });

                            }

                        });
                    });
                });
            </script>
        </head>
        <body>


            <script>
                document.write('<a style ="float:left; margin-left:510px;" href="' + document.referrer + '"> << Back to task list</a>');
            </script>

            <div id="tabs" style="width:600px;  height:670px; margin-left: 40px;">
                <ul>
                    <li><a href="#tabs-1">Details</a></li>
                    <li><a href="#tabs-2">Notes</a></li>
                    <li><a href="#tabs-3">People</a></li>
                    <li><a href="#tabs-4">Images</a></li>
                    <li><a href="#tabs-5">E-Mail</a></li>
                </ul>

                <div id="tabs-1">
                    <p>
                    <div style="float: Left; text-align: left;">
                        Task :  <label id="taskid">${taskid}</label>
                </div>
                <label style="float:right">
                    <input type="checkbox" id="trainingtask" > This is a training task   
                </label>

                <br>
                <label id="TaskFromLabel" style="float:left">Task From :</label>
                <select name="FromUser" id = "FromUser1" style=" margin-left: 10px; width: 180px" >
                    <option value="${taskfrom}">${taskfrom}</option>
                </select>
                <script>
                    document.getElementById("FromUser1").value =${taskFromString};
                </script>
                <br>
                Task Created :  <label id="TaskCreated">${taskdate}</label>

                <br>
                Task Summary :<label> <input type="text" id="tasksumm" style="width:250px; margin-left:15px;" value=${description}  > </label>     
                <br>
                IR Nr : <label> <input type="text" id="Irnr" style="width:60px; margin-left:83px;" value=${irnr} > </label> 
                <input type="checkbox" id="requestir" value="ReqIR">Request IR Nr
                <br>
                <label><input type="checkbox" id="recur" >Recurrence</label>
                <br>
                <label id="Recurlabel1"><input type="checkbox" id="recureveryday" >Every Day</label>
                <label id="Recurlabel2"> <input type="checkbox" id="dayr7" style="margin-left:68px;" >Day </label>
                <label id="Recurlabel3"> <input type="text" id="recurofeverymonth" style="width:35px;" value=${recurday}  > of every month.</label> 
                <label id="Recurlabel4"><input type="checkbox" id="recurweekly" style="margin-left:30px" >Weekly</label>
                <br>
                <label id="Recurlabel5"><input type="checkbox" id="recureveryweekday" value="Recur" >Every Weekday</label>
                <label id="Recurlabel6"><input type="checkbox" id="recurlastday" value="Recur" style="margin-left:30px" >last day of every month</label>
                <label id="Recurlabel7"><input type="checkbox" id="recurmonthly" value="Recur" style="margin-left:53px" >Monthly</label>
                <br>
                <label id="Recurlabel8"><input type="checkbox" id="recurexceptsun" value="Recur" >Every Day Except Sunday</label>
                <label id="Recurlabel9"><input type="checkbox" id="recurevery" value="Recur" style="margin-left:30px" >Every</label>
                <select name="RecurDay" id = "dayr5" style=" margin-left: 10px; width: 110px;" >
                    <option value="0"> </option>
                    <option value="Monday">Monday</option>
                    <option value="Tuesday">Tuesday</option>
                    <option value="Wednesday">Wednesday</option>
                    <option value="Thursday">Thursday</option>
                    <option value="Friday">Friday</option>
                    <option value="Saturday">Saturday</option>
                    <option value="Sunday">Sunday</option>
                </select> 
                <script>
                    document.getElementById("dayr5").value = ${recdayofweek};

                    if (document.getElementById("dayr5").value == "null") {
                        document.getElementById("dayr5").value = ""
                    }
                </script>

                <br>
                <label id="Recurlabel10"><input type="checkbox" id="monthr3" value="Recur" >Every</label>
                <label id="Recurlabel11"> <input type="text" id="rmonth1" style="width:55px;" value=${recureverymonths} > Months</label> 
                <br>
                <label> <textarea name="notes" id="taskfull" style="width: 575px; height: 205px" cols="60" rows="5" >${taskfull}</textarea></label>    
                <br>
                <script>
//                    document.getElementById("Recur").checked = true;
                    var a = ${recur}

                    if (a == "1") {
                        document.getElementById("recur").checked = true;
                        $("#recureveryday").css("visibility", "visible");
                        $("#Recurlabel1").css("visibility", "visible");
                        $("#dayr7").css("visibility", "visible");
                        $("#Recurlabel2").css("visibility", "visible");
                        $("#recurofeverymonth").css("visibility", "visible");
                        $("#Recurlabel3").css("visibility", "visible");
                        $("#RecurWeekly").css("visibility", "visible");
                        $("#Recurlabel4").css("visibility", "visible");
                        $("#recureveryweekday").css("visibility", "visible");
                        $("#Recurlabel5").css("visibility", "visible");
                        $("#recurlastday").css("visibility", "visible");
                        $("#Recurlabel6").css("visibility", "visible");
                        $("#recurmonthly").css("visibility", "visible");
                        $("#Recurlabel7").css("visibility", "visible");
                        $("#recurexceptsun").css("visibility", "visible");
                        $("#Recurlabel8").css("visibility", "visible");
                        $("#recurevery").css("visibility", "visible");
                        $("#Recurlabel9").css("visibility", "visible");
                        $("#dayr5").css("visibility", "visible");
                        $("#monthr3").css("visibility", "visible");
                        $("#Recurlabel10").css("visibility", "visible");
                        $("#rmonth1").css("visibility", "visible");
                        $("#Recurlabel11").css("visibility", "visible");
                    } else
                    {
                        document.getElementById("recur").checked = false;
                        $("#recureveryday").css("visibility", "hidden");
                        $("#Recurlabel1").css("visibility", "hidden");
                        $("#dayr7").css("visibility", "hidden");
                        $("#Recurlabel2").css("visibility", "hidden");
                        $("#recurofeverymonth").css("visibility", "hidden");
                        $("#Recurlabel3").css("visibility", "hidden");
                        $("#recurWeekly").css("visibility", "hidden");
                        $("#Recurlabel4").css("visibility", "hidden");
                        $("#recureveryweekday").css("visibility", "hidden");
                        $("#Recurlabel5").css("visibility", "hidden");
                        $("#recurlastday").css("visibility", "hidden");
                        $("#Recurlabel6").css("visibility", "hidden");
                        $("#recurmonthly").css("visibility", "hidden");
                        $("#Recurlabel7").css("visibility", "hidden");
                        $("#recurexceptsun").css("visibility", "hidden");
                        $("#Recurlabel8").css("visibility", "hidden");
                        $("#recurevery").css("visibility", "hidden");
                        $("#Recurlabel9").css("visibility", "hidden");
                        $("#dayr5").css("visibility", "hidden");
                        $("#monthr3").css("visibility", "hidden");
                        $("#Recurlabel10").css("visibility", "hidden");
                        $("#rmonth1").css("visibility", "hidden");
                        $("#Recurlabel11").css("visibility", "hidden");
                    }
                </script>
                <script>
                    var a = ${recuri}
                    if (a == "1") {
                        document.getElementById("recurmonthly").checked = true;
                    } else
                    {
                        document.getElementById("recurmonthly").checked = false;
                    }
                </script>
                <script>
                    var a = ${recurh}
                    if (a == "1") {
                        document.getElementById("recurweekly").checked = true;
                    } else
                    {
                        document.getElementById("recurweekly").checked = false;
                    }
                </script>
                <script>
                    var a = ${recure}
                    if (a == "1") {
                        document.getElementById("recurlastday").checked = true;
                    } else
                    {
                        document.getElementById("recurlastday").checked = false;
                    }
                </script>
                <script>
                    var a = ${recurg}
                    if (a == "1") {
                        document.getElementById("monthr3").checked = true;
                    } else
                    {
                        document.getElementById("monthr3").checked = false;
                    }
                </script>
                <script>
                    var a = ${recurc}
                    if (a == "1") {
                        document.getElementById("recurexceptsun").checked = true;
                    } else
                    {
                        document.getElementById("recurexceptsun").checked = false;
                    }
                </script>
                <script>
                    var a = ${recurb}
                    if (a == "1") {
                        document.getElementById("recureveryweekday").checked = true;
                    } else
                    {
                        document.getElementById("recureveryweekday").checked = false;
                    }
                </script>
                <script>
                    var a = ${recura}
                    if (a == "1") {
                        document.getElementById("recureveryday").checked = true;
                    } else
                    {
                        document.getElementById("recureveryday").checked = false;
                    }
                </script>
                <script>
                    var a = ${recurf}
                    if (a == "1") {
                        document.getElementById("recurevery").checked = true;
                    } else
                    {
                        document.getElementById("recurevery").checked = false;
                    }
                </script>
                <script>
                    var a = ${recurd}
                    if (a == "1") {
                        document.getElementById("dayr7").checked = true;
                    } else
                    {
                        document.getElementById("dayr7").checked = false;
                    }
                </script>

                <script>

                    if (document.getElementById("taskfull").value.length > 0) {

                        document.getElementById("taskfull").value = document.getElementById("taskfull").value.replace(/~/g, "\n");
                    }
                </script>
                <script>
                    //  document.getElementById("taskid").innerHTML = "111";
                    var a = ${train}
                    if (${train} == "Y") {
                        document.getElementById("trainingtask").checked = true;

                    } else
                    {
                        document.getElementById("trainingtask").checked = false;
                    }
                </script>

                <label id="linkedTasks" style="color:blue; float: right; text-align: right; margin-right:100px;">Linked Tasks</label>
                <br>
                Start Date :<label> <input type="text" id = "startdate" style="margin-left:27px; width: 135px;" value= ${startdate} ></label> <label id = "link1" style="margin-left:100px; color:blue;">${linkup1}</label> <label id = "link2" style="margin-left:50px;color:blue;">${linkup2}</label> 
                <br> 
                Review Date :<label> <input type="text" id = "reviewdate" style="margin-left:10px; width: 135px;" value= ${revdate}></label><label id = "link3" style="margin-left:100px;color:blue;">${linkup3}</label>  <label id = "link4" style="margin-left:50px;color:blue;">${linkup4}</label> 
                <br>
                End Date :<label> <input type="text" id = "enddate" style="margin-left:32px; width: 135px;" value= ${enddate}></label><label id = "link5" style="margin-left:100px;color:blue;">${linkup5}</label> <label id = "link6" style="margin-left:50px;color:blue;">${linkup6}</label> 
                <script>
                    var myCalendar1 = new dhtmlXCalendarObject(["startdate"]);
                    myCalendar1.setHolidays(["2017-01-01", "2017-01-02", "2017-03-21", "2017-04-14", "2017-04-17", "2017-04-27", "2017-05-01", "2017-06-16", "2017-08-09", "2017-09-24", "2017-09-25", "2017-12-16", "2017-12-25", "2017-12-26", "2018-01-01", "2018-03-21", "2018-03-30", "2018-04-02", "2018-04-27", "2018-05-01", "2018-06-16", "2018-08-09", "2018-09-24", "2018-12-16", "2018-12-17", "2018-12-25", "2018-12-26"]);
                    myCalendar1.setTooltip("2017-01-01", "New Year's Day", true, true);
                    myCalendar1.setTooltip("2017-01-02", "Public HoliDay", true, true);
                    myCalendar1.setTooltip("2017-03-21", "Human Rights Day", true, true);
                    myCalendar1.setTooltip("2017-04-14", "Good Friday", true, true);
                    myCalendar1.setTooltip("2017-04-17", "Family Day", true, true);
                    myCalendar1.setTooltip("2017-04-27", "Freedom Day", true, true);
                    myCalendar1.setTooltip("2017-05-01", "Workers Day", true, true);
                    myCalendar1.setTooltip("2017-06-16", "Youth Day", true, true);
                    myCalendar1.setTooltip("2017-08-09", "National Womens Day", true, true);
                    myCalendar1.setTooltip("2017-09-24", "Heritage Day", true, true);
                    myCalendar1.setTooltip("2017-09-25", "Public Holiday", true, true);
                    myCalendar1.setTooltip("2017-12-16", "Day of Reconciliation", true, true);
                    myCalendar1.setTooltip("2017-12-25", "Christmas Day", true, true);
                    myCalendar1.setTooltip("2017-12-26", "Day of Good Will", true, true);
                    myCalendar1.setTooltip("2018-01-01", "New Years Day", true, true);
                    myCalendar1.setTooltip("2018-03-21", "Human Rights Day", true, true);
                    myCalendar1.setTooltip("2018-03-30", "Good Friday", true, true);
                    myCalendar1.setTooltip("2018-04-02", "Family Day", true, true);
                    myCalendar1.setTooltip("2018-04-27", "Freedom Day", true, true);
                    myCalendar1.setTooltip("2018-05-01", "Labour Day", true, true);
                    myCalendar1.setTooltip("2018-06-16", "Youth Day", true, true);
                    myCalendar1.setTooltip("2018-08-09", "National Womens Day", true, true);
                    myCalendar1.setTooltip("2018-09-24", "Heritage Day", true, true);
                    myCalendar1.setTooltip("2018-12-16", "Day Of Reconciliation", true, true);
                    myCalendar1.setTooltip("2018-12-17", "Public Holiday", true, true);
                    myCalendar1.setTooltip("2018-12-25", "Christmas Day", true, true);
                    myCalendar1.setTooltip("2018-12-26", "Day Of Good Will", true, true);
                    myCalendar1.setDateFormat("%Y/%m/%d %H:%i");
                </script>
                <script>
                    var myCalendar2 = new dhtmlXCalendarObject(["reviewdate"]);
                    myCalendar2.setHolidays(["2017-01-01", "2017-01-02", "2017-03-21", "2017-04-14", "2017-04-17", "2017-04-27", "2017-05-01", "2017-06-16", "2017-08-09", "2017-09-24", "2017-09-25", "2017-12-16", "2017-12-25", "2017-12-26", "2018-01-01", "2018-03-21", "2018-03-30", "2018-04-02", "2018-04-27", "2018-05-01", "2018-06-16", "2018-08-09", "2018-09-24", "2018-12-16", "2018-12-17", "2018-12-25", "2018-12-26"]);
                    myCalendar2.setTooltip("2017-01-01", "New Year's Day", true, true);
                    myCalendar2.setTooltip("2017-01-02", "Public HoliDay", true, true);
                    myCalendar2.setTooltip("2017-03-21", "Human Rights Day", true, true);
                    myCalendar2.setTooltip("2017-04-14", "Good Friday", true, true);
                    myCalendar2.setTooltip("2017-04-17", "Family Day", true, true);
                    myCalendar2.setTooltip("2017-04-27", "Freedom Day", true, true);
                    myCalendar2.setTooltip("2017-05-01", "Workers Day", true, true);
                    myCalendar2.setTooltip("2017-06-16", "Youth Day", true, true);
                    myCalendar2.setTooltip("2017-08-09", "National Womens Day", true, true);
                    myCalendar2.setTooltip("2017-09-24", "Heritage Day", true, true);
                    myCalendar2.setTooltip("2017-09-25", "Public Holiday", true, true);
                    myCalendar2.setTooltip("2017-12-16", "Day of Reconciliation", true, true);
                    myCalendar2.setTooltip("2017-12-25", "Christmas Day", true, true);
                    myCalendar2.setTooltip("2017-12-26", "Day of Good Will", true, true);
                    myCalendar2.setTooltip("2018-01-01", "New Years Day", true, true);
                    myCalendar2.setTooltip("2018-03-21", "Human Rights Day", true, true);
                    myCalendar2.setTooltip("2018-03-30", "Good Friday", true, true);
                    myCalendar2.setTooltip("2018-04-02", "Family Day", true, true);
                    myCalendar2.setTooltip("2018-04-27", "Freedom Day", true, true);
                    myCalendar2.setTooltip("2018-05-01", "Labour Day", true, true);
                    myCalendar2.setTooltip("2018-06-16", "Youth Day", true, true);
                    myCalendar2.setTooltip("2018-08-09", "National Womens Day", true, true);
                    myCalendar2.setTooltip("2018-09-24", "Heritage Day", true, true);
                    myCalendar2.setTooltip("2018-12-16", "Day Of Reconciliation", true, true);
                    myCalendar2.setTooltip("2018-12-17", "Public Holiday", true, true);
                    myCalendar2.setTooltip("2018-12-25", "Christmas Day", true, true);
                    myCalendar2.setTooltip("2018-12-26", "Day Of Good Will", true, true);
                    myCalendar2.setDateFormat("%Y/%m/%d %H:%i");
                </script>
                <script>
                    var myCalendar3 = new dhtmlXCalendarObject(["enddate"]);
                    myCalendar3.setHolidays(["2017-01-01", "2017-01-02", "2017-03-21", "2017-04-14", "2017-04-17", "2017-04-27", "2017-05-01", "2017-06-16", "2017-08-09", "2017-09-24", "2017-09-25", "2017-12-16", "2017-12-25", "2017-12-26", "2018-01-01", "2018-03-21", "2018-03-30", "2018-04-02", "2018-04-27", "2018-05-01", "2018-06-16", "2018-08-09", "2018-09-24", "2018-12-16", "2018-12-17", "2018-12-25", "2018-12-26"]);
                    myCalendar3.setTooltip("2017-01-01", "New Year's Day", true, true);
                    myCalendar3.setTooltip("2017-01-02", "Public HoliDay", true, true);
                    myCalendar3.setTooltip("2017-03-21", "Human Rights Day", true, true);
                    myCalendar3.setTooltip("2017-04-14", "Good Friday", true, true);
                    myCalendar3.setTooltip("2017-04-17", "Family Day", true, true);
                    myCalendar3.setTooltip("2017-04-27", "Freedom Day", true, true);
                    myCalendar3.setTooltip("2017-05-01", "Workers Day", true, true);
                    myCalendar3.setTooltip("2017-06-16", "Youth Day", true, true);
                    myCalendar3.setTooltip("2017-08-09", "National Womens Day", true, true);
                    myCalendar3.setTooltip("2017-09-24", "Heritage Day", true, true);
                    myCalendar3.setTooltip("2017-09-25", "Public Holiday", true, true);
                    myCalendar3.setTooltip("2017-12-16", "Day of Reconciliation", true, true);
                    myCalendar3.setTooltip("2017-12-25", "Christmas Day", true, true);
                    myCalendar3.setTooltip("2017-12-26", "Day of Good Will", true, true);
                    myCalendar3.setTooltip("2018-01-01", "New Years Day", true, true);
                    myCalendar3.setTooltip("2018-03-21", "Human Rights Day", true, true);
                    myCalendar3.setTooltip("2018-03-30", "Good Friday", true, true);
                    myCalendar3.setTooltip("2018-04-02", "Family Day", true, true);
                    myCalendar3.setTooltip("2018-04-27", "Freedom Day", true, true);
                    myCalendar3.setTooltip("2018-05-01", "Labour Day", true, true);
                    myCalendar3.setTooltip("2018-06-16", "Youth Day", true, true);
                    myCalendar3.setTooltip("2018-08-09", "National Womens Day", true, true);
                    myCalendar3.setTooltip("2018-09-24", "Heritage Day", true, true);
                    myCalendar3.setTooltip("2018-12-16", "Day Of Reconciliation", true, true);
                    myCalendar3.setTooltip("2018-12-17", "Public Holiday", true, true);
                    myCalendar3.setTooltip("2018-12-25", "Christmas Day", true, true);
                    myCalendar3.setTooltip("2018-12-26", "Day Of Good Will", true, true);
                    myCalendar3.setDateFormat("%Y/%m/%d %H:%i");
                </script>
                <br>
                <label id="Priority" style="float:left; ">Priority :</label>
                <select name="Priority" id = "Priority1" style=" width: 120px; margin-left:50px;">
<!--                    <option value="">${taskprior}</option>-->
                    <option value="Normal">Normal</option>
                    <option value="Low">Low</option>
                    <option value="High">High</option>
                    <option value="Very Urgent">Very Urgent</option>

                </select>
                <script>
                    document.getElementById("Priority1").value = ${taskprior};
                </script>
                <label id="Statusday" style=" margin-left:30px;">${statusday}</label>
                <br>
                <label id="Status" style="float:left; ">Status :</label>
                <select name="Status" id = "Status1" style=" width: 120px; margin-left:55px;">
                    <option value="Not Started">Not Started</option>
                    <option value="In Progress">In Progress</option>
                    <option value="Completed">Completed</option>
                    <option value="Waiting On Someone Else">Waiting On Someone Else</option>
                    <option value="Deferred">Deferred</option>
                </select>
                <script>
                    document.getElementById("Status1").value = ${taskstat};
                </script>

                <input type ="button" value ="Save" id="Tasksave" style="width:75px; float:right;">
                <input type ="button" value ="Link" id="Tasklink" style="width:75px; float:right;margin-right:10px">
                <input type ="button" value ="Diary" id="Diarylink" style="width:75px; float:right;margin-right:10px">
                </p>

            </div>
            <div id="tabs-2">
                <p>
                    <label> <textarea name="notes" id="tasknotes" style="width:575px; height: 455px;" cols="44" rows="10" >${tasknotes}</textarea> </label>     
                    <br>
                    <br>
                    <script>
                        if (document.getElementById("tasknotes").value.length > 0) {
                            document.getElementById("tasknotes").value = document.getElementById("tasknotes").value.replace(/~/g, "\n");
                        }
                    </script>
                    <script type="text/javascript">
                        function updateComm() {
                            document.getElementById("tasknotes").value = "";
                            $("#Taskupdatecomm").css("visibility", "hidden");
                            $("#Tasksavecomm").css("visibility", "visible");
                            $("#tasknotes").focus();
                        }
                    </script>   
                    <input type ="button" value ="Update" id="Taskupdatecomm" onClick="updateComm();" style="width:75px; float:right"/>
                    <input type ="button" value ="Save" id="Tasksavecomm" style="width:75px;visibility: hidden;"/>
                    <script>
                        if (${train} == "Y") {
                            $("#Taskupdatecomm").css("visibility", "hidden");
                        } else {
                            $("#Taskupdatecomm").css("visibility", "visible");
                        }
                    </script>   
            </div>
            <div id="tabs-3">
                <form method="post" class="signin" action="#">
                    <br>
                    People assigned to this task
                    <br>
                    <br>
                    <select name="dseel" id = "dsee1" style="width:170px" onClick="loadMember();">
                        <option value="${taskto1}">${taskto1}</option>
                    </select>

                    <label id="taskstat1" style=" margin-left:50px;"/>${taskstat1}</label>
                    <script>
                        if (document.getElementById("taskstat1").innerHTML.length < 3 && document.getElementById("dsee1").value.length > 1) {
                            document.getElementById("taskstat1").innerHTML = "Not Started";
                        }

                    </script>
                    <label id="taskstatdate1" style=" margin-left:50px;"/>${statusday1}</label>
                    <br>
                    <select name="dsee2" id = "dsee2" style="width:170px" onClick="loadMember();">
                        <option value="${taskto2}">${taskto2}</option>
                    </select>
                    <label id="taskstat2" style=" margin-left:50px;"/>${taskstat2}</label>
                    <script>
                        if (document.getElementById("taskstat2").innerHTML.length < 3 && document.getElementById("dsee2").value.length > 1) {
                            document.getElementById("taskstat2").innerHTML = "Not Started";
                        }
                    </script>
                    <label id="taskstatdate2" style=" margin-left:50px;"/>${statusday2}</label>
                    <br>
                    <select name="dsee3" id = "dsee3" style="width:170px" onClick="loadMember();">
                        <option value="${taskto3}">${taskto3}</option>
                    </select>           
                    <label id="taskstat3" style=" margin-left:50px;"/>${taskstat3}</label>
                    <script>
                        if (document.getElementById("taskstat3").innerHTML.length < 3 && document.getElementById("dsee3").value.length > 1) {
                            document.getElementById("taskstat3").innerHTML = "Not Started";
                        }
                    </script>
                    <label id="taskstatdate3" style=" margin-left:50px;"/>${statusday3}</label>
                    <br>
                    <select name="dsee4" id = "dsee4" style="width:170px" onClick="loadMember();">
                        <option value="${taskto4}">${taskto4}</option>
                    </select>           
                    <label id="taskstat4" style=" margin-left:50px;"/>${taskstat4}</label>
                    <script>
                        if (document.getElementById("taskstat4").innerHTML.length < 3 && document.getElementById("dsee4").value.length > 1) {
                            document.getElementById("taskstat4").innerHTML = "Not Started";
                        }
                    </script>
                    <label id="taskstatdate4" style=" margin-left:50px;"/>${statusday4}</label>
                    <br>
                    <select name="dsee5" id = "dsee5" style="width:170px" onClick="loadMember();">
                        <option value="${taskto5}">${taskto5}</option>
                    </select>           
                    <label id="taskstat5" style=" margin-left:50px;"/>${taskstat5}</label>
                    <script>
                        if (document.getElementById("taskstat5").innerHTML.length < 3 && document.getElementById("dsee5").value.length > 1) {
                            document.getElementById("taskstat5").innerHTML = "Not Started";
                        }
                    </script>
                    <label id="taskstatdate5" style=" margin-left:50px;"/>${statusday5}</label>
                    <br>
                    <select name="dsee6" id = "dsee6" style="width:170px" onClick="loadMember();">
                        <option value="${taskto6}">${taskto6}</option>
                    </select>           
                    <label id="taskstat6" style=" margin-left:50px;"/>${taskstat6}</label>
                    <script>
                        if (document.getElementById("taskstat6").innerHTML.length < 3 && document.getElementById("dsee6").value.length > 1) {
                            document.getElementById("taskstat6").innerHTML = "Not Started";
                        }
                    </script>
                    <label id="taskstatdate6" style=" margin-left:50px;"/>${statusday6}</label>
                    <br>
                    <select name="dsee7" id = "dsee7" style="width:170px" onClick="loadMember();">
                        <option value="${taskto7}">${taskto7}</option>
                    </select> 
                    <label id="taskstat7" style=" margin-left:50px;"/>${taskstat7}</label>
                    <script>
                        if (document.getElementById("taskstat7").innerHTML.length < 3 && document.getElementById("dsee7").value.length > 1) {
                            document.getElementById("taskstat7").innerHTML = "Not Started";
                        }
                    </script>
                    <label id="taskstatdate7" style=" margin-left:50px;"/>${statusday7}</label>
                    <br>
                    <select name="dsee8" id = "dsee8" style="width:170px" onClick="loadMember();">
                        <option value="${taskto8}">${taskto8}</option>
                    </select>           
                    <label id="taskstat8" style=" margin-left:50px;"/>${taskstat8}</label>
                    <script>
                        if (document.getElementById("taskstat8").innerHTML.length < 3 && document.getElementById("dsee8").value.length > 1) {
                            document.getElementById("taskstat8").innerHTML = "Not Started";
                        }
                    </script>
                    <label id="taskstatdate8" style=" margin-left:50px;"/>${statusday8}</label>
                    <br>
                    <select name="dsee9" id = "dsee9" style="width:170px" onClick="loadMember();">
                        <option value="${taskto9}">${taskto9}</option>
                    </select>           
                    <label id="taskstat9" style=" margin-left:50px;"/>${taskstat9}</label>
                    <script>
                        if (document.getElementById("taskstat9").innerHTML.length < 3 && document.getElementById("dsee9").value.length > 1) {
                            document.getElementById("taskstat9").innerHTML = "Not Started";
                        }
                    </script>
                    <label id="taskstatdate9" style=" margin-left:50px;"/>${statusday9}</label>
                    <br>
                    <select name="dsee10" id = "dsee10" style="width:170px" onClick="loadMember();">
                        <option value="${taskto10}">${taskto10}</option>
                    </select> 
                    <label id="taskstat10" style=" margin-left:50px;"/>${taskstat10}</label>
                    <script>
                        if (document.getElementById("taskstat10").innerHTML.length < 3 && document.getElementById("dsee10").value.length > 1) {
                            document.getElementById("taskstat10").innerHTML = "Not Started";
                        }
                    </script>
                    <label id="taskstatdate10" style=" margin-left:50px;"/>${statusday10}</label>
                    <br>
                    <select name="dsee11" id = "dsee11" style="width:170px" onClick="loadMember();">
                        <option value="${taskto11}">${taskto11}</option>
                    </select>           
                    <label id="taskstat11" style=" margin-left:50px;"/>${taskstat11}</label>
                    <script>
                        if (document.getElementById("taskstat11").innerHTML.length < 3 && document.getElementById("dsee11").value.length > 1) {
                            document.getElementById("taskstat11").innerHTML = "Not Started";
                        }
                    </script>
                    <label id="taskstatdate11" style=" margin-left:50px;"/>${statusday11}</label>
                    <br>
                    <select name="dsee12" id = "dsee12" style="width:170px" onClick="loadMember();">
                        <option value="${taskto12}">${taskto12}</option>
                    </select>           
                    <label id="taskstat12" style=" margin-left:50px;"/>${taskstat12}</label>
                    <script>
                        if (document.getElementById("taskstat12").innerHTML.length < 3 && document.getElementById("dsee12").value.length > 1) {
                            document.getElementById("taskstat12").innerHTML = "Not Started";
                        }
                    </script>
                    <label id="taskstatdate12" style=" margin-left:50px;"/>${statusday12}</label>
                    <br>
                    <select name="dsee13" id = "dsee13" style="width:170px" onClick="loadMember();">
                        <option value="${taskto13}">${taskto13}</option>
                    </select>           
                    <label id="taskstat13" style=" margin-left:50px;"/>${taskstat13}</label>
                    <script>
                        if (document.getElementById("taskstat13").innerHTML.length < 3 && document.getElementById("dsee13").value.length > 1) {
                            document.getElementById("taskstat13").innerHTML = "Not Started";
                        }
                    </script>
                    <label id="taskstatdate13" style=" margin-left:50px;"/>${statusday13}</label>
                    <br>
                    <select name="dsee14" id = "dsee14" style="width:170px" onClick="loadMember();">
                        <option value="${taskto14}">${taskto14}</option>
                    </select>           
                    <label id="taskstat14" style=" margin-left:50px;"/>${taskstat14}</label>
                    <script>
                        if (document.getElementById("taskstat14").innerHTML.length < 3 && document.getElementById("dsee14").value.length > 1) {
                            document.getElementById("taskstat14").innerHTML = "Not Started";
                        }
                    </script>
                    <label id="taskstatdate14" style=" margin-left:50px;"/>${statusday14}</label>
                    <br>
                    <select name="dsee15" id = "dsee15" style="width:170px" onClick="loadMember();">
                        <option value="${taskto15}">${taskto15}</option>
                    </select> 
                    <label id="taskstat15" style=" margin-left:50px;"/>${taskstat15}</label>
                    <label id="taskstatdate15" style=" margin-left:50px;"/>${statusday15}</label>
                    <script>
                        if (document.getElementById("taskstat15").innerHTML.length < 3 && document.getElementById("dsee15").value.length > 1) {
                            document.getElementById("taskstat15").innerHTML = "Not Started";
                        }
                        if (document.getElementById("dsee1").value.length < 3) {
                            document.getElementById("taskstatdate1").innerHTML = "";
                        }
                        if (document.getElementById("dsee2").value.length < 3) {
                            document.getElementById("taskstatdate2").innerHTML = "";
                        }
                        if (document.getElementById("dsee3").value.length < 3) {
                            document.getElementById("taskstatdate3").innerHTML = "";
                        }
                        if (document.getElementById("dsee4").value.length < 3) {
                            document.getElementById("taskstatdate4").innerHTML = "";
                        }
                        if (document.getElementById("dsee5").value.length < 3) {
                            document.getElementById("taskstatdate5").innerHTML = "";
                        }
                        if (document.getElementById("dsee6").value.length < 3) {
                            document.getElementById("taskstatdate6").innerHTML = "";
                        }
                        if (document.getElementById("dsee7").value.length < 3) {
                            document.getElementById("taskstatdate7").innerHTML = "";
                        }
                        if (document.getElementById("dsee8").value.length < 3) {
                            document.getElementById("taskstatdate8").innerHTML = "";
                        }
                        if (document.getElementById("dsee9").value.length < 3) {
                            document.getElementById("taskstatdate9").innerHTML = "";
                        }
                        if (document.getElementById("dsee10").value.length < 3) {
                            document.getElementById("taskstatdate10").innerHTML = "";
                        }
                        if (document.getElementById("dsee11").value.length < 3) {
                            document.getElementById("taskstatdate11").innerHTML = "";
                        }
                        if (document.getElementById("dsee12").value.length < 3) {
                            document.getElementById("taskstatdate12").innerHTML = "";
                        }
                        if (document.getElementById("dsee13").value.length < 3) {
                            document.getElementById("taskstatdate13").innerHTML = "";
                        }
                        if (document.getElementById("dsee14").value.length < 3) {
                            document.getElementById("taskstatdate14").innerHTML = "";
                        }
                        if (document.getElementById("dsee15").value.length < 3) {
                            document.getElementById("taskstatdate15").innerHTML = "";
                        }
                        if (document.getElementById("dsee1").value.length < 3) {
                            document.getElementById("taskstat1").innerHTML = "";
                        }
                        if (document.getElementById("dsee2").value.length < 3) {
                            document.getElementById("taskstat2").innerHTML = "";
                        }
                        if (document.getElementById("dsee3").value.length < 3) {
                            document.getElementById("taskstat3").innerHTML = "";
                        }
                        if (document.getElementById("dsee4").value.length < 3) {
                            document.getElementById("taskstat4").innerHTML = "";
                        }
                        if (document.getElementById("dsee5").value.length < 3) {
                            document.getElementById("taskstat5").innerHTML = "";
                        }
                        if (document.getElementById("dsee6").value.length < 3) {
                            document.getElementById("taskstat6").innerHTML = "";
                        }
                        if (document.getElementById("dsee7").value.length < 3) {
                            document.getElementById("taskstat7").innerHTML = "";
                        }
                        if (document.getElementById("dsee8").value.length < 3) {
                            document.getElementById("taskstat8").innerHTML = "";
                        }
                        if (document.getElementById("dsee9").value.length < 3) {
                            document.getElementById("taskstat9").innerHTML = "";
                        }
                        if (document.getElementById("dsee10").value.length < 3) {
                            document.getElementById("taskstat10").innerHTML = "";
                        }
                        if (document.getElementById("dsee11").value.length < 3) {
                            document.getElementById("taskstat11").innerHTML = "";
                        }
                        if (document.getElementById("dsee12").value.length < 3) {
                            document.getElementById("taskstat12").innerHTML = "";
                        }
                        if (document.getElementById("dsee13").value.length < 3) {
                            document.getElementById("taskstat13").innerHTML = "";
                        }
                        if (document.getElementById("dsee14").value.length < 3) {
                            document.getElementById("taskstat14").innerHTML = "";
                        }
                        if (document.getElementById("dsee15").value.length < 3) {
                            document.getElementById("taskstat15").innerHTML = "";
                        }
                    </script>
                    <br/>            
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    Task Status : <label id="taskstatus" style=" margin-left:50px;"/>${taskstatus}</label>
                    <input type ="button" value ="Update" id="Taskupdatepeople" style="width:75px;  float: right; margin-right: 5px"/>
            </div>

            <script>
                var a = ${taskid};
                if (a == "0") {
                    $("#tabs-2").css("visibility", "hidden");
                    $("#tabs-4").css("visibility", "hidden");
                    document.getElementById("recur").checked = false;
                    document.getElementById("startdate").value = "";
                    document.getElementById("reviewdate").value = "";
                    document.getElementById("enddate").value = "";
                    document.getElementById("tasksumm").value = "";
                    document.getElementById("Irnr").value = "";
                    document.getElementById("recurofeverymonth").value = "";
                    document.getElementById("rmonth1").value = "";

                    $("#recureveryday").css("visibility", "hidden");
                    $("#Recurlabel1").css("visibility", "hidden");
                    $("#dayr7").css("visibility", "hidden");
                    $("#Recurlabel2").css("visibility", "hidden");
                    $("#recurofeverymonth").css("visibility", "hidden");
                    $("#Recurlabel3").css("visibility", "hidden");
                    $("#recurWeekly").css("visibility", "hidden");
                    $("#Recurlabel4").css("visibility", "hidden");
                    $("#recureveryweekday").css("visibility", "hidden");
                    $("#Recurlabel5").css("visibility", "hidden");
                    $("#recurlastday").css("visibility", "hidden");
                    $("#Recurlabel6").css("visibility", "hidden");
                    $("#recurmonthly").css("visibility", "hidden");
                    $("#Recurlabel7").css("visibility", "hidden");
                    $("#recurexceptsun").css("visibility", "hidden");
                    $("#Recurlabel8").css("visibility", "hidden");
                    $("#recurevery").css("visibility", "hidden");
                    $("#Recurlabel9").css("visibility", "hidden");
                    $("#dayr5").css("visibility", "hidden");
                    $("#monthr3").css("visibility", "hidden");
                    $("#Recurlabel10").css("visibility", "hidden");
                    $("#rmonth1").css("visibility", "hidden");
                    $("#Recurlabel11").css("visibility", "hidden");
                }
            </script>
            <div id="tabs-4"> 
                <div id="imagdiv">
                    <table cellspacing="0" id="diaryimag" style="float: left; border-collapse: collapse;margin-left:5px; heigth:300px; width:97%; border:1px solid black;"> 
                        <tr> 
                            <th style="width:120px;border-collapse: collapse;border:1px solid black;" scope="col">Date</th> 
                            <th style="width:180px;border-collapse: collapse;border:1px solid black;" scope="col">User</th> 
                            <th style="width:200px;border-collapse: collapse;border:1px solid black;" scope="col">Description</th> 
                            <th style="width:40px;border-collapse: collapse;border:1px solid black;" scope="col">ID</th> 
                        </tr> 
                        ${taskimage}                        
                    </table>
                </div>
                <br>

                <br>
                <label for="imageText">Enter description</label>

                <input id="imageText" name="ImageText" type="text" > <br/>
                <label for="imageFile"/>Select file </label>
                <input id="imageFile" name="imageFile" type="file" > <br/>
                <input id="uploadBtn" type="button" value="Upload" onClick="performAjaxSubmit();">

            </div>
            <div id="tabs-5">
                <label style="font-size:20px;">Send e-mail</label>
                <br> <br>
                <label>E-mails send here will also created a new notes.</label> <br>
                <label>For every response received a note will be created.</label> <br>
                <br>
                Mail to address 
                <input type="text" id="mailto" size="30" >
                <br>
                Type mail content below
                <label> <textarea name="content" id="mailcontent" style="width:560px; height: 355px;" cols="44" rows="10" ></textarea> </label>     
                <br>
                <br>                                
                <input type ="button" value ="Send now" id="sendemail" style="width:90px; float:right"/>                               
            </div>                    



            <label id="linktask1" style="visibility:hidden;"/>${linktask11}</label>
        <label id = "coord" style="visibility:hidden;"> </label>
        <script type="text/javascript">

            function performAjaxSubmit() {

                var sampleText = document.getElementById('imageText').value;

                var sampleFile1 = document.getElementById('imageFile').files[0];

                var formdata = new FormData();

                formdata.append("imageText", sampleText);

                formdata.append("imageFile", sampleFile1);
                formdata.append("tranId", document.getElementById("taskid").innerHTML);

                var xhr = new XMLHttpRequest();

                xhr.open("POST", "TaskFileUploader", true);

                xhr.send(formdata);

                xhr.onload = function (e) {
                    location.reload(true);
                    if (this.status == 200) {
                        alert(this.responseText);
                    }
                };
            }
        </script> 

    </div>

</body>
</html>
