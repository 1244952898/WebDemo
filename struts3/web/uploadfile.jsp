<%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2018-6-4
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fileupload</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/zy/doUpload" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username">
    文件：<input type="file" name="file1">
    <input type="submit" value="提交">
</form>
</body>
</html>
