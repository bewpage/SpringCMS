<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Author</title>
</head>
<body>
<form:form modelAttribute="author" method="post">
    <form:hidden path="id"/>
    <label for="firstName">Imię:
        <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/>
    </label>
    <label for="lastName">Nazwisko:
        <form:input path="lastName"/><form:errors path="lastName" cssClass="error"/>
    </label>
    <input type="submit">
</form:form>
</body>
</html>
