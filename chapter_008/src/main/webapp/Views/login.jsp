<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="US-ASCII">
    <title>Login Page</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/LoginServlet" method="post">
    <span style="color: red; "> <c:out value="${red}"></c:out></span><br>
    <p>Credentials</p>
    Username: <input type="text" name="user">
    <br>
    Password: <input type="password" name="pwd">
    <br>
    <input type="submit" value="Login">
</form>
</body>
</html>