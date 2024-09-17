<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/9/2024
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary" method="post">
    <label>Enter your word</label>
    <input type="text" name="word">
    <button type="submit">Enter</button>
</form>
<h3>Result: ${result}</h3>
</body>
</html>
