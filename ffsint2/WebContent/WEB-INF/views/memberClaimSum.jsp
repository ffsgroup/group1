
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
    <div style="float: left">
        <h1>FFS Group</h1>        
    </div>
    <div style="float: right; padding: 5px;" >
        <!-- User store in session with attribute: loginedUser -->
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
</head>  


</div>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<body>
    <br><br>
    Member <label id="lidno">${lidno}</label>   Claim No <label id="claimno"> ${claimid} </label>   Summary  <label id="summid"> ${summid} </label>
    <br>
    <br>
    <div style="border:1px solid grey; width:300px; float:left">
        <label>Name :   ${deceased} </label> <br>
        <label>ID No :  ${decid}</label> <br>
        <label>Member Details </label> <br>
        <label>Claim Details </label> <br>
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
                    <th style="min-width:50px; width:50px;" scope="col">Document</th> 
                    <th style="min-width:200px; width:200px;" scope="col">User</th> 
                    <th style="min-width:220px; width:220px;"scope="col">Date Received</th> 
                    <th style="min-width:130px; width:130px;" scope="col">Delete</th> 
                    <th style="min-width:130px; width:130px;" scope="col">Not Needed</th>                         
                </tr>
            </thead>      
            <tbody>
            <p>${errorString}</p>
            </tbody>
        </table>
    </div>    
    <br>
    <input type ="button" value ="Sign document" id="signDoc" style="width:120px;margin-left:10px;" >
    <input type ="button" value ="Upload document" id="upDoc" style="width:120px;margin-left:10px;" >
    <input type ="button" value ="Print document" id="printDoc" style="width:120px;margin-left:10px;" >

</body>
</html>
