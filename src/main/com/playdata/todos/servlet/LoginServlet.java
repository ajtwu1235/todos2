package com.playdata.todos.servlet;

import com.playdata.todos.config.History;
import com.playdata.todos.dao.UserDao;
import com.playdata.todos.dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        History.setHistory(req,resp);
        req.getRequestDispatcher("views/login.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User login = UserDao.getInstance().login(username, password);

//        Cookie cookie =new Cookie("uid",login.getId().toString());
//        Cookie cookie2 =new Cookie("uname",login.getName().toString());
//
//        resp.addCookie(cookie);
//        resp.addCookie(cookie2);
//        //유통기한 제한
//        cookie.setMaxAge(10);

        HttpSession session = req.getSession();
        session.setAttribute("uname",login.getName().toString());

        if(login==null){
            System.out.println("로그인 실패");
            resp.sendRedirect("/user");
        }else {
            System.out.println("로그인 완료");
            resp.sendRedirect("/main");
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
