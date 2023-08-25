<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Article List</title>
    <style>
        .menu {
            list-style-type: none;
            margin-top: 10px;
            padding: 0;
            overflow: hidden;
        }

        .menu li {
            display: inline-block;
        }
    </style>
</head>
<body>
<h1>Article's list</h1>
<c:forEach items="${articles}" var="article">
    <p>
        <a href="${pageContext.request.contextPath}/article/details?id=${article.id}">${article.title}</a>
        <a href="update/${article.id}">Update</a>
        <a href="remove/${article.id}">Remove</a>
    </p>
</c:forEach>
<br/>
<ul class="menu">
    <li><a href="${pageContext.request.contextPath}/article/add">Add Article</a></li>
    <li><a href="${pageContext.request.contextPath}/">Home</a></li>
</ul>
</body>
</html>
