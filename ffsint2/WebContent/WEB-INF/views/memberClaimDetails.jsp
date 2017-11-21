
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Claim details</title>
        <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
        <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="resources/dhtmlxcalendar.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/dhtmlxcalendar_1.css"/>        
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
                    //	writeLog("onClick event called, "+side+" calendar, date "+myCalendar.getFormatedDate(null,d));
                });
            }
        </script>

    </head>
    <body>
        <div style="background: #E0E0E0; height: 55px; padding: 5px;">
            <div style="float: left">
                <h1>FFS Group</h1>        
            </div>
            <div style="float: right; padding: 5px;" >
                <b>${loginedUser.userName}</b>
                <br>
                <a href="${pageContext.request.contextPath}/userInfo">Home</a>
                |
                <a href="${pageContext.request.contextPath}/login">Login</a>
            </div>
            <div style="text-align: center;">
                <h2>Claim Details</h2>       
            </div>

            <title>Claim Details</title>
        </div>    
        <br> <br>
        Member  <label id="lidno">${lidno}</label>   <label style="margin-left:10px;"> Claim </label> <label id="claimno"> ${tranid} </label> <label style="margin-left:10px;"> Summary </label> <label id="summid"> ${summid} </label> <br>

        <table>
            <tr>
                <td style="width:90px;"> <label> Deceased </label> </td> 
                <td style="width:100px"> </td>
                <td style="width:90px"> </td>
                <td style="width:100px;"><label> Beneficiary </label></td> 
                <td style="width:100px"> </td>
                <td style="width:90px"> </td>
                <td style="width:105px"> </td>
                <td style="width:100px"> </td>
            </tr>
            <tr>
                <td>   Names </td> <td><input type="text" id="decname" style="width:120px;" value=${ini}>  </td>
                <td style="width:90px"> </td>
                <td> <label> Name </label> </td> <td><input type="text" id="benname" style="width:120px;" value=${benname} > </td>
                <td style="width:90px"> </td>
                <td><label> TombStone </label> </td>       
                <td><select name="tomb" id = "stoneNr" style="margin-left: 5px; width: 120px" >
                        <option value="${tombnr}">${tombnr}</option>
                        <option value="None">None</option>
                        <option value="003">003</option>
                        <option value="046">046</option>                    
                    </select> </td>
            </tr>
            <tr>
                <td> Surname </td> <td><input type="text" id="decname" style="width:120px;" value=${sur} > </td> 
                <td style="width:90px"> </td>
                <td> <label> ID Nr </label></td> <td> <input type="text" style="width:120px;" value=${benid} > </td>
                <td style="width:90px"> </td>
                <td><label> Policy Type </label> </td> <td> <input type="text" style="width:120px;" value=${poltipe} > </td>
            </tr>
            <tr>
                <td><label> ID Nr </label></td> <td> <input type="text" style ="width:120px" value=${decid} > </td>
                <td style="width:90px"> </td>
                <td><label> Claimer </label> </td><td style="width:100px"> </td>            
                <td style="width:90px"> </td>
                <td> <label> Claim Nr </label></td> <td> <input type="text" style="width:120px;" value=${claimnr} > </td>
            </tr>
            <tr>
                <td> Relationship </td>
                <td><select name="rel" id = "decrel" style="width: 120px" >
                        <option value="${decrel}">${decrel}</option>
                        <option value="Main Member">Main Member</option>
                        <option value="Dependant">Dependant</option>
                        <option value="Still Born">Still Born</option>                    
                    </select> </td>
                <td style="width:90px"> </td>
                <td> Name </td> <td> <input type="text" style="width:120px" value=${claimsur} > </td>
                <td style="width:90px"> </td>

                <td> Claim date </td> <td> <input type="text" id="claimdate" style="width:120px" value=${claimdate} > </td>
            <script>
                var myCalendar1 = new dhtmlXCalendarObject(["claimdate"]);
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
                myCalendar1.setDateFormat("%Y/%m/%d");
            </script>                
        </tr>
        <tr>
            <td> Cause death </td> <td><select name="cod" id = "cause1" style="width: 120px;" >
                    <option value="${cause1}">${cause1}</option>
                    <option value="Natural">Natural</option>
                    <option value="UnNatural">UnNatural</option>               
                </select> </td>
            <td style="width:90px"> </td>
            <td> ID Nr </td> <td><input type="text" style="width:120px;" value =${claimerid} > </td>
            <td style="width:90px"> </td>
            <td> Claim amount </td> <td><input type="text" style="width:80px" value=${claimam} > </td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="text" style="width:120px;" value= ${cause2} > </td>
            <td> </td>
            <td> Relation </td> <td> <input type="text" style="width:120px;" value=${claimrel} > </td>
            <td> </td>
            <td> Grocery </td> <td> <input type="text" style="width:80px;" value=${grocery} > </td>            
        </tr>
        <tr>
            <td> Death date </td> <td> <input type="text" id="deathdate" style="width:120px" value=${deathdate} > </td>
            <td> </td>
            <td> Cell Nr </td> <td> <input type="text" style="width:120px" value=${claimcell} > </td>
            <td> </td>
            <td> Claim tipe </td> <td><select name="claimtipe" id = "claimtipe" style="width: 120px;" >
                    <option value="${claimtipe}">${claimtipe}</option>
                    <option value="Cash">Cash</option>
                    <option value="Funeral">Funeral</option>               
                </select> </td>
        <script>
            var myCalendar1 = new dhtmlXCalendarObject(["deathdate"]);
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
            myCalendar1.setDateFormat("%Y/%m/%d");
        </script>                
    </tr>
    <tr>
        <td> Bank name </td> <td> <input type="text" style="width:120px;" value=${bankname} > </td>
        <td> </td>
        <td> Address 1 </td> <td> <input type="text" style="width:120px;" value=${address1} > </td>
        <td> </td>
        <td> Funeral amount </td> <td> <input type="text" style="width:120px;" value=${funam} > </td>
    </tr>
    <tr>
        <td> Branch nr </td> <td> <input type="text" style="width:120px;" value=${branchnr} > </td>
        <td> </td>
        <td> Address 2 </td> <td><input type="text" style="width:120px;" value=${address2} > </td>
        <td> </td>
        <td>Deceased age</td> <td> <input type="text" style="width:80px" value=${decage} > </td>        
    </tr>   
    <tr>
        <td> Account Type </td> <td> <input type="text" style="width:120px;" value=${acctype} > </td>
        <td></td>
        <td> Address 3 </td> <td> <input type="text" style="width:120px;" value=${address3} > </td>
        <td></td>  
        <td> Policy Duration </td> <td> <input type="text" style ="width:120px" value=${poldur} > </td>
    </tr>
    <tr>
        <td> Acc name </td> <td> <input type="text" style="width:120px;" value=${accname} > </td>
        <td> </td>
        <td> Approved </td> <td><input type="text" id="appdate1" style="width:120px" value=${appdate} > </td>
        <td></td>
        <td> Status </td> <td> <input type="text" style="width:120px" value =${status} > </td>       
    </tr>
    <script>
        var myCalendar1 = new dhtmlXCalendarObject(["appdate1"]);
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
        myCalendar1.setDateFormat("%Y/%m/%d");
    </script>      
    <tr>
        <td>Account nr </td> <td> <input type="text" style="width:120px;" value=${accnr} > </td>
        <td> </td>
        <td> Effective </td> <td> <input type="text" id="effdate1" style="width:120px;" value=${effdate} > </td>
        <td></td>
        <td> Status date </td> <td> <input type="text" style="width:120px;" id ="statdate" value=${statusdate} > </td>
    </tr>    
    <script>
        var myCalendar1 = new dhtmlXCalendarObject(["statdate"]);
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
        myCalendar1.setDateFormat("%Y/%m/%d");
    </script>      
    <script>
        var myCalendar1 = new dhtmlXCalendarObject(["effdate1"]);
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
        myCalendar1.setDateFormat("%Y/%m/%d");
    </script>         
    <tr>
        <td></td> <td></td>
        <td></td>
        <td> Claim status 1 </td> <td> <select name="claimstat1" id = "claims1" style="margin-left: 5px; width: 120px;" >
                <option value="${claimstatus1}">${claimstatus1}</option>
                <option value="Accepted">Accepted</option>
                <option value="Waiting">Waiting</option>
                <option value="Completed">Completed</option>                    
                <option value="Invalid">Invalid</option>                    
            </select> </td>
        <td> </td>
        <td> Claim status 2 </td> <td> <select name="claimstat2" id = "claims2" style="margin-left: 5px; width: 120px;" >
                <option value="${claimstatus2}">${claimstatus2}</option>
                <option value="File Closed">File Closed</option>
                <option value="Waiting Documents">Waiting Documents</option>         
            </select>
        </td>
        <td></td> 
    </tr>
    <tr>
        <td></td><td></td>
        <td></td>
        <td></td><td></td>
        <td></td>
        <td> Tombstone ir </td> <td><input type="text" style="width:120px;" value=${tombir} > </td>
    </tr>
    <tr>
        <td>Approved <input type="checkbox" id = "appclaim" value="Approved" > </td>
        <td></td>
        <td></td>
        <td>Settled <input type="checkbox" id= "settclaim" value="Claim settled" > </td>
    </tr>
    <script>
      if (${claimapp} == "Y") {
          document.getElementById("appclaim").checked = true;
      }
      if (${claimsettled} == "Y") {
          document.getElementById("settclaim").checked = true;
      }
    </script>    
</table>
<label> <textarea name="notes" id="claimnotes" style="width:600px; height: 255px;" cols="50" rows="5" >${claimnotes}</textarea> </label>     
<br>
<input type="button" value="Save" style="margin-left:100px;width:100px">
<input type="button" value="Finance" style="margin-left:100px;width:100px" >
</body>
</html>
