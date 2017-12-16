<%@ page import="domains.user.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>TMPH00043</title>
    <link href="css/styles.css" rel="stylesheet" type="text/css" />
    <link href="css/table.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="menu-wrapper">
    <%@include file="../includes/menu.jsp"%>

</div>
<div class="content">

    <form method="post" action="adduser">

        <input type="hidden" name="page" value="adduser">


    <table class="responstable">
        <tr>
            <th>User Name</th><td><input type="text" name="username"></td>
        </tr>
        <tr>
            <th>Password</th><td><input type="password" name="password"></td>
        </tr>
        <tr>
            <th>Role</th><td>
                <select name="role">
                    <option value="admin">admin</option>
                    <option value="user">user</option>
                </select>
            </td>
        </tr>

        <tr>
           <td><input type="submit" value="Add User"></td>
        </tr>

    </table>
        </form>
</div>


</body>
</html>
