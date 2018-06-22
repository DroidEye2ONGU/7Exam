<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="Moudle.User" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/11/26
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<%
    User user;
    user = (User) ActionContext.getContext().getSession().get("user");
    if (user == null) {
%>
<script>
    alert("您未登录，将自动转到登陆页面")
</script>
<%
        response.setHeader("refresh", "0;URL=LoginPage.jsp");
    }
%>

<s:i18n name="7Exam">
    <center>
        <h1>
        登陆成功！下面是您的信息：<br></h1>
        <h2>
            <s:text name="regist.ID"/>：${user.ID}<br>
            <s:text name="regist.name"/>：${user.name}<br>
            <s:text name="regist.sex"/>:${user.sex}<br>
            <s:text name="regist.age"/>:${user.age}<br>
            <s:text name="regist.mail"/>:${user.mail}<br>
        </h2>
        <h3>
            <a href="logoff.action">注销</a>
        </h3>
    </center>
</s:i18n>
</body>
</html>
