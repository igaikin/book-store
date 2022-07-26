<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${sessionScope.language != null}">
    <fmt:setLocale value="${sessionScope.language}"/>
</c:if>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="title.editProfile"/></title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<h2><fmt:message key="title.editProfile"/></h2>
<div class="main">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="edit_profile">
        <label for="id"><fmt:message key="title.id"/>: </label>
        <input readonly="readonly" id="id" type="text" name="id" value="${user.id}">
        <br/>

        <input type="file" name="photo" multiple accept="images/*">
        <input type="submit" value="<fmt:message key="btn.load"/>">
        <br/>

        <label for="firstName"><fmt:message key="title.firstName"/>: </label>
        <input id="firstName" type="text" name="firstName" value="${user.firstName}">
        <br/>

        <label for="lastName"><fmt:message key="title.lastName"/>: </label>
        <input id="lastName" type="text" name="lastName" value="${user.lastName}">
        <br/>

        <label for="email"><fmt:message key="title.email"/>: </label>
        <input id="email" type="email" name="email" value="${user.email}">
        <br/>

        <c:if test="${userGlobal.role=='ADMIN'}">
            <label for="role"><fmt:message key="title.role"/>: </label>
            <input id="role" type="radio" name="role" value="CUSTOMER"
                   <c:if test="${user.role=='CUSTOMER'}">checked</c:if>> <fmt:message key="title.customer"/>
            <input type="radio" name="role" value="MANAGER"
                   <c:if test="${user.role=='MANAGER'}">checked</c:if>> <fmt:message key="title.manager"/>
            <input type="radio" name="role" value="ADMIN"
                   <c:if test="${user.role=='ADMIN'}">checked</c:if>> <fmt:message key="title.admin"/>
        </c:if>
        <c:if test="${userGlobal.role=='MANAGER'}">
            <fmt:message key="title.role"/>: ${userGlobal.role.name}
        </c:if>
        <br/>

        <input type="submit" value="<fmt:message key="btn.saveProfile"/>">
    </form>
    <c:if test="${message != null}">${message}</c:if>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
