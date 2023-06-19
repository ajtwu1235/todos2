<%@ page import="com.playdata.todos.dto.User" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main</title>

</head>
<body>
    <%

    %>
  <h1> 환영합니다</h1>
  <img src="/img/ffsf_360.png">
    <br>
    <a href="/back"> 뒤로가기</a>

    <%
//        User attribute = (User) session.getAttribute("uid");
        User attribute = (User) session.getAttribute("uid");
        System.out.println(attribute);
        String user_name = (String)request.getAttribute("uname");
        if(user_name==null){
            System.out.println("아니되오");
            response.sendRedirect("/login");
        }
        for(int i=0;i<3;i++){
            %>
       <h1> ${uname} 환영합니다</h1>
       <% }
    %>

    <%@ include file="todos.jsp"%>
    <%@ include file="todoList.jsp"%>
    <%@ include file="todoSearch.jsp"%>




</body>
</html>