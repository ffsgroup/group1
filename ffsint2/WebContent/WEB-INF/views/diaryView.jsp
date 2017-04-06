<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
<jsp:include page="_calendar.jsp"></jsp:include> 

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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
    
$(document).ready( function() {
    $('#countrytable').click( function(event) {
      var target = $(event.target);
      $td = target.closest('td');
    //  document.getElementById("diaryid").innerHTML = "1";
    //  $td.html(parseInt($td.html())+1);
      var col   = $td.index();
      var row   = $td.closest('tr').index();
      document.getElementById("diaryid").innerHTML = document.getElementById("countrytable").rows[row].cells[3].innerHTML;
    //  $('#debug').prepend('<div class="debugLine">Cell at position (' + [col,row].join(',') + ') clicked!</div>' );
               $.get('DiaryDetail(document.getElementById("countrytable").rows[row].cells[1].innerHTML'),function(responseJson) {
        	   if(responseJson!=null){
                         document.getElementById("diarysumm").innerHTML = value['tranid'];
	              //         rowNew.children().eq(0).text(value['tranid']); 
	               //        rowNew.children().eq(1).text(value['user']); 
	           //            rowNew.children().eq(2).text(value['desc1']); 
	          //             rowNew.children().eq(3).text(value['desc1']); 
	       //                rowNew.children().eq(4).text(value['desc1']); 
	     //                  rowNew.children().eq(5).text(value['desc1']); 
	    //                   rowNew.appendTo(table1);
                }
            }  
    });
  });

$(document).ready(function() {
//	$("#tablediv").hide();
     $("#showTable").click(function(event){
           $.get('DiaryDay',function(responseJson) {
        	   if(responseJson!=null){
            	   $("#countrytable").find("tr:gt(0)").remove();
            	   var table1 = $("#countrytable");
	               $.each(responseJson, function(key,value) { 
	               		   var rowNew = $("<tr><td></td><td></td><td></td><td></td></tr>");
	                       //rowNew.children().eq(0).text(value['tranid']); 
                               rowNew.children().eq(0).text(value['tranid']); 
	                       rowNew.children().eq(1).text(value['user']); 
	                       rowNew.children().eq(2).text(value['desc1']); 
	                       rowNew.children().eq(3).text(value['tranid']); 
	                       
	                       
	                       rowNew.appendTo(table1);
                              
                             
	               });
                  document.getElementsById("countrytable")[0].style.width = '20px';
                }
            });
        //    $("#tablediv").show();          
	 });      
});
</script>
</head>
<body class="container">


<div id="tablediv">
   
<table cellspacing="0" id="countrytable" margin-right:20px style="float: left; border-collapse: collapse;"> 
   
    <tr> 
        <th style="width:10%" scope="col">Time</th> 
        <th style="width:31%" scope="col">User</th> 
        <th style="width:51%" scope="col">Description</th> 
        <th style="width:8%" scope="col">ID</th> 
    </tr> 
    
</table>
</div>

 <form style="width:25%; height:400px; margin-left:70%">
  <fieldset>
    <legend>Diary Details:</legend>
    From 
     <div style="float: right; text-align: right;">
       ID :  <label id="diaryid">0</label>
      </div>    
      <br/>
    Summary: <input type="text" id="diarysumm"><br>
    Start Date: <input type="text"><br>
    End Date: <input type="text">
  </fieldset>
</form> 



</body>
<input type="button" value="Show Table" id="showTable"/>
<br/>
<br/>
    <jsp:include page="_footer.jsp"></jsp:include>
</html>