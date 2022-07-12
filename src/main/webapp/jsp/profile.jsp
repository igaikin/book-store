<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${sessionScope.language != null}">
    <fmt:setLocale value="${sessionScope.language}"/>
</c:if>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="title.user"/></title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<h2><fmt:message key="title.profile"/></h2>
<div class="main">
    <table>
        <tr>
            <th><fmt:message key="title.field"/></th>
            <th><fmt:message key="title.value"/></th>
        </tr>
        <tr>
            <td><fmt:message key="title.firstName"/></td>
            <td>${user.firstName}</td>
        </tr>
        <tr>
            <td><fmt:message key="title.lastName"/></td>
            <td>${user.lastName}</td>
        </tr>
        <tr>
            <td><fmt:message key="title.email"/></td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td><fmt:message key="title.role"/></td>
            <td>${user.role.name}</td>
        </tr>
    </table>
    </br>
    <a href="controller?command=edit_profile_form&id=${user.id}"><fmt:message key="title.editProfile"/></a>
    <c:if test="${message != null}">${message}</c:if>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
