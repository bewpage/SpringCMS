<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Author's List</title>
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
<h1>Author's List</h1>
<c:forEach items="${authors}" var="author">
    <p>${author.firstName} ${author.lastName}</p>
    <a href="update/${author.id}">Update</a>
    <a href="remove/${author.id}">Remove</a>
    </p>
</c:forEach>
<br/>
<ul class="menu">
    <li><a href="${pageContext.request.contextPath}/author/add">Add Author</a></li>
    <li><a href="${pageContext.request.contextPath}/">Home</a></li>
</ul>
</body>
</html>
