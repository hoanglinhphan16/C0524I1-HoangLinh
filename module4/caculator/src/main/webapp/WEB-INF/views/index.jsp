<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="result" method="post">
    <input type="number" name="value1">
    <input type="number" name="value2">
    <c:forEach var="item" items="${list}">
        <input type="submit" name="selectedItem" value="${item}">
    </c:forEach>
</form>
<c:if test="${not empty result}">
    <p>${result}</p>
</c:if>
<h1></h1>
</body>
</html>