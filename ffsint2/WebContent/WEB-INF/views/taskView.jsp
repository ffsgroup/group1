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
                $(function () {
                    $("#tabs").tabs();
                });
            </script> 

            <script type="text/javascript">
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

            <script type="text/javascript">
                $(document).ready(function () {
                    $("#Tasksavecomm").click(function (event) {
                        $.get('TaskSaveComm', {comment: document.getElementById("tasknotes").value, tranid: document.getElementById("taskid").innerHTML}, function (responseJson) {
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
                        //    $("#tablediv").show();  
                        $("#Taskupdatecomm").css("visibility", "visible");
                        $("#Tasksavecomm").css("visibility", "hidden");
                    });
                });
            </script>

            <script>
                $(document).ready(function () {
                    $("#Taskupdatepeople").click(function (event) {
                        $.get('TaskUpdatePeople', {tranid: document.getElementById("taskid").innerHTML, user1: document.getElementById("dsee1").value, user2: document.getElementById("dsee2").value, user3: document.getElementById("dsee3").value, user4: document.getElementById("dsee4").value, user5: document.getElementById("dsee5").value, user6: document.getElementById("dsee6").value, user7: document.getElementById("dsee7").value, user8: document.getElementById("dsee8").value, user9: document.getElementById("dsee9").value, user10: document.getElementById("dsee10").value, user11: document.getElementById("dsee11").value, user12: document.getElementById("dsee12").value, user13: document.getElementById("dsee13").value, user14: document.getElementById("dsee14").value, user15: document.getElementById("dsee1").value}, function (responseJson) {

                            if (responseJson !== null) {

                                $.each(responseJson, function (key, value) {

                                    var t1 = value['GenericDescriptionEng'];
                                    // alert(t1); 
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
                        $.get('TaskUpdate', {tranid: document.getElementById("taskid").innerHTML, recur1: document.getElementById("recur").checked, recur3: document.getElementById("recureveryday").checked, recur4: document.getElementById("recurofeverymonth").value, recur5: document.getElementById("recurweekly").checked, recur6: document.getElementById("recureveryweekday").checked, recur7: document.getElementById("recurlastday").checked, recur8: document.getElementById("recurmonthly").checked, recur9: document.getElementById("recurexceptsun").checked, recur10: document.getElementById("recurevery").checked, ir: document.getElementById("requestir").checked, tasksumm: document.getElementById("tasksumm").value, taskfull: document.getElementById("taskfull").value, recur13: document.getElementById("rmonth1").value, recur11: document.getElementById("dayr5").value, recur12: document.getElementById("monthr3").checked, sdate: document.getElementById("startdate").value, rdate: document.getElementById("reviewdate").value, edate: document.getElementById("enddate").value, prior: document.getElementById("Priority1").value, stats: document.getElementById("Status1").value, recur2: document.getElementById("dayr7").checked, taskto1: document.getElementById("dsee1").value, taskto2: document.getElementById("dsee2").value, taskto3: document.getElementById("dsee3").value, taskto4: document.getElementById("dsee4").value, taskto5: document.getElementById("dsee5").value, taskto6: document.getElementById("dsee6").value, taskto7: document.getElementById("dsee7").value, taskto8: document.getElementById("dsee8").value, taskto9: document.getElementById("dsee9").value, taskto10: document.getElementById("dsee10").value, taskto11: document.getElementById("dsee11").value, taskto12: document.getElementById("dsee12").value, taskto13: document.getElementById("dsee13").value, taskto14: document.getElementById("dsee14").value, taskto15: document.getElementById("dsee15").value, fromUser: document.getElementById("FromUser1").value}, function (responseJson) {
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



            <div id="tabs" style="width:600px;  height:670px; margin-left: 40px;">
                <ul>
                    <li><a href="#tabs-1">Details</a></li>
                    <li><a href="#tabs-2">Notes</a></li>
                    <li><a href="#tabs-3">People</a></li>
                    <li><a href="#tabs-4">Images</a></li>
                </ul>

                <div id="tabs-1">
                    <p>
                    <div style="float: Left; text-align: left;">
                        Task :  <label id="taskid">${taskid}</label>
                </div>

                <br>
                <label id="TaskFromLabel" style="float:left">Task From :</label>
                <select name="FromUser" id = "FromUser1" style=" margin-left: 10px; width: 180px" >
                    <option value=${taskfrom}>${taskfrom}</option>
                </select>
                <script>
                    document.getElementById("FromUser1").value =${taskFromString};
                </script>
                <br>
                Task Created :  <label id="TaskCreated">${taskdate}</label>

                <br>
                Task Summary :<label> <input type="text" id="tasksumm" style=" width:250px; margin-left:15px;" value=${description}  > </label>     
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
                    <option value="0"></option>
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
                <label id="linkedTasks" style="color:blue; float: right; text-align: right; margin-right:100px;">Linked Tasks</label>
                <br>
                Start Date :<label> <input type="text" id = "startdate" style="margin-left:27px; width: 135px;" value= ${startdate} ></label> 
                <br> 
                Review Date :<label> <input type="text" id = "reviewdate" style="margin-left:10px; width: 135px;" value= ${revdate}></label>
                <br>
                End Date :<label> <input type="text" id = "enddate" style="margin-left:32px; width: 135px;" value= ${enddate}></label>
                <script>
                    var myCalendar1 = new dhtmlXCalendarObject(["startdate"]);
                    myCalendar1.setDateFormat("%Y/%m/%d %H:%i");
                </script>
                <script>
                    var myCalendar2 = new dhtmlXCalendarObject(["reviewdate"]);
                    myCalendar2.setDateFormat("%Y/%m/%d %H:%i");
                </script>
                <script>
                    var myCalendar3 = new dhtmlXCalendarObject(["enddate"]);
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



            </div>
            <div id="tabs-3">
                <form method="post" class="signin" action="#">
                    <br>
                    People assigned to this task

                    <br>
                    <br>
                    <select name="dseel" id = "dsee1" style="width:170px" onClick="loadMember();">
                        <option value=${taskto1}>${taskto1}</option>
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
                        <option value=${taskto2}>${taskto2}</option>
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
                        <option value=${taskto3}>${taskto3}</option>
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
                        <option value=${taskto4}>${taskto4}</option>
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
                        <option value=${taskto5}>${taskto5}</option>
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
                        <option value=${taskto6}>${taskto6}</option>
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
                        <option value=${taskto7}>${taskto7}</option>
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
                        <option value=${taskto8}>${taskto8}</option>
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
                        <option value=${taskto9}>${taskto9}</option>
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
                        <option value=${taskto10}>${taskto10}</option>
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
                        <option value=${taskto11}>${taskto11}</option>
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
                        <option value=${taskto12}>${taskto12}</option>
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
                        <option value=${taskto13}>${taskto13}</option>
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
                        <option value=${taskto14}>${taskto14}</option>
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
                        <option value=${taskto15}>${taskto15}</option>
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

        </div>

    </body>
</html>
