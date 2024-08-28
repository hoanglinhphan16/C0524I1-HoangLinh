<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<%!
    Map<String, String> dic = new HashMap<>();
%>

<%
    dic.put("hello", "Xin chào");
    dic.put("how", "Thế nào");
    dic.put("book", "Quyển vở");
    dic.put("computer", "Máy tính");
    String search = request.getParameter("search");
    String result = dic.get(search);
    if (result != null) {
        out.println("Word: " + search);
        out.println("Result: " + result);
    } else {
        out.println("Not found");
    }
%>
<%--<c:if test ="${result != null}">--%>
<%--    ${search} means <c:out value="${result}"></c:out>--%>
<%--</c:if>--%>

<%--<c:if test="${result == null}">--%>
<%--    Not found--%>
<%--</c:if>--%>
</body>
</html>