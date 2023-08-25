<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
<h1>Add Category</h1>
<form:form method="post" modelAttribute="category">
    <label for="name">Name</label>
    <form:input path="name" id="name"/>
    <label for="description">Description</label>
    <form:input path="description" id="description"/>
    <label for="articles">Articles</label>
    <form:select path="articles" id="articles" multiple="true" items="${articles}" itemValue="id" itemLabel="title"/>
    <input type="submit" value="Add"/>
</form:form>
<br/>
<a href="/category/list">Category list</a>
<a href="/">Home</a>
</body>
</html>
