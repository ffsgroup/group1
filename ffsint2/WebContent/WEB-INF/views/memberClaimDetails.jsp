
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
        Member <label id="lidno">${lidno}</label>   Claim No <label id="claimno"> ${tranid} </label>   Summary  <label id="summid"> ${summid} </label> <br>

        <table>
            <tr>
                <td style="width:80px;"> <label> Deceased </label> </td> 
                <td style="width:100px"> </td>
                <td style="width:90px"> </td>
                <td style="width:80px;"><label> Beneficiary </label></td> 
                <td style="width:100px"> </td>
                <td style="width:90px"> </td>
                <td style="width:80px"> </td>
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
                
            </tr>

        </table>

    </body>
</html>
