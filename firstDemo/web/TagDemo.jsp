<%@ page import="java.util.List" %>
<%@ page import="MyServlet.zy.test.Dto.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2018-3-21
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TagDemo</title>
</head>
<body>
<c:set var="name" value="zy" scope="request"></c:set>
${requestScope.name}
<c:out value="${name}" default="abc"></c:out>
<c:out value="${names}" default="abc"></c:out>
<c:out value="${names}" default="<h3>abc</h3>" escapeXml="false"></c:out>
<c:if test="${!empty name}">
    if name=true
</c:if>
<c:if test="${empty names}" var="panduan">
    if names=true
</c:if>
<c:out value="${panduan}"></c:out>

<c:set var="scope" value="98"></c:set>
<c:choose>
    <c:when test="${scope>0&&scope<60}">
        及格
    </c:when>
    <c:when test="${scope>60&&scope<=80}">
        良
    </c:when>
    <c:otherwise>
        优
    </c:otherwise>
</c:choose>
<br/>
<%
    List<Person> list=new ArrayList();
    list.add(new Person("aaa",11));
    list.add(new Person("bbb",22));
    list.add(new Person("ccc",33));
    pageContext.setAttribute("pList",list);

    Map<Integer,Person> maps=new HashMap();
    maps.put(1,new Person("a",1));
    maps.put(2,new Person("b",2));
    maps.put(3,new Person("c",3));
    pageContext.setAttribute("m",maps);
%>
<c:forEach items="${pList}" varStatus="v" var="p">
    ${v.count}-${p.name}-${p.age}<br/>
</c:forEach>
<hr/>
<c:forEach items="${m}" var="entry">
    ${entry.key}--${entry.value.name}-${entry.value.age}<br/>
</c:forEach>

<%
String ss="aa-sds-dfsd-sdfs-阿斯顿-稍等会";
    pageContext.setAttribute("sss",ss);
%>
<c:forTokens items="${sss}" delims="-" var="s">
    ${s}
</c:forTokens>
</body>
</html>
