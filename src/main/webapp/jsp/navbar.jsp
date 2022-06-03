<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <ul id="nav">
        <li>
            <a href="controller?command=books">Catalogue</a>
        </li>
        <c:if test="${userGlobal == null}">
            <li>
                <a href="controller?command=login_page">Login</a>
            </li>
            or
            <li>
                <a href="controller?command=register_user_form">Register</a>
            </li>
        </c:if>
        <c:if test="${userGlobal != null}">
            <li>
                <a href="controller?command=profile&id=${userGlobal.id}">My Profile</a>
            </li>
            <c:if test="${userGlobal.role=='ADMIN'}">
                <li>
                    <a href="controller?command=orders"> Orders </a>
                </li>
                <li>
                    <a href="controller?command=users"> Users </a>
                </li>
            </c:if>
            <li>
                <a href="controller?command=logout">Logout</a>
            </li>
        </c:if>
    </ul>
</nav>

<style>
    #nav {
        margin: 0;
        padding: 0;
        list-style-type: none;
        border: 2px solid #0066FF;
        border-radius: 20px 5px;
        width: 100%;
        text-align: match-parent;
        background-color: #33ADFF;
    }

    #nav li {
        display: inline;
    }

    #nav a {
        color: #fff;
        padding: 5px 10px;
        text-decoration: none;
        font-weight: bold;
        display: inline;
        width: 100px;
    }

    #nav a:hover {
        border-radius: 20px 5px;
        background-color: #0066FF;
    }
</style>