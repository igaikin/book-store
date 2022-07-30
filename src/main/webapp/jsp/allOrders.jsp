<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${sessionScope.language != null}">
    <fmt:setLocale value="${sessionScope.language}"/>
</c:if>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="btn.orders"/></title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<h2><fmt:message key="btn.orders"/></h2>
<div class="main">
    <table>
        <tr>
            <th><fmt:message key="title.count"/></th>
            <th><fmt:message key="title.status"/></th>
            <th><fmt:message key="title.time"/></th>
            <th><fmt:message key="title.user"/></th>
            <th><fmt:message key="title.books"/></th>
            <th><fmt:message key="title.price"/></th>
            <th><fmt:message key="title.action"/></th>
        </tr>
        <c:forEach items="${orders}" var="order" varStatus="counter">
            <tr>
                <td>${counter.count}</td>
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
                <td>
                    <form action="controller" method="get">
                        <input type="hidden" name="command" value="order">
                        <input type="hidden" name="id" value="${order.id}">
                        <input type="submit" value="<fmt:message key="btn.details"/>">
                    </form>
                    <c:if test="${userGlobal.role=='ADMIN'}">
                        <form action="controller" method="get">
                            <input type="hidden" name="command" value="edit_order_form">
                            <input type="hidden" name="id" value="${order.id}">
                            <c:if test="${order.status!='CANCELLED'}">
                                <input type="submit" value="<fmt:message key="btn.edit"/>">
                            </c:if>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach><br/>
    </table>
    <c:if test="${message != null}">${message}</c:if>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
