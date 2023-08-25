<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Category</title>
</head>
<body>
<h1>Update Category</h1>
<form:form method="post" modelAttribute="category">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td>Name</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><form:input path="description"/></td>
        </tr>
        <tr>
            <td>Articles</td>
            <td>
                <form:select path="articles" multiple="true" items="${articles}" itemValue="id" itemLabel="title"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Update"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
