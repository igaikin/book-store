<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <h1>Book</h1>
</header>
<div class="main">
    <table>
        <tr>
            <th>Field</th>
            <th>Value</th>
        </tr>
        <tr>
            <td>ID</td>
            <td>${book.id}</td>
        </tr>
        <tr>
            <td>ISBN</td>
            <td>${book.isbn}</td>
        </tr>
        <tr>
            <td>Author</td>
            <td>${book.author}</td>
        </tr>
        <tr>
            <td>Title</td>
            <td>${book.title}</td>
        </tr>
        <tr>
            <td>Cover</td>
            <td>${book.cover.name}</td>
        </tr>
        <tr>
            <td>Pages</td>
            <td>${book.pages}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>$${book.price}</td>
        </tr>
    </table>
<a href="http://localhost:8090/bookstore.com/controller?command=editBookForm&id=${book.id}">Edit book</a>
    </br>
    <a href="http://localhost:8090/bookstore.com"> Back to main page </a>
</div>
<footer class="footer">
    &copy;CopyRight Gaikin, 2022
</footer>
</body>
</html>
