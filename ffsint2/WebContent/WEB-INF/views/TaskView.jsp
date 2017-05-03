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

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task</title>

        <script>
            $(function () {
                $("#tabs").tabs();
            });
        </script> 
    </head>
    <body>
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
                    Task :  <label id="TaskId"/>${taskid}</label>
                </div>     
                <br>
                <label id="TaskFromLabel" style="float:left">Task From :</label>
                <select name="FromUser" id = "FromUser1" style=" margin-left: 50px; width: 180px" >
                    <option value="" </option>
                </select>
                <script>
                    document.getElementById("FromUser1").value =${taskFromString};
                </script>
                <select name="FromUser2" id = "FromUser3" style=" margin-left: 40px; width: 180px" >
                    <option value="" </option>
                </select>
                <br>
                <div style="float: right; text-align: right; margin-right:50px;">
                    Task Created :  <label id="TaskCreated"/>06/04/2017 3:15:32PM</label>
                </div> 
                <br/>
                Task Summary :<label> <input type="text" id="Tasksumm" style="margin-left:15px;" value=${description}  > </label>     
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
            <div id="tabs-2">
                <p>
                    <label> <textarea name="notes" id="TaskNotes" style="width:575px; height: 455px;" cols="44" rows="10" ></textarea> </label>     
                    <br>
                    <br>
                    <input type ="button" value ="Save" id="Tasksavecomm" style="width:75px; float: right"/>
                    <input type ="button" value ="Update" id="Taskupdatecomm" style="width:75px;  float: right; margin-right: 20px"/>

            </div>


        </div>
    </body>
</html>
