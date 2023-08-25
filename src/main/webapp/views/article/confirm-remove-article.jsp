<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Article removal Confirmation</title>
</head>
<body>
<h1>Confirm</h1>
<a href="/article/remove/${articleId}/confirmed">Remove</a>
<a href="${pageContext.request.contextPath}/article/list">Cancel</a>
</body>
</html>
