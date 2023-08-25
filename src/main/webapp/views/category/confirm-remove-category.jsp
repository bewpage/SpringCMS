<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Confirm Deletion</title>
</head>
<body>
<h1>Confirm action</h1>
<a href="/category/remove/${categoryId}/confirmed">Confirm</a>
<a href="${pageContext.request.contextPath}/category/list">Cancel</a>
</body>
</html>
