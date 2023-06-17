package com.playdata.todos.servlet;

import com.playdata.todos.dao.ToDoDao;
import com.playdata.todos.dto.ToDos;
import com.playdata.todos.dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ToDosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/todos.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //컨텐츠 파라미터를 받음
        String content = req.getParameter("content");

        // 로그인 세션 로딩
        HttpSession session = req.getSession();
        String id = session.getId();
        System.out.println("세션 아이디:"+id);
        Object user =  session.getAttribute(id);
        System.out.println("세션 값:"+user);

        //Todos 입력
//        ToDos toDos = new ToDos(user.getId(),content,0);
//        ToDoDao.getInstance().insert(toDos);

    }
}
