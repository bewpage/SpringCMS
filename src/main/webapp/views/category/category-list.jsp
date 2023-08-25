<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Category List</title>
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
<h1>Category List</h1>
<c:forEach items="${categories}" var="category">
    <p>Name: ${category.name}</p>
    <p>Description: ${category.description}</p>
    <a href="update/${category.id}">Update</a>
    <a href="remove/${category.id}">Remove</a>
</c:forEach>
<br/>
<ul class="menu">
    <li><a href="/category/add">Add Category</a></li>
    <li><a href="/">Home</a></li>
</ul>
</body>
</html>
