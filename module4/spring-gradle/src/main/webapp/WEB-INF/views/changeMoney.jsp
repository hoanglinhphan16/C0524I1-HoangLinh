<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/9/2024
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/changeMoney" method="post">
    <label>Nhap so tien $ muon chuyen doi</label>
    <input type="number" name="money">
    <button type="submit">Submit</button>
</form>
<h3>So tien dc chuyen doi ${result} VND</h3>

</body>
</html>
