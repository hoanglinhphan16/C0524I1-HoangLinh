<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/8/2024
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/display-discount" method="post">
    <div>
        <h2>Product discount calculator</h2>
        <input type="text" name="productDetail" size="30" placeholder="Product detail" />
        <input type="number" name="listPrice" size="30" placeholder="List price" />
        <input type="number" name="discountPercent" size="30" placeholder="Discount percent (%)" />
        <input type="submit" value="Submit"/>
    </div>
</form>
</body>
</html>
