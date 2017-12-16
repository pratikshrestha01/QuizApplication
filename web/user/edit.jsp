<%@ page import="domains.user.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>TMPH00043</title>
    <link href="css/styles.css" rel="stylesheet" type="text/css" />
    <link href="css/table.css" rel="stylesheet" type="text/css" />
    <link href="css/background.css" rel="stylesheet"/>
    <style>body {
        width: 100%;
        height: 100%;
        background: url(http://subtlepatterns.com/patterns/sativa.png) repeat fixed;
        font-family: 'Open Sans', sans-serif;
        font-weight: 200;
    }</style>
</head>
<body>
<div class="menu-wrapper">
    <%@include file="../includes/menu.jsp"%>

</div>
<div class="content">

    <form method="post" action="adduser">

        <input type="hidden" name="page" value="update">
        <input type="hidden" name="id" value="${user.id}">


    <table class="responstable">
        <tr>
            <th>User Name</th><td><input type="text" name="username" value="${user.name}"></td>
        </tr>
        <tr>
            <th>Password</th><td><input type="text" name="password" value="${user.password}"></td>
        </tr>
        <tr>
            <th>Role</th><td><input type="text" name="role" value="${user.role}"></td>
        </tr>

        <tr>
           <td><input type="submit" value="Update User"></td>
        </tr>

    </table>
        </form>
</div>


</body>
</html>
