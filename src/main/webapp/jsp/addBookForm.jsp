<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <h1>Add Book</h1>
</header>
<div class="add">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="addBook"/>
        <table>
            <tr>
                <td> Author:</td>
                <td><input type="text" name="author"></td>
            </tr>
            <tr>
                <td> Title:</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <td> Cover:</td>
                <td><input type="radio" id="cover1"
                           name="cover" value="HARD">
                    <label for="cover1">Hardcover</label>
                    <input type="radio" id="cover2"
                           name="cover" value="SOFT">
                    <label for="cover2">Paperback</label>
                </td>
            </tr>
            <tr>
                <td> Pages:</td>
                <td><input type="number" name="pages"></td>
            </tr>
            <tr>
                <td> ISBN:</td>
                <td><input type="text" name="isbn"></td>
            </tr>
            <tr>
                <td> Price:</td>
                <td><input type="number" min="0.00" max="1000.00" step="0.01" name="price"></td>
            </tr>
        </table>
        <br/>
        <td colspan="2"><input type="submit" name="submit" value="Add"></td>
    </form>
    </br>
    <a href="http://localhost:8090/bookstore.com"> Back to main Page </a>
</div>
<footer class="footer">
    &copy;CopyRight Gaikin, 2022
</footer>
</body>
</html>
