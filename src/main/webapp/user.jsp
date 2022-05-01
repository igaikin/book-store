<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Gaikin
  Date: 01.05.2022
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <link href="style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>User</h1>
<table>
    <tr>
        <th>Field</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>ID</td>
        <td>${user.id}</td>
    </tr>
    <tr>
        <td>First Name</td>
        <td>${user.firstName}</td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td>${user.lastName}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td>Role</td>
        <td>${user.role.name}</td>
    </tr>
</table>
</body>
</html>