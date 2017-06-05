<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task Search</title>
        <jsp:include page="_TaskSearchHeader.jsp"></jsp:include>
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
                $(document).ready(function () {
                    $("#countrytable").click(function (event) {
                        var target = $(event.target);
                        $td = target.closest('td');
                        var col = $td.index();
                        var row = $td.closest('tr').index();
                        window.location = "TaskView.jsp?key=" + encodeURIComponent(document.getElementById("countrytable").rows[row + 1].cells[0].innerHTML);

                    });
                });                
                
                $(document).ready(function () {
                    $("#searchNow").click(function (event) {
                        $.get('TaskSearchDo', {idSearch: document.getElementById("searchId").value, summSearch: document.getElementById("searchSumm").value}, function (responseJson) {
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
            </script>

        </head>
        <body>
            <br>
            Search task ID <input type="text" id="searchId" style="width:120px;margin-left:42px;">
            <br>
            Search task summary <input type ="text" id="searchSumm" style="width:120px;">
            <br>
            <br>
            <input type="button" value="Search" id="searchNow">
            <br>
            <br>
            Search Results
            <div id="tablediv">

                <table cellspacing="0" id="countrytable" margin-right:20px style="border-collapse: collapse;" > 
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
                    <p>${errorString}</p>

                </tbody>

            </table>
        </div>
        
        <script>
            $('table').on('scroll', function () {
                $("table > *").width($("table").width() + $("table").scrollLeft());
            });
        </script>        
    </body>
</html>
