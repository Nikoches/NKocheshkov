<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Table of Users</title>
    <jsp:include page="Parts/HeadPart.jsp" />
</head>
<body>
<h2>           Users:</h2>
<br>
<button onclick="location.href = 'add';" class="btn btn-default" >Add User</button>
<br>
<button onclick="location.href = 'remove';" class="btn btn-default" >Remove All</button>
<br>
<div class=="container">
    <table class="table">
    <thead>
    <tr>
        <th>Download Link</th>
        <th>Picture</th>
        <th>id</th>
        <th>email</th>
        <th>name</th>
        <th>login</th>
    </tr>
    </thead>
        <tbody>
    <c:forEach items="${list}" var = "user">
        <tr>
            <td><a href="${pageContext.servletContext.contextPath}/download?name=${user.imageName}">Download</a></td>
            <td>
                <img src="${pageContext.servletContext.contextPath}/download?name=${user.imageName}" width="100px" height="100px"/>
            </td>
        <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.login}"/></td>
        <td><a href="remove?id=${user.id}&key=delete">Delete</a></td>
        <td><a href="update?id=${user.id}&key=update">Update</a></td>
        </tr>
    </c:forEach>
        </tbody>
</table>
</div>

<br>
<form action="LogoutServlet" method="post">
   <br> <button formmethod="post" type="submit" onclick="location.href = 'LogoutServlet';" class="btn btn-primary" >Logout</button>
</form>
</body>
</html>
