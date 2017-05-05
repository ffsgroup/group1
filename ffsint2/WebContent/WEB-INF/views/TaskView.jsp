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
                <label id="Recurlabel3"> <input type="text" id="Recurofeverymonth" style="width:35px;"  /> of every month.</label> 
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
                    <option value="1">Monday</option>
                    <option value="2">Tuesday</option>
                    <option value="3">Wednesday</option>
                    <option value="4">Thursday</option>
                    <option value="5">Friday</option>
                    <option value="6">Saturday</option>
                    <option value="7">Sunday</option>
                </select>
              ${recur}
                <script>
//                    document.getElementById("Recur").checked = true;
                    var a = ${recur}
                    if(a == "1"){
                        document.getElementById("Recur").checked = true;
                         $("#Recureveryday").css("visibility", "visible");
                           $("#Recurlabel1").css("visibility", "visible");
                    }
                    else
                    {
                         document.getElementById("Recur").checked = false;
                          $("#Recureveryday").css("visibility", "hidden");
                           $("#Recurlabel1").css("visibility", "hidden");
                          
                    }
                    </script>
                <br>
                <label id="Recurlabel10"><input type="checkbox" id="Recurevery" value="Recur" >Every</label>
                <label id="Recurlabel11"> <input type="text" id="RecurMonths" style="width:55px;" value=${recureverymonths} /> Months</label> 
                <br>
                <label id="Recurlabel12"> <textarea name="notes" id="taskfull" style="width: 575px; height: 205px" cols="60" rows="5" >${taskfull}</textarea></label>    
                <br>
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


        </div>
               
    </body>
</html>
