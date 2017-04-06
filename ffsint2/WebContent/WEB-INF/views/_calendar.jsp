<script language="JavaScript">

//Form button calendar (author unknown)
//For this script and more
//Visit http://javascriptkit.com

function setDate(str) {

 if (str == "   ") {
  return;
 }

 mnth1 = document.forms[0].month.value;
 mnth = mnth1;
 mnth++;
 year = document.forms[0].year.value;
 dateStr = mnth+"/"+str+"/"+year;

 dateStr = trim(dateStr);
 
 document.forms[1].dateField.value = dateStr;


}//setDate()

/**
 * The function removes spaces from the selected date.
 */

function trim(str) {

 res="";

 for(var i=0; i< str.length; i++) {
   if (str.charAt(i) != " ") {
     res +=str.charAt(i);
  }
 }
   
 return res;

}//trim()
 
/**
 * The method to get the Month name given the Month number of the year.
 */

function getMonthName(mnth) {

 if (mnth == 0) {
  name = "January";
 }else if(mnth==1) {
  name = "February";
 }else if(mnth==2) {
  name = "March";
 }else if(mnth==3) {
  name = "April";
 }else if(mnth==4) {
  name = "May";
 } else if(mnth==5) {
  name = "June";
 } else if(mnth==6) {
  name = "July";
 } else if(mnth==7) {
  name = "August";
 } else if(mnth==8) {
  name = "September";
 } else if(mnth==9) {
  name = "October";
 } else if(mnth==10) {
  name = "November";
 } else if(mnth==11) {
  name = "December";
 }

 return name;

}//getMonthName()

/**
 * Get the number of days in the month based on the year.
 */

function getNoOfDaysInMnth(mnth,yr) {
 
 rem = yr % 4;

 if(rem ==0) {
   leap = 1;
 } else {
  leap = 0;
 }

 noDays=0;

 if ( (mnth == 1) || (mnth == 3) || (mnth == 5) ||
      (mnth == 7) || (mnth == 8) || (mnth == 10) ||
      (mnth == 12)) {
  noDays=31;
 } else if (mnth == 2) {
           noDays=28+leap;
        } else {
           noDays=30;
 }

 //alert(noDays);
 return noDays;
 
      
}//getNoOfDaysInMnth()
  
/**
 * The function to reset the date values in the buttons of the 
 * slots.
 */

function fillDates(dayOfWeek1,noOfDaysInmnth) {

 for(var i=1; i<43; i++) {
   str = "s"+i;
   document.forms[0].elements[str].value="   ";
 }


 startSlotIndx = dayOfWeek1;
 slotIndx = startSlotIndx;

 for(var i=1; i<(noOfDaysInmnth+1); i++) {
  slotName = "s"+slotIndx;

  val="";
  if (i<10) {
    val = " "+i+" ";
  } else {
    val = i;
  }

  document.forms[0].elements[slotName].value = val;
  slotIndx++;
 }
  
}//fillDates()
 

/**
 * The function that is called at the time of loading the page.
 * This function displays Today's date and also displays the 
 * the calendar of the current month.
 */

function thisMonth() {

  dt = new Date();
  mnth  = dt.getMonth(); /* 0-11*/
  dayOfMnth = dt.getDate(); /* 1-31*/
  dayOfWeek = dt.getDay(); /*0-6*/
  yr = dt.getFullYear(); /*4-digit year*/

  //alert("month:"+(mnth+1)+":dayofMnth:"+dayOfMnth+":dayofweek:"+dayOfWeek+":year:"+yr);

  mnthName = getMonthName(mnth)+ " ";
  document.forms[0].month.value = mnth;
  document.forms[0].year.value = yr;
  document.forms[0].currMonth.value = mnth;
  document.forms[0].currYear.value = yr;
  
  document.forms[0].monthYear.value = mnthName+yr;
  document.forms[1].dateField.value = (mnth+1)+"/"+dayOfMnth+"/"+yr;

  startStr = (mnth+1)+"/1/"+yr;
  dt1 = new Date(startStr);
  dayOfWeek1 = dt1.getDay(); /*0-6*/

  noOfDaysInMnth = getNoOfDaysInMnth(mnth+1,yr);
  fillDates(dayOfWeek1+1,noOfDaysInMnth);
 

}//thisMonth()

/**
 * The function that will be used to display the calendar of the next month.
 */

function nextMonth() {

 var currMnth = document.forms[0].month.value;
 currYr = document.forms[0].year.value;

 if (currMnth == "11") {
    nextMnth = 0;
    nextYr = currYr;
    nextYr++;
 } else {
   nextMnth=currMnth;
   nextMnth++;
   nextYr = currYr;
 }

 mnthName = getMonthName(nextMnth);
 document.forms[0].month.value=nextMnth;
 document.forms[0].year.value=nextYr;
 document.forms[0].monthYear.value= mnthName+" "+nextYr;

 str = (nextMnth+1)+"/1/"+nextYr;
 dt = new Date(str);
 dayOfWeek = dt.getDay();

 noOfDays = getNoOfDaysInMnth(nextMnth+1,nextYr);

 fillDates(dayOfWeek+1,noOfDays);
 

}//nextMonth()

/**
 * The method to display the calendar of the previous month.
 */

function prevMonth() {

 var currMnth = document.forms[0].month.value;
 currYr = document.forms[0].year.value;

 if (currMnth == "0") {
    prevMnth = 11;
    prevYr = currYr;
    prevYr--;
 } else {
   prevMnth=currMnth;
   prevMnth--;
   prevYr = currYr;
 }

 str = (prevMnth+1)+"/1/"+prevYr;
 dt = new Date(str);
 dayOfWeek = dt.getDay();

 /***********************************************
  * Remove the comment if do not want the user to 
  * go to any previous month than this current month.
  ***********************************************/

 /*

 runningMonth = document.forms[0].currMonth.value;
 rMonth=runningMonth;
 rMonth++;
 runningYear = document.forms[0].currYear.value;
 rYear=runningYear;

 str = (rMonth)+"/1/"+rYear;
 dt1 = new Date(str);
 
 if (dt.valueOf() < dt1.valueOf()) {
   alert('Cannot Go Before Current Month');
   return;
 }
 
 */

 /**************************************************
 * End of comment
 **************************************************/

 mnthName = getMonthName(prevMnth);
 document.forms[0].month.value=prevMnth;
 document.forms[0].year.value=prevYr;
 document.forms[0].monthYear.value= mnthName+" "+prevYr;

 noOfDays = getNoOfDaysInMnth(prevMnth+1,prevYr);
 fillDates(dayOfWeek+1,noOfDays);
 
}//prevMonth()

</script>
</head>


<body onload="thisMonth()">
<table border=1 bgcolor="#d3dce2" align=left>
<tr>
<td>
<form method="post">
    <!-- Hidden fields --->

    <input type=hidden name=month value="">
    <input type=hidden name=year value="">
    <input type=hidden name=currMonth value="">
    <input type=hidden name=currYear value="">

 
    <!-- End of Hidden fields --->

    <p>
     <input type="button" name="prev" onclick="prevMonth()" 
     value="<<">
     <input type="text" size="15" name="monthYear" 
     value="">
     <input type="button" name="next" onclick="nextMonth()" value=">>">
   </p>
    
    <table bgcolor="#D4D4D4" align=center border="1" cellpadding="0" cellspacing="0" 
    width="150">
        <!--  <tr bgcolor="#10A0A0"> --> 
         <tr bgcolor="#b1dcf9">
            <td width="14%"><strong>SUN</strong></td>
            <td width="14%"><strong>MON</strong></td>
            <td width="14%"><strong>TUE</strong></td>
            <td width="14%"><strong>WED</strong></td>
            <td width="14%"><strong>THU</strong></td>
            <td width="15%"><strong>FRI</strong></td>
            <td width="15%"><strong>SAT</strong></td>
        </tr>
        <tr>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
	    name="s1" value=" 1 "></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s2" value=" 2 "></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s3" value=" 3 "></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s4" value=" 4 "></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s5" value=" 5 "></td>
            <td align="center" width="15%"><input type="button"
            onclick="setDate(this.value);"
            name="s6" value=" 6 "></td>
            <td align="center" width="15%"><input type="button"
            onclick="setDate(this.value);"
            name="s7" value=" 7 "></td>
        </tr>
        <tr>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s8" value=" 8 "></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s9" value=" 9 "></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s10" value="10"></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s11" value="11"></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s12" value="12"></td>
            <td align="center" width="15%"><input type="button"
            onclick="setDate(this.value);"
            name="s13" value="13"></td>
            <td align="center" width="15%"><input type="button"
            onclick="setDate(this.value);"
            name="s14" value="14"></td>
        </tr>
        <tr>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s15" value="15"></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s16" value="16"></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s17" value="17"></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s18" value="18"></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s19" value="19"></td>
            <td align="center" width="15%"><input type="button"
            onclick="setDate(this.value);"
            name="s20" value="20"></td>
            <td align="center" width="15%"><input type="button"
            onclick="setDate(this.value);"
            name="s21" value="21"></td>
        </tr>
        <tr>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s22" value="22"></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s23" value="23"></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s24" value="24"></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s25" value="25"></td>
            <td align="center" width="14%"><input type="button"
            onclick="setDate(this.value);"
            name="s26" value="26"></td>
            <td align="center" width="15%"><input type="button"
            onclick="setDate(this.value);"
            name="s27" value="27"></td>
            <td align="center" width="15%"><input type="button"
            onclick="setDate(this.value);"
            name="s28" value="28"></td>
        </tr>
        <tr>
            <td align="center"><input type="button" name="s29"
            onclick="setDate(this.value);"
            value="29"></td>
            <td align="center"><input type="button" name="s30"
            onclick="setDate(this.value);"
            value="30"></td>
            <td align="center"><input type="button" name="s31"
            onclick="setDate(this.value);"
            value="   "></td>
            <td align="center"><input type="button" name="s32"
            onclick="setDate(this.value);"
            value="   "></td>
            <td align="center"><input type="button" name="s33"
            onclick="setDate(this.value);"
            value="   "></td>
            <td align="center"><input type="button" name="s34"
            onclick="setDate(this.value);"
            value="   "></td>
            <td align="center"><input type="button" name="s35"
            onclick="setDate(this.value);"
            value="   "></td>
        </tr>
        <tr>
            <td align="center"><input type="button" name="s36"
            onclick="setDate(this.value);"
            value="   "></td>
            <td align="center"><input type="button" name="s37"
            onclick="setDate(this.value);"
            value="   "></td>
            <td align="center"><input type="button" name="s38"
            onclick="setDate(this.value);"
            value="   "></td>
            <td align="center"><input type="button" name="s39"
            onclick="setDate(this.value);"
            value="   "></td>
            <td align="center"><input type="button" name="s40"
            onclick="setDate(this.value);"
            value="   "></td>
            <td align="center"><input type="button" name="s41"
            onclick="setDate(this.value);"
            value="   "></td>
            <td align="center"><input type="button" name="s42"
            onclick="setDate(this.value);"
            value="   "></td>
        </tr>
    </table>
</form>
 <form method="post">
  <table border=0 cellspacing=1 cellpadding=1>
  <tr>
  <td>
  <b>Selected:</b>
  </td>
  <td align=center>
  <input type=text size="12" name=dateField>
  </td>
  <tr>
  </table>
 </form>
</td>
</tr>
</table>