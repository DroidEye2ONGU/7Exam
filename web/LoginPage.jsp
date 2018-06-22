<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DroidEye
  Date: 2017/11/26
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<script>
    function Login() {
        var sy_loginForm = document.getElementById("loginForm");
        sy_loginForm.action = "RegistPage.jsp";
        sy_loginForm.submit();
    }
</script>
<%
    if (ActionContext.getContext().getSession().get("user") != null) {
%>
<script language="JavaScript">
    alert("您已经登陆，将自动转入登录页面");
</script>
<%
        response.setHeader("refresh", "0;URL=WelcomePage.jsp");
    }
%>
<body>
<center>
    <font color="red"><s:fielderror fieldName="UserWrong"/></font>
    <h1>
        <%--<s:form action="login" method="POST" id="loginForm">--%>
            <%--<s:textfield key="login.User" name="ID/>--%>
            <%--<s:password key="login.Pass" name="pass"/>--%>
            <%--<s:submit key="login.Login"/>--%>
            <%--<s:submit key="login.Regist" onclick="Login()"/>--%>
        <%--</s:form>--%>

        <s:form action="login" method="POST">
            <s:textfield key="login.User" name="ID"/>
            <s:password key="login.Pass" name="pass"/>
            <tr>
                <td colspan="2">
                    <s:submit key="login.Login" theme="simple"
                              onclick="this.form.action='login';"/>
                    <s:submit key="login.Regist" theme="simple"
                              onclick="this.form.action='RegistPage.jsp';"/>
                </td>
            </tr>

        </s:form>

    </h1>
</center>
</body>
</html>
