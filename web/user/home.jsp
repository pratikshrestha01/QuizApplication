<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>TMPH00043</title>
    <link href="css/styles.css" rel="stylesheet" type="text/css" />
    <style>body {
        background-color: #a1a1a1;
        width: 100%;
        height: 100%;
        background: url(http://subtlepatterns.com/patterns/sativa.png) repeat fixed;
        font-family: 'Open Sans', sans-serif;
        font-weight: 200;
    }</style>
</head>
<body>
<%@ page import="controller.user.SessionCreator" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%

    SessionCreator str= new SessionCreator();
    Map uname=str.userchecker(request,response);

   /* Iterator it = uname.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        System.out.println(pair.getKey() + " = " + pair.getValue());
        it.remove(); // avoids a ConcurrentModificationException
    }*/

%>
<div class="menu-wrapper" style="margin-top: 180px; margin-left:500px;">
    <%@include file="../includes/menu.jsp"%>

</div>
<div class="content">








</div>


</body>
</html>
