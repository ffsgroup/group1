<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="true" %>
<jsp:include page="_SecurityHeader.jsp"></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
        <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Security</title>

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
                border: solid 1px grey;
            }
            tbody {
                overflow-y: scroll;
                overflow-x: hidden;
                height: 45%;
            }
        </style> 
    </head>
    <body>
        <div id="tablediv" style="position:relative;height:320px;">

            <table cellspacing="0" id="countrytable" margin-right:20px> 
                <thead>
                <tr> 
                    <th style="min-width:200px; width:200px" scope="col">Name</th> 
                    <th style="min-width:100px; width:100px" scope="col">Login</th> 
                    <th style="min-width:100px; width:100px" scope="col">Branch</th> 
                    <th style="min-width:45px; width:45px" scope="col">ID</th> 
                </tr>
                </thead>
                <tbody>
                <p>${errorString}</p>

                </tbody>
            </table>
        </div>
        <br>
        <div id="tabs" style="width:80%;">
            <ul>
                <li><a href="#tabs-1">Policies</a></li>
                <li><a href="#tabs-2">Claims</a></li>
                <li><a href="#tabs-3">Vehicle</a></li>
                <li><a href="#tabs-4">Reports</a></li>
                <li><a href="#tabs-5">Misc</a></li>
                <li><a href="#tabs-6">Tasks</a></li>
                <li><a href="#tabs-7">Tombstone</a></li>
                <li><a href="#tabs-8">Other</a></li>
                <li><a href="#tabs-9">Codes</a></li>

            </ul>
            <div id="tabs-1">
            </div>        
            <div id="tabs-2">
            </div>  
            <div id="tabs-3">
            </div>  
            <div id="tabs-4">
            </div>  
            <div id="tabs-5">
            </div> 
            <div id="tabs-6">
            </div> 
            <div id="tabs-7">
            </div> 
            <div id="tabs-8">
            </div> 
            <div id="tabs-9">
            </div> 
        </div> 

        <script>
            $(function () {
                $("#tabs").tabs();
            });
        </script>    

        <script>
            $('table').on('scroll', function () {
                $("table > *").width($("table").width() + $("table").scrollLeft());
            });
        </script>
    </body>
</html>
