<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Order</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tapestry&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <h1>Create Order</h1>
</header>
<div class="add">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="createOrder"/>
        <table>
            <tr>
                <td> Status</td>

            <tr>
                <td> Books</td>
                <td>
                    <select>
                        <option value="">-- Select book --</option>
                        <c:forEach items="${book.id}" var="item">
                            <option value="${book.id}">${book.author} - ${book.title}</option>
                        </c:forEach>
                    </select>
                    </br>
                    <div class="number">Quantity
                        <button class="number-minus" type="button"
                                onclick="this.nextElementSibling.stepDown(); this.nextElementSibling.onchange();">-
                        </button>
                        <input type="number" min="0" value="1" readonly>
                        <button class="number-plus" type="button"
                                onclick="this.previousElementSibling.stepUp(); this.previousElementSibling.onchange();">
                            +
                        </button>
                    </div>
                    Price: ${book.price}
                    <br/>
                    <input type="button" onclick="function add_value_f() {

                    }
                    add_value_f()" value="Add book"/>
                </td>

            </tr>
            <tr>
                <td> Total price</td>
                <td><input type="number" min="0.00" max="1000.00" step="0.01" name="price"></td>
            </tr>
        </table>
        <br/>
        <td colspan="2"><input type="submit" name="submit" value="Add"></td>
    </form>
    </br>
    <a href="http://localhost:8090/bookstore.com"> Back to main Page </a>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
