<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
        <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>        

        <link rel="stylesheet" type="text/css" href="resources/button.css"/>
    <div style="background: #E0E0E0; height: 55px; padding: 5px;">
        <div style="float: left">
            <h1>FFS Group</h1>        
        </div>
        <div style="float: right; padding: 10px;" >
            <!-- User store in session with attribute: loginedUser -->
            <b>${loginedUser.userName}</b>
            <br>
            <div class="dropdown">
                <button onclick="myFunction()" class="dropbtn">Menu </button>
                <div id="myDropdown" class="dropdown-content">
                    <a href="#" id="memAdditional">Additionals</a>
                    <a href="#">Branch New</a>
                    <a href="#">Claims</a>
                    <a href="#">Document Request</a>
                    <a href="#">Membership Card</a>
                    <a href="#">New</a>
                    <a href="#">Post Lookup</a>
                </div>
            </div>
            <a href="${pageContext.request.contextPath}/userInfo">Home</a>
            |
            <a href="${pageContext.request.contextPath}/login">Login</a>
        </div>
        <div style="text-align: center;">
            <h2>Members</h2>        
        </div>
        
        <script>
            $(document).ready(function () {
                $("#dependTable").click(function (event) {
                    var target = $(event.target);
                    $td = target.closest('td');
                    var col = $td.index();
                    var row = $td.closest('tr').index();                    
                    window.location = "MemberViewDepend?key=" + encodeURIComponent(document.getElementById("dependTable").rows[row].cells[9].innerHTML);
                });
            });

        </script>
        <script>
            $(document).ready(function () {
                $("#memAdditional").click(function (event) {
                    window.location = "MemberAddition?key=" + encodeURIComponent(document.getElementById("memnum").value);

                });
            });

        </script> 
        <script>
            function changePayMeth(sel) {
                $("#stopDetail").css("visibility", "hidden");
                $("#debitDetail").css("visibility", "hidden");
                if (sel.options[sel.selectedIndex].text == "Cash") {
                    $("#stopDetail").css("visibility", "hidden");
                    $("#debitDetail").css("visibility", "hidden");
                }
                if (sel.options[sel.selectedIndex].text == "Debit Order") {
                    $("#stopDetail").css("visibility", "hidden");
                    $("#debitDetail").css("visibility", "visible");
                }

                if (sel.options[sel.selectedIndex].text == "Stop Order") {
                    $("#stopDetail").css("visibility", "visible");
                    $("#debitDetail").css("visibility", "hidden");
                }
            }

            function myFunction() {
                document.getElementById("myDropdown").classList.toggle("show");
            }

            window.onclick = function (event) {
                if (!event.target.matches('.dropbtn')) {

                    var dropdowns = document.getElementsByClassName("dropdown-content");
                    var i;
                    for (i = 0; i < dropdowns.length; i++) {
                        var openDropdown = dropdowns[i];
                        if (openDropdown.classList.contains('show')) {
                            openDropdown.classList.remove('show');
                        }
                    }
                }
            }
        </script>    



        <script src="resources/dhtmlxcalendar.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/dhtmlxcalendar_1.css"/>
        <style type="text/css">
            table, th, td {
                border: 1px solid black;
            }
        </style>
        <title>Members</title>
        <script>

            $(document).ready(function () {
                $("#updateAccount").click(function (event) {
                    var thisbranch = $("#mbranch option:selected").text();
                    var thismeth = $("#paymet option:selected").text();
                    $.get('MemberUpdateAccount', {thisMember: document.getElementById("memnum").value, joindat: document.getElementById("joindat").value, claimdat: document.getElementById("claimdat").value, coveramount: document.getElementById("coveramount").value, bettot: document.getElementById("bettot").value, paypoint: document.getElementById("paypoint").value, benefname: document.getElementById("benefname").value, benefid: document.getElementById("benefid").value, benefrelation: document.getElementById("benefrelation").value, benefdate: document.getElementById("benefdate").value, mbranch: thisbranch, paymeth: thismeth, accholder: document.getElementById("accholder").value, accNo: document.getElementById("accNo").value, deductDay: document.getElementById("deductDay").value, bankName: document.getElementById("bankName").value, accType: document.getElementById("accType").value, debitdate: document.getElementById("debitdate").value, branchNr: document.getElementById("branchNr").value, groupScheme: document.getElementById("groupScheme").value, empName1: document.getElementById("empName1").value, payerName: document.getElementById("payerName").value, empName2: document.getElementById("empName2").value, payerId: document.getElementById("payerId").value, stopOrderDate: document.getElementById("stopOrderDate").value, salNr: document.getElementById("salNr").value}, function (responseJson) {
                        if (responseJson !== null) {
                            $.each(responseJson, function (key, value) {
                                var t1 = value['GenGroupId'];
                                if (t1 == "success") {
                                    alert("success");
                                } else {
                                    alert("failed");
                                }
                            });
                        } else {
                            alert("no response");
                        }
                    });
                });
            });

            $(document).ready(function () {
                $("#contactupdate").click(function (event) {
                    $.get('MemberUpdateContact', {thisMember: document.getElementById("memnum").value, padd1: document.getElementById("padd1").value, padd2: document.getElementById("padd2").value, padd3: document.getElementById("padd3").value, pcode: document.getElementById("pcode").value, post1: document.getElementById("post1").value, post2: document.getElementById("post2").value, post3: document.getElementById("post3").value, postcode: document.getElementById("postcode").value, phonecell: document.getElementById("phonecell").value, phonework: document.getElementById("phonework").value, phonehome: document.getElementById("phonehome").value}, function (responseJson) {
                        if (responseJson !== null) {
                            $.each(responseJson, function (key, value) {
                                var t1 = value['GenGroupId'];
                                if (t1 == "success") {
                                    alert("success");
                                } else {
                                    alert("failed");
                                }
                            });
                        } else {
                            alert("no response");
                        }
                    });
                });
            });

            $(document).ready(function () {
                $("#newrec").click(function (event) {
                    window.location = "MemberNewRec.jsp?key=" + encodeURIComponent(document.getElementById("memnum").value);
                });
            });

            $(document).ready(function () {
                $("#claimgrid").click(function (event) {
                    var target = $(event.target);
                    $td = target.closest('td');
                    var col = $td.index();
                    var row = $td.closest('tr').index();
                    window.location = "MemberClaimSumm.jsp?key=" + encodeURIComponent(document.getElementById("claimgrid").rows[row].cells[0].innerHTML);

                });
            });

            function memberGetVoice() {
                $.get('MemberGetVoice', {thisMember: document.getElementById("memnum").value}, function (responseJson) {
                    if (responseJson != null) {
                        var table2 = $("#voicegrid");
                        $.each(responseJson, function (key, value) {
                            var rowNew = $("<tr><td></td><td></td><td></td></tr>");
                            rowNew.children().eq(0).text(value['user']);
                            rowNew.children().eq(1).text(value['dateMod']);
                            rowNew.children().eq(2).text(value['description']);
                            rowNew.appendTo(table2);
                        });
                    } else {
                        document.getElementById("memtitle").value = "No such member";
                    }
                });
            }


            function memberGetClaims() {
                $("#claimgrid").find("tr:gt(0)").remove()
                $.get('MemberGetClaims', {thisMember: document.getElementById("memnum").value}, function (responseJson) {

                    if (responseJson != null) {
                        var table2 = $("#claimgrid");
                        $.each(responseJson, function (key, value) {
                            var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                            rowNew.children().eq(0).text(value['ClaimNr']);
                            rowNew.children().eq(1).text(value['ClaimDate']);
                            rowNew.children().eq(2).text(value['DeceasedIni']);
                            rowNew.children().eq(3).text(value['DeceasedSur']);
                            rowNew.children().eq(4).text(value['DateOfDeath']);
                            rowNew.children().eq(5).text(value['ClaimStatus']);

                            rowNew.appendTo(table2);
                        });
                    } else {
                        document.getElementById("memtitle").value = "No such member";
                    }
                });

            }


            function memberGetImages() {

                // get member notes
                $.get('MemberGetImages', {thisMember: document.getElementById("memnum").value}, function (responseJson) {

                    if (responseJson != null) {
                        var table2 = $("#imagegrid");
                        $.each(responseJson, function (key, value) {
                            var rowNew = $("<tr><td></td><td></td><td></td></tr>");
                            rowNew.children().eq(0).text(value['user']);
                            rowNew.children().eq(1).text(value['dateMod']);
                            rowNew.children().eq(2).text(value['description']);

                            rowNew.appendTo(table2);
                        });
                    } else {
                        document.getElementById("memtitle").value = "No such member";
                    }
                });

            }


            function memberGetNotes() {

                // get member notes
                $.get('MemberGetNote', {thisMember: document.getElementById("memnum").value}, function (responseJson) {

                    if (responseJson != null) {
                        var table2 = $("#notesgrid");
                        $.each(responseJson, function (key, value) {
                            var rowNew = $("<tr><td></td><td></td><td></td></tr>");
                            rowNew.children().eq(0).text(value['dateMod']);
                            rowNew.children().eq(1).text(value['tranUserId']);
                            rowNew.children().eq(2).text(value['tranComment']);

                            rowNew.appendTo(table2);
                        });
                    } else {
                        document.getElementById("memtitle").value = "No such member";
                    }
                });

            }


            function membergetrec() {

                // get receipt details
                $.get('MemberReceiptGet', {thisMember: document.getElementById("memnum").value}, function (responseJson) {

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
                            // Display payment method
                            document.getElementById("paidrecmeth").innerHTML = value['betmet'];
                        });
                    } else {
                        document.getElementById("memtitle").value = "No such member";
                    }
                });

            }
            function membergetdepen() {
                var countDepen = 0;
                var activeDepen = 0;
                var dependAlert = "Check Dependents over 21 > ";
                var dependAlert2 = "Check Dependents almost 21 > ";

                $.get('MemberGetDepen', {thisMember: document.getElementById("memnum").value}, function (responseJson) {
                    if (responseJson != null) {
                        var table3 = $("#dependTable");
                        $.each(responseJson, function (key, value) {
                            countDepen++;
                            if (value['status'] == "ACTIVE" || value['status'] == "RE-JOINED") {
                                activeDepen++;
                            }
                            var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                            rowNew.children().eq(0).text(value['ini']);
                            rowNew.children().eq(1).text(value['sur']);
                            rowNew.children().eq(2).text(value['gebdat']);
                            rowNew.children().eq(3).text(value['sex']);
                            rowNew.children().eq(4).text(value['verwskap']);
                            rowNew.children().eq(5).text(value['age']);
                            rowNew.children().eq(6).text(value['premie']);
                            rowNew.children().eq(7).text(value['status']);
                            rowNew.children().eq(8).text(value['statusdate']);
                            rowNew.children().eq(9).text(value['tranid']);
                            var startdate = new Date(value['gebdat']);
                            var enddate = new Date();
                            var monthsDif = enddate.getMonth() - startdate.getMonth() +
                                    (12 * (enddate.getFullYear() - startdate.getFullYear()));
                            if (monthsDif > 252 && (value['status'] == "ACTIVE" || value['status'] == "RE-JOINED") && value['verwskap'] == "CHILD") {
                                dependAlert = dependAlert + " " + value['ini'] + " " + value['sur'];
                            }
                            if (monthsDif > 250 && monthsDif < 253 && (value['status'] == "ACTIVE" || value['status'] == "RE-JOINED") && value['verwskap'] == "CHILD") {
                                dependAlert2 = dependAlert2 + " " + value['ini'] + " " + value['sur'];
                            }

                            rowNew.appendTo(table3);
                        });

                        document.getElementById('nrdepen').value = countDepen;
                        document.getElementById('actDepen').value = activeDepen;
                    } else {
                        var table3 = $("#depend");
                        var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                        rowNew.children().eq(0).text("No Dependents");
                        rowNew.appendTo(table3);
                    }
                    if (dependAlert == "Check Dependents over 21 > ") {
                        document.getElementById("alert10").innerHTML = "";
                    } else {
                        document.getElementById("alert10").innerHTML = dependAlert;
                    }
                    if (dependAlert2 == "Check Dependents almost 21 > ") {
                        document.getElementById("alert11").innerHTML = "";
                    } else {
                        document.getElementById("alert11").innerHTML = dependAlert2;
                    }
                });
            }

            function membergetclaim() {

                $.get('MemberGetClaims', {thisMember: document.getElementById("memnum").value}, function (responseJson) {
                    if (responseJson != null) {
                        var table3 = $("#claimgrid");
                        $.each(responseJson, function (key, value) {
                            var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                            rowNew.children().eq(0).text(value['ini']);
                            rowNew.children().eq(1).text(value['sur']);
                            rowNew.children().eq(2).text(value['gebdat']);
                            rowNew.children().eq(3).text(value['sex']);
                            rowNew.children().eq(4).text(value['verwskap']);
                            rowNew.children().eq(5).text(value['age']);
                            rowNew.children().eq(6).text(value['premie']);
                            rowNew.children().eq(7).text(value['status']);
                            rowNew.children().eq(8).text(value['statusdate']);
                            rowNew.children().eq(9).text(value['tranid']);
                            rowNew.appendTo(table3);
                        });
                    } else {
                        var table3 = $("#depend");
                        var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                        rowNew.children().eq(0).text("No Claims");
                        rowNew.appendTo(table3);
                    }
                });
            }

            function loadMember()
            {
                if (document.getElementById("memnum").value.length === 8) {
                    var count = $("#memrecruit option").length;
                    if (count.valueOf() < 3) {
                        $.get('MemberGetRecruiter', function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    $('#memrecruit').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');

                                });
                            }
                        });
                    }

                    var count = $("#marriage option").length;
                    if (count.valueOf() < 2) {
                        $.get('MemberGetMarriage', function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    $('#marriage').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');

                                });
                            }
                        });
                    }

                    var count = $("#memcomp option").length;
                    if (count.valueOf() < 2) {
                        $.get('MemberGetCompanyName', function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    $('#memcomp').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');

                                });
                            }
                        });
                    }

                    var count = $("#mempoltype option").length;
                    if (count.valueOf() < 2) {
                        $.get('MemberGetPolType', function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    $('#mempoltype').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');
                                });
                            }
                        });
                    }

                    var count = $("#memstatus option").length;
                    if (count.valueOf() < 2) {
                        $.get('MemberGetPolStatus', function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    $('#memstatus').append('<option value="' + value['GenericDescriptionEng'] + '">' + value['GenericDescriptionEng'] + '</option>');
                                });
                            }
                        });
                    }

//                        document.getElementById("memname").value = "3";
                    // page one details
                    $.get('MemberDetail', {thisMember: document.getElementById("memnum").value}, function (responseJson) {
                        document.getElementById("memname").value = "0";
                        if (responseJson != null) {
                            $.each(responseJson, function (key, value) {
                                document.getElementById("memname").value = value['ini'];

                                document.getElementById("memtitle").value = value['shortname'];
                                document.getElementById("memsur").value = value['sur'];
                                document.getElementById("memidno").value = value['idno'];
                                document.getElementById("memgend").value = value['sex'];
                                document.getElementById("mememail").value = value['email'];
                                document.getElementById("memrecruit").value = value['recruiter'];
                                document.getElementById("memrecruitdate").value = value['recruitdate'];
                                document.getElementById("marriage").selectedIndex = value['troustat'] - 1;
//                                    document.getElementById("memage").value = value['age'];
                                document.getElementById("memdob").value = value['gebdat'];
                                document.getElementById("poldate").value = value['aanstdat'];
                                document.getElementById("memcomp").selectedIndex = value['orgid'];
                                document.getElementById("memstatusday").value = value['joindat'];
                                document.getElementById("mempoltype").selectedIndex = value['lidtipe'];
                                document.getElementById("memlang").value = value['taal'];
                                document.getElementById("cancode").value = value['cancode'];
                                document.getElementById("memstatus").selectedIndex = value['status'];
                                document.getElementById("memprem").value = value['initialPayment'];
                                document.getElementById("memtotprem").value = value['initialPayment'];
                                //tab 2 Contact
                                document.getElementById("padd1").value = value['physline1'];
                                document.getElementById("padd2").value = value['physline2'];
                                document.getElementById("padd3").value = value['physline3'];
                                document.getElementById("pcode").value = value['physcode'];
                                document.getElementById("post1").value = value['pobox'];
                                document.getElementById("post2").value = value['street'];
                                document.getElementById("post3").value = value['city'];
                                document.getElementById("postcode").value = value['zip'];
                                document.getElementById("postdate").value = value['postdate'];
                                document.getElementById("phonecell").value = value['opmaak'];
                                document.getElementById("phonehome").value = value['telh'];
                                document.getElementById("phonework").value = value['telw'];
                                //tab 4 Account
                                document.getElementById("joindat").value = value['joindat'];
                                document.getElementById("claimdat").value = value['eisdat'];
                                document.getElementById("mbranch").value = value['branch'];
                                document.getElementById("coveramount").value = value['coveramount'];
                                document.getElementById("bettot").value = value['bettot'];
                                document.getElementById("paymet").value = value['betmet'];

                                document.getElementById("paypoint").value = value['paypoint'];
                                document.getElementById("benefname").value = value['benefname'];
                                document.getElementById("benefid").value = value['benefID'];
                                document.getElementById("benefrelation").value = value['benefRelation'];
                                document.getElementById("benefdate").value = value['benefdate'];
                                document.getElementById("groupScheme").value = value['GroupSc'];
                                //Tab 5 Receipts
                                document.getElementById("paidrecdate").innerHTML = value['bettot'];
                                document.getElementById("creditrec").innerHTML = value['krediet'];
                                if (document.getElementById("paypoint").value === "undefined") {
                                    document.getElementById("paypoint").value = "";
                                }
                                if (document.getElementById("benefname").value === "undefined") {
                                    document.getElementById("benefname").value = "";
                                }
                                if (document.getElementById("benefid").value === "undefined") {
                                    document.getElementById("benefid").value = "";
                                }
                                if (document.getElementById("benefrelation").value === "undefined") {
                                    document.getElementById("benefrelation").value = "";
                                }
                                if (value['betmet'] === "6") {
                                    $("#stopDetail").css("visibility", "visible");
                                } else {
                                    $("#stopDetail").css("visibility", "hidden");
                                }
                                if (value['betmet'] === "3") {
                                    $("#debitDetail").css("visibility", "visible");
                                } else {
                                    $("#debitDetail").css("visibility", "hidden");
                                }

                                if (value['newprelidno'].substring(0, 1) == "Y") {
                                    $("#alert1").css("visibility", "visible");
                                } else {
                                    $("#alert1").css("visibility", "hidden");
                                }
                                if (value['newprelidno'].substring(1, 2) == "Y") {
                                    $("#alert2").css("visibility", "visible");
                                } else {
                                    $("#alert2").css("visibility", "hidden");
                                }
                                if (value['newprelidno'].substring(2, 3) == "Y") {
                                    $("#alert3").css("visibility", "visible");
                                } else {
                                    $("#alert3").css("visibility", "hidden");
                                }
                                if (value['newprelidno'].substring(3, 4) == "Y") {
                                    $("#alert4").css("visibility", "visible");
                                } else {
                                    $("#alert4").css("visibility", "hidden");
                                }
                                if (value['newprelidno'].substring(4, 5) == "Y") {
                                    $("#alert5").css("visibility", "visible");
                                } else {
                                    $("#alert5").css("visibility", "hidden");
                                }
                                if (value['newprelidno'].substring(5, 6) == "Y") {
                                    $("#alert6").css("visibility", "visible");
                                } else {
                                    $("#alert6").css("visibility", "hidden");
                                }
                                if (value['newprelidno'].substring(6, 7) == "Y") {
                                    $("#alert7").css("visibility", "visible");
                                } else {
                                    $("#alert7").css("visibility", "hidden");
                                }
                                if (value['newprelidno'].substring(7, 8) == "Y") {
                                    $("#alert8").css("visibility", "visible");
                                } else {
                                    $("#alert8").css("visibility", "hidden");
                                }
                                if (value['newprelidno'].substring(8, 9) == "Y") {
                                    $("#alert9").css("visibility", "visible");
                                } else {
                                    $("#alert9").css("visibility", "hidden");
                                }

                            });
                            membergetdepen();
                            membergetclaim();
                        }
                    });

                    if (document.getElementById("memnum").value.length === 8) {
                        $.get('MemberGetExtraPol', {thisMember: document.getElementById("memnum").value}, function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    document.getElementById("addpol1").innerHTML = value['secPol1'];
                                    document.getElementById("addpol1am").innerHTML = value['secPol1Premie'];
                                    document.getElementById("addpol2").innerHTML = value['secPol2'];
                                    document.getElementById("addpol2am").innerHTML = value['secPol2Premie'];
                                    document.getElementById("addpol3").innerHTML = value['secPol3'];
                                    document.getElementById("addpol3am").innerHTML = value['secPol3Premie'];
                                    document.getElementById("addpol4").innerHTML = value['secPol4'];
                                    document.getElementById("addpol4am").innerHTML = value['secPol4Premie'];
                                    document.getElementById("addpol5").innerHTML = value['secPol5'];
                                    document.getElementById("addpol5am").innerHTML = value['secPol5Premie'];
                                    document.getElementById("addpol6").innerHTML = value['secPol6'];
                                    document.getElementById("addpol6am").innerHTML = value['secPol6Premie'];
                                    document.getElementById("addpol7").innerHTML = value['secPol7'];
                                    document.getElementById("addpol7am").innerHTML = value['secPol7Premie'];
                                    if (document.getElementById("addpol1").innerHTML == "undefined") {
                                        document.getElementById("addpol1").innerHTML = "";
                                    }
                                    if (document.getElementById("addpol2").innerHTML == "undefined") {
                                        document.getElementById("addpol2").innerHTML = "";
                                    }
                                    if (document.getElementById("addpol3").innerHTML == "undefined") {
                                        document.getElementById("addpol3").innerHTML = "";
                                    }
                                    if (document.getElementById("addpol4").innerHTML == "undefined") {
                                        document.getElementById("addpol4").innerHTML = "";
                                    }
                                    if (document.getElementById("addpol5").innerHTML == "undefined") {
                                        document.getElementById("addpol5").innerHTML = "";
                                    }
                                    if (document.getElementById("addpol6").innerHTML == "undefined") {
                                        document.getElementById("addpol6").innerHTML = "";
                                    }
                                    if (document.getElementById("addpol7").innerHTML == "undefined") {
                                        document.getElementById("addpol7").innerHTML = "";
                                    }
                                    if (document.getElementById("addpol1am").innerHTML == "undefined") {
                                        document.getElementById("addpol1am").innerHTML = "";
                                    }
                                    if (document.getElementById("addpol2am").innerHTML == "undefined") {
                                        document.getElementById("addpol2am").innerHTML = "";
                                    }
                                    if (document.getElementById("addpol3am").innerHTML == "undefined") {
                                        document.getElementById("addpol3am").innerHTML = "";
                                    }
                                    if (document.getElementById("addpol4am").innerHTML == "undefined") {
                                        document.getElementById("addpol4am").innerHTML = "";
                                    }
                                    if (document.getElementById("addpol5am").innerHTML == "undefined") {
                                        document.getElementById("addpol5am").innerHTML = "";
                                    }
                                    if (document.getElementById("addpol6am").innerHTML == "undefined") {
                                        document.getElementById("addpol6am").innerHTML = "";
                                    }
                                    if (document.getElementById("addpol7am").innerHTML == "undefined") {
                                        document.getElementById("addpol7am").innerHTML = "";
                                    }

                                });
                            }
                        });
                    }

                    if (document.getElementById("memnum").value.length === 8) {
                        $.get('MemberHavePost', {thisMember: document.getElementById("memnum").value}, function (responseJson) {
                            $("#alert12").css("visibility", "hidden");

                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    if (value['GenGroupId'] == "Y") {
                                        $("#alert12").css("visibility", "visible");
                                    } else {
                                        $("#alert12").css("visibility", "hidden");
                                    }
                                });
                            }
                        });
//  get post send for alert here                        

                    }
                    // Tab 4 Accouts
                    if (document.getElementById("memnum").value.length === 8) {
                        $.get('MemberGetDebitOrder', {thisMember: document.getElementById("memnum").value}, function (responseJson) {
                            if (responseJson != null) {
                                $.each(responseJson, function (key, value) {
                                    //Debit order
                                    document.getElementById("accholder").value = value['REK_NAAM'];
                                    document.getElementById("accNo").value = value['REK_NO'];
                                    document.getElementById("deductDay").value = value['KERE'];
                                    document.getElementById("bankName").value = value['BankName'];
                                    document.getElementById("accType").value = value['TIPE_REK'];
                                    document.getElementById("debitdate").value = value['DAT1'];
                                    document.getElementById("branchNr").value = value['TAKKODE'];
                                    //Stop Order
                                    document.getElementById("empName1").value = value['EmpName1'];
                                    document.getElementById("empName2").value = value['EmpName2'];
                                    document.getElementById("stopOrderDate").value = value['DAT1'];
                                    document.getElementById("payerName").value = value['PayerName'];
                                    document.getElementById("payerId").value = value['PayerID'];
                                    document.getElementById("salNr").value = value['SalNr'];

                                });
                            }
                        });
                    }

                    $("#depend").find("tr:gt(0)").remove();
                    $("#recgrid").find("tr:gt(0)").remove();
                    $("#notesgrid").find("tr:gt(0)").remove();
                    $("#imagegrid").find("tr:gt(0)").remove();
                    $("#claimgrid").find("tr:gt(0)").remove();
                    $("#voicegrid").find("tr:gt(0)").remove();

                } else {
                    //Member Details
                    document.getElementById("memtitle").value = "No such member";
                    document.getElementById("memname").value = "";
                    document.getElementById("memsur").value = "";
                    document.getElementById("memidno").value = "";
                    document.getElementById("memgend").value = 0;
                    document.getElementById("mememail").value = "";
                    document.getElementById("memrecruit").value = "";
                    document.getElementById("memrecruitdate").value = "";
                    document.getElementById("marriage").selectedIndex = "";
//                                    document.getElementById("memage").value = "";
                    document.getElementById("memdob").value = "";
                    document.getElementById("poldate").value = "";
                    document.getElementById("memcomp").selectedIndex = "";
                    document.getElementById("memstatusday").value = "";
                    document.getElementById("mempoltype").selectedIndex = "";
                    document.getElementById("memlang").value = "";
                    document.getElementById("cancode").selectedIndex = "";
                    document.getElementById("memstatus").selectedIndex = "";
                    document.getElementById("memprem").value = "";
                    document.getElementById("memtotprem").value = "";
                    //tab 2 Contact
                    document.getElementById("padd1").value = "";
                    document.getElementById("padd2").value = "";
                    document.getElementById("padd3").value = "";
                    document.getElementById("pcode").value = "";
                    document.getElementById("post1").value = "";
                    document.getElementById("post2").value = "";
                    document.getElementById("post3").value = "";
                    document.getElementById("postcode").value = "";
                    document.getElementById("postdate").value = "";
                    document.getElementById("phonecell").value = "";
                    document.getElementById("phonehome").value = "";
                    document.getElementById("phonework").value = "";
                    //tab 3 Dependants
                    document.getElementById('nrdepen').value = "0";
                    document.getElementById('actDepen').value = "0";
                    $("#depend").find("tr:gt(0)").remove();
                    //tab 4 Account
                    document.getElementById("joindat").value = "";
                    document.getElementById("claimdat").value = "";
                    document.getElementById("mbranch").value = "";
                    document.getElementById("coveramount").value = "";
                    document.getElementById("bettot").value = "";
                    document.getElementById("paymet").selectedIndex = "";
                    document.getElementById("paypoint").value = "";
                    document.getElementById("benefname").value = "";
                    document.getElementById("benefid").value = "";
                    document.getElementById("benefrelation").value = "";
                    document.getElementById("benefdate").value = "";
                    //Debit order
                    document.getElementById("accholder").value = "";
                    document.getElementById("accNo").value = "";
                    document.getElementById("deductDay").value = "";
                    document.getElementById("bankName").value = "";
                    document.getElementById("accType").value = "";
                    document.getElementById("debitdate").value = "";
                    document.getElementById("branchNr").value = "";
                    document.getElementById("groupScheme").value = "";
                    //Stop Order
                    document.getElementById("empName1").value = "";
                    document.getElementById("empName2").value = "";
                    document.getElementById("stopOrderDate").value = "";
                    document.getElementById("payerName").value = "";
                    document.getElementById("payerId").value = "";
                    document.getElementById("salNr").value = "";
                    //tab 5 Receipts
                    document.getElementById("paidrecdate").innerHTML = "YYYY/MM/DD";
                    document.getElementById("creditrec").innerHTML = "0.00";
                    document.getElementById("paidrecmeth").innerHTML = "";
                    $("#recgrid").find("tr:gt(0)").remove();
                    //tab 6 Notes
                    $("#notesgrid").find("tr:gt(0)").remove();
                    //tab 7 Claims
                    $("#imagegrid").find("tr:gt(0)").remove();
                    //tab 8 Images
                    $("#claimgrid").find("tr:gt(0)").remove();
                    //tab 10 Voice
                    $("#voicegrid").find("tr:gt(0)").remove();
                    //Extra Policies
                    document.getElementById("addpol1").innerHTML = "";
                    document.getElementById("addpol1am").innerHTML = "";
                    document.getElementById("addpol2").innerHTML = "";
                    document.getElementById("addpol2am").innerHTML = "";
                    document.getElementById("addpol3").innerHTML = "";
                    document.getElementById("addpol3am").innerHTML = "";
                    document.getElementById("addpol4").innerHTML = "";
                    document.getElementById("addpol4am").innerHTML = "";
                    document.getElementById("addpol5").innerHTML = "";
                    document.getElementById("addpol5am").innerHTML = "";
                    document.getElementById("addpol6").innerHTML = "";
                    document.getElementById("addpol6am").innerHTML = "";
                    document.getElementById("addpol7").innerHTML = "";
                    document.getElementById("addpol7am").innerHTML = "";

                }
            }


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
            <label> Member Number <input type ="text" id="memnum" width ="15" style="margin-left:10px" onkeyup="loadMember()" value="000" > </label>
            <br>
            <label> Title <input type ="text" id="memtitle" width="25" style="margin-left:47px"> </label>
            <label style="margin-left:100px"> Company Name <select id="memcomp" style="width:100px" > <option value=""></option> </select> </label>
            <br>
            <label> Name <input type="text" id="memname" width="25" style="margin-left:35px" > </label>
            <label style ="margin-left: 100px"> Policy Type <select id="mempoltype" style="width:150px; margin-left:30px;" > <option value=""></option> </select> </label>
            <br>
            <label> Surname <input type="text" id="memsur" width="25" style="margin-left:20px"> </label>
            <label style="margin-left:100px"> Policy Date <input type="text" id="poldate" width="20" style="margin-left:30px;" > </label>
            <br>
            <label> ID Number <input type="text" id="memidno" width="25" style="margin-left:3px"> </label>
            <label style="margin-left:100px"> Cancel Code <select id="cancode" style="width:100px; margin-left:20px;">
                    <option value="0"></option>
                    <option value="01 Insufficient Funds One">01 Insufficient Funds One</option>
                    <option value="02 Payment Stopped By You">02 Payment Stopped By You</option> 
                    <option value="03 Account Closed">03 Account Closed</option> 
                    <option value="04 Rejected By Bank - Incorrect Details">04 Rejected By Bank - Incorrect Details</option> 
                    <option value="05 Debits Not Allowed To Account">05 Debits Not Allowed To Account</option> 
                    <option value="06 Account Frozen">06 Account Frozen</option> 
                    <option value="07 No Authority To Debit">07 No Authority To Debit</option> 
                    <option value="08 Account Effects Not Cleared">08 Account Effects Not Cleared</option> 
                    <option value="09 Cancellation From Branch">09 Cancellation From Branch</option> 
                    <option value="10 Cancellation From Client">10 Cancellation From Client</option> 
                    <option value="11 Insufficient Funds Two">11 Insufficient Funds Two</option> 
                    <option value="12 Main Member Deceased">12 Main Member Deceased</option> 
                    <option value="13 Amendmend Cancellation">13 Amendmend Cancellation</option> 
                    <option value="14 No Such Account">14 No Such Account</option> 
                    <option value="17 Cancelled By Goverment">17 Cancelled By Goverment</option> 
                    <option value="29 Prev. Stopped Via Advice">29 Prev. Stopped Via Advice</option> 
                    <option value="34 Account Holder Deceased">34 Account Holder Deceased</option> 
                    <option value="35 Cancelled By Head Office">35 Cancelled By Head Office</option> 
                    <option value="46 Acc Transfer ( Within Bank )">46 Acc Transfer ( Within Bank )</option> 
                </select> </label>
            <br>
            <label> Gender <select id="memgend" style="width:85px; margin-left:28px;"><option value="0">Select</option> <option value="1">Male</option><option value="2">Female</option></select> </label>
            <label style="margin-left:166px"> Language <select id="memlang" style="width:100px; margin-left:40px;"> 
                    <option value="0"></option> 
                    <option value="1">Afrikaans</option> 
                    <option value="2">English</option> 
                </select> </label>
            <br>    
            <label> E-Mail <input type="text" id="mememail" width="25" style="margin-left:31px" > </label>
            <label style="margin-left:100px"> Status <select id="memstatus" style ="width:100px; margin-left:62px"><option value=""></option></select> </label>
            <br>
            <label> Recruiter <select id="memrecruit" style="width:150px; margin-left:17px;"> <option value=""> </option> </select> </label>
            <label style="margin-left:100px"> Status Date <input type="text" id="memstatusday" width="25" style = "margin-left:27px"> </label>
            <br>
            <label Style ="margin-left:20px"> Date <input type="text" id="memrecruitdate" style="margin-left:25px" > </label>
            <label style="margin-left:100px" > Premium <input type="text" id="memprem" style="width:60px; margin-left:45px; " > </label>
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
                <li><a href="#tabs-5" onclick="membergetrec();">Receipts</a></li>
                <li><a href="#tabs-6" onclick="memberGetNotes();">Notes</a></li>
                <li><a href="#tabs-7" onclick="memberGetClaims()">Claims</a></li>
                <li><a href="#tabs-8" onclick="memberGetImages();">Images</a></li>
                <li><a href="#tabs-9">Letters</a></li>
                <li><a href="#tabs-10" onclick="memberGetVoice();">Voice</a></li>
            </ul>

            <div id="tabs-1">
                <div id="alert1" style="color:red; float:left;"> Postal address incorrect </div>
                <div id="alert2" style="color:red; float:left; margin-left:200px"> ID No incorrect </div>
                <div style="float: right; text-align: right;margin-right:20;">
                    Additional / Extra Policies
                </div>     
                <br>
                <div id="alert3" style="color:red; float:left;"> Cell nr incorrect </div>
                <div id="alert4" style="color:red; float:left; margin-left:200px"> Contact HO </div>
                <div style="float: right; text-align: right;margin-right:15px;">
                    Premium 
                </div>
                <div style="float: right; text-align: right;margin-right:20px;">
                    Policy
                </div>
                <br>
                <div id="alert5" style="color:red; float:left;"> Check dependents </div>
                <div id="alert6" style="color:red; float:left; margin-left:200px"> Check premium </div>
                <div id="addpol1am" style="float: right; text-align: right;margin-right:30px;"></div>
                <div id ="addpol1" style="float: right; text-align: right;margin-right:30px;"></div>
                <br>
                <div id="alert7" style="color:red; float:left;"> Read Notes </div>
                <div id="alert8" style="color:red; float:left; margin-left:200px"> Stop order premium </div> 
                <div id="addpol2am" style="float: right; text-align: right;margin-right:30px;"></div>
                <div id ="addpol2" style="float: right; text-align: right;margin-right:30px;"></div>
                <br>
                <div id="alert9" style="color:red; float:left;"> Check express post </div>
                <div id="alert12" style="color:red; float:left;margin-left:200px "> Check post </div>
                <div id="addpol3am" style="float: right; text-align: right;margin-right:30px;"></div>
                <div id ="addpol3" style="float: right; text-align: right;margin-right:30px;"></div>
                <br>
                <div id="alert10" style="color:red; float:left;"> Alert Dependent </div>
                <div id="addpol4am" style="float: right; text-align: right;margin-right:30px;"></div>
                <div id ="addpol4" style="float: right; text-align: right;margin-right:30px;"></div>
                <br>
                <div id="alert11" style="color:red; float:left;"> Alert Dependent </div>
                <div id="addpol5am" style="float: right; text-align: right;margin-right:30px;"></div>
                <div id ="addpol5" style="float: right; text-align: right;margin-right:30px;"></div>
                <br>                
                <div id="addpol6am" style="float: right; text-align: right;margin-right:30px;"></div>
                <div id ="addpol6" style="float: right; text-align: right;margin-right:30px;"></div>
                <br>                
                <div id="addpol7am" style="float: right; text-align: right;margin-right:30px;"></div>
                <div id ="addpol7" style="float: right; text-align: right;margin-right:30px;"></div>
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
                <input id="actDepen" style="margin-left:10px; width:30px;">
                <input type="button" value="New" id="newdepen" style="width:75px; float:right;">
                <br>  

                <div id="tablediv">

                    <table cellspacing="0" id="dependTable" margin-right:20px style="table-layout:fixed;float: left; border-collapse: collapse;margin-left:10px; border: 1px solid black;width:95%"> 

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

                    </table>
                </div>

            </div>
            <div id="tabs-4">
                <label> Join Date </label>
                <input type="text" id="joindat" style="margin-left:19px;width:100px;" >
                <label style="margin-left:40px"> Cover Amount </label>
                <input type="text" id="coveramount" style="margin-left:26px;width:60px" >
                <label style="margin-left:140px"> Beneficiary </label>
                <br>
                <label> Claim date </label>
                <input type="text" id="claimdat" style="margin-left:10px;width:100px;" >
                <label style="margin-left:40px"> Paid Up To </label>
                <input type="text" id="bettot" style="width:100px; margin-left:49px" >
                <label style="margin-left:30px"> Name </label>
                <input type="text" id="benefname" style="width:190px; margin-left:50px" >

                <br>
                <label> Branch </label>
                <select name="membranch" id="mbranch" style="width:100px; margin-left:38px" >
                    <option value=""> </option>
                    <option value="Durban">Durban</option>
                    <option value="Empangeni">Empangeni</option>
                    <option value="Empangeni Pensioners">Empangeni Pensioners</option>
                    <option value="Finance">Finance</option>
                    <option value="Head Office">Head Office</option>
                    <option value="Melmoth">Melmoth</option>
                    <option value="Melmoth Pensioners">Melmoth Pensioners</option>
                    <option value="Mokopane">Mokopane</option>
                    <option value="Mtubatuba">Mtubatuba</option>
                    <option value="Mtubatuba Pensioners">Mtubatuba Pensioners</option>
                    <option value="Nongoma">Nongoma</option>
                    <option value="Nongoma Pensioners">Nongoma Pensioners</option>
                    <option value="Ulundi">Ulundi</option>
                    <option value="Workshop">Workshop</option>
                </select>                      
                <label style="margin-left:44px"> Payment Method </label>
                <select onchange="changePayMeth(this)" name="paymeth" id="paymet" style="margin-left:10px; width:110px;">
                    <option value="0"></option> 
                    <option value="1">Cash</option>
                    <option value="2">Direct Deposit</option>
                    <option value="3">Debit Order</option>
                    <option value="4">Postal Payment</option>
                    <option value="5">External Payments</option>
                    <option value="6">Stop Order</option>
                    <option value="7">Debit + Stop Order</option>
                    <option value="8">Debit</option>
                    <option value="9">Staff Payment</option> 
                    <option value="10">Pensioners</option> 
                    <option value="11">Cheque</option> 

                </select>
                <label style="margin-left:30px;"> ID Nr </Label>
                <input type="text" id="benefid" style="width:160px;margin-left:55px">
                <br>
                <label style="margin-left:240px;"> Pay Point </label>
                <input type="text" id="paypoint" style="margin-left:60px; width:100px;" >
                <label style="margin-left:30px"> Relationship </label>
                <input type="text" id="benefrelation" style="margin-left:10px;width:100px;" >
                <br>
                <label style="margin-left:515px"> Date </label>
                <input type="text" id="benefdate" style="width:100px; margin-left:60px">
                <input type="button" id ="updateAccount" value="Update" style="float:right;width:85px">
                <br>
                <fieldset id="debitDetail">
                    Bank Details
                    <br>
                    <label> Acc Holder </label>
                    <input type="text" id="accholder" style="width:170px; margin-left:15px" >
                    <label style="margin-left:20px"> Acc Number </label>
                    <input type="text" id ="accNo" style="margin-left:25px; width:100px" >
                    <label style="margin-left:40px"> Day to Deduct </label>
                    <input type="text" id="deductDay" style="width:50px;margin-left:20px">
                    <br>
                    <label> Bank Name </label>
                    <input type ="text" id="bankName" style="margin-left:10px;width:170px" >
                    <label style="margin-left:20px"> Account Type </label>
                    <select name="acctyp" id="accType" style="width:120px; margin-left:19px" >
                        <option value=""> </option>      
                        <option value="SAVINGS">Savings</option>
                        <option value="CHEQUE">Cheque</option>
                        <option value="TRANSMISSION">Transmission</option>
                    </select>     
                    <label style="margin-left:25px;width:100px;"> Start Date </label>
                    <input type="text" id="debitdate" style="width:100px; margin-left:50px;" >

                    <br>
                    <label> Branch Nr </label>                       
                    <input type="text" id="branchNr" style="width:170px;margin-left:22px;" >
                    <label style="margin-left:20px;">Groupscheme</label>
                    <select name="groupSchem" id="groupScheme" style="margin-left:16px;width:120px" >
                        <option value=""> </option>      
                        <option value="GS001">GS001</option>
                        <option value="GS002">GS002</option>
                        <option value="GS003">GS003</option>
                        <option value="GS004">GS004</option>
                        <option value="GS005">GS005</option>
                        <option value="GS006">GS006</option>


                    </select> 
                </fieldset>

                <fieldset id="stopDetail">
                    Stop Order
                    <br>
                    <label> Employer 1 </label>
                    <label style="margin-left:10px">
                        <input type="text" list ="emp1" id= "empName1" style="width:170px">
                        <!--                        <datalist id="emp1">
                                                    <option> </option>
                                                </datalist>-->
                    </label>
                    <label style="margin-left:25px;"> Payer Name </label>
                    <input type="text" id="payerName" style="margin-left:10px;width:150px">
                    <br>
                    <label> Employer 2 </label>
                    <label style="margin-left:10px">
                        <input type="text" list="emp2" id="empName2" style="width:170px">
                        <!--                        <datalist id="emp2" >
                                                    <option> </option>
                                                </datalist>-->
                    </label>
                    <label Style="margin-left:25px"> Payer Id </label>
                    <input type="text" id="payerId" style="width:150px;margin-left:40px;">
                    <br>
                    <label> Start Date</label>
                    <input type="text" id="stopOrderDate"  style="margin-left:20px;width:100px;">
                    <label style="margin-left:92px;width:100px" > Salary Nr </label>
                    <input type="text" id="salNr" style="margin-left:35px; width:120px" >
                    <br>
                    <script>
                        var myCalendar6 = new dhtmlXCalendarObject(["joindat"]);
                        myCalendar6.setDateFormat("%Y/%m/%d");
                        var myCalendar7 = new dhtmlXCalendarObject(["claimdat"]);
                        myCalendar7.setDateFormat("%Y/%m/%d");
                        var myCalendar8 = new dhtmlXCalendarObject(["bettot"]);
                        myCalendar8.setDateFormat("%Y/%m/%d");
                        var myCalendar9 = new dhtmlXCalendarObject(["benefdate"]);
                        myCalendar9.setDateFormat("%Y/%m/%d");
                        var myCalendar10 = new dhtmlXCalendarObject(["debitdate"]);
                        myCalendar10.setDateFormat("%Y/%m/%d");
                        var myCalendar11 = new dhtmlXCalendarObject(["stopOrderDate"]);
                        myCalendar11.setDateFormat("%Y/%m/%d");
                    </script>  
                </fieldset>

            </div>
            <div id="tabs-5">  
                This policy paid until :
                <label style="margin-left:5px" id="paidrecdate"></label>
                <label style="margin-left:60px"> Payment Method : </label>
                <label id="paidrecmeth" style="margin-left:5px"></label>

                <input type="button" id="bankfeerec" value="Bank Fees" style="margin-left:30px;width:90px">
                <input type="button" id="cancellrec" value="Cancell" style="margin-left:20px;width:90px">
                <input type="button" id="newrec" value="New Rec" style="margin-left:20px;width:90px">
                <br>
                <label style="margin-left:0px"> Credit:</label>
                <label style="margin-left:10px" id="creditrec"></label>      
                <input type="button" id="printoldrec" value="Print" style="margin-left:533px;width:90px;">
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
                        <!--                                <tr>
                                                            <td> 08:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr>   <td> 08:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr><td> 09:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr><td> 09:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr><td> 10:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr><td> 10:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr><td> 11:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr><td> 11:30 </td> <td> </td> <td> </td> <td> </td></tr>-->

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
                        <!--                                <tr>
                                                            <td> 08:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr>   <td> 08:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr><td> 09:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr><td> 09:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr><td> 10:00 </td> <td> </td> <td> </td> <td> </td></tr>                             -->

                    </table>
                </div> 
                <br>
                <br>
                <textarea style="border: 1px solid #111;"  id="notesdet" cols="100" rows="5">
                </textarea>
            </div>   

            <div id="tabs-7"> 
                <input type="button" id="updatenote" value="New Claim" style="float:right;margin-right:20px;width:95px">
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
                        <!--                                <tr>
                                                            <td> 08:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr>   <td> 08:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr><td> 09:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr><td> 09:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr><td> 10:00 </td> <td> </td> <td> </td> <td> </td></tr>                             -->
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
                        <!--                                <tr>
                                                            <td> 08:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr>   <td> 08:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr><td> 09:00 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr><td> 09:30 </td> <td> </td> <td> </td> <td> </td></tr>
                                                        <tr><td> 10:00 </td> <td> </td> <td> </td> <td> </td></tr>                             -->
                    </table>
                </div> 
            </div> 

        </div>

    </body>
</html>
