<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>todos Insert</title>
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>
<div>

    <%
        if(session.getAttribute("uid")==null)
            response.sendRedirect("/login");
    %>
    <h1>ToDos 입력 화면</h1>
    <form action="/todos" method="post" accept-charset="UTF-8">
        <input type = "text" name="content" placeholder="컨텐츠를 입력해주세요">
        <input type = "submit">
    </form>
</div>
</body>
</html>