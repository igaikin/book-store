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
<header>
    <h1>Edit Profile</h1>
</header>
<div class="edit">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="editProfile"/>
        <table>
            <tr>
                <td> ID:</td>
                <td><input readonly="readonly" type="text" name="id" value="${user.id}"/></td>
            </tr>
            <tr>
                <td> First Name:</td>
                <td><input type="text" name="firstName" value="${user.firstName}"/></td>
            </tr>
            <tr>
                <td> Last Name:</td>
                <td><input type="text" name="lastName" value="${user.lastName}"/></td>
            </tr>
            <tr>
                <td> Email:</td>
                <td><input type="text" name="email" value="${user.email}"/></td>
            </tr>
            <tr>
                <td> Role:</td>
                <td>
                    <input type="radio" name="role" value="CUSTOMER"
                           <c:if test="${user.role=='CUSTOMER'}">checked</c:if>> Customer
                    <br/>
                    <input type="radio" name="role" value="MANAGER"
                           <c:if test="${user.role=='MANAGER'}">checked</c:if>> Manager
                    <br/>
                    <input type="radio" name="role" value="ADMIN"
                           <c:if test="${user.role=='ADMIN'}">checked</c:if>> Administrator
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="submit" value="Save Profile"></td>
            </tr>
        </table>
    </form>
    </br>
    <a href="http://localhost:8090/bookstore.com"> Back to main Page </a>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
