<%@ page import="domains.user.User" %>
<%@ page import="java.util.List" %>
<%
  String error = ((String)request.getAttribute("error") == null)? "": (String)request.getAttribute("error");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>TMPH00043</title>
  <link href="css/login.css" type="text/css" rel="stylesheet">
</head>
<body>

<div class="login">
  <h1>Sign up</h1>
  <form class="" action="register" method="post">
    <div style="color: red; padding: 20px 0;"><%=error %></div>
    <input type="hidden" name="page" value="registerUser">
    <input type="text" placeholder="Username" name="username" required />
    <input type="password" placeholder="Password" required name="password"/>
    <button type="submit" class="btn btn-primary btn-block btn-large">Sign up</button>
  </form>
  <span style="color:#ffffff;">Already a Member?</span></span><a href="/" class="registerlink">Login</a>
</div>

</body>
</html>

