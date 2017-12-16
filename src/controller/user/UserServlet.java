package controller.user;

import domains.user.User;
import service.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ravi on 05/07/2016.
 */
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");



        if (page.equalsIgnoreCase("list")) {

            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request, response);
        }


        if (page.equalsIgnoreCase("adduserform")) {
            RequestDispatcher rd = request.getRequestDispatcher("user/adduserform.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("registerform")) {
            RequestDispatcher rd = request.getRequestDispatcher("user/register.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("adduser")) {

            User user = new User();

            user.setName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));

            new UserService().addUser(user);

            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request, response);


        }

        //register new users
        if (page.equalsIgnoreCase("registerUser")) {
            Boolean userCreated = false;
            request.setAttribute("error", "");
            System.out.println("regestering New user");
            UserService userService = new UserService();
            int userAvailable = userService.checkUsername(request.getParameter("username"));
            System.out.println(userAvailable);
            if(request.getParameter("username").isEmpty() || request.getParameter("password").isEmpty()){
                request.setAttribute("error", "UserName or Password cannot be empty");
            } else if(userAvailable > 0){
                request.setAttribute("error", "UserName is not available.");
            }
            else{
                User user = new User();

                user.setName(request.getParameter("username"));
                user.setPassword(request.getParameter("password"));
                user.setRole("user");

                userService.addUser(user);
                userCreated = true;
            }
            if(userCreated){
                System.out.println("User created");
                //request.setAttribute("message", "Registration successful.");
                HttpSession session = request.getSession();
                session.setAttribute("loginMessage", "Registration successful.");
                //RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                //rd.forward(request, response);
                response.sendRedirect("/");
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("user/register.jsp");
                rd.forward(request, response);
            }

        }

        if (page.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));

            new UserService().delete(id);

            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));

            User user = new UserService().getUser(id);

            request.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("user/edit.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("update")) {
            User user = new User();
            user.setId(Integer.parseInt(request.getParameter("id")));
            user.setName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));

            new UserService().update(user);

            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request, response);
        }


            if (page.equalsIgnoreCase("qlist")) {

                RequestDispatcher rd = request.getRequestDispatcher("user/question.jsp");
                rd.forward(request, response);

            }
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
