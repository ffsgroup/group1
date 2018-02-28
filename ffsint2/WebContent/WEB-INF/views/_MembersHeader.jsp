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
         <div class="dropdown">
  <button onclick="myFunction()" class="dropbtn">Menu </button>
  <div id="myDropdown" class="dropdown-content">
    <a href="#">Additionals</a>
    <a href="#">Branch New</a>
    <a href="#">Claims</a>
    <a href="#">Document Request</a>
    <a href="#">Membership Card</a>
    <a href="#">New</a>
    <a href="#">Post Lookup</a>
  </div>
</div>
        <a href="${pageContext.request.contextPath}/userInfo">Home</a>
        |
        <a href="${pageContext.request.contextPath}/login">Login</a>
    </div>
    <div style="text-align: center;">
        <h2>Members</h2>        
    </div>

    <script>
     function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}  

window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
    </script>    

</div>