<%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2018-6-6
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<table align="center" border="1">
<tr>
    <td>序号号</td>
    <td>编号</td>
    <td>用户名</td>
    <td>密码</td>
</tr>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <s:iterator var="user" value="#request.list" status="st">
        <tr>
            <td><s:property value="#st.count"></s:property></td>
            <td><s:property value="#user.id"></s:property></td>
            <td><s:property value="#user.username"></s:property></td>
            <td><s:property value="#user.pwd"></s:property></td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
