<?xml version="1.0" encoding="UTF-8"?>

<jnlp spec="1.5+" codebase="" href="http://localhost:8080/resources/launch.jnlp">
    <information>
        <title>MemberSignDec</title>
        <vendor>User</vendor>
        <homepage> href=""</homepage>
        <description>MemberSignDec</description>
        <description> kind="short">MemberSignDec</description>
    </information>
    <update> check="always"</update>
    <security>
        <all-permissions/>
    </security>
    <resources>
        <j2se version="1.8+"/>
        <jar href="http://localhost:8080/resources/MemberSignDec.jar" main="true"/>
        <jar href="http://localhost:8080/resources/pdfbox-2.0.5.jar"/>
        <jar href="wgssSTU.jar"/>
        <jar href="javax.servlet.jsp.jstl-1.2.4.jar"/>
        <jar href="javax.servlet.jsp.jstl-api-1.2.1.jar"/>
        <jar href="javax.servlet-3.0.jar"/>
    </resources>
    <application-desc main-class="MemberSignDec.MemberSignDec">

    </application-desc>
</jnlp>
