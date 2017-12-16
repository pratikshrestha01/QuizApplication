<%@ page import="domains.user.User" %>
<%@ page import="java.util.List" %>
<%@ page import="domains.question.Question" %>
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

    <%
        List<Question> questionList = (List<Question>)request.getAttribute("questionList");
    %>
<h2><a href="questionForm?page=addQuestionform">Add New Question</a></h2>

    <table class="responstable">
        <tr>
            <th>Question</th>
            <th>Option1</th>
            <th>Option2</th>
            <th>Option3</th>
            <th>Option4</th>
            <th>Correct Ans</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>


     <%
         for (Question question : questionList) {


     %>
        <tr>
            <td><%=question.getQuestion()%></td>
            <td><%=question.getOption1()%></td>
            <td><%=question.getOption2()%></td>
            <td><%=question.getOption3()%></td>
            <td><%=question.getOption4()%></td>

            <td><%=question.getRight_ans()%></td>

            <td><a href="qedit?page=edit&id=<%=question.getId()%>"><img src="image/edit.jpg" alt="Edit" height="10px" width="20px"/></a></td>
            <td><a href="qdelete?page=delete&id=<%=question.getId()%>"><img src="image/delete.png" alt="Delete"  height="10px" width="20px"/></a></td>
        </tr>

        <%}%>
    </table>

</div>


</body>
</html>
