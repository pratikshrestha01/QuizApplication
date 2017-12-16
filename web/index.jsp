<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <script src="js/login.js"></script>
      <link href="css/login.css" type="text/css" rel="stylesheet">
    <title></title>
  </head>
  <body>

  <%@ page import="controller.user.SessionCreator" %>
  <%

      SessionCreator str= new SessionCreator();
      str.forLoginPage(request,response);
      String message = ((String)session.getAttribute("loginMessage") == null)? "" : (String)session.getAttribute("loginMessage");
      session.setAttribute("loginMessage", "");
  %>

  <div class="login">
      <h1>Login</h1>
      <form class="" action="login" method="post">
          <div style="color: rgb(128, 239, 128); padding: 20px 0;"><%=message %></div>
          <input type="text" placeholder="Username" name="username" required="required" />
          <input type="password" placeholder="Password" required name="password"/>
          <button type="submit" class="btn btn-primary btn-block btn-large">Login</button>
      </form>
      <span style="color:#ffffff;">Not a Member?</span></span><a href="userForm?page=registerform" class="registerlink">Register now</a>
  </div>
  </body>
</html>
