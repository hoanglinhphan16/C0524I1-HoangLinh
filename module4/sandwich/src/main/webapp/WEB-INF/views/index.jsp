<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="save" method="post">
<c:forEach var="item" items="${list}">
  <input type="checkbox" name="selectedItems" value="${item}">
  <label>${item}</label>
</c:forEach>
  <button type="submit">submit</button>
</form>
</body>
</html>