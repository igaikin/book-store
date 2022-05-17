<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <h1>Users</h1>
    <nav>
        <a href="http://localhost:8090/bookstore.com/controller?command=books"> Books </a>
        <a href="http://localhost:8090/bookstore.com/controller?command=orders"> Orders </a>
    </nav>
</header>
<div class="main">
    <table>
        <tr>
            <th>Count</th>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Role</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="counter">
            <tr>
                <td>${counter.count}</td>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td><a href="controller?command=profile&id=${user.id}">${user.email}</a></td>
                <td>${user.role.name}</td>
                <td>
                    <a href="http://localhost:8090/bookstore.com/controller?command=editProfileForm&id=${user.id}">Edit</a>
                    <a href="http://localhost:8090/bookstore.com/controller?command=deleteUser&id=${User.id}">Delete</a>
                </td>
            </tr>
        </c:forEach><br/>
    </table>
    </br>
    <a href="http://localhost:8090/bookstore.com/controller?command=registerUserForm"> Registration </a>
    </br>
    <a href="http://localhost:8090/bookstore.com"> Back to main Page </a>
</div>
<footer class="footer">
    &copy;CopyRight Gaikin, 2022
</footer>
</body>
</html>
