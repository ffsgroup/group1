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
                $("#logoff").click(function (event) {
                    if (document.getElementById("username").innerHTML.length > 1) {
                        //        if (document.getElementById("newname").value.length > 5 && document.getElementById("newuser").value.length > 5 && document.getElementById("newbranch").value.length > 5 ) {
                        $.get('SecurityLogoff', {name: document.getElementById("username").innerHTML}, function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    if (value["GenericDescriptionEng"] == "success") {
                                        document.getElementById("newpass").value = "";
                                        alert("User logged off.");
                                    } else {
                                        alert("An error ocurred. User not logged off. " + value["GenericDescriptionEng"]);
                                    }
                                });
                            }
                        });

                    } else {
                        alert('Select user first');
                    }

                });
            });

            $(document).ready(function () {
                $("#changepass").click(function (event) {
                    if (document.getElementById("username").innerHTML.length > 1) {
                        //        if (document.getElementById("newname").value.length > 5 && document.getElementById("newuser").value.length > 5 && document.getElementById("newbranch").value.length > 5 ) {
                        $.get('SecurityChangePass', {name: document.getElementById("username").innerHTML, passw: document.getElementById("newpass").value}, function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    if (value["GenericDescriptionEng"] == "success") {
                                        document.getElementById("newpass").value = "";
                                        alert("Password changed.");
                                    } else {
                                        alert("An error ocurred. Password not changed. " + value["GenericDescriptionEng"]);
                                    }
                                });
                            }
                        });

                    } else {
                        alert('Select user first');
                    }

                });
            });


            $(document).ready(function () {
                $("#deleteuser").click(function (event) {
                    //        if (document.getElementById("newname").value.length > 5 && document.getElementById("newuser").value.length > 5 && document.getElementById("newbranch").value.length > 5 ) {
                    $.get('SecurityDelUser', {name: document.getElementById("deluser").value}, function (responseJson) {
                        if (responseJson != null) {
                            $.each(responseJson, function (key, value) {
                                if (value["GenericDescriptionEng"] == "success") {
                                    document.getElementById("deluser").value = "";
                                    alert("User was deleted.");
                                } else {
                                    alert("An error ocurred. This user was not deleted");
                                }
                            });
                        }
                    });
                    //     }
                });
            });

            $(document).ready(function () {
                $("#createuser").click(function (event) {
                    //        if (document.getElementById("newname").value.length > 5 && document.getElementById("newuser").value.length > 5 && document.getElementById("newbranch").value.length > 5 ) {
                    $.get('SecurityNewUser', {name: document.getElementById("newname").value, user: document.getElementById("newuser").value, branch: document.getElementById("newbranch").value}, function (responseJson) {
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

            function newMemberBranch() {
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
                                if (value['securestr'].substring(3, 4) == "1") {
                                    document.getElementById("sec4").checked = true;
                                } else {
                                    document.getElementById("sec4").checked = false;
                                }
                                if (value['securestr'].substring(9, 10) == "1") {
                                    document.getElementById("sec10").checked = true;
                                } else {
                                    document.getElementById("sec10").checked = false;
                                }
                                if (value['securestr'].substring(4, 5) == "1") {
                                    document.getElementById("sec5").checked = true;
                                } else {
                                    document.getElementById("sec5").checked = false;
                                }
                                if (value['securestr'].substring(41, 42) == "1") {
                                    document.getElementById("sec42").checked = true;
                                } else {
                                    document.getElementById("sec42").checked = false;
                                }
                                if (value['securestr'].substring(43, 44) == "1") {
                                    document.getElementById("sec44").checked = true;
                                } else {
                                    document.getElementById("sec44").checked = false;
                                }
                                if (value['securestr'].substring(2, 3) == "1") {
                                    document.getElementById("sec3").checked = true;
                                } else {
                                    document.getElementById("sec3").checked = false;
                                }
                                if (value['securestr'].substring(1, 2) == "1") {
                                    document.getElementById("sec2").checked = true;
                                } else {
                                    document.getElementById("sec2").checked = false;
                                }
                                if (value['securestr'].substring(70, 71) == "1") {
                                    document.getElementById("sec71").checked = true;
                                } else {
                                    document.getElementById("sec71").checked = false;
                                }
                                if (value['securestr'].substring(10, 11) == "1") {
                                    document.getElementById("sec11").checked = true;
                                } else {
                                    document.getElementById("sec11").checked = false;
                                }
                                if (value['securestr'].substring(11, 12) == "1") {
                                    document.getElementById("sec12").checked = true;
                                } else {
                                    document.getElementById("sec12").checked = false;
                                }
                                if (value['securestr'].substring(45, 46) == "1") {
                                    document.getElementById("sec46").checked = true;
                                } else {
                                    document.getElementById("sec46").checked = false;
                                }
                                if (value['securestr'].substring(42, 43) == "1") {
                                    document.getElementById("sec43").checked = true;
                                } else {
                                    document.getElementById("sec43").checked = false;
                                }
                                if (value['securestr'].substring(15, 16) == "1") {
                                    document.getElementById("sec16").checked = true;
                                } else {
                                    document.getElementById("sec16").checked = false;
                                }
                                if (value['securestr'].substring(7, 8) == "1") {
                                    document.getElementById("sec8").checked = true;
                                } else {
                                    document.getElementById("sec8").checked = false;
                                }
                                if (value['securestr'].substring(71, 72) == "1") {
                                    document.getElementById("sec72").checked = true;
                                } else {
                                    document.getElementById("sec72").checked = false;
                                }
                                if (value['securestr'].substring(72, 73) == "1") {
                                    document.getElementById("sec73").checked = true;
                                } else {
                                    document.getElementById("sec73").checked = false;
                                }
                                if (value['securestr'].substring(58, 59) == "1") {
                                    document.getElementById("sec59").checked = true;
                                } else {
                                    document.getElementById("sec59").checked = false;
                                }
                                if (value['securestr'].substring(59, 60) == "1") {
                                    document.getElementById("sec60").checked = true;
                                } else {
                                    document.getElementById("sec60").checked = false;
                                }
                                if (value['securestr'].substring(60, 61) == "1") {
                                    document.getElementById("sec61").checked = true;
                                } else {
                                    document.getElementById("sec61").checked = false;
                                }
                                if (value['securestr'].substring(61, 62) == "1") {
                                    document.getElementById("sec62").checked = true;
                                } else {
                                    document.getElementById("sec62").checked = false;
                                }
                                if (value['securestr'].substring(67, 68) == "1") {
                                    document.getElementById("sec68").checked = true;
                                } else {
                                    document.getElementById("sec68").checked = false;
                                }
                                if (value['securestr'].substring(73, 74) == "1") {
                                    document.getElementById("sec74").checked = true;
                                } else {
                                    document.getElementById("sec74").checked = false;
                                }
                                if (value['securestr'].substring(76, 77) == "1") {
                                    document.getElementById("sec77").checked = true;
                                } else {
                                    document.getElementById("sec77").checked = false;
                                }
                                if (value['securestr'].substring(77, 78) == "1") {
                                    document.getElementById("sec78").checked = true;
                                } else {
                                    document.getElementById("sec78").checked = false;
                                }
                                if (value['securestr'].substring(102, 103) == "1") {
                                    document.getElementById("sec103").checked = true;
                                } else {
                                    document.getElementById("sec103").checked = false;
                                }
                                if (value['securestr'].substring(103, 104) == "1") {
                                    document.getElementById("sec104").checked = true;
                                } else {
                                    document.getElementById("sec104").checked = false;
                                }
                                if (value['securestr'].substring(126, 127) == "1") {
                                    document.getElementById("sec127").checked = true;
                                } else {
                                    document.getElementById("sec127").checked = false;
                                }
                                if (value['securestr'].substring(147, 148) == "1") {
                                    document.getElementById("sec148").checked = true;
                                } else {
                                    document.getElementById("sec148").checked = false;
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
            table.userGrid {
                border-collapse: collapse;
                width: 50%;
                overflow-x: scroll;
                display: block;
            }
            thead {
                background-color: #EFEFEF;
            }
            thead, tbody{
                display: block;
            }
            td.userGrid, th {
                min-width: 100px;
                height: 25px;
                border: solid 1px grey;
            }
            tbody.userGrid {
                overflow-y: scroll;
                overflow-x: hidden;
                height: 85%;
            }
        </style> 
    </head>
    <body>
        <div id="tablediv" style="position:relative;height:220px;">

            <table class = "userGrid" cellspacing="0" id="countrytable" margin-right:20px> 
                <thead>
                    <tr> 
                        <th style="min-width:200px; width:200px" scope="col">Name</th> 
                        <th style="min-width:130px; width:130px" scope="col">Login</th> 
                        <th style="min-width:100px; width:100px" scope="col">Branch</th> 
                        <th style="min-width:45px; width:45px" scope="col">ID</th> 
                    </tr>
                </thead>
                <tbody style = "overflow-y: scroll;overflow-x: hidden; height: 85%;">
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

                <table class="table newtable1" style="border:none; width:75%;">
                    <tbody>
                        <tr>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec4" >Update Accounts </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec11">Issue Alert </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec59">View All OP </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec103">Print Offline </label></td>
                        </tr>
                        <tr>    
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec10"> Update Notes </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec12"> Remove Alert</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec60"> Edit OP</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec104"> Auth Bank Fees</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec5"> Update Members </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec46"> Accept Changes</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec61"> New Complaint</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec127"> Other Alerts</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec42"> Create Member </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec43"> Import Payments</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec62"> Edit Complaint</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec148"> Import Cancel File</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec44"> Update Additionals</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec16"> Cancel Receipt</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec68"> Reprint Receipt</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec3"> Update Dependants </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec8"> Issue Receipt</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec74"> Export SMS</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec2"> Update Contacts </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec72"> Print Multiple</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec77"> Grocery</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec71"> Print Member Card</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec73"> Mailing List</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec78"> Post Back</label></td>
                        </tr>
                    <br>
                    </tbody>
                </table>
                <br>

            </div>        
            <div id="tabs-3">
                <table class="table newtable1" style="border:none; width:75%;">
                    <tbody>
                        <tr>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec35" > Beneficiary Name </label></td>
                            <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec27"> Funeral Receipt </label></td>
                             <td style="min-width:200px; width:200px;"> <label><input type ="checkbox" id="sec27"> Funeral Receipt </label></td>
                        </tr>
                        <tr>    
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec34"> Claim Comments </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec26"> Edit After Auth</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec7"> Update Claims </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec25"> Auth Funeral</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec6"> View Claims </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec24"> New Funeral</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec14"> Submit Claim Note</label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec23"> View Funeral</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec15"> Accept Claim Note </label></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec75"> Manual Trips</label></td>
                        </tr>
                        <tr>
                            <td style="min-width:200px; width:200px;"></td>
                            <td style="min-width:200px; width:200px;"><label><input type ="checkbox" id="sec82"> Trip Passenger</label></td>
                        </tr>                       
                    <br>
                    </tbody>
                </table>                
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
            $('table.userGrid').on('scroll', function () {
                $("table > *").width($("table").width() + $("table").scrollLeft());
            });
        </script>
    </body>
</html>
