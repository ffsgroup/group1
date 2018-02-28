<%-- 
    Document   : _TaskHeader
    Created on : Apr 12, 2017, 10:01:23 AM
    Author     : user149
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="resources/button.css"/>
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
        <h2>Members</h2>        
    </div>


</div>

<div>
    <br> <br>
    <label style = "font-size: 20"> Member </label> 
    <label style = "font-size: 20" id="memno"> ${member} </label> 
    <label style = "font-size: 20"> Additional Policies </label> 
    <br>
    <br>
    <table>
        <tr>
            <td>Additional Policy 1</td> <td> <input type ="text" id="pol1" width ="15" style="margin-left:10px" value=${pol1} > </td>            
        </tr>
        <tr>
            <td>Additional Policy 2</td> <td> <input type ="text" id="pol2" width ="15" style="margin-left:10px" value=${pol2} > </td>            
        </tr>
        <tr>
            <td>Additional Policy 3</td> <td> <input type ="text" id="pol3" width ="15" style="margin-left:10px" value=${pol3} > </td>            
        </tr>
        <tr>
            <td>Additional Policy 4</td> <td> <input type ="text" id="pol4" width ="15" style="margin-left:10px" value=${pol4} > </td>            
        </tr>
        <tr>
            <td>Additional Policy 5</td> <td> <input type ="text" id="pol5" width ="15" style="margin-left:10px" value=${pol5} > </td>            
        </tr>
        <tr>
            <td>Additional Policy 6</td> <td> <input type ="text" id="pol6" width ="15" style="margin-left:10px" value=${pol6} > </td>            
        </tr>
        <tr>
            <td>Additional Policy 7</td> <td> <input type ="text" id="pol7" width ="15" style="margin-left:10px" value=${pol7} > </td>            
        </tr>
        <tr>
            <td>Additional Policy 8</td> <td> <input type ="text" id="pol8" width ="15" style="margin-left:10px" value=${pol8} > </td>            
        </tr>
        <tr>
            <td>Additional Policy 9</td> <td> <input type ="text" id="pol9" width ="15" style="margin-left:10px" value=${pol9} > </td>            
        </tr>            
        <tr>
            <td>Additional Policy 10</td> <td> <input type ="text" id="pol10" width ="15" style="margin-left:10px" value=${pol10} > </td>            
        </tr>        

    </table>
    <br>
    <input type ="button" value="Update" >

</div>    