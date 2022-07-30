<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${sessionScope.language != null}">
    <fmt:setLocale value="${sessionScope.language}"/>
</c:if>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="title.editOrder"/></title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<h2><fmt:message key="title.editOrder"/></h2>
<div class="main">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="edit_order">
        <label for="id"><fmt:message key="title.id"/>: </label>
        <input readonly="readonly" id="id" type="text" name="id" value="${order.id}">
        <br/>

        <label for="status"><fmt:message key="title.status"/>: </label>
        <input id="status" type="radio" name="status" value="PENDING"
               <c:if test="${order.status.name=='PENDING'}">checked</c:if>> <fmt:message key="title.pending"/>
        <input type="radio" name="status" value="DELIVERING"
               <c:if test="${order.status.name=='DELIVERING'}">checked</c:if>> <fmt:message key="title.delivering"/>
        <input type="radio" name="status" value="DELIVERING"
               <c:if test="${order.status.name=='DELIVERED'}">checked</c:if>> <fmt:message key="title.delivered"/>
        <input type="radio" name="status" value="CANCELLED"
               <c:if test="${order.status.name=='CANCELLED'}">checked</c:if>> <fmt:message key="title.cancelled"/>
        <br/>

        <label for="dateTime"><fmt:message key="title.dateTime"/>: </label>
        <input readonly="readonly" id="dateTime" type="datetime-local" name="dateTime" value="${order.orderDateTime}">
        <br/>

        <label for="user"><fmt:message key="title.customer"/>: </label>
        <input readonly="readonly" id="user" type="text" name="user" value="${order.user.firstName} ${order.user.lastName}">
        <br/>

        <label for="price"><fmt:message key="title.price"/>: </label>
        <input readonly="readonly" id="price" type="number" name="price" value="${order.totalPrice}">
        <br/>

        <input type="submit" value="<fmt:message key="btn.saveOrder"/>">
    </form>
    <c:if test="${message != null}">${message}</c:if>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
