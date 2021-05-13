<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/4/22
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form method="post" action="Servlet1?opr=update">
    <input type="hidden" value="${keyword.id}" name="id">
    标题 <input type="text" value="${keyword.name}" name="name">
    作者 <input type="text" value="${keyword.type}" name="type">
    内容 <input type="text" value="${keyword.createDate}" name="createDate">
    <input type="submit" value="提交">
</form>
</body>
</html>
