<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <h1>Registration</h1>
</header>
<div class="add">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="register"/>
        <table>
            <tr>
                <td> First Name:</td>
                <td><input type="text" name="firstName"></td>
            </tr>
            <tr>
                <td> Last Name:</td>
                <td><input type="text" name="lastName"></td>
            </tr>
            <tr>
                <td> Role:</td>
                <td><input type="radio" id="role1"
                           name="role" value="CUSTOMER" checked>
                    <label for="role1">Customer</label>
                    <input type="radio" id="role2"
                           name="role" value="MANAGER">
                    <label for="role2">Manager</label>
                    <input type="radio" id="role3"
                           name="role" value="ADMIN">
                    <label for="role3">Administrator</label>
                </td>
            </tr>
            <tr>
                <td> Email:</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td> Password:</td>
                <td><input type="text" name="password"></td>
            </tr>
        </table>
        <br/>
        <td colspan="2"><input type="submit" name="submit" value="Registration"></td>
    </form>
    </br>
    <a href="http://localhost:8090/bookstore.com"> Back to main Page </a>
</div>
<footer class="footer">
    &copy;CopyRight Gaikin, 2022
</footer>
</body>
</html>
