<%-- 
    Document   : taskReport
    Created on : Jun 2, 2017, 3:23:42 PM
    Author     : Matt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task Reports</title>
        <jsp:include page="_taskReportsHeader.jsp"></jsp:include>
        <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
        <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
        <script>
            
            function loadTaskRoles() {
                var count = $("#taskReportRole option").length;
                if (count.valueOf() < 2) {
                    $.get('taskReportGetRoles', function (responseJson) {
                        if (responseJson != null) {
                            $.each(responseJson, function (key, value) {
                                $('#taskReportRole').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');
//                                $('#dsee2').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');

                            });
                        }
                    });
                }
            }
            
            
            function loadUser() {
                var count = $("#selectReportPeople option").length;
                if (count.valueOf() < 2) {
                    $.get('SecurityGetActiveUser', function (responseJson) {
                        if (responseJson != null) {
                            $.each(responseJson, function (key, value) {
                                $('#selectReportPeople').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
//                                $('#dsee2').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');

                            });
                        }
                    });
                }
            }

            function loadBranch() {
                var count = $("#taskReportBranch option").length;
                if (count.valueOf() < 2) {
                    $.get('SecurityGetBranch', function (responseJson) {
                        if (responseJson != null) {
                            $.each(responseJson, function (key, value) {
                                $('#taskReportBranch').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');
                                 
                            });
                        }
                    });
                }
            }
            
             $(document).ready(function () {
                    $("#closeTaskReport").click(function (event) {
                        window.location = "TaskIndex.jsp";

                    });
                });
        </script>  
    </head>
    <body>
        <br>
        <fieldset style="width:500px ">
            <label> Tasks for: <select id="taskReportFor" style="width:150px; margin-left:27px;"  > <option value=""></option> 
                <option value="All">All</option>
                <option value="In Progress">In Progress</option> 
                <option value="Completed">Completed</option> 
                <option value="Not Started">Not Started</option> 
                <option value="Deferred">Deferred</option> 
                <option value="Waiting On Someone Else">Waiting On Someone Else</option> </select> 
            </label>
            <br>
            <br>
            <label> Select People: <select id="selectReportPeople" style="width:150px" onClick="loadUser();" > <option value=""></option> </select> </label>
            <br>
            <label> Select Branch: <select id="taskReportBranch" style="width:150px" onClick="loadBranch();" > <" option value=""></option> </select> </label>
            <br>
            <label> Select Role: <select id="taskReportRole" style="width:150px; margin-left:17px;" onClick="loadTaskRoles();"> <option value=""></option> </select> </label>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <input type="button" value="Run" id="runTaskReport">
             <input type="button" value="Close" id="closeTaskReport">
            <br>
        </fieldset>
    </body>
</html>
