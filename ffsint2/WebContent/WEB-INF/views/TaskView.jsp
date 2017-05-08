<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="true" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
    </head>
    <body>



        <div id="tabs" style="width:40%;  height:670px; margin-left: 40px;">
            <ul>
                <li><a href="#tabs-1">Details</a></li>
                <li><a href="#tabs-2">Notes</a></li>
                <li><a href="#tabs-3">People</a></li>
                <li><a href="#tabs-4">Images</a></li>
            </ul>

            <div id="tabs-1">
                <p>
                <div style="float: Left; text-align: left;">
                    Task :  <label id="TaskId"/>${taskid}</label>
                </div>     
                <br>
                <label id="TaskFromLabel" style="float:left">Task From :</label>
                <select name="FromUser" id = "FromUser1" style=" margin-left: 50px; width: 180px" >
                    <option value=${taskfrom}>${taskfrom}</option>
                </select>
                <script>
                    document.getElementById("FromUser1").value =${taskFromString};
                </script>
                <select name="FromUser2" id = "FromUser3" style=" margin-left: 40px; width: 180px" >
                    <option value="" </option>
                </select>
                <br>
                <div style="float: right; text-align: right; margin-right:5px;">
                    Task Created :  <label id="TaskCreated"/>${taskdate}</label>
                </div> 
                <br/>
                Task Summary :<label> <input type="text" id="Tasksumm" style=" width:250px; margin-left:15px;" value=${description}  > </label>     
                <br>
                IR Nr : <label> <input type="text" id="Irnr" style="width: 60px; margin-left:83px" value=${irnr} /> </label> 
                <input type="checkbox" id="RequestIR" value="ReqIR">Request IR Nr
                <br>
                <label><input type="checkbox" id="Recur" value="Recur" >Recurrence</label>
                <br>
                <label id="Recurlabel1"><input type="checkbox" id="Recureveryday" value="Recur" >Every Day</label>
                <label id="Recurlabel2"><input type="checkbox" id="Recurday" value="Recur" style="margin-left:68px" >Day</label>
                <label id="Recurlabel3"> <input type="text" id="Recurofeverymonth" style="width:35px;" value=${recurday}  /> of every month.</label> 
                <label id="Recurlabel4"><input type="checkbox" id="RecurWeekly" value="Recur" style="margin-left:30px" >Weekly</label>
                <br>
                <label id="Recurlabel5"><input type="checkbox" id="Recureveryweekday" value="Recur" >Every Weekday</label>
                <label id="Recurlabel6"><input type="checkbox" id="Recurlastday" value="Recur" style="margin-left:30px" >last day of every month</label>
                <label id="Recurlabel7"><input type="checkbox" id="Recurmonthly" value="Recur" style="margin-left:53px" >Monthly</label>
                <br>
                <label id="Recurlabel8"><input type="checkbox" id="Recurexceptsun" value="Recur" >Every Day Except Sunday</label>
                <label id="Recurlabel9"><input type="checkbox" id="Recurevery" value="Recur" style="margin-left:30px" >Every</label>
                <select name="RecurDay" id = "RecurDay1" style=" margin-left: 10px; width: 110px;" >
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
                    document.getElementById("RecurDay1").value = ${recdayofweek};
                </script>

                <br>
                <label id="Recurlabel10"><input type="checkbox" id="Recureverymonth" value="Recur" >Every</label>
                <label id="Recurlabel11"> <input type="text" id="RecurMonths" style="width:55px;" value=${recureverymonths} /> Months</label> 
                <br>
                <label> <textarea name="notes" id="taskfull" style="width: 575px; height: 205px" cols="60" rows="5" >${taskfull}</textarea></label>    
                <br>
                <script>
//                    document.getElementById("Recur").checked = true;
                    var a = ${recur}
                    if (a == "1") {
                        document.getElementById("Recur").checked = true;
                        $("#Recureveryday").css("visibility", "visible");
                        $("#Recurlabel1").css("visibility", "visible");
                        $("#Recurday").css("visibility", "visible");
                        $("#Recurlabel2").css("visibility", "visible");
                        $("#Recurofeverymonth").css("visibility", "visible");
                        $("#Recurlabel3").css("visibility", "visible");
                        $("#RecurWeekly").css("visibility", "visible");
                        $("#Recurlabel4").css("visibility", "visible");
                        $("#Recureveryweekday").css("visibility", "visible");
                        $("#Recurlabel5").css("visibility", "visible");
                        $("#Recurlastday").css("visibility", "visible");
                        $("#Recurlabel6").css("visibility", "visible");
                        $("#Recurmonthly").css("visibility", "visible");
                        $("#Recurlabel7").css("visibility", "visible");
                        $("#Recurexceptsun").css("visibility", "visible");
                        $("#Recurlabel8").css("visibility", "visible");
                        $("#Recurevery").css("visibility", "visible");
                        $("#Recurlabel9").css("visibility", "visible");
                        $("#RecurDay1").css("visibility", "visible");
                        $("#Recureverymonth").css("visibility", "visible");
                        $("#Recurlabel10").css("visibility", "visible");
                        $("#RecurMonths").css("visibility", "visible");
                        $("#Recurlabel11").css("visibility", "visible");
                    } else
                    {
                        document.getElementById("Recur").checked = false;
                        $("#Recureveryday").css("visibility", "hidden");
                        $("#Recurlabel1").css("visibility", "hidden");
                        $("#Recurday").css("visibility", "hidden");
                        $("#Recurlabel2").css("visibility", "hidden");
                        $("#Recurofeverymonth").css("visibility", "hidden");
                        $("#Recurlabel3").css("visibility", "hidden");
                        $("#RecurWeekly").css("visibility", "hidden");
                        $("#Recurlabel4").css("visibility", "hidden");
                        $("#Recureveryweekday").css("visibility", "hidden");
                        $("#Recurlabel5").css("visibility", "hidden");
                        $("#Recurlastday").css("visibility", "hidden");
                        $("#Recurlabel6").css("visibility", "hidden");
                        $("#Recurmonthly").css("visibility", "hidden");
                        $("#Recurlabel7").css("visibility", "hidden");
                        $("#Recurexceptsun").css("visibility", "hidden");
                        $("#Recurlabel8").css("visibility", "hidden");
                        $("#Recurevery").css("visibility", "hidden");
                        $("#Recurlabel9").css("visibility", "hidden");
                        $("#RecurDay1").css("visibility", "hidden");
                        $("#Recureverymonth").css("visibility", "hidden");
                        $("#Recurlabel10").css("visibility", "hidden");
                        $("#RecurMonths").css("visibility", "hidden");
                        $("#Recurlabel11").css("visibility", "hidden");



                    }
                </script>
                <script>
                    var a = ${recuri}
                    if (a == "1") {
                        document.getElementById("Recurmonthly").checked = true;
                    } else
                    {
                        document.getElementById("Recurmonthly").checked = false;
                    }
                </script>
                <script>
                    var a = ${recurh}
                    if (a == "1") {
                        document.getElementById("RecurWeekly").checked = true;
                    } else
                    {
                        document.getElementById("RecurWeekly").checked = false;
                    }
                </script>
                <script>
                    var a = ${recure}
                    if (a == "1") {
                        document.getElementById("Recurlastday").checked = true;
                    } else
                    {
                        document.getElementById("Recurlastday").checked = false;
                    }
                </script>
                <script>
                    var a = ${recurg}
                    if (a == "1") {
                        document.getElementById("Recureverymonth").checked = true;
                    } else
                    {
                        document.getElementById("Recureverymonth").checked = false;
                    }
                </script>
                <script>
                    var a = ${recurc}
                    if (a == "1") {
                        document.getElementById("Recurexceptsun").checked = true;
                    } else
                    {
                        document.getElementById("Recurexceptsun").checked = false;
                    }
                </script>
                <script>
                    var a = ${recurb}
                    if (a == "1") {
                        document.getElementById("Recureveryweekday").checked = true;
                    } else
                    {
                        document.getElementById("Recureveryweekday").checked = false;
                    }
                </script>
                <script>
                    var a = ${recura}
                    if (a == "1") {
                        document.getElementById("Recureveryday").checked = true;
                    } else
                    {
                        document.getElementById("Recureveryday").checked = false;
                    }
                </script>
                <script>
                    var a = ${recurf}
                    if (a == "1") {
                        document.getElementById("Recurevery").checked = true;
                    } else
                    {
                        document.getElementById("Recurevery").checked = false;
                    }
                </script>
                <script>
                    var a = ${recurd}
                    if (a == "1") {
                        document.getElementById("Recurday").checked = true;
                    } else
                    {
                        document.getElementById("Recurday").checked = false;
                    }
                </script>

                <script>

                    if (document.getElementById("taskfull").value.length > 0) {

                        document.getElementById("taskfull").value = document.getElementById("taskfull").value.replace(/~/g, "\n");
                    }
                </script>
                <label id="linkedTasks" style="color:blue; float: right; text-align: right; margin-right:100px;"/>Linked Tasks</label>

                Start Date :<label> <input type="text" id = "startdate" style="margin-left:27px; width: 135px;" value= ${startdate} /></label> 
                <br> 
                Review Date :<label> <input type="text" id = "Reviewdate" style="margin-left:10px; width: 135px;" value= ${revdate}/></label>
                <br>
                End Date :<label> <input type="text" id = "enddate" style="margin-left:32px; width: 135px;" value= ${enddate}/></label>
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
                <label id="Statusday" style=" margin-left:30px;"/>${statusday}</label>
                <br>
                <label id="Status" style="float:left; ">Status :</label>
                <select name="Status" id = "Status1" style=" width: 120px; margin-left:55px;">
<!--                     <option value="">${taskstat}</option>-->
                    <option value="Not Started">Not Started</option>
                    <option value="In Progress">In Progress</option>
                    <option value="Completed">Completed</option>
                    <option value="Waiting On Someone Else">Waiting On Someone Else</option>
                    <option value="Deferred">Deferred</option>
                </select>
                <script>
                    document.getElementById("Status1").value = ${taskstat};
                </script>

                <input type ="button" value ="Save" id="Tasksave" style="width:75px; float:right;"/>

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
                    <input type ="button" value ="Save" id="Tasksavecomm" style="width:75px; float: right"/>
                    <input type ="button" value ="Update" id="Taskupdatecomm" style="width:75px;  float: right; margin-right: 20px"/>

            </div>
            <div id="tabs-3">
                <form method="post" class="signin" action="#">
                    <br>
                    People assigned to this task

                    <br>
                    <br>
                    <select name="dseel" id = "dsee1" style="width:170px">
                        <option value=${taskto1}>${taskto1}</option>
                    </select>
                    
                    <label id="taskstat1" style=" margin-left:50px;"/>${taskstat1}</label>
                
                <script>
                    a
                    document.getElementById("taskstat1").value.length
                    if( document.getElementById("taskstat1").value.length < 3){
                     document.getElementById("taskstat1").value = "Not Started"
                    }
                    </script>
                    <label id="taskstatdate1" style=" margin-left:50px;"/>${statusday}</label>
                    <br>
                    <select name="dsee2" id = "dsee2" style="width:170px">
                        <option value=${taskto2}>${taskto2}</option>
                    </select>
                    <label id="taskstat2" style=" margin-left:50px;"/>${taskstat2}</label>
                    <label id="taskstatdate2" style=" margin-left:50px;"/>${statusday}</label>
                    <br>
                    <select name="dsee3" id = "dsee3" style="width:170px">
                        <option value=${taskto3}>${taskto3}</option>
                    </select>           
                    <label id="taskstat3" style=" margin-left:50px;"/>${taskstat3}</label>
                    <label id="taskstatdate3" style=" margin-left:50px;"/>${statusday}</label>
                    <br>
                    <select name="dsee4" id = "dsee4" style="width:170px">
                        <option value=${taskto4}>${taskto4}</option>
                    </select>           
                    <label id="taskstat4" style=" margin-left:50px;"/>${taskstat4}</label>
                    <label id="taskstatdate4" style=" margin-left:50px;"/>${statusday}</label>
                    <br>
                    <select name="dsee5" id = "dsee5" style="width:170px">
                        <option value=${taskto5}>${taskto5}</option>
                    </select>           
                    <label id="taskstat5" style=" margin-left:50px;"/>${taskstat5}</label>
                    <label id="taskstatdate5" style=" margin-left:50px;"/>${statusday}</label>
                    <br>
                    <select name="dsee6" id = "dsee6" style="width:170px">
                        <option value=${taskto6}>${taskto6}</option>
                    </select>           
                    <label id="taskstat6" style=" margin-left:50px;"/>${taskstat6}</label>
                    <label id="taskstatdate6" style=" margin-left:50px;"/>${statusday}</label>
                    <br>
                    <select name="dsee7" id = "dsee7" style="width:170px">
                        <option value=${taskto7}>${taskto7}</option>
                    </select> 
                    <label id="taskstat7" style=" margin-left:50px;"/>${taskstat7}</label>
                    <label id="taskstatdate7" style=" margin-left:50px;"/>${statusday}</label>
                    <br>
                    <select name="dsee8" id = "dsee8" style="width:170px">
                        <option value=${taskto8}>${taskto8}</option>
                    </select>           
                    <label id="taskstat8" style=" margin-left:50px;"/>${taskstat8}</label>
                    <label id="taskstatdate8" style=" margin-left:50px;"/>${statusday}</label>
                    <br>
                    <select name="dsee9" id = "dsee9" style="width:170px">
                        <option value=${taskto9}>${taskto9}</option>
                    </select>           
                    <label id="taskstat9" style=" margin-left:50px;"/>${taskstat9}</label>
                    <label id="taskstatdate9" style=" margin-left:50px;"/>${statusday}</label>
                    <br>
                    <select name="dsee10" id = "dsee10" style="width:170px">
                        <option value=${taskto10}>${taskto10}</option>
                    </select> 
                    <label id="taskstat10" style=" margin-left:50px;"/>${taskstat10}</label>
                    <label id="taskstatdate10" style=" margin-left:50px;"/>${statusday}</label>
                    <br>
                    <select name="dsee11" id = "dsee11" style="width:170px">
                        <option value=${taskto11}>${taskto11}</option>
                    </select>           
                    <label id="taskstat11" style=" margin-left:50px;"/>${taskstat11}</label>
                    <label id="taskstatdate11" style=" margin-left:50px;"/>${statusday}</label>
                    <br>
                    <select name="dsee12" id = "dsee12" style="width:170px">
                        <option value=${taskto12}>${taskto12}</option>
                    </select>           
                    <label id="taskstat12" style=" margin-left:50px;"/>${taskstat12}</label>
                    <label id="taskstatdate12" style=" margin-left:50px;"/>${statusday}</label>
                    <br>
                    <select name="dsee13" id = "dsee13" style="width:170px">
                        <option value=${taskto13}>${taskto13}</option>
                    </select>           
                    <label id="taskstat13" style=" margin-left:50px;"/>${taskstat13}</label>
                    <label id="taskstatdate13" style=" margin-left:50px;"/>${statusday}</label>
                    <br>
                    <select name="dsee14" id = "dsee14" style="width:170px">
                        <option value=${taskto14}>${taskto14}</option>
                    </select>           
                    <label id="taskstat14" style=" margin-left:50px;"/>${taskstat14}</label>
                    <label id="taskstatdate14" style=" margin-left:50px;"/>${statusday}</label>
                    <br>
                    <select name="dsee15" id = "dsee15" style="width:170px">
                        <option value=${taskto15}>${taskto15}</option>
                    </select> 
                    <label id="taskstat15" style=" margin-left:50px;"/>${taskstat15}</label>
                    <label id="taskstatdate15" style=" margin-left:50px;"/>${statusday}</label>
                    <br/>            
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                   

                    <input type ="button" value ="Close" id="Taskpeoplecls" style="width:75px; float: right"/>
                    <input type ="button" value ="Update" id="Taskupdatepeople" style="width:75px;  float: right; margin-right: 5px"/>

            </div>
        </div>

    </body>
</html>
