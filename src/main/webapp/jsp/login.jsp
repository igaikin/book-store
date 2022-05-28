<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="login">
    <label for="email-input">Email: </label>
    <input id="email-input" type="text" name="email"><br/>
    <label for="password-input">Password: </label>
    <input id="password-input" type="password" name="password"><br/>
    <input type="submit" value="Login">
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
