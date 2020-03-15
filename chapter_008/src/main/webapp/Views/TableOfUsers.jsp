<%@ page import="ServletExample.Model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.02.2020
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table of Users</title>
</head>
<body>
<jsp:useBean id="list" class="java.util.ArrayList" scope="request"/>
<h2>Users:</h2>
<table>
    <tbody>
    <%
        List<User> names = (List<User>) request.getAttribute("list");
            for (User s : names) {
                String s1 = "<td> %s </td>";
                out.println("<tr><td>Name: " + s.getName() + "</td><td>Login: "+s.getLogin()+"</td>"+"<td>Email: "+s.getEmail()+s.getId()+"</td>"+"<a href=\"update?id=<%out.println(s.getId());%>\">Update</a>\" + "</tr> ");
    }
    %>
</tbody>
</table>

</body>
</html>
