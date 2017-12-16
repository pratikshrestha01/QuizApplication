package controller.user;

import domains.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;


import java.util.Map;


/**
 * Created by user on 8/23/2016.
 */
public class SessionCreator extends HttpServlet {

    public Cookie csstter(HttpServletRequest request, HttpServletResponse response, String role, int uid) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("id",uid);

        session.setAttribute("user", (request.getParameter("username")));
        session.setAttribute("role", role);
        session.setAttribute("marks", 0);
        //setting session to expiry in 30 mins
        session.setMaxInactiveInterval(30*60);


        Cookie loginCookie = new Cookie("user",(request.getParameter("username")));

        loginCookie.setMaxAge(30*600);
       /* response.addCookie(loginCookie);
        response.sendRedirect("main.jsp");*/

        return loginCookie;

    }


    public Map userchecker(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String user = null;
        String role =null;
        if(session.getAttribute("user") == null){
            response.sendRedirect("index.jsp");
        }else user = (String) session.getAttribute("user"); role =(String) session.getAttribute("role");
        String userName = null;
        String sessionID = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")) userName = cookie.getValue();


                if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
            }
        }else{
            sessionID = session.getId();
        }
        Map map = new HashMap();
        map.put("name", userName);
        map.put("role", role);

        return map;
    }

    public void forLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String user = null;
        if(session.getAttribute("user") != null){

            response.sendRedirect("/home?page=home");
        }
    }

    public void forLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("JSESSIONID")){

                }
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        //invalidate the session if exists
        HttpSession session = request.getSession(false);

        if(session != null){
            session.invalidate();
        }
        //no encoding because we have invalidated the session
        response.sendRedirect("index.jsp");
    }
}
