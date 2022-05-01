<%--
  Created by IntelliJ IDEA.
  User: Gaikin
  Date: 01.05.2022
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link href="style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>Users</h1>
<table>
    <tr>
        <td>Count</td>
        <td>ID</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Email</td>
        <td>Role</td>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="counter">
        <tr>
            <td>${counter.count}</td>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.role.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
