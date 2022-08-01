<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<div class="pagination_section">
    <c:if test="${requestScope.currentPage > 1}">
        <a href="controller?command=${param.command}&page=1">|<< First</a>
        <a href="controller?command=${param.command}&page=${requestScope.currentPage - 1}"><<
            Previous</a>
    </c:if>
    <c:if test="${requestScope.lastPage > 1}">
        Page: ${requestScope.currentPage}
    </c:if>
    <c:if test="${requestScope.currentPage < requestScope.lastPage}">
        <a href="controller?command=${param.command}&page=${requestScope.currentPage + 1}">Next >></a>
        <a href="controller?command=${param.command}&page=${requestScope.lastPage}">Last >>|</a>
    </c:if>
</div>
</html>
