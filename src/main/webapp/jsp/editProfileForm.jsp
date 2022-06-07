<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Profile</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<h2>Edit Profile</h2>
<div class="main">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="edit_profile">
        <label for="id">ID: </label>
        <input readonly="readonly" id="id" type="text" name="id" value="${user.id}">
        <br/>
        <label for="firstName">First Name: </label>
        <input id="firstName" type="text" name="firstName" value="${user.firstName}">
        <br/>
        <label for="lastName">Last Name: </label>
        <input id="lastName" type="text" name="lastName" value="${user.lastName}">
        <br/>
        <label for="email">Email: </label>
        <input id="email" type="email" name="email" value="${user.email}">
        <br/>
        <label for="role">Role: </label>
        <input id="role" type="radio" name="role" value="CUSTOMER"
               <c:if test="${user.role=='CUSTOMER'}">checked</c:if>> Customer
        <input type="radio" name="role" value="MANAGER"
               <c:if test="${user.role=='MANAGER'}">checked</c:if>> Manager
        <input type="radio" name="role" value="ADMIN"
               <c:if test="${user.role=='ADMIN'}">checked</c:if>> Administrator
        <br/>
        <input type="submit" value="Save Profile">
    </form>
    </br>
    <a href="http://localhost:8090/bookstore.com"> Back to main Page </a>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
