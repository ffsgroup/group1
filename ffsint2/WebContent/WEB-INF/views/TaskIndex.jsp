<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <jsp:include page="_header.jsp"></jsp:include>
        
   

            <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
            <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
            <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

                       

            <script src="resources/dhtmlxcalendar.js"></script>
            <link rel="stylesheet" type="text/css" href="resources/dhtmlxcalendar_1.css"/>
           

            <script>
                
                $(document).ready(function () {
                    $("#ToMeInProg").click(function (event) {
                        $.get('TaskServlet', function (responseJson) {
                            if (responseJson != null) {
                                $("#countrytable").find("tr:gt(0)").remove();
                                var table1 = $("#countrytable");
                                $.each(responseJson, function (key, value) {
                                    var rowNew = $("   <tr> <td></td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>");
                                    rowNew.children().eq(0).text(value['tranid']);
                                    rowNew.children().eq(1).text(value['taskto1']);
                                    rowNew.children().eq(2).text(value['description']);
                                    rowNew.children().eq(3).text(value['startdate']);
                                    rowNew.children().eq(4).text(value['revdate']);
                                    rowNew.children().eq(5).text(value['enddate']);
                                    rowNew.children().eq(6).text(value['statusday']);
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
             <h2>Tasks</h2>
             <b>Tasks In Progress :</b><input type="checkbox" id="ToMeInProg" value="ToMe">Assigned To Me
                               <input type="checkbox" id="ByMeInProg" value="ByMe" >Assigned By Me
                               <input type="checkbox" id="TaskInFuture" value="InFuture" >Tasks In The Future<br>
             <b>Tasks Completed :</b><input type="checkbox" id="ToMeComp" value="CompToMe">Assigned To Me
                               <input type="checkbox" id="ByMeComp" value="CompByMe" >Assigned By Me<br>
                               <input type="checkbox" id="NewTask" value="ByMe" >New Tasks
                               <input type="checkbox" id="UpdatedTasks" value="ToMe">Updated Tasks
                               <input type="checkbox" id="UrgentTasks" value="ByMe" >Urgent Tasks
                               <input type="checkbox" id="TrainingTasks" value="ToMe">Training Tasks
                            
                               
        
        <div style="margin-bottom: 20px;">
        </div>
        <div id="calendarHere" style="position:relative;height:320px; float:right;margin-right: 250px"></div>

        <div id="tablediv">

            <table cellspacing="0" id="countrytable" margin-right:20px style="table-layout:fixed;float: left; border-collapse: collapse;"> 

                <tr> 
                    <th style="width:60px" scope="col">ID</th> 
                    <th style="width:100px" scope="col">To</th> 
                    <th style="width:150px" scope="col">Description</th> 
                    <th style="width:100px" scope="col">Review Date</th> 
                    <th style="width:100px" scope="col">End Date</th> 
                    <th style="width:100px" scope="col">Status Date</th> 
                    <th style="width:100px" scope="col">Start Date</th> 
                <tr>
                    <td>11111 </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td></tr>
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
                  
                  </tr>


            </table>
        </div>


  
            
    
        <button id="Button1"></button>
        


        


        
        


    </body>
    <jsp:include page="_footer.jsp"></jsp:include>
</html>