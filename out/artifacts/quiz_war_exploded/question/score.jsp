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
<body style="background-color: #a1a1a1;">
<div class="menu-wrapper">
  <%@include file="../includes/menu.jsp"%>


</div>
<%
  int i = (Integer)request.getAttribute("i");
  int hScore = (Integer)request.getAttribute("hScore");
  int bScore = ((Integer)request.getAttribute("bScore") == 0 ||(Integer)request.getAttribute("bScore")<i )? i : (Integer)request.getAttribute("bScore");
%>
<div style="background-image: url(image/a.jpg); height: 309px; width: 550px; margin:auto; margin-top: 25px;">
  <div style="padding-left: 210px; padding-top: 130px;">
    <p style="color: white; font-size: 30px;"> Best Score</p><br/>
    <p style="padding-left: 50px;"><span style="color: #333f4e; font-size: 50px;"><%out.println(bScore);%></span></p>
    <p style="color: white; font-size: 30px;"> High Score</p><br/>
    <p style="padding-left: 50px;"><span style="color: #333f4e; font-size: 50px;"><%out.println(hScore);%></span></p>
    <p style="color: white; font-size: 30px;"> Your Score</p><br/>
    <p style="padding-left: 50px;"><span style="color: #333f4e; font-size: 50px;"><%out.println(i);%></span></p>

</div>
  </div>
  </div>
</body>
</html>
