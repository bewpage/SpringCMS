<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Author removal Confirmation</title>
</head>
<body>
<h1>Confirm</h1>
<a href="/author/remove/${authorId}/confirmed">Remove</a>
<a href="${pageContext.request.contextPath}/author/list">Cancel</a>
</body>
</html>
