<%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2018-5-29
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login.action" name="frmLogin" method="post">
    用户名： <input type="text" value="11" name="person.name">
    密码：  <input type="text" value="11" name="person.pwd">
            <input type="submit" value="注册">
</form>
</body>
</html>
