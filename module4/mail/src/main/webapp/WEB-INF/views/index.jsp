<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form:form action="update" method="post" modelAttribute="setting">
    <fieldset>
        <legend>Setting</legend>
        <table>
            <tr>
                <td><form:label path="language">Language:</form:label></td>
                <td><form:select path="language" items="${languages}" /></td>
            </tr>
            <tr>
                <td><form:label path="pageSize">Page Size:</form:label></td>
                <td>Show <form:select path="pageSize" items="${pageSizes}"/> emails per page</td>
            </tr>
            <tr>
                <td><form:label path="filter">Spams filter:</form:label></td>
                <td>Show <form:checkbox path="filter"/> Enable spams filter</td>
            </tr>
            <tr>
                <td><form:label path="signature">Signature:</form:label></td>
                <td><form:input path="signature"/></td>
            </tr>
            <tr>
                <td></td>
                <td><form:button>update</form:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>