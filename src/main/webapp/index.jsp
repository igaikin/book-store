<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head id="header">
    <title>Welcome to Bookstore.com</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>


<body id="content">


<header>
    <h1>Welcome to Bookstore.com</h1>
    <c:if test="${userGlobal != null}">
        <h2>Welcome ${userGlobal.firstName}!</h2>
    </c:if>
    <c:if test="${userGlobal == null}">
        <h2>Welcome Guest!</h2>
    </c:if>
    <%--    <nav>--%>
    <%--        <a href="http://localhost:8090/bookstore.com/controller?command=books"> Books </a>--%>
    <%--        <a href="http://localhost:8090/bookstore.com/controller?command=users"> Users </a>--%>
    <%--        <a href="http://localhost:8090/bookstore.com/controller?command=orders"> Orders </a>--%>
    <%--    </nav>--%>
    <jsp:include page="jsp/header.jsp"/>
</header>
<div class="main">

</div>



    <jsp:include page="jsp/footer.jsp"/>



</body>
</html>
