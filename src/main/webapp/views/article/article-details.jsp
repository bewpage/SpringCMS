<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Article Detail</title>
</head>
<body>
<h1>Article Detail</h1>
<hr>
<h2>Title: ${article.title}</h2>
<p>Content: ${article.content}</p>
<p>Author: ${article.author.firstName} ${article.author.lastName}</p>
<p>Created: ${formattedCreated}</p>
<p>Updated: ${formattedUpdated}</p>
<p>Categories</p>
<ul>
    <c:forEach items="${article.categories}" var="category">
        <li>${category.name}</li>
    </c:forEach>
</ul>
<hr>
<a href="${pageContext.request.contextPath}/article/list">Back to List</a>
</body>
</html>
