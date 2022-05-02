<%--
  Created by IntelliJ IDEA.
  User: Gaikin
  Date: 01.05.2022
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <h1>Orders</h1>
    <nav>
        <a href="http://localhost:8090/bookstore.com/books"> Books </a>
        <a href="http://localhost:8090/bookstore.com/users"> Users </a>
    </nav>
</header>
<div class="main">
    <table>
        <tr>
            <td>Count</td>
            <td>ID</td>
            <td>Status</td>
            <td>Date/Time</td>
            <td>User</td>
            <td>Price</td>
        </tr>
        <c:forEach items="${orders}" var="order" varStatus="counter">
            <tr>
                <td>${counter.count}</td>
                <td>${order.id}</td>
                <td>${order.status.name}</td>
                <td>
                    <time>${order.orderDateTime}</time>
                </td>
                <td>ID = ${order.user.id}; ${order.user.firstName} ${order.user.lastName}</td>
                <td>$${order.totalPrice}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<footer class="footer">
    ©CopyRight Gaikin, 2022
</footer>
</body>
</html>
