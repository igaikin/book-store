<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${sessionScope.language != null}">
    <fmt:setLocale value="${sessionScope.language}"/>
</c:if>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="title.editBook"/></title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<h2><fmt:message key="title.editBook"/></h2>
<div class="main">
    <form action="controller" method="post" enctype="multipart/form-data">
        <input type="hidden" name="command" value="edit_book"/>
        <img src="${book.image}" alt="${book.author} - ${book.title}"/>
        <br/>
        <label for="image"><fmt:message key="title.image"/></label>
        <input id="image" accept="image/jpg" type="file" name="image">
        <br/>
        <label for="id"><fmt:message key="title.id"/>: </label>
        <input readonly="readonly" id="id" type="text" name="id" value="${book.id}">
        <br/>
        <label for="author"><fmt:message key="title.author"/>: </label>
        <input id="author" type="text" name="author" value="${book.author}">
        <br/>
        <label for="title"><fmt:message key="title.title"/>: </label>
        <input id="title" type="text" name="title" value="${book.title}">
        <br/>
        <label for="cover"><fmt:message key="title.cover"/>: </label>
        <input id="cover" type="radio" name="cover" value="SOFT"
               <c:if test="${book.cover=='SOFT'}">checked</c:if>> <fmt:message key="title.soft"/>
        <input type="radio" name="cover" value="HARD"
               <c:if test="${book.cover=='HARD'}">checked</c:if>> <fmt:message key="title.hard"/>
        <br/>
        <label for="pages"><fmt:message key="title.pages"/>: </label>
        <input id="pages" type="number" name="pages" value="${book.pages}">
        <br/>
        <label for="isbn"><fmt:message key="title.isbn"/>: </label>
        <input id="isbn" type="text" name="isbn" value="${book.isbn}">
        <br/>
        <label for="price"><fmt:message key="title.price"/>: $</label>
        <input id="price" type="number" min="0.00" max="1000.00" step="0.01" name="price" value="${book.price}">
        <br/>
        <input type="submit" value="<fmt:message key="btn.save"/>">
    </form>
    <c:if test="${message != null}">${message}</c:if>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
