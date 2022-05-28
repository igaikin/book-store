<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <%--    <nav>--%>
    <%--        <a href="http://localhost:8090/bookstore.com/controller?command=orders"> Orders </a>--%>
    <%--        <a href="http://localhost:8090/bookstore.com/controller?command=users"> Users </a>--%>
    <%--    </nav>--%>
    <jsp:include page="header.jsp"/>
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
            <td>${book.isbn}</td>
            <td>${book.author}</td>
            <td>${book.title}</td>
            <td>${book.cover.name}</td>
            <td>${book.pages}</td>
            <td>${book.price}</td>
            <td>
                <form action="controller" method="get">
                    <input type="hidden" name="command" value="book">
                    <input type="hidden" name="id" value="${book.id}">
                    <input type="submit" value="Details">
                </form>
                <form action="controller" method="get">
                    <input type="hidden" name="command" value="editBookForm">
                    <input type="hidden" name="id" value="${book.id}">
                    <input type="submit" value="Edit">
                </form>
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="deletebook">
                    <input type="hidden" name="id" value="${book.id}">
                    <input type="submit" value="Delete">
                </form>
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="add_to_cart">
                    <input type="hidden" name="book_id" value="${book.id}">
                    <input type="hidden" name="from" value="jsp/allBooks.jsp">
                    <input type="submit" value="Add to Cart">
                </form>
            </td>
        </tr>
    </c:forEach><br/>
</table>
</br>
<a href="http://localhost:8090/bookstore.com/controller?command=addBookForm"> Add Book </a>
</br>
<a href="http://localhost:8090/bookstore.com"> Back to main Page </a>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>