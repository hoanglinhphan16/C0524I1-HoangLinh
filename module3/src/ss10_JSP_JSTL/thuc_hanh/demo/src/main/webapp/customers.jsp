<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Danh sách khách hàng</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<table border="1">
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <!-- Sử dụng JSTL để lặp qua danh sách khách hàng -->
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.dob}</td>
            <td>${customer.address}</td>
            <td><img src="${customer.photoUrl}" alt="Photo" width="100"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>