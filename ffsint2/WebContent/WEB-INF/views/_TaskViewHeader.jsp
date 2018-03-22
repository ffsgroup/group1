<%-- 
    Document   : _TaskHeader
    Created on : Apr 12, 2017, 10:01:23 AM
    Author     : user149
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
  <div style="float: left">
      <h1>FFS Group   

      </h1> 

     </div>
    <div style="float: right; padding: 10px;" >
  <!-- User store in session with attribute: loginedUser -->
    <b>${loginedUser.userName}</b>
    <br>
    <script>
  document.write('<a href="' + document.referrer + '">Back</a>');
</script>
|
   <a href="${pageContext.request.contextPath}/userInfo">Home</a>
   |
   <a href="${pageContext.request.contextPath}/login">Login</a>
  </div>
     <div style="text-align: center;">
      <h2>Task Details</h2>        
     </div>
  
 
  
</div>