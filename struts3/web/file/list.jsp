<%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2018-6-4
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<table border="1" align="center">
<tr>
    <td>编号</td>
    <td>文件名</td>
    <td>餐桌</td>
</tr>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:forEach var="fileName" items="${fileNames}" varStatus="vs">
<tr>
    <td>${vs.count}</td>
    <td>${fileName}</td>
    <td>
        <c:url var="url" value="down_down">
            <c:param name="filename" value="${fileName}"></c:param>
        </c:url>
        <a href="${url}">下载</a>
    </td>
</tr>
    </c:forEach>
</table>
</body>
</html>
