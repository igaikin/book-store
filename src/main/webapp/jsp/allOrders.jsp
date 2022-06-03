<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Orders</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<h2>Orders</h2>
<div class="main">
    <table>
        <tr>
            <th>Count</th>
            <th>ID</th>
            <th>Status</th>
            <th>Date/Time</th>
            <th>User</th>
            <th>Books</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${orders}" var="order" varStatus="counter">
            <tr>
                <td>${counter.count}</td>
                <td>${order.id}</td>
                <td>${order.status.name}</td>
                <td>
                    <time>${order.orderDateTime}</time>
                </td>
                <td>
                    <a href="controller?command=profile&id=${order.user.id}">${order.user.firstName} ${order.user.lastName}</a>
                </td>
                <td>
                    <c:forEach items="${order.items}" var="item">
                        ${item.value} x <a href="controller?command=book&id=${item.key.id}">${item.key.title}</a><br/>
                    </c:forEach>
                </td>
                <td>
                    $${order.totalPrice}
                </td>
            </tr>
        </c:forEach><br/>
    </table>
    </br>
    <a href="http://localhost:8090/bookstore.com/controller?command=create_order_form"> Create order </a>
    </br>
    <a href="http://localhost:8090/bookstore.com"> Back to main Page </a>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
