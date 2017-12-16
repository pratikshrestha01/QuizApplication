<%@ page import="domains.user.User" %>
<%@ page import="java.util.List" %>
<%@ page import="domains.question.Question" %>
<!DOCTYPE html PUBLIC "-//W3C//Dth XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/Dth/xhtml1-transitional.dth">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>TMPH00043</title>
    <link href="css/styles.css" rel="stylesheet" type="text/css" />
    <link href="css/table.css" rel="stylesheet" type="text/css" />
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



    <%
        Question question = (Question)request.getAttribute("question");
    %>
    <table class="responstable quiz">
        <tr>
            <th colspan="2"><%=question.getQuestion()%></th>
        </tr>

        <tr>
            <th><a href="qsubmit?page=qsubmit&value=<%=question.getOption1()%>&id=<%=question.getId()%>"><%=question.getOption1()%></a></th>
            <th><a href="qsubmit?page=qsubmit&value=<%=question.getOption2()%>&id=<%=question.getId()%>"><%=question.getOption2()%></a></th>
        </tr>

        <tr>
            <th><a href="qsubmit?page=qsubmit&value=<%=question.getOption3()%>&id=<%=question.getId()%>"><%=question.getOption3()%></a></th>
            <th><a href="qsubmit?page=qsubmit&value=<%=question.getOption4()%>&id=<%=question.getId()%>"><%=question.getOption4()%></a></th>
        </tr>


    </table>
</div>


</body>
</html>
