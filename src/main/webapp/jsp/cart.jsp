<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${sessionScope.language != null}">
    <fmt:setLocale value="${sessionScope.language}"/>
</c:if>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="btn.cart"/></title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<h2><fmt:message key="btn.cart"/></h2>
<div class="main">
    <table>
        <tr>
            <th><fmt:message key="title.image"/></th>
            <th><fmt:message key="title.book"/></th>
            <th><fmt:message key="title.quantity"/></th>
            <th><fmt:message key="title.price"/></th>
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
        <input type="submit" value="<fmt:message key="btn.createOrder"/>"/>
    </form>
    <c:if test="${message != null}">${message}</c:if>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
