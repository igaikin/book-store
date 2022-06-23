<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<h2>Login page</h2>
<div class="main">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="login">
        <label for="email-input">Email: </label>
        <input id="email-input" type="text" name="email"><br/>
        <label for="password-input">Password: </label>
        <input id="password-input" type="password" name="password"><br/>
        <input type="submit" value="Login">
    </form>
    <c:if test="${message != null}">${message}</c:if>
    <c:if test="${message != null}">${message}</c:if>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
