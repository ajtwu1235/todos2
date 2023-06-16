package com.playdata.todos.servlet;

import com.playdata.todos.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("views/main.html").forward(req,resp);

        String result="";

        if(UserDao.getInstance().me==null){
            result="익명님";
        }else{
            result=UserDao.getInstance().me.toString();
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>main</title>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "  <h1> "+ result+"환영합니다</h1>\n" +
                "  <img src=\"/img/ffsf_360.png\">\n" +
                "\n" +
                "</body>\n" +
                "</html>");

    }
}
