<%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2018-6-6
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin_login.action" method="post">
    用户名：<input type="text" name="admin.username">
    密 码：<input type="text" name="admin.pwd">
    <input type="submit" value="提交">
</form>
</body>
</html>
