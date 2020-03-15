<%@ page import="ServletExample.Model.User" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.02.2020
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Updating User</title>
</head>
<body>
<%
    User user = (User)request.getAttribute("user");
%>
<form name="loginForm" method="post" action="update">
    Username: <input type="text" name="name" value="<%out.print(user.getName());%>"/> <br/>
    <p>  </p>
    Login: <input type="text" name="login" value="<%out.print(user.getLogin());%>"/> <br/>
    <p>  </p>
    Email: <input type="text" name="email" value="<%out.print(user.getEmail());%>"/> <br/>
    <p>  </p>
    <input type="hidden" name="id" value="<%out.print(user.getId());%>"/> <br/>
    <input type="submit" value="Update" />
    <p></p>
    <a href="all">All Users</a>
</form>
</body>
</html>
