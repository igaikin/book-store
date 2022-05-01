<%--
  Created by IntelliJ IDEA.
  User: Gaikin
  Date: 01.05.2022
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
    <link href="style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>Order</h1>
<table>
    <tr>
        <th>Field</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>ID</td>
        <td>${order.id}</td>
    </tr>
    <tr>
        <td>Status</td>
        <td>${order.status.name}</td>
    </tr>
    <tr>
        <td>Date/Time</td>
        <td>${order.orderDateTime}</td>
    </tr>
    <tr>
        <td>User</td>
        <td>ID = ${order.user.id}; Name = ${order.user.firstName} ${order.user.lastName}</td>
    </tr>
    <tr><td>Price</td><td>$${order.totalPrice}</td></tr>


</table>
</body>
</html>
