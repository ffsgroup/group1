<%-- 
    Document   : taskMyIdea
    Created on : Jun 2, 2017, 3:24:00 PM
    Author     : Matt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task My Ideas</title>
        <jsp:include page="_taskMyIdeasHeader.jsp"></jsp:include>
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
    </head>
    <body>
        <br>
        <fieldset style="width:780px; height: 660px;">
            <label> <textarea name="taskMyIdeas" id="taskMyIdeas" style="width:775px; height: 625px;"  ></textarea> </label> 
             <input type ="button" value ="Save and Close" id="taskMyIdeaSave" style="float:right">
        </fieldset>
    </body>
</html>
