<%--
  Created by IntelliJ IDEA.
  User: playdata
  Date: 2023-06-19
  Time: 오후 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form method="post" action="/todoUpdate">
  <input type="number" value="${todoId}" name="id">
  <input type="text" value="${content}" name="content">
  <input type="submit">
</form>
</body>
</html>
