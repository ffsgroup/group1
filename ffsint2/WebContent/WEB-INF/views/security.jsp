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

        <script>
                $(document).ready(function () {
                    $("#createuser").click(function (event) {
                //        if (document.getElementById("newname").value.length > 5 && document.getElementById("newuser").value.length > 5 && document.getElementById("newbranch").value.length > 5 ) {
                        $.get('SecurityNewUser', {name: document.getElementById("newname").value, user: document.getElementById("newuser").value, branch:document.getElementById("newbranch").value}, function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    if (value["GenericDescriptionEng"] == "success") {
                                        document.getElementById("newname").value = "";
                                        document.getElementById("newuser").value = "";
                                      alert("User was created.");
                                    } else {
                                      alert("An error ocurred. This user was not created");
                                    }
                                });
                        }  
                        });
               //     }
                    });
                });            
            
           function loadMemberDel() {
                    var count = $("#deluser option").length;
                    if (count.valueOf() < 1) {
                        $.get('SecurityGetAllUser', function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    $('#deluser').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                });
                            }
                        });
                    } 
           }            
            
           function newMemberBranch () {
                    var count = $("#newbranch option").length;
                    if (count.valueOf() < 1) {
                        $.get('SecurityGetBranch', function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    $('#newbranch').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');
                                });
                            }
                        });
                    } 
           }
            
            $(document).ready(function () {
                $("#countrytable").click(function (event) {
                    var target = $(event.target);
                    $td = target.closest('td');
                    var col = $td.index();
                    var row = $td.closest('tr').index();

                    $.get('SecurityGetUser', {tranid: document.getElementById("countrytable").rows[row + 1].cells[3].innerHTML}, function (responseJson) {
                        if (responseJson != null) {
                            $.each(responseJson, function (key, value) {
                                document.getElementById("username").innerHTML = value['userName'];
                                document.getElementById("userid").innerHTML = value['tranid'];

                                document.getElementById("test1").value = value['securestr'].substring(0, 1);
                                if (value['securestr'].substring(0, 1) == "1") {
                                    document.getElementById("polaccupd").checked = true;
                                } else {
                                    document.getElementById("polaccupd").checked = false;
                                }


                            });

                        }
                    });
                });
            });

        </script>                 


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
                height: 85%;
            }
        </style> 
    </head>
    <body>
        <div id="tablediv" style="position:relative;height:220px;">

            <table cellspacing="0" id="countrytable" margin-right:20px> 
                <thead>
                    <tr> 
                        <th style="min-width:200px; width:200px" scope="col">Name</th> 
                        <th style="min-width:130px; width:130px" scope="col">Login</th> 
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
                <li><a href="#tabs-1">Password</a></li>
                <li><a href="#tabs-2">Policies</a></li>
                <li><a href="#tabs-3">Claims</a></li>
                <li><a href="#tabs-4">Vehicle</a></li>
                <li><a href="#tabs-5">Reports</a></li>
                <li><a href="#tabs-6">Misc</a></li>
                <li><a href="#tabs-7">Tasks</a></li>
                <li><a href="#tabs-8">Tombstone</a></li>
                <li><a href="#tabs-9">Other</a></li>
                <li><a href="#tabs-10">Codes</a></li>

            </ul>
            <div id="tabs-1" style="height:220px;color:black">
                User : <label id="username"> </label>
                <br>
                Id : <label id="userid"> </label>
                <br>
                Change password : <input type ="text" id="newpass" style="width:80px;">
                <input type="button" id="changepass" value="Change" style="width:80px;">
                <br>
                Log off user <input type="button" value="Log Off" id="logoff" style="width:80px;">
                <br><br>
                <div style="border:1px solid grey; width:300px; float:left">
                    <label style="font-weight:bold">Create User </label> <br>
                    User Name <input type="text" id="newname" style="width:100px">
                    <br>
                    Login <input type="text" id="newuser" style="width:100px; margin-left:32px;">
                    <br>
                    Branch <select id="newbranch" style="width:100px;margin-left:22px;" onClick="newMemberBranch();" > </select>
                    <input type="button" value="Create" id="createuser" style="float:right;">
                    <br>
                </div>  
                
                <div style="border:1px solid grey; width:300px; float:left; margin-left:50px">
                    <label style="font-weight:bold">Delete User</label>
                    <br>
                    Select User <select id="deluser" style="width:150" onClick="loadMemberDel();"></select>
                    <br>
                    <br>
                    <input type="button" value="Delete" id="deleteuser" style="float:right;">
                    
                </div>
            </div>
                <div id="tabs-2">
                    <input type ="checkbox" id="polaccupd"> Update Accounts <br>
                    <input type="text" id="test1"> <br>

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
                <div id="tabs-10">
                </div> 
            </div> 
            <br>

            <br>
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
