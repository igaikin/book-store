<%--
  Created by IntelliJ IDEA.
  User: Gaikin
  Date: 01.05.2022
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<header>
    <h1>Books</h1>
    <nav>
        <a href="http://localhost:8090/bookstore.com/orders"> Orders </a>
        <a href="http://localhost:8090/bookstore.com/users"> Users </a>
    </nav>
</header>
<div class="main">
    <table>
        <tr>
            <td>Count</td>
            <td>ID</td>
            <td>ISBN</td>
            <td>Author</td>
            <td>Title</td>
            <td>Cover</td>
            <td>Pages</td>
            <td>Price</td>
        </tr>
        <c:forEach items="${books}" var="book" varStatus="counter">
            <tr>
                <td>${counter.count}</td>
                <td>${book.id}</td>
                <td>${book.isbn}</td>
                <td>${book.author}</td>
                <td>${book.title}</td>
                <td>${book.cover.name}</td>
                <td>${book.pages}</td>
                <td>${book.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<footer class="footer">
    "©CopyRight Gaikin, 2022"
</footer>
</body>
</html>