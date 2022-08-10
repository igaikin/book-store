<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${sessionScope.language != null}">
    <fmt:setLocale value="${sessionScope.language}"/>
</c:if>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<nav>
    <ul id="nav">
        <li>
            <a href="/bookstore.com"><fmt:message key="btn.home"/></a>
        </li>
        <li>
            <a href="controller?command=books"><fmt:message key="btn.catalogue"/></a>
        </li>
        <li>
            <a href="controller?command=cart"><fmt:message key="btn.cart"/></a>
        </li>
        <c:if test="${userGlobal == null}">
            <li>
                <a href="controller?command=login_page"><fmt:message key="btn.login"/></a>
            </li>
            /
            <li>
                <a href="controller?command=register_user_form"><fmt:message key="btn.register"/></a>
            </li>
        </c:if>
        <c:if test="${userGlobal != null}">
            <li>
                <a href="controller?command=profile&id=${userGlobal.id}"><fmt:message key="btn.profile"/></a>
            </li>
            <li>
            <c:if test="${userGlobal != null}">
                <li>
                    <a href="controller?command=my_orders&id=${userGlobal.id}"><fmt:message key="btn.myOrders"/> </a>
                </li>
            </c:if>
            </li>
            <c:if test="${userGlobal.role=='ADMIN'}">
                <li>
                    <a href="controller?command=orders"> <fmt:message key="btn.orders"/> </a>
                </li>
                <li>
                    <a href="controller?command=users"> <fmt:message key="btn.users"/> </a>
                </li>
            </c:if>
            <li>
                <a href="controller?command=logout&page=${requestScope['javax.servlet.forward.request_uri']}"><fmt:message
                        key="btn.logout"/> </a>
            </li>
        </c:if>
        <li class="language">
            <a href="controller?command=change_language&lang=en">
                <img src='images/lang/uk.png' alt="en">
            </a>
            <a href="controller?command=change_language&lang=de">
                <img src='images/lang/de.png' alt="de">
            </a>
            <a href="controller?command=change_language&lang=ru">
                <img src='images/lang/ru.png' alt="ru">
            </a>
        </li>
        <li>
            <form method="post" action="controller">
                <input name="command" value="search" type="hidden"/>
                <label for="search-input" hidden>Search: </label>
                <c:if test="${requestScope.searchString == null}">
                    <input id="search-input" name="searchString" type="search"
                           placeholder="<fmt:message key="btn.search"/> ..."/>
                </c:if>
                <c:if test="${requestScope.searchString != null}">
                    <input id="search-input" name="searchString" type="search" value="${requestScope.searchString}"/>
                </c:if>
                <input type="submit" value="<fmt:message key="btn.search"/>">
            </form>
        </li>
    </ul>
</nav>
</html>
