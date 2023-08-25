<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Author</title>
</head>
<body>
<h1>Add author</h1>
<form:form modelAttribute="author" method="post">
    <label for="firstName">Name:
        <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/>
    </label>
    <label for="lastName">Surname:
        <form:input path="lastName"/><form:errors path="lastName" cssClass="error"/>
    </label>
    <label for="Articles">Articles:
        <form:select path="articles" items="${articles}" itemValue="id" itemLabel="title" multiple="true"/>
    </label>
    <input type="submit">
</form:form>
</body>
</html>
