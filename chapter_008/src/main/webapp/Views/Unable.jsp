<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26.04.2020
  Time: 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Unknown Authority</title>
    <jsp:include page="Parts/HeadPart.jsp" />
    <meta charset="US-ASCII">
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/all" method="post">
    <span style="color: red; "> "Unauthorized access rights request"</span><br>
    <input type="submit" value="get back to users">
</form>
<br>
</body>
</html>
