package com.playdata.todos.servlet;

import com.playdata.todos.config.History;
import com.playdata.todos.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("views/main.html").forward(req,resp);
        History.setHistory(req,resp);

        Cookie[] cookies = req.getCookies();
        String uid = null;
        String uname = null;
        for(Cookie c:cookies){
            if(c.getName().equals("uid")){
                uid =c.getName();
                uname=c.getValue();
            }
            if(c.getName().equals("uname")){
                uid=c.getName();
                uname= c.getValue();
            }
            System.out.println(uid);
            System.out.println(uname);
        }

        HttpSession session = req.getSession();
        Object uname1 = session.getAttribute("uname");


        String result="";

        if(UserDao.getInstance().me==null){
            result="익명님";
        }else{
            result=uname;
        }

        String back ="/back";

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
                "  <h1> "+ result+"환영합니다</h1>\n" +uname1+
                // 뒤로가기 경로
                "  <a href="+back+"> 뒤로가기</a>\n"+
                "  <img src=\"/img/ffsf_360.png\">\n" +
                "\n" +
                "</body>\n" +
                "</html>");

    }
}
