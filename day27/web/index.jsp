
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form name="frm_test" action="${pageContext.request.contextPath }/upload" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="userName">  <br/>
    文件：   <input type="file" name="file_img">   <br/>
    <input type="submit" value="注册">
  </form>
  </body>
</html>
