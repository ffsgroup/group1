<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
        <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>   
        <script src="resources/dhtmlxcalendar.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/dhtmlxcalendar_1.css"/>
        <link rel="stylesheet" type="text/css" href="resources/button.css"/>

        <script>
            $(document).ready(function () {
                $("#updated").click(function (event) {
                    var thisrelate = $("#mrelate1 option:selected").text();
                    var thisgend = $("#gend1 option:selected").text();
                    var thisstat = $("#stat1 option:selected").text();
                    $.get('MemberUpdateDepend', {thisMember: document.getElementById("memno").innerHTML, tranid : document.getElementById("tranid").innerHTML, ini: document.getElementById("ini").value, sur: document.getElementById("sur").value, idno: document.getElementById("idno").value, bdate: document.getElementById("bdate").value, joindate: document.getElementById("joindate").value, mrelate1: thisrelate, gend1: thisgend, stat1: thisstat, statdate1: document.getElementById("statdate1").value }, function (responseJson) {
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
          </script>  
          <script>  
            var myCalendar;
            function doOnLoad() {
                myCalendar = new dhtmlXCalendarObject("myCalendar1");
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
    </head> 
    <body>
        <div style="background: #E0E0E0; height: 55px; padding: 5px;">
            <div style="float: left">
                <h1>FFS Group</h1>        
            </div>
            <div style="float: right; padding: 10px;" >
                <!-- User store in session with attribute: loginedUser -->
                <b>${loginedUser.userName}</b>
                <br>
                <a href="${pageContext.request.contextPath}/userInfo">Home</a>
                |
                <a href="${pageContext.request.contextPath}/login">Login</a>
            </div>
            <div style="text-align: center;">
                <h2>Member Dependent</h2>        
            </div>
        </div>


        <div>
            <br> <br>
            <label style = "font-size:20px"> Edit Member Dependent </label> 
            <label style = "font-size:20px" id="tranid">${tranid}</label> 
            <br>
            <label style = "font-size:20px"> Member </label> 
            <label style = "font-size:20px" id="memno">${lidno}</label>
            <br>
            <br>
            <table>
                <tr>
                    <td>First name</td> <td> <input type ="text" id="ini" width ="15" style="margin-left:10px" value=${ini} > </td>            
                </tr>
                <tr>
                    <td>Surname</td> <td> <input type ="text" id="sur" width ="15" style="margin-left:10px" value=${sur} > </td>            
                </tr>
                <tr>
                    <td>ID No</td> <td> <input type ="text" id="idno" width ="15" style="margin-left:10px" value=${idno} > </td>            
                </tr>
                <tr>
                    <td>Birth date</td> <td> <input type ="text" id="bdate" width ="15" style="margin-left:10px" value=${gebdat} > </td>            
                </tr>
                <tr>
                    <td>Join date</td> <td> <input type ="text" id="joindate" width ="15" style="margin-left:10px" value=${joindate} > </td>            
                </tr>
                <tr>
                    <td>Relationship</td> <td> <select name="mrelate" id="mrelate1" style="width:120px; margin-left:38px;">
                            <option value="${verwskap}">${verwskap}</option>
                            <option value="SPOUSE">SPOUSE</option>
                            <option value="CHILD">CHILD</option>
                            <option value="WIFE">WIFE</option>
                            <option value="HUSBAND">HUSBAND</option>
                            <option value="PARENT">PARENT</option>
                            <option value="STUDENT">STUDENT</option>
                            <option value="CHILD - EXTRA">CHILD - EXTRA</option>
                            <option value="CHILD - DISABLED">CHILD - DISABLED</option>
                        </select>          
                    </td>            
                </tr>
                <tr>
                    <td>Gender</td> <td> <select name="gend1" id="gend1" style="width:120px; margin-left:38px;">
                            <option value="${sex}">${sex}</option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </select>
                </tr>
                <tr>
                    <td>Status</td> <td><select name="status1" id="stat1" style="width:120px; margin-left:38px;">
                            <option value="${status}">${status}</option>
                            <option value="ARCHIVE">ARCHIVE</option>
                            <option value="HISTORIC">HISTORIC</option>
                            <option value="ACTIVE">ACTIVE</option>
                            <option value="FULLY PAID UP">FULLY PAID UP</option>
                            <option value="WAITING">WAITING</option>
                            <option value="CANCELLED">CANCELLED</option>
                            <option value="DECEASED">DECEASED</option>
                            <option value="RE-JOINED">RE-JOINED</option>
                            <option value="SUSPENDED">SUSPENDED</option>
                        </select>  
                    </td>            
                </tr>
                <tr>
                    <td>Status Date</td> <td> <input type ="text" id="statdate1" width ="15" style="margin-left:10px" value=${statusdate} > </td>            
                </tr>                 

            </table>


            <br>
            <label id = "label1" style = "visibility:hidden;" >${secur}</label>
            <input type ="button" id="updated" value="Update" >
            <script>
                var myCalendar1 = new dhtmlXCalendarObject(["bdate"]);
                myCalendar1.setDateFormat("%Y/%m/%d");

                var myCalendar2 = new dhtmlXCalendarObject(["joindate"]);
                myCalendar2.setDateFormat("%Y/%m/%d");

                var myCalendar3 = new dhtmlXCalendarObject(["statdate1"]);
                myCalendar3.setDateFormat("%Y/%m/%d");

            </script>  
            <script>
                var val1 = document.getElementById("label1").innerHTML;
                if (document.getElementById("label1").innerHTML == "Y") {
                    $("#updated").css("visibility", "visible");
                } else {
                    $("#updated").css("visibility", "hidden");
                }
            </script>   
        </div>    
    </body>    
</html>