<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${sessionScope.language != null}">
    <fmt:setLocale value="ru"/>
</c:if>
<fmt:setBundle basename="messages"/>
<head>
    <title><fmt:message key="msg.welcome"/> Bookstore.com</title>
</head>
<header>
    <h1><fmt:message key="msg.welcome"/> Bookstore.com</h1>
    <c:if test="${userGlobal != null}">
        <h2>Welcome ${userGlobal.firstName}!</h2>
    </c:if>
    <c:if test="${userGlobal == null}">
        <h2>Welcome Guest!</h2>
    </c:if>
</header>
<style>
    header {
        background: url('../images/fon_knizhnie_polki.jpg');
        background-size: cover;
    }
</style>
