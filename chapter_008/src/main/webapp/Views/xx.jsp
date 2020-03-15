<%@ page import="ServletExample.Model.User" %>
<%@ page import="java.util.Formatter" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Scanner" %><%--
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
<a href="add">Add User</a>
<table>
    <tbody>
    <%
        String test1 = "<tr> <td>email = %s</td> <td>login = %s</td> <td>name = %s</td> <td><a href=\"update?id=%s&key=update\">Update</a></td> <td><a href=\"update?id=%s&key=delete\">Delete</a></td> </tr>";
        Formatter formatter = new Formatter();
        List<User> names = (List<User>) request.getAttribute("list");
        for (User s : names) {
            out.println(formatter.format(test1,s.getEmail(),s.getLogin(),s.getName(),s.getId(),s.getId()));
    }
    %>
    </tbody>
</table>

</body>
</html>
