<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<header>
    <h1>Books</h1>
    <nav>
        <a href="http://localhost:8090/bookstore.com/controller?command=orders"> Orders </a>
        <a href="http://localhost:8090/bookstore.com/controller?command=users"> Users </a>
    </nav>
</header>
<br class="main">
<table>
    <tr>
        <th>Count</th>
        <th>ID</th>
        <th>ISBN</th>
        <th>Author</th>
        <th>Title</th>
        <th>Cover</th>
        <th>Pages</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${books}" var="book" varStatus="counter">
        <tr>
            <td>${counter.count}</td>
            <td>${book.id}</td>
            <td><a href="controller?command=book&id=${book.id}">${book.isbn}</a></td>
            <td>${book.author}</td>
            <td>${book.title}</td>
            <td>${book.cover.name}</td>
            <td>${book.pages}</td>
            <td>${book.price}</td>
            <td>
                <a href="http://localhost:8090/bookstore.com/controller?command=editBookForm&id=${book.id}">Edit</a>
                <a href="http://localhost:8090/bookstore.com/controller?command=deletebook&id=${book.id}">Delete</a>
            </td>
        </tr>
    </c:forEach><br/>
</table>
</br>
<a href="http://localhost:8090/bookstore.com/controller?command=addBookForm"> Add Book </a>
</br>
<a href="http://localhost:8090/bookstore.com"> Back to main Page </a>
</div>
<footer class="footer">
    &copy;CopyRight Gaikin, 2022
</footer>
</body>
</html>