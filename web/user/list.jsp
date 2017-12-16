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
<%@ page import="controller.user.SessionCreator" %>
<%@ page import="java.util.Map" %>
<%

    SessionCreator str= new SessionCreator();
    Map uname=str.userchecker(request,response);


%>
<div class="menu-wrapper">
    <%@include file="../includes/menu.jsp"%>

</div>
<div class="content">

    <%
        List<User> userList = (List<User>)request.getAttribute("userList");
    %>
<h2><a href="userForm?page=adduserform">Add New User</a></h2>

    <table class="responstable">
        <tr>
            <th>Name</th>
            <th>Password</th>
            <th>Role</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

     <%
         for (User user : userList) {
     %>
        <tr>
            <td><%=user.getName()%></td>
            <td><%=user.getPassword()%></td>
            <td><%=user.getRole()%></td>
            <td><a href="edit?page=edit&id=<%=user.getId()%>"><img src="image/edit.jpg" alt="Edit" height="10px" width="20px"/></a></td>
            <td><a href="delete?page=delete&id=<%=user.getId()%>"><img src="image/delete.png" alt="Delete"  height="10px" width="20px"/></a></td>
        </tr>

        <%}%>
    </table>

</div>


</body>
</html>
