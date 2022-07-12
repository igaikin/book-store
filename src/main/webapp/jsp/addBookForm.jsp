<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${sessionScope.language != null}">
    <fmt:setLocale value="${sessionScope.language}"/>
</c:if>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="title.addBook"/></title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<h2><fmt:message key="title.addBook"/></h2>
<div class="main">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="add_book"/>
        <table>
            <tr>
                <td> <fmt:message key="title.author"/>:</td>
                <td><input type="text" name="author"></td>
            </tr>
            <tr>
                <td> <fmt:message key="title.title"/>:</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <td> <fmt:message key="title.cover"/>:</td>
                <td><input type="radio" id="cover1"
                           name="cover" value="HARD">
                    <label for="cover1"><fmt:message key="title.hard"/></label>
                    <input type="radio" id="cover2"
                           name="cover" value="SOFT">
                    <label for="cover2"><fmt:message key="title.soft"/></label>
                </td>
            </tr>
            <tr>
                <td> <fmt:message key="title.pages"/>:</td>
                <td><input type="number" name="pages"></td>
            </tr>
            <tr>
                <td> <fmt:message key="title.isbn"/>:</td>
                <td><input type="text" name="isbn"></td>
            </tr>
            <tr>
                <td> <fmt:message key="title.price"/>:</td>
                <td><input type="number" min="0.00" max="1000.00" step="0.01" name="price"></td>
            </tr>
        </table>
        <br/>
        <td colspan="2"><input type="submit" name="submit" value="<fmt:message key="btn.add"/>"></td>
    </form>
    <c:if test="${message != null}">${message}</c:if>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
