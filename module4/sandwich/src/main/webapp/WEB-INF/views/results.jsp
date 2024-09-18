<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/9/2024
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${empty selectedItems}">
    <h2>${message}</h2>
</c:if>
<c:if test="${not empty selectedItems}">
    <h3>You selected:</h3>
    <ul>
        <c:forEach var="item" items="${selectedItems}">
            <li>${item}</li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>
