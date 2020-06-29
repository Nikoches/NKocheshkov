
<html>
<head>
    <jsp:include page="Parts/HeadPart.jsp" />
    <title>Creation Form</title>
</head>
<body vlink="#FF9428">

<form name="loginForm" method="post" action="<%=request.getContextPath()%>/add" enctype="multipart/form-data">
    <p>  </p>
    Username: <input type="text" name="name"/> <br/>
    <p>  </p>
    Login: <input type="text" name="login"/> <br/>
    <p>  </p>
    Email: <input type="text" name="email"/> <br/>
    <p>  </p>
    Password: <input type="password" name="password"/> <br/>
    <p>  </p>
    <select name="role">
        <option value="1">Administrator</option>
        <option value="2">User</option>
    </select>
    <p>  </p>
    <br><br>
        <div class="checkbox">
            <input type="file" name="file">
        </div>
    <p>  </p>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>