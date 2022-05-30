<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <td>${user.email}</td>
                <td>${user.role.name}</td>
                <td>
                    <form action="controller" method="get">
                        <input type="hidden" name="command" value="profile">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="submit" value="Details">
                    </form>
                    <form action="controller" method="get">
                        <input type="hidden" name="command" value="edit_profile_form">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="submit" value="Edit">
                    </form>
                    <form action="controller" method="post">
                        <input type="hidden" name="command" value="delete_user">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach><br/>
    </table>
    </br>
    <a href="http://localhost:8090/bookstore.com/controller?command=register_user_form"> Registration </a>
    </br>
    <a href="http://localhost:8090/bookstore.com"> Back to main Page </a>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
