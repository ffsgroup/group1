<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <jsp:include page="_TaskHeader.jsp"></jsp:include>
            <title>Tasks</title>

            <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
            <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
            <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
            <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

            <script>              
                
                $(document).ready(function () {
                    $("#runTaskReport").click(function (event) {
                        
                        if (document.getElementById("selectReportPeople").value.length > 1) {
                        $.get('TaskReportFor', {reportFor: document.getElementById("taskReportFor").value, reportPeople: document.getElementById("selectReportPeople").value}, function (responseJson) {
                            if (responseJson != null) {
                             //  window.location = "resources/test.txt"; 
                                $.each(responseJson, function (key, value) {
                                    if (value['taskfrom'].length > 1) {
                                    window.location = "resources/" + value['taskfrom']; }
                                else {
                                        alert("failed");
                                    }
                                });
                            }
                        });
                    }
                     
                       if (document.getElementById("taskReportBranch").value.length > 1) {
                        $.get('TaskReportBranch', {reportFor: document.getElementById("taskReportFor").value, reportBranch: document.getElementById("taskReportBranch").value}, function (responseJson) {
                            if (responseJson != null) {
                          //     window.location = "resources/test.txt"; 
                                $.each(responseJson, function (key, value) {
                                    if (value['taskfrom'].length > 1) {
                                    window.location = "resources/" + value['taskfrom']; }
                                else {
                                        alert("failed");
                                    }
                                });
                            }
                        });
                    }
                    
                       if (document.getElementById("taskReportRole").value.length > 1) {
                        $.get('TaskReportRole', {reportFor: document.getElementById("taskReportFor").value, reportRole: document.getElementById("taskReportRole").value}, function (responseJson) {
                            if (responseJson != null) {
                          //     window.location = "resources/test.txt"; 
                                $.each(responseJson, function (key, value) {
                                    if (value['taskfrom'].length > 1) {
                                    window.location = "resources/" + value['taskfrom']; }
                                else {
                                        alert("failed");
                                    }
                                });
                            }
                        });
                    }
                    
                    
                    });
                });


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
                        $('#taskReportBranch').append('<option value=""></option>');
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
            <div>
                <br>
                <fieldset style="width:500px ">

                    <label> Tasks for: <select id="taskReportFor" style="width:150px; margin-left:27px;"  >
                            <option value=""></option> 
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
                    <label> Select Branch: <select id="taskReportBranch" style="width:150px" onClick="loadBranch();" > <option value=""></option> </select> </label>
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
            </div>
            
        </body>
    <jsp:include page="_footer.jsp"></jsp:include>
</html>
