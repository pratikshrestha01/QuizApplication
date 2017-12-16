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

  <form method="post" action="QuestionService">

    <input type="hidden" name="page" value="addquestion">


    <table class="responstable">
      <tr>
        <th>Question</th><td><input type="text" name="question"></td>
      </tr>
      <tr>
        <th>Option1</th><td><input type="text" name="option1"></td>
      </tr>
      <tr>
        <th>Option2</th><td><input type="text" name="option2"></td>
      </tr>
      <tr>
        <th>Option3</th><td><input type="text" name="option3"></td>
      </tr>
      <tr>
        <th>Option4</th><td><input type="text" name="option4"></td>
      </tr>
      <tr>
        <th>Right Answer</th><td><input type="text" name="right_ans"></td>
      </tr>

      <tr>
        <td><input type="submit" value="Add Question"></td>
      </tr>

    </table>
  </form>
</div>


</body>
</html>
