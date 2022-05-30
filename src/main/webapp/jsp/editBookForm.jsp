<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Book</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <h1>Edit Book</h1>
</header>
<div class="edit">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="edit_book"/>
        <table>
            <tr>
                <td> ID:</td>
                <td><input readonly="readonly" type="text" name="id" value="${book.id}"/></td>
            </tr>
            <td> Author:</td>
            <td><input type="text" name="author" value="${book.author}"/></td>
            </tr>
            <tr>
                <td> Title:</td>
                <td><input type="text" name="title" value="${book.title}"></td>
            </tr>
            <tr>
                <td> Cover:</td>
                <td>
                    <input type="radio" name="cover" value="SOFT"
                           <c:if test="${book.cover=='SOFT'}">checked</c:if>> Paperback
                    <br/>
                    <input type="radio" name="cover" value="HARD"
                           <c:if test="${book.cover=='HARD'}">checked</c:if>> Hardcover
                </td>
            </tr>
            <tr>
                <td> Pages:</td>
                <td><input type="number" name="pages" value="${book.pages}"></td>
            </tr>
            <tr>
                <td> ISBN:</td>
                <td><input type="text" name="isbn" value="${book.isbn}"></td>
            </tr>
            <tr>
                <td> Price:</td>
                <td><input type="number" min="0.00" max="1000.00" step="0.01" name="price" value="${book.price}"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="submit" value="Save"></td>
                <%--                <a href="http://localhost:8090/bookstore.com/controller?command=editbook&id=${book.id}">Save</a>--%>
            </tr>
        </table>
    </form>
    </br>
    <a href="http://localhost:8090/bookstore.com"> Back to main Page </a>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
