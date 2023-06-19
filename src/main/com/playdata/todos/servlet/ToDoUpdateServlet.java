package com.playdata.todos.servlet;

import com.playdata.todos.dao.ToDoDao;
import com.playdata.todos.dto.TodoJoinUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToDoUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getAttribute("todoId"));
        System.out.println(req.getParameter("todoId"));

        req.setAttribute("todoId",req.getParameter("todoId"));

//
//        //컨텐츠 호출
//        TodoJoinUser oldContent = ToDoDao.getInstance().findById(todoId);
//        //바꾸기전 컨텐츠 세팅
//        req.setAttribute("content",oldContent);

        req.getRequestDispatcher("/views/todoUpdate.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //웹페이지에서 받아온 컨텐츠
        String newContent = req.getParameter("content");

        //이전에 받은 컨텐츠
        int todoId = Integer.parseInt(req.getParameter("id"));


        ToDoDao.getInstance().UpdateToDo(newContent,todoId);

    }
}
