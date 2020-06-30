<!DOCTYPE html>
<html lang="en">
<head>
    <title>Upload</title>
    <jsp:include page="Parts/HeadPart.jsp" />
</head>
<body>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>URL</th>
            <th>View</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${images}" var="image" varStatus="status">
            <tr valign="top">
                <td><a href="${pageContext.servletContext.contextPath}/download?name=${image}">Download</a></td>
                <td>
                    <img src="${pageContext.servletContext.contextPath}/download?name=${image}" width="100px" height="100px"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h2>Upload image</h2>
    <form action="<%=request.getContextPath()%>/upload" method="post" enctype="multipart/form-data">
        <div class="checkbox">
            <input type="file" name="file">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

</body>
</html>