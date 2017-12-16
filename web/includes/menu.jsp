<div class="menu">
    <%@ page import="controller.user.SessionCreator" %>
    <%@ page import="java.util.Map" %>
    <%@ page import="java.util.Iterator" %>
    <%



    %>

    <ul>
        <li><a href="home?page=home">Home</a></li>
            <%
                SessionCreator strs= new SessionCreator();
                Map unames=strs.userchecker(request,response);
                String role="";
                Iterator its = unames.entrySet().iterator();
                while (its.hasNext()) {
                    Map.Entry pair = (Map.Entry)its.next();
                    System.out.println(pair.getKey() + " = " + pair.getValue());
                    if(pair.getKey().toString().trim().equals("role")){
                        System.out.println("sucess");
                        role= (String) pair.getValue();
                    }
                    its.remove(); // avoids a ConcurrentModificationException
                }
                System.out.println("role p "+ role);
                if(role.equals("admin")){
            %>
        <li><a href="list?page=list" >User</a></li>
        <li><a href="qlist?page=list" >Question</a></li>
                <% } %>
        <li><a href="pquiz?page=pquiz">PlayQuiz</a></li>
         <li><a href="logout?page=logout">Logout</a></li>
    </ul>
</div>