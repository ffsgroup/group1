<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>User Info</title>
 </head>
 <body>
   
    <jsp:include page="_header.jsp"></jsp:include>
   
     <br />
     <a href ="${pageContext.request.contextPath}/diary.jsp">
      <img border="0" alt="Diary" src="resources/cal2.jpg" width="100" height ="100">    
    </a>
      <br>
     <a href="${pageContext.request.contextPath}/diary.jsp">Diary</a>
    <br>
      <a href="${pageContext.request.contextPath}/TaskIndex.jsp">Tasks</a>
     <br />
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>