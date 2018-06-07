<%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2018-5-31
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <form action="${pageContext.request.contextPath}/hello" method="post">
   同户名：<input type="text" name="p.name">
   密码：<input type="text" name="p.pwd">
   <input type="submit" value="提交">
 </form>
  </body>
</html>
