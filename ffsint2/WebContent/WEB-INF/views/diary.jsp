<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="true" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <jsp:include page="_DiaryHeader.jsp"></jsp:include>
            <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
            <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
            <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

            <style type="text/css">
                #mask {
                    display: none;
                    background: #000; 
                    position: fixed; left: 0; top: 0; 
                    z-index: 10;
                    width: 100%; height: 100%;
                    opacity: 0.8;
                    z-index: 999;
                }

                .login-popup{
                    display:none;
                    background: #fff;
                    padding: 10px; 	
                    border: 2px solid #ddd;
                    float: left;
                    font-size: 1.2em;
                    position: fixed;
                    top: 40%; left: 40%;
                    z-index: 99999;
                    box-shadow: 0px 0px 20px #999;
                    -moz-box-shadow: 0px 0px 20px #999; /* Firefox */
                    -webkit-box-shadow: 0px 0px 20px #999; /* Safari, Chrome */
                    border-radius:3px 3px 3px 3px;
                    -moz-border-radius: 3px; /* Firefox */
                    -webkit-border-radius: 3px; /* Safari, Chrome */
                }

                img.btn_close {
                    float: right; 
                    margin: -20px -20px 0 0;
                }

                fieldset { 
                    border:none; 
                }

                form.signin .textbox label { 
                    display:block; 
                    padding-bottom:7px; 
                }

                form.signin .textbox span { 
                    display:block;
                }
                form.signin input:-moz-placeholder { color:#bbb; text-shadow:0 0 2px #000; }
                form.signin input::-webkit-input-placeholder { color:#bbb; text-shadow:0 0 2px #000;  }

            </style>            

            <script src="resources/dhtmlxcalendar.js"></script>
            <link rel="stylesheet" type="text/css" href="resources/dhtmlxcalendar_1.css"/>

            <script type="text/javascript">
                $(document).ready(function () {
                    $("#diarysavepeople").click(function (event) {
                        $.get('DiaryUpdatePeople', {duser1: document.getElementById('diaryuser1').value, duser2: document.getElementById('diaryuser2').value, duser3: document.getElementById('diaryuser3').value, duser4: document.getElementById('diaryuser4').value, duser5: document.getElementById('diaryuser5').value, duser6: document.getElementById('diaryuser6').value, duser7: document.getElementById('diaryuser7').value, duser8: document.getElementById('diaryuser8').value, duser9: document.getElementById('diaryuser9').value, duser10: document.getElementById('diaryuser10').value, resp1: document.getElementById('response1').value, resp2: document.getElementById('response2').value, resp3: document.getElementById('response3').value, resp4: document.getElementById('response4').value, resp5: document.getElementById('response5').value, resp6: document.getElementById('response6').value, resp7: document.getElementById('response7').value, resp8: document.getElementById('response8').value, resp9: document.getElementById('response9').value, resp10: document.getElementById('response10').value, fromuser: document.getElementById('fromuser').innerHTML, tranid: document.getElementById('diaryid').innerHTML}, function (responseJson) {
                            if (responseJson != null) {
                                $("#delresp").empty();
                                document.getElementById("addresp").value = "";
                                $.each(responseJson, function (key, value) {
                                    $('#delresp').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');
                                });
                            }
                        });
                    });
                });

                $(document).ready(function () {
                    $("#diarysave").click(function (event) {
                        var comp = "N";
                        if (document.getElementById("dcomp").checked == true) {
                            comp = "Y"
                        }

                        $.get('DiaryCreateNew', {diarysumm: document.getElementById('diarysumm').value, startdate: document.getElementById('startdate').value, enddate: document.getElementById('enddate').value, locat: document.getElementById('locat').value, diarytask: document.getElementById('diarytask').value, diarynotes: document.getElementById('diarynotes').value, duser1: document.getElementById('diaryuser1').value, duser2: document.getElementById('diaryuser2').value, duser3: document.getElementById('diaryuser3').value, duser4: document.getElementById('diaryuser4').value, duser5: document.getElementById('diaryuser5').value, duser6: document.getElementById('diaryuser6').value, duser7: document.getElementById('diaryuser7').value, duser8: document.getElementById('diaryuser8').value, duser9: document.getElementById('diaryuser9').value, duser10: document.getElementById('diaryuser10').value, resp1: document.getElementById('response1').value, resp2: document.getElementById('response2').value, resp3: document.getElementById('response3').value, resp4: document.getElementById('response4').value, resp5: document.getElementById('response5').value, resp6: document.getElementById('response6').value, resp7: document.getElementById('response7').value, resp8: document.getElementById('response8').value, resp9: document.getElementById('response9').value, resp10: document.getElementById('response10').value, fromuser: document.getElementById('fromuser').innerHTML, tranid: document.getElementById('diaryid').innerHTML, complete: comp}, function (responseJson) {
                            if (responseJson != null) {
                                $("#delresp").empty();
                                document.getElementById("addresp").value = "";
                                $.each(responseJson, function (key, value) {
                                    $('#delresp').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');
                                    alert("diary added / updated");
                                    document.getElementById("diaryid").innerHTML = "0";
                                    document.getElementById("fromuser").innerHTML = "";
                                    document.getElementById("diarysumm").value = "";
                                    document.getElementById("startdate").value = "";
                                    document.getElementById("enddate").value = "";
                                    document.getElementById("locat").value = "";
                                    document.getElementById("diarytask").value = "";
                                    document.getElementById("diarynotes").value = "";
                                    document.getElementById("dcomp").checked = false;
                                });
                            }
                        });
                    });
                });

                $(document).ready(function () {
                    $("#addrespbut").click(function (event) {
                        $.get('DiaryAddResp', {locat: document.getElementById("addresp").value}, function (responseJson) {
                            if (responseJson != null) {
                                $("#delresp").empty();
                                document.getElementById("addresp").value = "";
                                $.each(responseJson, function (key, value) {
                                    $('#delresp').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');
                                });
                            }
                        });
                    });
                });

                $(document).ready(function () {
                    $("#addlocatbut").click(function (event) {
                        $.get('DiaryAddLocat', {locat: document.getElementById("addlocat").value}, function (responseJson) {
                            if (responseJson != null) {
                                $("#dellocat").empty();
                                document.getElementById("addlocat").value = "";
                                $.each(responseJson, function (key, value) {
                                    $('#dellocat').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');
                                });
                            }
                        });
                    });
                });

                $(document).ready(function () {
                    $("#dellocatbut").click(function (event) {
                        $.get('DiaryDelLocat', {locat: document.getElementById("dellocat").value}, function (responseJson) {
                            if (responseJson != null) {
                                $("#dellocat").empty();
                                $.each(responseJson, function (key, value) {
                                    $('#dellocat').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');
                                });
                            }
                        });
                    });
                });

                $(document).ready(function () {
                    $("#delrespbut").click(function (event) {
                        $.get('DiaryDelResp', {locat: document.getElementById("delresp").value}, function (responseJson) {
                            if (responseJson != null) {
                                $("#delresp").empty();
                                $.each(responseJson, function (key, value) {
                                    $('#delresp').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');
                                });
                            }
                        });
                    });
                });

            </script>

            <script type="text/javascript">
                $(document).ready(function () {
                    $("#diaryimag").click(function (event) {
                        var target = $(event.target);
                        $td = target.closest('td');
                        var col = $td.index();
                        var row = $td.closest('tr').index();
                        $.get('DiaryViewImage', {diaryid: document.getElementById("diaryimag").rows[row].cells[3].innerHTML, tranid: document.getElementById("diaryid").innerHTML}, function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    if (value['locat'].length > 1) {
                                        // window.location = "resources/" + value['locat']; 
                                        var url = "resources/" + value['locat'];
                                        window.open(url, 'Download');
                                    } else {
                                        alert("failed"alert);
                                    }
                                });
                            }
                        });
                    });
                });
            </script>

            <script type="text/javascript">
                $(document).ready(function () {
                    $("#DiaryAv").click(function (event) {

                        var count = $("#DiaryAv option").length;
                        if (count.valueOf() < 2) {

                            $.get('DiaryAvail', function (responseJson) {
                                if (responseJson != null) {

                                    $.each(responseJson, function (key, value) {


                                        $('#DiaryAv').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    });
                                }
                            });
                        }
                    });
                });
            </script>

            <script type="text/javascript">
                $(document).ready(function () {
                    $("#diarysavecomm").click(function (event) {
                        $.get('DiarySaveComm', {comment: document.getElementById("diarycomment").value, tranid: document.getElementById("diaryid").innerHTML}, function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    document.getElementById("diarycomment").value = value['comm'];
                                    if (document.getElementById("diarycomment").value == "undefined") {
                                        document.getElementById("diarycomment").value = "";
                                    }
                                    if (document.getElementById("diarycomment").value.length > 0) {
                                        //   document.getElementById("diarycomment").value = "2"; 
                                        document.getElementById("diarycomment").value = value['comm'].replace(/~/g, "\n");
                                    }

                                });
                            }
                        });
                        $("#diaryupdatecomm").css("visibility", "visible");
                        $("#diarysavecomm").css("visibility", "hidden");
                    });
                });
            </script>

            <script type="text/javascript">

                function updateComm() {
                    document.getElementById("diarycomment").value = "";
                    $("#diaryupdatecomm").css("visibility", "hidden");
                    $("#diarysavecomm").css("visibility", "visible");
                    $("#diarycomment").focus();

                }

            </script>                                  

            <script type="text/javascript">

                function NewDiary1() {

                    var diarysumm = document.getElementById('diarysumm').value;
                    var startdate = document.getElementById('startdate').value;
                    var enddate = document.getElementById('enddate').value;
                    var locat = document.getElementById('locat').value;
                    var diarytask = document.getElementById('diarytask').value;
                    var diarynotes = document.getElementById('diarynotes').value;
                    var duser1 = document.getElementById('diaryuser1').value;
                    var duser2 = document.getElementById('diaryuser2').value;
                    var duser3 = document.getElementById('diaryuser3').value;
                    var duser4 = document.getElementById('diaryuser4').value;
                    var duser5 = document.getElementById('diaryuser5').value;
                    var duser6 = document.getElementById('diaryuser6').value;
                    var duser7 = document.getElementById('diaryuser7').value;
                    var duser8 = document.getElementById('diaryuser8').value;
                    var duser9 = document.getElementById('diaryuser9').value;
                    var duser10 = document.getElementById('diaryuser10').value;
                    var resp1 = document.getElementById('response1').value;
                    var resp2 = document.getElementById('response2').value;
                    var resp3 = document.getElementById('response3').value;
                    var resp4 = document.getElementById('response4').value;
                    var resp5 = document.getElementById('response5').value;
                    var resp6 = document.getElementById('response6').value;
                    var resp7 = document.getElementById('response7').value;
                    var resp8 = document.getElementById('response8').value;
                    var resp9 = document.getElementById('response9').value;
                    var resp10 = document.getElementById('response10').value;
                    var fromuser = document.getElementById('fromuser').innerHTML;
                    var formdata = new FormData();

                    formdata.append("diarysumm", diarysumm);
                    formdata.append("startdate", startdate);
                    formdata.append("enddate", enddate);
                    formdata.append("locat", locat);
                    formdata.append("diarytask", diarytask);
                    formdata.append("diarynotes", diarynotes);
                    formdata.append("tranId", document.getElementById("diaryid").innerHTML);
                    formdata.append("duser1", duser1);
                    formdata.append("duser2", duser2);
                    formdata.append("duser3", duser3);
                    formdata.append("duser4", duser4);
                    formdata.append("duser5", duser5);
                    formdata.append("duser6", duser6);
                    formdata.append("duser7", duser7);
                    formdata.append("duser8", duser8);
                    formdata.append("duser9", duser9);
                    formdata.append("duser10", duser10);
                    formdata.append("resp1", resp1);
                    formdata.append("resp2", resp2);
                    formdata.append("resp3", resp3);
                    formdata.append("resp4", resp4);
                    formdata.append("resp5", resp5);
                    formdata.append("resp6", resp6);
                    formdata.append("resp7", resp7);
                    formdata.append("resp8", resp8);
                    formdata.append("resp9", resp9);
                    formdata.append("resp10", resp10);
                    formdata.append("fromuser", document.getElementById("fromuser").innerHTML);

                    var xhr = new XMLHttpRequest();

                    xhr.open("POST", "DiaryCreate", true);

                    xhr.send(formdata);

                    xhr.onload = function (e) {

                        if (this.status == 200) {

                            alert(this.responseText);

                        }

                    };

                }

            </script>

            <script type="text/javascript">
                $(document).ready(function () {
                    $("#imagupload").click(function (event) {
                        $.ajax({
                            url: "DiaryUpImage",
                            type: "get",
                            data: {"tranid": document.getElementById("diaryid").innerHTML,
                                "userfile": fileupload.files[0]
                            }
                        });
                    });
                });
            </script>         

            <script>
                $(function () {
                    $("#tabs").tabs();
                });
            </script>

            <script>
                var myCalendar;
                function doOnLoad() {
                    myCalendar = new dhtmlXCalendarObject("calendarHere");
                    myCalendar.setDate(new Date);
                    myCalendar.show();
                    myCalendar.hideTime();
                    myCalendar.showToday();
                    myCalendar.setHolidays(["2017-01-01", "2017-01-02", "2017-03-21", "2017-04-14", "2017-04-17", "2017-04-27", "2017-05-01", "2017-06-16", "2017-08-09", "2017-09-24", "2017-09-25", "2017-12-16", "2017-12-25", "2017-12-26", "2018-01-01"]);
                    myCalendar.setTooltip("2017-01-01", "New Year's Day", true, true);
                    myCalendar.setTooltip("2017-01-02", "Public HoliDay", true, true);
                    myCalendar.setTooltip("2017-03-21", "Human Rights Day", true, true);
                    myCalendar.setTooltip("2017-04-14", "Good Friday", true, true);
                    myCalendar.setTooltip("2017-04-17", "Family Day", true, true);
                    myCalendar.setTooltip("2017-04-27", "Freedom Day", true, true);
                    myCalendar.setTooltip("2017-05-01", "Workers Day", true, true);
                    myCalendar.setTooltip("2017-06-16", "Youth Day", true, true);
                    myCalendar.setTooltip("2017-08-09", "National Womens Day", true, true);
                    myCalendar.setTooltip("2017-09-24", "Heritage Day", true, true);
                    myCalendar.setTooltip("2017-09-25", "Public Holiday", true, true);
                    myCalendar.setTooltip("2017-12-16", "Day of Reconciliation", true, true);
                    myCalendar.setTooltip("2017-12-25", "Christmas Day", true, true);
                    myCalendar.setTooltip("2017-12-26", "Day of Good Will", true, true);
                    myCalendar.setTooltip("2018-01-01", "New Years Day", true, true);
                    myCalendar._drawMonth(new Date);

                    myCalendar.attachEvent("onClick", function (side, d) {

                        $.get('DiaryDay', {thisDate: myCalendar.getFormatedDate(null, d), thisUser: document.getElementById("DiaryAv").value}, function (responseJson) {
                            if (responseJson != null) {
                                $("#countrytable").find("tr:gt(0)").remove();
                                var table1 = $("#countrytable");
                                $.each(responseJson, function (key, value) {
                                    var rowNew = $("<tr><td></td><td></td><td></td><td></td></tr>");
                                    if (value['complete'] == "Y") {
                                        var rowNew = $("<tr><td></td><td style = 'color:red;'></td><td style = 'color:red;'></td><td></td></tr>");
                                    }
                                    rowNew.children().eq(0).text(value['ShortDate']);

                                    rowNew.children().eq(1).text(value['user']);
                                    rowNew.children().eq(2).text(value['desc1']);
                                    rowNew.children().eq(3).text(value['tranid']);
                                    rowNew.appendTo(table1);
                                });
                                document.getElementsById("countrytable")[0].style.width = '20px';
                            }
                        });

                    });
                }
            </script>
            <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
            <style type="text/css">
                table, td, th
                {
                    border:1px solid black;
                    width:40%;
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



            <script type="text/javascript">
                $(document).ready(function () {
                    $("#opentask").click(function (event) {
                        window.location = "TaskView.jsp?key=" + encodeURIComponent(document.getElementById("diarytask").value);
                    });
                });

                $(document).ready(function () {
                    $("#imagupload2").click(function (event) {
                        $.get('DiaryUpImage', {tranid: document.getElementById("diaryid").innerHTML}, function (responseJson) {
                            $("#diaryimag").find("tr:gt(0)").remove();
                            if (responseJson != null) {
                                var table2 = $("#diaryimag");
                                $.each(responseJson, function (key, value) {
                                    var rowNew = $("<tr><td></td><td></td><td></td><td></td></tr>");
                                    rowNew.children().eq(0).text(value['DateUp']);
                                    rowNew.children().eq(1).text(value['User']);
                                    rowNew.children().eq(2).text(value['User']);
                                    rowNew.children().eq(3).text(value['Tranid']);
                                    rowNew.appendTo(table2);
                                });
                            }
                        });        
                    });
                });

                $(document).ready(function () {
                    $("#countrytable").click(function (event) {
                        var target = $(event.target);
                        $td = target.closest('td');
                        var col = $td.index();
                        var row = $td.closest('tr').index();
                        document.getElementById("diaryid").innerHTML = document.getElementById("countrytable").rows[row].cells[3].innerHTML;
                        if (document.getElementById("countrytable").rows[row].cells[3].innerHTML > 0) {
                            $("#tabs-2").css("visibility", "visible");
                            $("#tabs-4").css("visibility", "visible");
                            $("#diarysavepeople").css("visibility", "visible");
                        } else {
                            $("#tabs-2").css("visibility", "hidden");
                            $("#tabs-4").css("visibility", "hidden");
                            $("#diarysavepeople").css("visibility", "hidden");
                        }

                        $.get('DiaryDetail', {tranid: document.getElementById("countrytable").rows[row].cells[3].innerHTML}, function (responseJson) {
                            document.getElementById("fromuser").innerHTML = "";
                            document.getElementById("diarysumm").value = "";
                            document.getElementById("startdate").value = "";
                            document.getElementById("enddate").value = "";
                            document.getElementById("locat").value = "";
                            document.getElementById("diarytask").value = "";
                            document.getElementById("diarynotes").value = "";
                            document.getElementById("diarycomment").value = "";                            
                            document.getElementById("diaryuser1").value = "";
                            document.getElementById("diaryuser2").value = "";
                            document.getElementById("diaryuser3").value = "";
                            document.getElementById("diaryuser4").value = "";
                            document.getElementById("diaryuser5").value = "";
                            document.getElementById("diaryuser6").value = "";
                            document.getElementById("diaryuser7").value = "";
                            document.getElementById("diaryuser8").value = "";
                            document.getElementById("diaryuser9").value = "";
                            document.getElementById("diaryuser10").value = "";
                            document.getElementById("response1").value = "";
                            document.getElementById("response2").value = "";
                            document.getElementById("response3").value = "";
                            document.getElementById("response4").value = "";
                            document.getElementById("response5").value = "";
                            document.getElementById("response6").value = "";
                            document.getElementById("response7").value = "";
                            document.getElementById("response8").value = "";
                            document.getElementById("response9").value = "";
                            document.getElementById("response10").value = "";
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    document.getElementById("fromuser").innerHTML = value['user'];
                                    document.getElementById("diarysumm").value = value['desc1'];
                                    document.getElementById("startdate").value = value['sdate'];
                                    document.getElementById("enddate").value = value['edate'];
                                    document.getElementById("locat").value = value['locat'];
                                    document.getElementById("diarytask").value = value['task'];
                                    document.getElementById("diarynotes").value = value['notes'];
                                    document.getElementById("diarycomment").value = value['comm'];
                                    if (document.getElementById("diarycomment").value == "undefined") {
                                        document.getElementById("diarycomment").value = "";
                                    }
                                    if (document.getElementById("diarycomment").value.length > 0) {
                                        document.getElementById("diarycomment").value = value['comm'].replace(/~/g, "\n");
                                    }
                                    if (value['complete'] == "Y") {
                                        document.getElementById("dcomp").checked = true;
                                    } else {
                                        document.getElementById("dcomp").checked = false;
                                    }

                                    document.getElementById("diaryuser1").value = value['user1'];
                                    document.getElementById("diaryuser2").value = value['user2'];
                                    document.getElementById("diaryuser3").value = value['user3'];
                                    document.getElementById("diaryuser4").value = value['user4'];
                                    document.getElementById("diaryuser5").value = value['user5'];
                                    document.getElementById("diaryuser6").value = value['user6'];
                                    document.getElementById("diaryuser7").value = value['user7'];
                                    document.getElementById("diaryuser8").value = value['user8'];
                                    document.getElementById("diaryuser9").value = value['user9'];
                                    document.getElementById("diaryuser10").value = value['user10'];
                                    document.getElementById("response1").value = value['user1ans'];
                                    document.getElementById("response2").value = value['user2ans'];
                                    document.getElementById("response3").value = value['user3ans'];
                                    document.getElementById("response4").value = value['user4ans'];
                                    document.getElementById("response5").value = value['user5ans'];
                                    document.getElementById("response6").value = value['user6ans'];
                                    document.getElementById("response7").value = value['user7ans'];
                                    document.getElementById("response8").value = value['user8ans'];
                                    document.getElementById("response9").value = value['user9ans'];
                                    document.getElementById("response10").value = value['user10ans'];
                                    if (document.getElementById("response1").value == 'undefined') {
                                        document.getElementById("response1").value = "";
                                    }
                                    if (document.getElementById("response2").value == 'undefined') {
                                        document.getElementById("response2").value = "";
                                    }
                                    if (document.getElementById("response3").value == 'undefined') {
                                        document.getElementById("response3").value = "";
                                    }
                                    if (document.getElementById("response4").value == 'undefined') {
                                        document.getElementById("response4").value = "";
                                    }
                                    if (document.getElementById("response5").value == 'undefined') {
                                        document.getElementById("response5").value = "";
                                    }
                                    if (document.getElementById("response6").value == 'undefined') {
                                        document.getElementById("response6").value = "";
                                    }
                                    if (document.getElementById("response7").value == 'undefined') {
                                        document.getElementById("response7").value = "";
                                    }
                                    if (document.getElementById("response8").value == 'undefined') {
                                        document.getElementById("response8").value = "";
                                    }
                                    if (document.getElementById("response9").value == 'undefined') {
                                        document.getElementById("response9").value = "";
                                    }
                                    if (document.getElementById("response10").value == 'undefined') {
                                        document.getElementById("response10").value = "";
                                    }
                                    if (document.getElementById("diaryuser1").value == 'undefined') {
                                        document.getElementById("diaryuser1").value = "";
                                    }
                                    if (document.getElementById("diaryuser2").value == 'undefined') {
                                        document.getElementById("diaryuser2").value = "";
                                    }
                                    if (document.getElementById("diaryuser3").value == 'undefined') {
                                        document.getElementById("diaryuser3").value = "";
                                    }
                                    if (document.getElementById("diaryuser4").value == 'undefined') {
                                        document.getElementById("diaryuser4").value = "";
                                    }
                                    if (document.getElementById("diaryuser5").value == 'undefined') {
                                        document.getElementById("diaryuser5").value = "";
                                    }
                                    if (document.getElementById("diaryuser6").value == 'undefined') {
                                        document.getElementById("diaryuser6").value = "";
                                    }
                                    if (document.getElementById("diaryuser7").value == 'undefined') {
                                        document.getElementById("diaryuser7").value = "";
                                    }
                                    if (document.getElementById("diaryuser8").value == 'undefined') {
                                        document.getElementById("diaryuser8").value = "";
                                    }
                                    if (document.getElementById("diaryuser9").value == 'undefined') {
                                        document.getElementById("diaryuser9").value = "";
                                    }
                                    if (document.getElementById("diaryuser10").value == 'undefined') {
                                        document.getElementById("diaryuser10").value = "";
                                    }

                                });

                            }
                        });

                        $.get('DiaryImageLoad', {tranid: document.getElementById("diaryimag").rows[row].cells[3].innerHTML}, function (responseJson) {
                            $("#diaryimag").find("tr:gt(0)").remove();
                            if (responseJson != null) {
                                var table2 = $("#diaryimag");
                                $.each(responseJson, function (key, value) {
                                    var rowNew = $("<tr><td></td><td></td><td></td><td></td></tr>");
                                    rowNew.children().eq(0).text(value['DateUp']);
                                    rowNew.children().eq(1).text(value['User']);
                                    rowNew.children().eq(2).text(value['ImageDesc']);
                                    rowNew.children().eq(3).text(value['Tranid']);
                                    rowNew.appendTo(table2);
                                });
                            }
                        });

                    });
                });

                $(document).ready(function () {
                    $("#showTable").click(function (event) {
                        $.get('DiaryDay', function (responseJson) {
                            if (responseJson != null) {
                                $("#countrytable").find("tr:gt(0)").remove();
                                var table1 = $("#countrytable");
                                $.each(responseJson, function (key, value) {
                                    var rowNew = $("<tr><td></td><td></td><td></td><td></td></tr>");
                                    rowNew.children().eq(0).text(value['tranid']);
                                    rowNew.children().eq(1).text(value['user']);
                                    rowNew.children().eq(2).text(value['desc1']);
                                    rowNew.children().eq(3).text(value['tranid']);
                                    rowNew.appendTo(table1);
                                });
                                document.getElementsById("countrytable")[0].style.width = '20px';
                            }
                        });
                    });
                });

                $(document).ready(function () {
                    $("#locat").click(function (event) {
                        var count = $("#locations option").length;
                        if (count.valueOf() < 3) {
                            $.get('DiaryLocat', function (responseJson) {
                                if (responseJson != null) {
                                    $.each(responseJson, function (key, value) {
                                        var option = document.createElement('option');
                                        option.value = value['GenericDescriptionEng'];
                                        locations.appendChild(option);
                                    });
                                }
                            });
                        }
                    });
                });

                $(document).ready(function () {
                    $("#tabs").click(function (event) {
                        var count = $("#resp1 option").length;
                        if (count.valueOf() < 3) {
                            $.get('DiaryResponse', function (responseJson) {
                                if (responseJson != null) {
                                    $.each(responseJson, function (key, value) {
                                        var option = document.createElement('option');
                                        option.value = value['GenericDescriptionEng'];
                                        resp1.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['GenericDescriptionEng'];
                                        resp2.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['GenericDescriptionEng'];
                                        resp3.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['GenericDescriptionEng'];
                                        resp4.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['GenericDescriptionEng'];
                                        resp5.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['GenericDescriptionEng'];
                                        resp6.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['GenericDescriptionEng'];
                                        resp7.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['GenericDescriptionEng'];
                                        resp8.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['GenericDescriptionEng'];
                                        resp9.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['GenericDescriptionEng'];
                                        resp10.appendChild(option);

                                    });
                                }
                            });
                        }

                        var count = $("#duser1 option").length;
                        if (count.valueOf() < 3) {
                            $.get('DiaryUser', function (responseJson) {
                                if (responseJson != null) {

                                    $.each(responseJson, function (key, value) {
                                        var option = document.createElement('option');
                                        option.value = value['userName'];
                                        duser1.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['userName'];
                                        duser2.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['userName'];
                                        duser3.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['userName'];
                                        duser4.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['userName'];
                                        duser5.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['userName'];
                                        duser6.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['userName'];
                                        duser7.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['userName'];
                                        duser8.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['userName'];
                                        duser9.appendChild(option);
                                        var option = document.createElement('option');
                                        option.value = value['userName'];
                                        duser10.appendChild(option);
                                    });
                                }
                            });
                        }

                        $.get('DiaryImageLoad', {tranid: document.getElementById("diaryid").innerHTML}, function (responseJson) {
                            $("#diaryimag").find("tr:gt(0)").remove();
                            if (responseJson != null) {
                                var table2 = $("#diaryimag");
                                $.each(responseJson, function (key, value) {
                                    var rowNew = $("<tr><td></td><td></td><td></td><td></td></tr>");
                                    rowNew.children().eq(0).text(value['DateUp']);
                                    rowNew.children().eq(1).text(value['User']);
                                    rowNew.children().eq(2).text(value['ImageDesc']);
                                    rowNew.children().eq(3).text(value['Tranid']);
                                    rowNew.appendTo(table2);
                                });
                            }
                        });

                    });
                });

            </script>

        </head>

        <body onload="doOnLoad();" class="container">
            <br>
            Available diaries 
            <select name="DiaryAvail" id = "DiaryAv" >
                <option value="${loginedUser.userName}">${loginedUser.userName} </option>
        </select>


        <div class="container">
            <div id="content">

                <div class="post">
                    <div class="btn-sign">
                        <a href="#login-box" class="login-window" style="float:right">Settings</a>
                    </div>
                </div>

                <div id="login-box" class="login-popup" style="width:40%">
                    <a href="#" class="close"><img src="close_pop.png" class="btn_close" title="Close Window" alt="Close" /></a>
                    <form method="post" class="signin" action="#">

                        People that can see my diary
                        <br>
                        <select name="dseel" id = "dsee1" style="width:170px">
                            <option value=""></option>
                        </select>
                        <br>
                        <select name="dsee2" id = "dsee2" style="width:170px">
                            <option value=""></option>
                        </select>
                        <br>
                        <select name="dsee3" id = "dsee3" style="width:170px">
                            <option value=""></option>
                        </select>           
                        <br>
                        <select name="dsee4" id = "dsee4" style="width:170px">
                            <option value=""></option>
                        </select>           
                        <br>
                        <select name="dsee5" id = "dsee5" style="width:170px">
                            <option value=""></option>
                        </select>           
                        <br>
                        <select name="dsee6" id = "dsee6" style="width:170px">
                            <option value=""></option>
                        </select>           
                        <br>
                        <select name="dsee7" id = "dsee7" style="width:170px">
                            <option value=""></option>
                        </select>           
                        <br>
                        <select name="dsee8" id = "dsee8" style="width:170px">
                            <option value=""></option>
                        </select>           
                        <br>
                        <select name="dsee9" id = "dsee9" style="width:170px">
                            <option value=""></option>
                        </select>           
                        <br>
                        <select name="dsee10" id = "dsee10" style="width:170px">
                            <option value=""></option>
                        </select>           
                        <br>

                        <button class="submit button" id="diarySettClose" type="button">Update</button>
                        <br>
                        <br>

                        Locations <br>
                        <select name ="dlocat" id="dellocat" style ="width:150px">
                            <option value=""></option>
                        </select>
                        <button class="submit button" id="dellocatbut" type ="button">Remove</button>
                        <br>                            
                        <input type="text" id = "addlocat" />
                        <button class="submit button" id="addlocatbut" type ="button">Add</button> 
                        <br>
                        Responses
                        <br>
                        <select name ="dresp" id="delresp" style ="width:150px">
                            <option value=""></option>
                        </select>
                        <button class="submit button" id="delrespbut" type ="button">Remove</button>
                        <br>                            
                        <input type="text" id = "addresp" />
                        <button class="submit button" id="addrespbut" type ="button">Add</button> 
                        <br>
                    </form>
                </div>

            </div>
        </div>

        <div style="margin-bottom: 20px;">
        </div>
        <div id="calendarHere" style="position:relative;height:320px; float:left;"></div>

        <div id="tablediv">
            <table cellspacing="0" id="countrytable" margin-right:10px style="table-layout:fixed;float: left; border-collapse: collapse;margin-left:290px;"> 
                <tr> 
                    <th style="width:3%" scope="col">Time</th> 
                    <th style="width:13%" scope="col">User</th> 
                    <th style="width:13%" scope="col">Description</th> 
                    <th style="width:3%" scope="col">ID</th> 
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
                <tr><td> 12:00 </td> <td> </td> <td> </td> <td> </td></tr>
                <tr><td> 12:30 </td> <td> </td> <td> </td> <td> </td></tr>
                <tr><td> 13:00 </td> <td> </td> <td> </td> <td> </td></tr>
                <tr><td> 13:30 </td> <td> </td> <td> </td> <td> </td></tr>
                <tr><td> 14:00 </td> <td> </td> <td> </td> <td> </td></tr>
                <tr><td> 14:30 </td> <td> </td> <td> </td> <td> </td></tr>
                <tr><td> 15:00 </td> <td> </td> <td> </td> <td> </td></tr>
                <tr><td> 15:30 </td> <td> </td> <td> </td> <td> </td></tr>
                <tr><td> 16:00 </td> <td> </td> <td> </td> <td> </td></tr>
                <tr><td> 16:30 </td> <td> </td> <td> </td> <td> </td>
                </tr>
            </table>
        </div>


        <div id="tabs" style="width:28%; float:right;">
            <ul>
                <li><a href="#tabs-1">Details</a></li>
                <li><a href="#tabs-2">Notes</a></li>
                <li><a href="#tabs-3">People</a></li>
                <li><a href="#tabs-4">Images</a></li>
            </ul>

            <div id="tabs-1">
                <p>
                <div style="float: right; text-align: right;">
                    ID :  <label id="diaryid">${getid}</label>
                </div>     
                From <label id="fromuser" style="margin-left:14px"/>${fuser}</label> 
                <br/>
                Summary<label> <input type="text" id="diarysumm" style="margin-left:10px" value =${dsumm} > </label> 
                <br>
                Start Date <label> <input type="text" id = "startdate" style="margin-left:5px" value=${sdate} ></label> 
                <br>     
                End Date<label> <input type="text" id = "enddate" style="margin-left:10px" value=${edate}  > </label>
                <br>
                <script>
                    var myCalendar1 = new dhtmlXCalendarObject(["startdate"]);
                    myCalendar1.setHolidays(["2017-01-01", "2017-01-02", "2017-03-21", "2017-04-14", "2017-04-17", "2017-04-27", "2017-05-01", "2017-06-16", "2017-08-09", "2017-09-24", "2017-09-25", "2017-12-16", "2017-12-25", "2017-12-26", "2018-01-01"]);
                    myCalendar1.setTooltip("2017-01-01", "New Year's Day", true, true);
                    myCalendar1.setTooltip("2017-01-02", "Public HoliDay", true, true);
                    myCalendar1.setTooltip("2017-03-21", "Human Rights Day", true, true);
                    myCalendar1.setTooltip("2017-04-14", "Good Friday", true, true);
                    myCalendar1.setTooltip("2017-04-17", "Family Day", true, true);
                    myCalendar1.setTooltip("2017-04-27", "Freedom Day", true, true);
                    myCalendar1.setTooltip("2017-05-01", "Workers Day", true, true);
                    myCalendar1.setTooltip("2017-06-16", "Youth Day", true, true);
                    myCalendar1.setTooltip("2017-08-09", "National Womens Day", true, true);
                    myCalendar1.setTooltip("2017-09-24", "Heritage Day", true, true);
                    myCalendar1.setTooltip("2017-09-25", "Public Holiday", true, true);
                    myCalendar1.setTooltip("2017-12-16", "Day of Reconciliation", true, true);
                    myCalendar1.setTooltip("2017-12-25", "Christmas Day", true, true);
                    myCalendar1.setTooltip("2017-12-26", "Day of Good Will", true, true);
                    myCalendar1.setTooltip("2018-01-01", "New Years Day", true, true);
                    myCalendar1.setDateFormat("%Y/%m/%d %H:%i");

                    var myCalendar2 = new dhtmlXCalendarObject(["enddate"]);
                    myCalendar2.setHolidays(["2017-01-01", "2017-01-02", "2017-03-21", "2017-04-14", "2017-04-17", "2017-04-27", "2017-05-01", "2017-06-16", "2017-08-09", "2017-09-24", "2017-09-25", "2017-12-16", "2017-12-25", "2017-12-26", "2018-01-01"]);
                    myCalendar2.setTooltip("2017-01-01", "New Year's Day", true, true);
                    myCalendar2.setTooltip("2017-01-02", "Public HoliDay", true, true);
                    myCalendar2.setTooltip("2017-03-21", "Human Rights Day", true, true);
                    myCalendar2.setTooltip("2017-04-14", "Good Friday", true, true);
                    myCalendar2.setTooltip("2017-04-17", "Family Day", true, true);
                    myCalendar2.setTooltip("2017-04-27", "Freedom Day", true, true);
                    myCalendar2.setTooltip("2017-05-01", "Workers Day", true, true);
                    myCalendar2.setTooltip("2017-06-16", "Youth Day", true, true);
                    myCalendar2.setTooltip("2017-08-09", "National Womens Day", true, true);
                    myCalendar2.setTooltip("2017-09-24", "Heritage Day", true, true);
                    myCalendar2.setTooltip("2017-09-25", "Public Holiday", true, true);
                    myCalendar2.setTooltip("2017-12-16", "Day of Reconciliation", true, true);
                    myCalendar2.setTooltip("2017-12-25", "Christmas Day", true, true);
                    myCalendar2.setTooltip("2017-12-26", "Day of Good Will", true, true);
                    myCalendar2.setTooltip("2018-01-01", "New Years Day", true, true);
                    myCalendar2.setDateFormat("%Y/%m/%d %H:%i");

                </script>
                Location <input type="text" list="locations" id="locat" value=${dlocat}>
                <label>
                    <datalist id="locations" >
                        <option value=${dlocat}>  
                    </datalist>
                </label>
                <br>
                Task <label> <input type="text" id="diarytask" style="width: 60px" value=${dtask} > </label> 
                <input type="button" value="Open Task" id="opentask"/>
                <br>
                <br>
                Descriptions <br>
                <label> <textarea name="notes" id="diarynotes" cols="40" rows="5" >${dnotes}</textarea> </label>    
                <br>
                <br>
                <input type ="checkbox" value="Completed" id="dcomp" style="float:left">
                <input type ="button" value ="Save" id="diarysave" style="width:75px; float:right;"/> Completed
          
            </div>

            <div id="tabs-2" style="visibility: visible">
                <p>
                    <label> <textarea name="notes" id="diarycomment" cols="44" rows="10" > ${comm}</textarea> </label>     
                    <br>
                    <br>
                    <input type ="button" value ="Update" id="diaryupdatecomm" onClick="updateComm();" style="width:75px; float:right"/>
                    <input type ="button" value ="Save" id="diarysavecomm" style="width:75px;visibility: hidden;"/>
                </p>
            </div>
            <script>
                if (document.getElementById("diaryid").innerHTML > 0) {
                    $("#tabs-2").css("visibility", "visible");
                } else {
                    $("#tabs-2").css("visibility", "hidden");
                }
                var comp = ${completed}
                if (comp = "Y") {
                    document.getElementById("dcomp").checked = true;
                } else {
                    document.getElementById("dcomp").checked = false;
                }
            </script>
            <div id="tabs-3">
                <p>
                    Name    <span style="margin-left:150px;">  Response
                        <br>
                        <input type="text" size ="17" list="duser1" id="diaryuser1" value=${p1}>
                        <label>
                            <datalist id="duser1" >
                                <option> 
                            </datalist>
                        </label>   
                        <input type="text" size ="17" list="resp1" id="response1" value=${a1}>
                        <label>
                            <datalist id="resp1" >
                                <option> 
                            </datalist>
                        </label> 
                        <br>
                        <input type="text" size ="17" list="duser2" id="diaryuser2" value=${p2}>
                        <label>
                            <datalist id="duser2" >
                                <option> 
                            </datalist>
                        </label>   
                        <input type="text" size ="17" list="resp2" id="response2" value=${a2}>
                        <label>
                            <datalist id="resp2" >
                                <option> 
                            </datalist>
                        </label> 
                        <br>

                        <input type="text" size ="17" list="duser3" id="diaryuser3" value=${p3}>
                        <label>
                            <datalist id="duser3" >
                                <option> 
                            </datalist>
                        </label>   
                        <input type="text" size ="17" list="resp3" id="response3" value=${a3}>
                        <label>
                            <datalist id="resp3" >
                                <option> 
                            </datalist>
                        </label> 
                        <br>

                        <input type="text" size ="17" list="duser4" id="diaryuser4" value=${p4}>
                        <label>
                            <datalist id="duser4" >
                                <option> 
                            </datalist>
                        </label>   
                        <input type="text" size ="17" list="resp4" id="response4" value=${a4}>
                        <label>
                            <datalist id="resp4" >
                                <option> 
                            </datalist>
                        </label> 
                        <br>

                        <input type="text" size ="17" list="duser5" id="diaryuser5" value=${p5}>
                        <label>
                            <datalist id="duser5" >
                                <option> 
                            </datalist>
                        </label>   
                        <input type="text" size ="17" list="resp5" id="response5" value=${a5}>
                        <label>
                            <datalist id="resp5" >
                                <option> 
                            </datalist>
                        </label> 
                        <br>      

                        <input type="text" size ="17" list="duser6" id="diaryuser6"value=${p6}>
                        <label>
                            <datalist id="duser6" >
                                <option> 
                            </datalist>
                        </label>   
                        <input type="text" size ="17" list="resp6" id="response6" value=${a6}>
                        <label>
                            <datalist id="resp6" >
                                <option> 
                            </datalist>
                        </label> 
                        <br>                           

                        <input type="text" size ="17" list="duser7" id="diaryuser7" value=${p7}>
                        <label>
                            <datalist id="duser7" >
                                <option> 
                            </datalist>
                        </label>   
                        <input type="text" size ="17" list="resp7" id="response7" value=${a7}>
                        <label>
                            <datalist id="resp7" >
                                <option> 
                            </datalist>
                        </label> 
                        <br>   

                        <input type="text" size ="17" list="duser8" id="diaryuser8" value=${p8}>
                        <label>
                            <datalist id="duser8" >
                                <option> 
                            </datalist>
                        </label>   
                        <input type="text" size ="17" list="resp8" id="response8" value=${a8}>
                        <label>
                            <datalist id="resp8" >
                                <option> 
                            </datalist>
                        </label> 
                        <br>   

                        <input type="text" size ="17" list="duser9" id="diaryuser9" value=${p9}>
                        <label>
                            <datalist id="duser9" >
                                <option> 
                            </datalist>
                        </label>   
                        <input type="text" size ="17" list="resp9" id="response9" value=${a9}>
                        <label>
                            <datalist id="resp9" >
                                <option> 
                            </datalist>
                        </label> 
                        <br>   

                        <input type="text" size ="17" list="duser10" id="diaryuser10" value=${p10}>
                        <label>
                            <datalist id="duser10" >
                                <option> 
                            </datalist>
                        </label>   
                        <input type="text" size ="17" list="resp10" id="response10" value=${a10}>
                        <label>
                            <datalist id="resp10" >
                                <option> 
                            </datalist>
                        </label> 
                        <br>                           
                        <br>
                        <input type ="button" value ="Save" id="diarysavepeople" style="width:75px; float:right; visibility: hidden"/>
                </p>

            </div>

            <div id="tabs-4" style="visibility: visible">
                <div id="imagdiv">
                    <table cellspacing="0" id="diaryimag" style="float: left; border-collapse: collapse;margin-left:5px; heigth:300px; width:100%; "> 
                        <tr> 
                            <th style="width:10%" scope="col">Date</th> 
                            <th style="width:31%" scope="col">User</th> 
                            <th style="width:51%" scope="col">Description</th> 
                            <th style="width:8%" scope="col">ID</th> 
                        </tr> 
                    </table>
                </div>
                <br>

                <form id="form1">    
                    <br>
                    <label for="imageText">Enter description</label>

                    <input id="imageText" name="ImageText" type="text" /> <br/>

                    <label for="imageFile"/>Select file </label>

                    <input id="imageFile" name="imageFile" type="file" /> <br/>

                    <input id="uploadBtn" type="button" value="Upload" onClick="performAjaxSubmit();"/>

                </form>
            </div>
            <script>
                if (document.getElementById("diaryid").innerHTML > 0) {
                    $("#tabs-4").css("visibility", "visible");
                } else {
                    $("#tabs-4").css("visibility", "hidden");
                }
            </script>            
        </div>


        <br/>
        <br/>



        <br/>            
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>

        <br/>
        <!--
        <input type="button" value="Show Table" id="showTable"/>
        -->
        <br/>
        <br/>


        <script type="text/javascript">

            function performAjaxSubmit() {

                var sampleText = document.getElementById('imageText').value;

                var sampleFile1 = document.getElementById('imageFile').files[0];

                var formdata = new FormData();

                formdata.append("imageText", sampleText);

                formdata.append("imageFile", sampleFile1);
                formdata.append("tranId", document.getElementById("diaryid").innerHTML);

                var xhr = new XMLHttpRequest();

                xhr.open("POST", "DiaryFileUploader", true);

                xhr.send(formdata);

                xhr.onload = function (e) {

                    if (this.status == 200) {

                        alert(this.responseText);

                    }

                };

            }

        </script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('a.login-window').click(function () {

                    // Getting the variable's value from a link 
                    var loginBox = $(this).attr('href');

                    //Fade in the Popup and add close button
                    $(loginBox).fadeIn(300);

                    //Set the center alignment padding + border
                    var popMargTop = ($(loginBox).height() + 24) / 2;
                    var popMargLeft = ($(loginBox).width() + 24) / 2;

                    $(loginBox).css({
                        'margin-top': -popMargTop,
                        'margin-left': -popMargLeft
                    });

                    // Add the mask to body
                    $('body').append('<div id="mask"></div>');
                    $('#mask').fadeIn(300);
                    // update diary settings
                    var count = $("#dsee1 option").length;
                    if (count.valueOf() < 3) {
                        $.get('DiaryUser', function (responseJson) {
                            if (responseJson != null) {

                                $.each(responseJson, function (key, value) {

                                    $('#dsee1').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee2').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee3').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee4').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee5').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee6').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee7').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee8').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee9').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                    $('#dsee10').append('<option value="' + value['userName'] + '">' + value['userName'] + '</option>');
                                });
                            }
                        });
                    }

                    $.get('DiarySettAvail', function (responseJson) {
                        if (responseJson != null) {
                            //$("#dsee1").val("");
                            document.getElementById("dsee1").selectedIndex = "0";
                            document.getElementById("dsee2").selectedIndex = "0";
                            document.getElementById("dsee3").selectedIndex = "0";
                            document.getElementById("dsee4").selectedIndex = "0";
                            document.getElementById("dsee5").selectedIndex = "0";
                            document.getElementById("dsee6").selectedIndex = "0";
                            document.getElementById("dsee7").selectedIndex = "0";
                            document.getElementById("dsee8").selectedIndex = "0";
                            document.getElementById("dsee9").selectedIndex = "0";
                            document.getElementById("dsee10").selectedIndex = "0";

                            //$("#dsee2").val("Matthys Buitendag");
                            //document.getElementById("dsee1").value = "Matthys Buitendag";
                            $.each(responseJson, function (key, value) {
                                //   $("#dsee1").val(value['userName']);
                                //document.getElementById("dsee1").value = value['userName'];  

                                if (document.getElementById("dsee1").value.length < 2)
                                {
                                    document.getElementById("dsee1").value = value['userName'];
                                } else if (document.getElementById("dsee2").value.length < 2)
                                {
                                    document.getElementById("dsee2").value = value['userName'];
                                } else if (document.getElementById("dsee3").value.length < 2)
                                {
                                    document.getElementById("dsee3").value = value['userName'];
                                } else if (document.getElementById("dsee4").value.length < 2)
                                {
                                    document.getElementById("dsee4").value = value['userName'];
                                } else if (document.getElementById("dsee5").value.length < 2)
                                {
                                    document.getElementById("dsee5").value = value['userName'];
                                } else if (document.getElementById("dsee6").value.length < 2)
                                {
                                    document.getElementById("dsee6").value = value['userName'];
                                } else if (document.getElementById("dsee7").value.length < 2)
                                {
                                    document.getElementById("dsee7").value = value['userName'];
                                } else if (document.getElementById("dsee8").value.length < 2)
                                {
                                    document.getElementById("dsee8").value = value['userName'];
                                } else if (document.getElementById("dsee9").value.length < 2)
                                {
                                    document.getElementById("dsee9").value = value['userName'];
                                } else if (document.getElementById("dsee10").value.length < 2)
                                {
                                    document.getElementById("dsee10").value = value['userName'];
                                }
                            });
                        }
                    });
                    // end update
                    //  get can update
                    $.get('DiaryCanSet', function (responseJson) {
                        if (responseJson != null) {
                            $.each(responseJson, function (key, value) {
                                if (value['GenGroupId'] = '1') {
                                    // 1= visible   
                                    $("#dellocatbut").css("visibility", "visible");
                                    // get combobox items  
                                    $.get('DiaryGetSet', function (responseJson) {
                                        if (responseJson != null) {
                                            $.each(responseJson, function (key, value) {
                                                if (value['GenGroupId'] == "44") {
                                                    $('#dellocat').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');
                                                }
                                                if (value['GenGroupId'] == "45") {
                                                    $('#delresp').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');
                                                }

                                            });
                                        }
                                    });


                                }

                            });
                        }
                    });


                    return false;

                });

                // When clicking on the button close or the mask layer the popup closed
                $('a.close, #mask').click(function () {
                    $('#mask , .login-popup').fadeOut(300, function () {
                        $('#mask').remove();
                    });
                    return false;
                });

                $('#diarySettClose').click(function () {
                    $('#mask , .login-popup').fadeOut(300, function () {
                        $('#mask').remove();
                    });
                    return false;
                });
            });
        </script>


    </body>
    <jsp:include page="_footer.jsp"></jsp:include>
</html>