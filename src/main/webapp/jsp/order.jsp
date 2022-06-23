<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<h2>Order</h2>
<div class="main">
    <table>
        <tr>
            <th>Field</th>
            <th>Value</th>
        </tr>
        <tr>
            <td>ID</td>
            <td>${order.id}</td>
        </tr>
        <tr>
            <td>Status</td>
            <td>${order.status.name}</td>
        </tr>
        <tr>
            <td>Date/Time</td>
            <td>${order.orderDateTime}</td>
        </tr>
        <tr>
            <td>User</td>
            <td>ID = ${order.user.id}; Name = ${order.user.firstName} ${order.user.lastName}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>$${order.totalPrice}</td>
        </tr>
    </table>
    <c:if test="${message != null}">${message}</c:if>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>