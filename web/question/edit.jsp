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

<% Question question=(Question)request.getAttribute("question"); %>

  <form method="post" action="addquestion">

    <input type="hidden" name="page" value="update">
    <input type="hidden" name="id" value="<%=question.getId()%>">
   <table class="responstable">
      <tr>
        <th>Question</th><td><input type="text" name="question" value="<%=question.getQuestion()%>"></td>
      </tr>
      <tr>
        <th>Option1</th><td><input type="text" name="option1" value="<%=question.getOption1()%>"></td>
      </tr>
      <tr>
        <th>Option2</th><td><input type="text" name="option2" value="<%=question.getOption2()%>"></td>
      </tr>
      <tr>
        <th>Option3</th><td><input type="text" name="option3" value="<%=question.getOption3()%>"></td>
      </tr>
      <tr>
        <th>Option4</th><td><input type="text" name="option4" value="<%=question.getOption4()%>"></td>
      </tr>
      <tr>
        <th>Right Answer</th><td><input type="text" name="right_ans" value="<%=question.getRight_ans()%>"></td>
      </tr>

      <tr>
        <td><input type="submit" value="Update Question"></td>
      </tr>

    </table>
  </form>
 
</div>


</body>
</html>

    