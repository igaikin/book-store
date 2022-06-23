<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<h2>Cart</h2>
<div class="main">
    <table>
        <tr>
            <th>Book</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
        <c:forEach var="entry" items="${requestScope.cart}">
            <tr>
                <td>${entry.book.author} - ${entry.book.title}</td>
                <td>${entry.quantity}</td>
                <td>${entry.price}</td>
            </tr>
        </c:forEach>
    </table>
    <p>TOTAL: $${totalPrice}</p>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="create_order">
        <input type="submit" value="Create Order"/>
    </form>
<%--    <button action="controller?command=create_order">Create Order</button>--%>
    <c:if test="${message != null}">${message}</c:if>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
