<%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2018-6-1
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<!-- 页面： 必须要拿到ValueStack -->

<br/>1. 取根元素的值<br/>
<s:property value="user.name"/>

<br/>2. 取非根元素的值<br/>
<s:property value="#request.cn"/>
<s:property value="#session.Session_data"/>
<s:property value="#request.request_data"/>
<s:property value="#application.Application_data"/>    <br/>

<!-- 自动找request/session/application,找到后立刻返回 -->
<s:property value="#request_data"/>
<s:property value="#attr.Session_data"/>
<s:property value="#attr.request_data"/>
<s:property value="#attr.Application_data"/>  <br/>

<!-- 获取请求的参数数据 -->
<s:property value="#parameters.userName"/>

<!-- struts的调试标签：可以观测值栈数据 -->
<s:debug></s:debug>
</body>
</html>
