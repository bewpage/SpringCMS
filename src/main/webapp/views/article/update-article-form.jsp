<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Article</title>
</head>
<body>
<h1>Update Article</h1>
<form:form method="post" modelAttribute="article">
    <label for="title">Title</label>
    <form:input path="title" id="title"/>
    <label for="author">Author</label>
    <form:select path="author" id="author" items="${authors}" itemValue="id" itemLabel="lastName"/>
    <label for="category">Category</label>
    <form:select path="categories" id="category" items="${categories}" itemValue="id" itemLabel="name" multiple="true"/>
    <label for="content">Content</label>
    <form:textarea path="content" id="content"/>
    <input type="submit" value="Update"/>
</form:form>
</body>
</html>
