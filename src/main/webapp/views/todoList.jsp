<%@ page import="com.playdata.todos.dto.TodoJoinUser" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: playdata
  Date: 2023-06-19
  Time: 오전 10:28
  To change this template use File | Settings | File Templates.
--%>


<table>
    <tr>
        <td>id</td>
        <td>content</td>
        <td>작성자</td>
        <td>작성일</td>
        <td>check</td>
    </tr>

    <%
        List<TodoJoinUser> todos =(List<TodoJoinUser>) request.getAttribute("todoList");

        for(TodoJoinUser todo:todos){%>

    <tr>
        <td><%=todo.getId()%></td>
        <td><%=todo.getContent()%></td>
         <td><%=todo.getName()%></td>
         <td><%=todo.getCreateAt()%></td>
        <%
            if(attribute.getId()==todo.getUid()){
               %>
        <td>
            <a href="/todoUpdate?todoId=<%= todo.getId()%>">수정</a>
        </td>
        <%
            }
        %>
    </tr>
            <%
        }
    %>
</table>