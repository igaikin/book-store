<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<div class="pagination_section">
    <a href="controller?command=books&page"><< Previous</a>
    <a href="controller?command=books&page=1">1</a>
    <a href="controller?command=books&page=2">2</a>
    <a href="controller?command=books&page=3">3</a>
    <a href="controller?command=books&page=4">4</a>
    <a href="controller?command=books&page+1">Next >></a>
</div>
</html>
