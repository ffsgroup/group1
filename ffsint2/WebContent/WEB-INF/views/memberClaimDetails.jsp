
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Claim details</title>
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
       Member <label id="lidno">${lidno}</label>   Claim No <label id="claimno"> ${claimid} </label>   Summary  <label id="summid"> ${summid} </label> <br>
       
       <label style="margin-left:10px"> Deceased </label> <label style="margin-left:250px"> Beneficiary </label> 
       <br> 
       Names <input style="margin-left:10px;" type="text" id="decname" style="width:123px;" value=${ini}>  
       <label style="margin-left:100px"> Name </label> <input style="margin-left:10px;" type="text" id="benname" style="width:120px;" value=${benname} >
       <label style="margin-left:150px"> TombStone Nr </label>        
                <select name="tomb" id = "stoneNr" style="margin-left: 5px; width: 180px" >
                    <option value="${tombnr}">${tombnr}</option>
                    <option value="None">None</option>
                    <option value="003">003</option>
                    <option value="046">046</option>                    
                </select>             
       <br>
       Surname <input type="text" id="decname" style="width:120px;" value=${sur} >  
       <label style=margin-left:100px;"> ID Nr </label>
       <input type="text" style="width:120px;" value=${benid} >
       <label style="margin-left:200px; width:120px"> Policy Type </label> 
       <input type="text" style="width:120px;" value=${poltype} >
       <br> 
       
    </body>
</html>
