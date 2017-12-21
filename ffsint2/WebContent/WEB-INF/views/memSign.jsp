<% response.setContentType("application/x-java-jnlp-file"); %>

<%@ page import="java.net.*,java.util.*"
         %>
<%
    String member = request.getParameter("member");
    String amount = request.getParameter("amount");
%>

<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<jnlp codebase="" spec="1.0+">
    <information>
        <title>MemberSignDec</title>
        <vendor>User</vendor>

        <description>MemberSignDec</description>
        <description kind="short">MemberSignDec</description>
    </information>
    <update check="always"/>
    <security>
        <all-permissions/>
    </security>
    <resources>
        <j2se version="1.8+"/>
        <jar href="http://localhost:8080/resources/MemberSignDec.jar" main="true"/>
        <jar href="http://localhost:8080/resources/pdfbox-2.0.5.jar"/>
        <jar href="http://localhost:8080/resources/wgssSTU.jar"/>
        <jar href="http://localhost:8080/resources/javax.servlet.jsp.jstl-1.2.4.jar"/>
        <jar href="http://localhost:8080/resources/javax.servlet.jsp.jstl-api-1.2.1.jar"/>
        <jar href="http://localhost:8080/resources/javax.servlet-3.0.jar"/>
    </resources>
    <application-desc main-class="MemberSignDec.MemberSignDec">
        <argument><%= member%></argument>
        <argument><%= amount%></argument>
    </application-desc>

</jnlp>