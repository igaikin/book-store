<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${sessionScope.language != null}">
    <fmt:setLocale value="${sessionScope.language}"/>
</c:if>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="btn.users"/></title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<h2><fmt:message key="btn.users"/></h2>
<div class="main">
    <table>
        <tr>
            <th><fmt:message key="title.count"/></th>
            <th><fmt:message key="title.avatar"/></th>
            <th><fmt:message key="title.firstName"/></th>
            <th><fmt:message key="title.lastName"/></th>
            <th><fmt:message key="title.email"/></th>
            <th><fmt:message key="title.role"/></th>
            <th><fmt:message key="title.action"/></th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="counter">
            <tr>
                <td>${counter.count}</td>
                <td style="height: 125px">
                    <img src="${user.avatar}" style="width: auto; height: 100%" alt="${user.email}"/>
                </td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.role.name}</td>
                <td>
                    <form action="controller" method="get">
                        <input type="hidden" name="command" value="profile">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="submit" value="<fmt:message key="btn.details"/>">
                    </form>
                    <form action="controller" method="get">
                        <input type="hidden" name="command" value="edit_profile_form">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="submit" value="<fmt:message key="btn.edit"/>">
                    </form>
                    <form action="controller" method="post">
                        <input type="hidden" name="command" value="delete_user">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="submit" value="<fmt:message key="btn.delete"/>">
                    </form>
                </td>
            </tr>
        </c:forEach><br/>
    </table>
    </br>
    <a href="controller?command=register_user_form"> <fmt:message key="btn.register"/> </a>
    <c:if test="${message != null}">${message}</c:if>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
