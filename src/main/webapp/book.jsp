<%--
  Created by IntelliJ IDEA.
  User: Gaikin
  Date: 01.05.2022
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
    <link href="style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>Book</h1>
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
</body>
</html>
