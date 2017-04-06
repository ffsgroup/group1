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
    <jsp:include page="_menu.jsp"></jsp:include>
     <br />
     <a href="${pageContext.request.contextPath}/diary.jsp">Diary</a>
      <!--     <jsp:include page="_calendar.jsp"></jsp:include> --> 
     <br />
 <jsp:include page="diary-test.jsp"></jsp:include>
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>