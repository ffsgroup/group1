<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="true" %>
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
            <table id="welcome">
                <tr>
                    <td style="width:150px;">
                        <a href ="${pageContext.request.contextPath}/diary.jsp">
                        <img  style="float: left ; border-right: 100px; " alt="Diary" src="resources/cal2.jpg" width="100" height ="100">    
                    </a>
                </td>
                <td style="width:150px;">
                    <a href ="${pageContext.request.contextPath}/TaskIndex.jsp">
                        <img border="0" alt="Task" src="resources/Task4.jpg" width="100" height ="100">    
                    </a>
                </td>   
                <td style="width:150px;">
                    <a href ="${pageContext.request.contextPath}/Members.jsp">
                        <img border="0" alt="Members" src="resources/images5.jpg" width="100" height ="100">    
                    </a>
                </td>  
            </tr>  
            <tr> 
                <td>   
                    <a  href="${pageContext.request.contextPath}/diary.jsp" style="margin-left:30px">Diary</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/TaskIndex.jsp" style="margin-left:30px">Tasks</a>
                </td> 
                <td> 
                    <a href="${pageContext.request.contextPath}/Members.jsp" style="margin-left:30px">Members</a>
                </td> 
            </tr> 
            <tr></tr>
            <tr>
                <td id = "sectd">   
                    <a href ="${pageContext.request.contextPath}/Security.jsp"> 
                        <img id="secbut" style="float: left ; border-right: 100px; " src="resources/secure1.jpg" width="100" height ="100">    
                    </a>
                </td>        
            </tr>
            <tr>
                <td> 
                    <a id ="seclnk" href="${pageContext.request.contextPath}/Security.jsp" style="margin-left:30px">Security</a> 
                </td>
            </tr>
        </table>     
        <br>
        <label style ="visibility:hidden" id="temp1" > ${secureStr} </label>
        <br>

        <jsp:include page="_footer.jsp"></jsp:include>
        <script type="text/javascript">
            if (document.getElementById("temp1").innerHTML.substr(13, 1) == "1" || document.getElementById("temp1").innerHTML.substr(50, 1) == "1") {
                document.getElementById("secbut").style.visibility = "visible";
                document.getElementById("seclnk").style.visibility = "visible";
            } else {
                document.getElementById("secbut").style.visibility = "hidden";
                document.getElementById("seclnk").style.visibility = "hidden";
            }
        </script>
         
    </body>
</html>