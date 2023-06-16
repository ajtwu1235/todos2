package com.playdata.todos.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class History {

    static int count=-1;
    public static void setHistory(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        String requestURI = req.getRequestURI();
        String history = "history";
        int index = 0;

        if(cookies == null) {
            resp.addCookie(new Cookie(history + index , requestURI));
            return;
        }
        int max = 0;
        for (int i  = 0; i< cookies.length; i++) {
            Cookie c = cookies[i];
            if(c.getName().contains(history)
                    && index < Integer.parseInt(
                    c.getName().replace(history,"")
            )) {
                index = Integer.parseInt(
                        c.getName().replace(history, "")
                );
                max = i;
            }
        }
        index++;
        if(!cookies[max].getValue().equals(requestURI))
        resp.addCookie(new Cookie(history + index , requestURI));
    }

    public static void back(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        count++;
        Cookie[] cookies = req.getCookies();

        Arrays.sort(cookies, new Comparator<Cookie>() {
            public int compare(Cookie a, Cookie b) {
                return b.getName().compareTo(a.getName());
            }
        });

        System.out.println("쿠키 리스트");
        for(Cookie c :cookies){
            System.out.println("쿠키:"+c.getName());
        }

        if(cookies==null){
            System.out.println("쿠키"+cookies[0].getValue().toString());
            resp.sendRedirect("/login");
        }else{
            System.out.println(cookies[0+count].getValue().toString());
            resp.sendRedirect(cookies[0+count].getValue().toString());
        }
    }

    public static void after(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        count--;

        if(count<0){
            System.out.println("명령 무시 앞으로갈게 없음");
            return;
        }

        Cookie[] cookies = req.getCookies();

        Arrays.sort(cookies, new Comparator<Cookie>() {
            public int compare(Cookie a, Cookie b) {
                return b.getName().compareTo(a.getName());
            }
        });

        System.out.println("쿠키 리스트");
        for(Cookie c :cookies){
            System.out.println("쿠키:"+c.getName());
        }

        if(cookies==null){
            System.out.println("쿠키"+cookies[0].getValue().toString());
            resp.sendRedirect("/login");
        }else{
            System.out.println(cookies[0+count].getValue().toString());
            resp.sendRedirect(cookies[0+count].getValue().toString());
        }
    }
}
