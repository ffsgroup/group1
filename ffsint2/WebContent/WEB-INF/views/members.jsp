<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
        <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>        
        <jsp:include page="_MembersHeader.jsp"></jsp:include>
        <script src="resources/dhtmlxcalendar.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/dhtmlxcalendar_1.css"/>
        <style type="text/css">
            table, th, td {
                border: 1px solid black;
            </style>

            <script>
                function loadMember()
                {
                     if (document.getElementById("memnum").value.length === 8 ){
                    document.getElementById("memname").value = "3";
                    // page one details
                    $.get('MemberDetail',{thisMember : document.getElementById("memnum").value}, function (responseJson) {
                        document.getElementById("memname").value = "0";
                        if (responseJson != null) {
                            $.each(responseJson, function (key, value) {
                                document.getElementById("memname").value = "1";

                                document.getElementById("memtitle").value = value['shortname'];
                            });
                        } else {
                         document.getElementById("memtitle").value = "No such member";      
                        }
                    });
                    
                    // get receipt details
                    $.get('MemberGetRec',{thisRec : document.getElementById("memnum").value}, function (responseJson) {
                        $("#recgrid").find("tr:gt(0)").remove();
                        if (responseJson != null) {
                            var table2 = $("#recgrid");
                            $.each(responseJson, function (key, value) {
                            var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                                    rowNew.children().eq(0).text(value['kwitno']);
                                    rowNew.children().eq(1).text(value['datum']);
                                    rowNew.children().eq(2).text(value['bedrag']);
                                    rowNew.children().eq(3).text(value['betmet']);
                                    rowNew.children().eq(4).text(value['descr']);
                                    rowNew.children().eq(5).text(value['operator']);
                                    rowNew.children().eq(6).text(value['bettot']);
                                    rowNew.children().eq(7).text(value['cardused']);
                                    rowNew.children().eq(8).text(value['decsign']);
                                    rowNew.appendTo(table2);    
                            });
                        } else {
                         document.getElementById("memtitle").value = "No such member";      
                        }
                    });
                    
                    
                    } else {
                     document.getElementById("memtitle").value = "No such member";   
                    }
                }
            </script>            

            <script>
                var myCalendar;
                function doOnLoad() {
                    myCalendar = new dhtmlXCalendarObject("calendarHere");
                    //		myCalendar.setSkin("material");
                    //  myCalendar.setDate(new Date(2016, 7, 7, 16, 0));
                    myCalendar.setDate(new Date);
                    myCalendar.show();
                    myCalendar.hideTime();
                    myCalendar.showToday();
                    myCalendar.setHolidays(["2017-01-01", "2017-01-02", "2017-03-21", "2017-04-14", "2017-04-17", "2017-04-27", "2017-05-01", "2017-06-16"]);
                    myCalendar.setTooltip("2017-01-01", "New Year's Day", true, true);
                    myCalendar.setTooltip("2017-01-02", "Public HoliDay", true, true);
                    myCalendar.setTooltip("2017-03-21", "Human Rights Day", true, true);
                    myCalendar.setTooltip("2017-04-14", "Good Friday", true, true);
                    myCalendar.setTooltip("2017-04-17", "Family Day", true, true);
                    myCalendar.setTooltip("2017-04-27", "Freedom Day", true, true);
                    myCalendar.setTooltip("2017-05-01", "Workers Day", true, true);
                    myCalendar.setTooltip("2017-06-16", "Youth Day", true, true);
                    //  myCalendar.setInsensitiveRange(null, "2012-05-04");
                    // myCalendar._drawMonth(new Date(2016, 7, 1));
                    myCalendar._drawMonth(new Date);
                    myCalendar.attachEvent("onClick", function (side, d) {
                        //	writeLog("onClick event called, "+side+" calendar, date "+myCalendar.getFormatedDate(null,d));
                    });
                }
            </script>

            <script>
                $(function () {
                    $("#tabs").tabs();
                });
            </script>

        </head>
        <body>
            <br>
            <fieldset>
                <label> Member Number <input type ="text" id="memnum" width ="15" style="margin-left:10px" onkeyup="loadMember()" /> </label>
                    <br>
                    <label> Title <input type ="text" id="memtitle" width="25" style="margin-left:47px"> </label>
                    <label style="margin-left:100px"> Company Name <select id="memcomp" style="width:100px" > <option value=""></option> </select> </label>
                    <br>
                    <label> Name <input type="text" id="memname" width="25" style="margin-left:35px" > </label>
                    <label style ="margin-left: 100px"> Policy Type <select id="mempoltype" style="width:100px; margin-left:30px;" > <option value=""></option> </select> </label>
                <br>
                <label> Surname <input type="text" id="memsur" width="25" style="margin-left:20px"> </label>
                    <label style="margin-left:100px"> Policy Date <input type="text" id="poldate" width="20" style="margin-left:30px;" > </label>
                <br>
                <label> ID Number <input type="text" id="memidno" width="25" style="margin-left:3px"> </label>
                    <label style="margin-left:100px"> Cancel Code <select id="cancode" style="width:100px; margin-left:20px;"><option value=""></option> </select> </label>
                <br>
                <label> Gender <select id="memgend" style="width:85px; margin-left:28px;"> <option value=""> </option></select> </label>
                <label style="margin-left:166px"> Language <select id="memlang" style="width:100px; margin-left:40px;"> <option value=""></option> </select> </label>
                <br>    
                <label> E-Mail <input type="text" id="mememail" width="25" style="margin-left:31px" > </label>
                    <label style="margin-left:100px"> Status <select id="memstatus" style ="width:100px; margin-left:62px"><option value=""></option></select> </label>
                    <br>
                    <label> Recruiter <select id="memrecruit" style="width:150px; margin-left:17px;"> <option value=""> </option> </select> </label>
                <label style="margin-left:100px"> Status Date <input type="text" id="memstatusday" width="25" style = "margin-left:27px"> </label>
                    <br>
                    <label Style ="margin-left:20px"> Date <input type="text" id="memrecruitdate" style="margin-left:25px" > </label>
                    <label style="margin-left:100px" > Premium <input type="text" id="memprem" style="width:60px; margin-left:45px" > </label>
                    <br>
                    <label> Age <input type ="text" id="memage" style="margin-left:48px; width:60px"> </label>
                    <label style="margin-left:185px" > Total Premium  <input type="text" id="memtotprem" style="width:60px;margin-left:10px" > </label>
                    <br>
                    <label> Marriage <select id="marriage" style="width:120px; margin-left:18px;" <option value=""> </option> </select> </label>
                <br>
                <label> Date Birth <input type="text" id="memdob" style="width:100px; margin-left:10px" > </label>


                    <script>
                        var myCalendar1 = new dhtmlXCalendarObject(["poldate"]);
                        myCalendar1.setDateFormat("%Y/%m/%d %H:%i");
                        var myCalendar2 = new dhtmlXCalendarObject(["memstatusday"]);
                        myCalendar2.setDateFormat("%Y/%m/%d %H:%i");
                        var myCalendar3 = new dhtmlXCalendarObject(["memrecruitdate"]);
                        myCalendar3.setDateFormat("%Y/%m/%d %H:%i");

                        var myCalendar4 = new dhtmlXCalendarObject(["memdob"]);
                        myCalendar4.setDateFormat("%Y/%m/%d");
                    </script>            

                </fieldset>   

                <div id="tabs" style="width:99%; float:left;">
                <ul>
                    <li><a href="#tabs-1">Home</a></li>
                    <li><a href="#tabs-2">Contacts</a></li>
                    <li><a href="#tabs-3">Dependants</a></li>
                    <li><a href="#tabs-4">Account</a></li>
                    <li><a href="#tabs-5">Receipts</a></li>
                    <li><a href="#tabs-6">Notes</a></li>
                    <li><a href="#tabs-7">Claims</a></li>
                    <li><a href="#tabs-8">Images</a></li>
                    <li><a href="#tabs-9">Letters</a></li>
                    <li><a href="#tabs-10">Voice</a></li>
                </ul>

                <div id="tabs-1">
                    <div id="alert1" style="color:red; float:left;"> Alert 1 </div>
                    <div id="alert2" style="color:red; float:left; margin-left:200px"> Alert 2 </div>
                        <div style="float: right; text-align: right;margin-right:20;">
                        Additional / Extra Policies
                    </div>     
                    <br>
                    <div id="alert3" style="color:red; float:left;"> Alert 3 </div>
                    <div id="alert4" style="color:red; float:left; margin-left:200px"> Alert 4 </div>
                        <div style="float: right; text-align: right;margin-right:15px;">
                        Premium 
                    </div>
                    <div style="float: right; text-align: right;margin-right:20px;">
                        Policy
                    </div>
                    <br>
                    <div id="alert5" style="color:red; float:left;"> Alert 5 </div>
                    <div id="alert6" style="color:red; float:left; margin-left:200px"> Alert 6 </div>
                        <div id="addpol1am" style="float: right; text-align: right;margin-right:30px;">100</div>
                    <div id ="addpol1" style="float: right; text-align: right;margin-right:30px;">00000001</div>
                    <br>
                    <div id="alert7" style="color:red; float:left;"> Alert 7 </div>
                    <div id="alert8" style="color:red; float:left; margin-left:200px"> Alert 8 </div> 
                        <div id="addpol2am" style="float: right; text-align: right;margin-right:30px;">80</div>
                    <div id ="addpol2" style="float: right; text-align: right;margin-right:30px;">00000002</div>
                    <br>
                    <div id="alert9" style="color:red; float:left;"> Alert 9 </div>
                    <div id="addpol3am" style="float: right; text-align: right;margin-right:30px;">70</div>
                    <div id ="addpol3" style="float: right; text-align: right;margin-right:30px;">00000003</div>
                    <br>
                    <div id="alert10" style="color:red; float:left;"> Alert Dependent </div>
                    <div id="addpol4am" style="float: right; text-align: right;margin-right:30px;">60</div>
                    <div id ="addpol4" style="float: right; text-align: right;margin-right:30px;">00000004</div>
                    <br>

                    <div id="addpol5am" style="float: right; text-align: right;margin-right:30px;">50</div>
                    <div id ="addpol5" style="float: right; text-align: right;margin-right:30px;">00000005</div>
                    <br>                
                    <div id="addpol6am" style="float: right; text-align: right;margin-right:30px;">40</div>
                    <div id ="addpol6" style="float: right; text-align: right;margin-right:30px;">00000006</div>
                    <br>                
                    <div id="addpol7am" style="float: right; text-align: right;margin-right:30px;">30</div>
                    <div id ="addpol7" style="float: right; text-align: right;margin-right:30px;">00000007</div>
                    <br>
                </div>

                <div id="tabs-2">
                    <label style="float:left; margin-left:20px"> Physical Address </label>
                        <label style="float:left; margin-left:210px"> Postal Address </label>
                        <br>
                        <label style="float:left;"> Line 1 </label>
                    <label> <input type="text" id="padd1" style="margin-left:30px;width:150px;"> </label>
                    <label style="margin-left:80px"> Care off </label>
                        <label> <input type="text" id="post1" style="width:150px; margin-left:24px"> </label>
                        <label style="margin-left:50px">Cell Phone </label>
                        <label> <input type="text" id="phonecell" style="margin-left:15px; width:120px;"> </label>
                    <br>
                    <label style="float:left;"> Line 2 </label>
                    <label> <input type="text" id="padd2" style="margin-left:30px;width:150px;"> </label>
                    <label style="margin-left:80px"> P.O. Box </label>                
                        <label> <input type="text" id="post2" style="width:150px; margin-left:20px"> </label>
                        <label style="margin-left:50px">Tel Work </label>
                        <label> <input type="text" id="phonework" style="margin-left:30px; width:120px;"> </label>                
                    <br>
                    <label style="float:left;"> Line 3 </label>
                    <label> <input type="text" id="padd3" style="margin-left:30px;width:150px;"> </label>
                    <label style="margin-left:80px"> Town </label>
                        <label> <input type="text" id="post3" style="width:150px; margin-left:45px"> </label>
                        <label style="margin-left:50px">Tel Home </label>
                        <label> <input type="text" id="phonehome" style="margin-left:25px; width:120px;"> </label>
                    <br>
                    <label style="float:left;"> Code </label>
                    <label> <input type="text" id="pcode" style="width:50px;margin-left:33px"> </label>
                        <label style="margin-left:182px"> Code</label>
                        <label> <input type="text" id="postcode" Style="width:50px; margin-left:40px"> </label>
                        <br>
                        <label style="margin-left:315px"> Date </label>
                        <label> <input type="text" style="margin-left:43px;width:120px" id="postdate"> </label>
                        <input type ="button" value ="Update" id="contactupdate" style="width:75px; float:right;">
                    <script>
                        var myCalendar5 = new dhtmlXCalendarObject(["postdate"]);
                        myCalendar5.setDateFormat("%Y/%m/%d");
                    </script>                    
                </div>

                <div id="tabs-3">

                    <label style="float:left;"> Dependants </label>
                    <input type="text" style="margin-left:10px;width:30px;" id="nrdepen"> 
                    <label style="margin-left:30px">/  Active </label>
                        <input id="" style="margin-left:10px; width:30px;">
                    <input type="button" value="New" id="newdepen" style="width:75px; float:right;">
                    <br>  

                    <div id="tablediv">

                        <table cellspacing="0" id="depend" margin-right:20px style="table-layout:fixed;float: left; border-collapse: collapse;margin-left:10px; border: 1px solid black;width:95%"> 

                                <tr style="border-collapse: collapse;border: 1px solid black;"> 
                                <th style="width:80px" scope="col">FirstName</th> 
                                    <th style="width:100px" scope="col">Surname</th> 
                                    <th style="width:100px" scope="col">Birthday</th> 
                                    <th style="width:100px" scope="col">Gender</th> 
                                    <th style="width:100px" scope="col">Relationship</th> 
                                    <th style="width:100px" scope="col">Age</th> 
                                    <th style="width:100px" scope="col">Premium</th> 
                                    <th style="width:100px" scope="col">Status</th> 
                                    <th style="width:100px" scope="col">Status Date</th> 
                                    <th style="width:100px" scope="col">ID</th> 

                                </tr>
                                <tr>
                                    <td> 08:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr>   <td> 08:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 09:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 09:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 10:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 10:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 11:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 11:30 </td> <td> </td> <td> </td> <td> </td></tr>

                            </table>
                        </div>

                    </div>
                    <div id="tabs-4">
                        <label> Join Date </label>
                        <input type="text" id="joindat" style="margin-left:19px;width:100px;" >
                    <label style="margin-left:40px"> Cover Amount </label>
                        <input type="text" style="margin-left:26px;width:60px" >
                        <label style="margin-left:140px"> Beneficiary </label>
                        <br>
                        <label> Claim date </label>
                        <input type="text" id="claimdat" style="margin-left:10px;width:100px;" >
                    <label style="margin-left:40px"> Paid Up To </label>
                        <input type="text" style="width:100px; margin-left:49px" >
                        <label style="margin-left:30px"> Name </label>
                        <input type="text" style="width:190px; margin-left:50px" >

                        <br>
                        <label> Branch </label>
                        <select name="membranch" id="mbranch" style="width:100px; margin-left:38px" >
                            <option value=""> </option>
                        </select>                      
                        <label style="margin-left:44px"> Payment Method </label>
                        <select name="paymeth" id="paymet" style="margin-left:10px; width:110px;">
                        <option value=""></option> 

                    </select>
                    <label style="margin-left:30px;"> ID Nr </Label>
                    <input type="text" id="benefid" style="width:160px;margin-left:55px">
                        <br>
                        <label style="margin-left:240px;"> Pay Point </label>
                    <input type="text" style="margin-left:60px; width:100px;" >
                    <label style="margin-left:30px"> Relationship </label>
                        <input type="text" style="margin-left:10px;width:100px;" >
                    <br>
                    <label style="margin-left:515px"> Date </label>
                        <input type="text" id="benefdate" style="width:100px; margin-left:60px">
                        <input type="button" value="Update" style="float:right;width:85px">
                        <br>
                        <fieldset>
                            Bank Details
                            <br>
                            <label> Acc Holder </label>
                            <input type="text" style="width:100px; margin-left:15px" >
                            <label style="margin-left:20px"> Acc Number </label>
                            <input type="text" style="margin-left:25px; width:100px" >
                            <label style="margin-left:20px"> Day to Deduct </label>
                            <input type="text" style="width:50px;margin-left:20px">
                            <br>
                            <label> Bank Name </label>
                            <input type ="text" style="margin-left:10px;width:100px" >
                            <label style="margin-left:20px"> Account Type </label>
                            <select name="acctyp" id="acctype" style="width:100px; margin-left:19px" >
                                <option value=""> </option>
                            </select>     
                            <label style="margin-left:25px;width:100px;"> Start Date </label>
                        <input type="text" id="debitdate" style="width:100px; margin-left:50px;" >
                        <br>
                        <label> Branch Nr </label>                       
                        <input type="text" style="width:100px;margin-left:22px;" >

                        <label style="margin-left:20px;"> Groupscheme </label>
                        <input type="text" style="margin-left:16px;width:100px" >
                        </fieldset>

                        <fieldset>
                            Stop Order
                            <br>
                            <label> Employer 1 </label>
                            <label style="margin-left:10px">
                                <input type="text" list ="emp1" id= "empl1" style="width:120px">
                                <datalist id="emp1">
                                    <option> </option>
                                </datalist>
                            </label>
                            <label style="margin-left:25px;"> Payer Name </label>
                        <input type="text" style="margin-left:10px;width:150px">
                            <br>
                            <label> Employer 2 </label>
                            <label style="margin-left:10px">
                                <input type="text" list="emp2" id="empl2" style="width:120px">
                                <datalist id="emp2" >
                                    <option> </option>
                                </datalist>
                            </label>
                            <label Style="margin-left:25px"> Payer Id </label>
                            <input type="text" style="width:100px;margin-left:40px;">
                        <br>
                        <label> Start Date</label>
                        <input type="text" id="stoporderdate"  style="margin-left:20px;width:100px;">
                        <label style="margin-left:40px;width:100px" > Salary Nr </label>
                            <input type="text" style="margin-left:35px; width:80px" >
                            <br>
                            <script>
                                var myCalendar5 = new dhtmlXCalendarObject(["joindat"]);
                                myCalendar5.setDateFormat("%Y/%m/%d");
                                var myCalendar5 = new dhtmlXCalendarObject(["claimdat"]);
                                myCalendar5.setDateFormat("%Y/%m/%d");
                                var myCalendar5 = new dhtmlXCalendarObject(["benefdate"]);
                                myCalendar5.setDateFormat("%Y/%m/%d");
                                var myCalendar5 = new dhtmlXCalendarObject(["debitdate"]);
                                myCalendar5.setDateFormat("%Y/%m/%d");
                                var myCalendar5 = new dhtmlXCalendarObject(["stoporderdate"]);
                                myCalendar5.setDateFormat("%Y/%m/%d");
                            </script>  
                        </fieldset>

                    </div>
                    <div id="tabs-5">  
                        This policy paid until :
                        <label style="margin-left:5px" id="paidrecdate">2017/03/31 </label>
                        <label style="margin-left:60px"> Payment Method : </label>
                        <label id="paidrecmeth" style="margin-left:5px"> Cash </label>

                        <input type="button" id="bankfeerec" value="Bank Fees" style="margin-left:30px;width:90px">
                        <input type="button" id="cancellrec" value="Cancell" style="margin-left:20px;width:90px">
                        <input type="button" id="newrec" value="New Rec" style="margin-left:20px;width:90px">
                        <br>
                        <label style="margin-left:0px"> Credit </label>
                        <label style="margin-left:10px"> 00 </label>      
                        <input type="button" id="printoldrec" value="Print" style="margin-left:425px;width:90px;">
                    <input type="button" id="viewoldrec" value="View Old" style="margin-left:20px; width:90px;">
                    <br>
                    <div id="recdiv">

                        <table cellspacing="0" id="recgrid" margin-right:20px style="table-layout:fixed;float: left; border-collapse: collapse;margin-left:10px; border: 1px solid black;width:95%"> 

                                <tr style="border-collapse: collapse;border: 1px solid black;"> 
                                <th style="width:80px" scope="col">Receipt nr</th> 
                                    <th style="width:100px" scope="col">Date</th> 
                                    <th style="width:100px" scope="col">Amount</th> 
                                    <th style="width:100px" scope="col">Method</th> 
                                    <th style="width:100px" scope="col">Description</th> 
                                    <th style="width:100px" scope="col">Operator</th> 
                                    <th style="width:100px" scope="col">Paid Until</th> 
                                    <th style="width:100px" scope="col">Card</th> 
                                    <th style="width:100px" scope="col">Declaration</th> 

                                </tr>
                                <tr>
                                    <td> 08:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr>   <td> 08:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 09:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 09:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 10:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 10:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 11:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 11:30 </td> <td> </td> <td> </td> <td> </td></tr>

                            </table>
                        </div>


                    </div>
                    <div id="tabs-6"> 
                        <input type="button" id="newnote" value ="new" style="float:right;margin-right:20px;width:75px">
                        <input type="button" id="updatenote" value="update" style="float:right;margin-right:20px;width:75">

                        <div id="notediv">

                            <table cellspacing="0" id="notesgrid" margin-right:0px style="table-layout:fixed;float: left; border-collapse: collapse;margin-left:0px; border: 1px solid black;width:70%"> 

                                <tr style="border-collapse: collapse;border: 1px solid black;">                               
                                <th style="width:100px" scope="col">Date</th> 
                                    <th style="width:100px" scope="col">User</th> 
                                    <th style="width:100px" scope="col">Description</th> 

                                </tr>
                                <tr>
                                    <td> 08:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr>   <td> 08:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 09:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 09:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 10:00 </td> <td> </td> <td> </td> <td> </td></tr>                             

                            </table>
                        </div> 
                        <br>
                        <br>
                        <textarea style="border: 1px solid #111;"  id="notesdet" cols="100" rows="5">
                    </textarea>
                </div>   

                <div id="tabs-7"> 
                    <input type="button" id="updatenote" value="New Claim" style="float:right;margin-right:20px;width:75px">
                        <div id="claimdiv">
                            <table cellspacing="0" id="claimgrid" margin-right:0px style="table-layout:fixed;float: left; border-collapse: collapse;margin-left:0px; border: 1px solid black;width:80%"> 

                                <tr style="border-collapse: collapse;border: 1px solid black;">                               
                                <th style="width:100px" scope="col">Claim Nr</th> 
                                    <th style="width:100px" scope="col">Claim Date</th> 
                                    <th style="width:100px" scope="col">Initial</th> 
                                    <th style="width:100px" scope="col">Surname</th> 
                                    <th style="width:100px" scope="col">Death Date</th> 
                                    <th style="width:100px" scope="col">Status</th> 
                                </tr>
                                <tr>
                                    <td> 08:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr>   <td> 08:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 09:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 09:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 10:00 </td> <td> </td> <td> </td> <td> </td></tr>                             
                            </table>
                        </div> 
                    </div>  
                    <div id="tabs-8"> 
                        <input type="button" id="uploadimag" value="Upload" style="float:right;margin-right:20px;width:75px">
                        <div id="imagediv">
                            <table cellspacing="0" id="imagegrid" margin-right:0px style="table-layout:fixed;float: left; border-collapse: collapse;margin-left:0px; border: 1px solid black;width:80%"> 

                                <tr style="border-collapse: collapse;border: 1px solid black;">                               
                                <th style="width:100px" scope="col">User</th> 
                                    <th style="width:100px" scope="col">Date</th> 
                                    <th style="width:100px" scope="col">Description</th>  
                                </tr>
                                <tr>
                                    <td> 08:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr>   <td> 08:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 09:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 09:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 10:00 </td> <td> </td> <td> </td> <td> </td></tr>                             
                            </table>
                        </div> 
                    </div> 
                    <div id="tabs-9"> 
                        <input type="checkbox" value="Amendment" id="letamend" > Amendment 
                        <br>
                        <input type="checkbox" value="safinamend" id="safinamend"> Safin Amend
                        <br>
                        <input type="checkbox" value="membcard" id="membcard"> Membership card
                        <input type="checkbox" value="incwelcome" id="incwelcome" style="margin-left:25"> Include welcome letter
                        <br>
                        <input type="checkbox" value="tomember" id="tomember"> This post was send to the member
                        <br>
                        <input type="button" value="Print" style="float:right;margin-right:20px" id="memprintletter">


                    </div>
                    <div id="tabs-10"> 
                        <input type="button" id="uploadvoice" value="Upload" style="float:right;margin-right:20px;width:75px">
                        <div id="voicediv">
                            <table cellspacing="0" id="voicegrid" margin-right:0px style="table-layout:fixed;float: left; border-collapse: collapse;margin-left:0px; border: 1px solid black;width:80%"> 

                                <tr style="border-collapse: collapse;border: 1px solid black;">                               
                                <th style="width:100px" scope="col">User</th> 
                                    <th style="width:100px" scope="col">Date</th> 
                                    <th style="width:100px" scope="col">Description</th>  
                                </tr>
                                <tr>
                                    <td> 08:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr>   <td> 08:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 09:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 09:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                <tr><td> 10:00 </td> <td> </td> <td> </td> <td> </td></tr>                             
                            </table>
                        </div> 
                    </div> 

                </div>

            </body>
        </html>