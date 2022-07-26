<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${sessionScope.language != null}">
    <fmt:setLocale value="${sessionScope.language}"/>
</c:if>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>Books</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<h2><fmt:message key="btn.catalogue"/></h2>
<div class="main">
    <table>
        <tr>
            <th><fmt:message key="title.count"/></th>
            <th><fmt:message key="title.image"/></th>
            <th><fmt:message key="title.author"/></th>
            <th><fmt:message key="title.title"/></th>
            <th><fmt:message key="title.cover"/></th>
            <th><fmt:message key="title.isbn"/></th>
            <th><fmt:message key="title.pages"/></th>
            <th><fmt:message key="title.price"/></th>
            <th><fmt:message key="title.action"/></th>
        </tr>
        <c:forEach items="${books}" var="book" varStatus="counter">
            <tr>
                <td>${counter.count}</td>
                <td style="height: 250px">
                    <img src="${book.image}" style="width: auto; height: 100%" alt="${book.author} - ${book.title}"/>
                </td>
                <td>${book.author}</td>
                <td>${book.title}</td>
                <td>${book.cover.name}</td>
                <td>${book.isbn}</td>
                <td>${book.pages}</td>
                <td>$${book.price}</td>
                <td>
                    <form action="controller" method="get">
                        <input type="hidden" name="command" value="book">
                        <input type="hidden" name="id" value="${book.id}">
                        <input type="submit" value="<fmt:message key="btn.details"/>">
                    </form>
                    <form action="controller" method="post">
                        <input type="hidden" name="command" value="add_to_cart">
                        <input type="hidden" name="book_id" value="${book.id}">
                        <input type="hidden" name="from" value="jsp/allBooks.jsp">
                        <input type="submit" value="<fmt:message key="btn.addToCart"/>">
                    </form>
                    <c:if test="${userGlobal.role=='ADMIN'}">
                        <form action="controller" method="get">
                            <input type="hidden" name="command" value="edit_book_form">
                            <input type="hidden" name="id" value="${book.id}">
                            <input type="submit" value="<fmt:message key="btn.edit"/>">
                        </form>
                        <form action="controller" method="post">
                            <input type="hidden" name="command" value="delete_book">
                            <input type="hidden" name="id" value="${book.id}">
                            <input type="submit" value="<fmt:message key="btn.delete"/>">
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach><br/>
    </table>
    </br>
    <a href="controller?command=add_book_form"> <fmt:message key="title.addBook"/></a>
    <c:if test="${message != null}">${message}</c:if>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>