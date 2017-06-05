<%-- 
    Document   : _taskReportsHeader
    Created on : Jun 5, 2017, 12:27:17 PM
    Author     : user149
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
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
      <h2>Tasks Reports</h2>        
     </div>
  
 
  
</div>