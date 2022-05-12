<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <h1>User</h1>
</header>
<div class="main">
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
    </br>
    <a href="http://localhost:8090/bookstore.com"> Back to main Page </a>
</div>
<footer class="footer">
    &copy;CopyRight Gaikin, 2022
</footer>
</body>
</html>
