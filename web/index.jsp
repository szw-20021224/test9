<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/4/22
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>keyword</title>
  </head>
  <body>
  <table border="1">
    <tr>
      <td colspan="6">添加</td>
    </tr>
    <c:forEach  var="keyword" items="${keywordList}" varStatus="status">
    <tr>
      <td width="200">${keyword.id}</td>
      <td width="200">${keyword.name}</td>
      <td width="200">${keyword.type}</td>
      <td width="200">${keyword.createDate}</td>
      <td width="200"><a href="TestServlet?opr=getById&id=${keyword.id}">修改</a></td>
      <td width="200"><a href="TestServlet?opr=delete&id=${keyword.id}">删除</a></td>
    </tr>
    </c:forEach>
  </body>
</html>
