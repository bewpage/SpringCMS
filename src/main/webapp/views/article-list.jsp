<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Article's list</h1>
<c:forEach items="${lastFiveArticles}" var="article">
    <p>
        <a href="article?id=${article.id}">${article.title}</a>
    </p>
</c:forEach>
</body>
</html>
