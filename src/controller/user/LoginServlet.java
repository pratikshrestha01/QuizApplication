package controller.user;

import domains.user.User;
import service.user.UserService;
import utils.DatabaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String message = "";

        User user = null;

        try {
            user = new UserService().getUser(username, password);
            //check for username and password
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (user!=null) {


            // session start here


            SessionCreator sc= new SessionCreator();

            Cookie loginCookie= sc.csstter(request, response, user.getRole(), user.getId());
             response.addCookie(loginCookie);


            // session end here










            message = "Login Success!";
            request.setAttribute("message", message);
            request.setAttribute("user", user);

            RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
            rd.forward(request, response);


        }else{
            message = "Invalid Username or Password!!";
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("logout")) {


            SessionCreator sc= new SessionCreator();
            sc.forLogout(request,response);


        }else{
            RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
            rd.forward(request, response);
        }

    }


}
