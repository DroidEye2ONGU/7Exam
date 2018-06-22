<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %><%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/11/26
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<script>
    function Back() {
        var sy_loginForm = document.getElementById("registForm");
        sy_loginForm.action = "LoginPage.jsp";
        sy_loginForm.submit();
    }
</script>
<%
    if (ActionContext.getContext().getSession().get("user") != null) {
%>
<script>
    alert("您已经登陆，将自动转入登录页面")
</script>
<%
        response.setHeader("refresh", "0;URL=WelcomePage.jsp");
    }
%>
<body>
<center>
    <font color="red"><s:fielderror fieldName="AddNewUserWrong"/></font>
    <h1>
        请注册
    </h1>
    <h1>
    <s:form action="regist" method="POST" id="registForm">
        <s:textfield key="regist.ID" name="user.ID"/>
        <s:password key="regist.pass" name="user.pass"/>
        <s:textfield key="regist.name" name="user.name"/>
        <s:textfield key="regist.age" name="age"/>
        <s:select list="#{'男':'男','女':'女'}" key="regist.sex" name="user.sex" listKey="key" listValue="value" value="男"/>
        <s:textfield key="regist.mail" name="user.mail"/>
        <s:submit key="regist.submit"/>
        <s:submit key="regist.back" onclick="Back()"/>
    </s:form>
    </h1>
</center>
</body>
</html>
