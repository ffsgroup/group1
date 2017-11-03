
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
        <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <script>
            $(document).ready(function () {
                $("#claimDetail").click(function (event) {
                    var target = $(event.target);
                    window.location = "MemberClaimDetails.jsp?claim=" + encodeURIComponent(document.getElementById("claimno").innerHTML);
                });
            });

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
            <h2>Claim Summary</h2>       
        </div>
        <title>Claim Summary</title>
    </div>    
    <br><br>
    Member <label id="lidno">${lidno}</label>   Claim No <label id="claimno"> ${claimid} </label>   Summary  <label id="summid"> ${summid} </label>
    <br>
    <br>
    <div style="border:1px solid grey; width:300px; float:left">
        <label>Name :   ${deceased} </label> <br>
        <label>ID No :  ${decid}</label> <br>
        <input type="button" style="width:120px;" id="memDetail" value="Member Details" > <br>
        <input type="button" style="width:120px;" id="claimDetail" value="Claim Details" > <br>
        <label id="fundone"> Funeral arrangements not done </label>
        <br>
    </div>  

    <div style="border:1px solid grey; width:300px; float:left; margin-left:80px">
        <label style="font-weight:bold">Tasks</label>
        <br>
        <label> Enquiry Task : ${taskenq}</label><br>
        <label> Claim Task : ${taskclaim}</label><br>
        <label> Payment Method Task : ${taskpay}</label><br>
        <br>
    </div>
    <br>
    <br><br><br><br><br>
    <label style ="float:left; margin-left:10px"> Documents</label> <br>

    <div id="tablediv">  
        <table cellspacing="0" id="claimdoc" margin-right:20px style="position:relative;height:320px;border:1px solid grey;" > 
            <thead>
                <tr> 
                    <th style="min-width:180px; width:180px;border-collapse:collapse; border:1px solid grey" scope="col">Document</th> 
                    <th style="min-width:160px; width:160px;border-collapse:collapse; border:1px solid grey" scope="col">User</th> 
                    <th style="min-width:160px; width:160px;border-collapse:collapse; border:1px solid grey"scope="col">Date Received</th> 
                    <th style="min-width:95px; width:95px;border-collapse:collapse; border:1px solid grey" scope="col">Delete</th> 
                    <th style="min-width:95px; width:95px;border-collapse:collapse; border:1px solid grey" scope="col">Not Needed</th>                         
                </tr>
            </thead>      
            <tbody>
            <p>${docs}</p>
            </tbody>
        </table>
    </div>    
    <br>
    <input type ="button" value ="Sign document" id="signDoc" style="width:120px;margin-left:10px;" >
    <input type ="button" value ="Upload document" id="upDoc" style="width:120px;margin-left:10px;" >
    <input type ="button" value ="Print document" id="printDoc" style="width:120px;margin-left:10px;" >

</body>
</html>
