<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <ul>
        <li>
            <a href="controller?command=books">Catalogue</a>
        </li>
        <c:if test="${userGlobal == null}">
            <li>
                <a href="controller?command=login_page">Login</a>
            </li>
        </c:if>
        <c:if test="${userGlobal != null}">
            <li>
                <a href="controller?command=profile&id=${userGlobal.id}">My Profile</a>
            </li>
            <li>
                <a href="controller?command=logout">Logout</a>
            </li>
        </c:if>
    </ul>
</nav>
