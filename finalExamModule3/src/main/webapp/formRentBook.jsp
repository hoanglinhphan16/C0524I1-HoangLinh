<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
    String message = (String) session.getAttribute("message");
    String status = (String) session.getAttribute("status");
    if (message != null && status != null) {
%>
<div id="popup" class="popup <%= status %>">
    <span class="popup-message"><%= message %></span>
    <button id="close-popup" onclick="closePopup()">X</button>
</div>
<%
        session.removeAttribute("message");
        session.removeAttribute("status");
    }
%>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
            crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
    <form action="/BookServlet?action=createRentCard" method="post" class="form-post">
        <h1>Mượn sách</h1>
        <div class="d-flex justify-content-evenly">
            <div class="d-flex flex-column">
                <p>Mã mượn sách</p>
                <p>Tên sách</p>
                <p>Tên học sinh</p>
                <p>Ngày mượn</p>
                <p>Ngày trả</p>
            </div>
            <div class="d-flex flex-column">
                <input name="bookId" class="form-control" value="${book.id}" required readonly>
                <input name="bookName" class="form-control" value="${book.name}" required readonly>
                <select name="studentId" required>
                    <option disabled>-- Chọn học sinh --</option>
                    <c:forEach var="item" items="${students}">
                        <option value="${item.id}">
                                ${item.name}
                        </option>
                    </c:forEach>
                </select>
                <input type="date" class="form-control" name="rentDate" required readonly value="${dateNow}">
                <input type="date" class="form-control" name="returnDate" required>
            </div>
        </div>
        <div class="d-flex justify-content-evenly">
            <button type="submit" class="btn btn-primary">Mượn sách</button>
            <a href="BookServlet" class="btn btn-danger">Huỷ</a>
        </div>
    </form>


</div>
<script src="js/main.js"></script>
</body>
</html>