<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>

    <body>
<c:forEach items="${cities}" var="city">
    <tr>
        <td>${city.name}</td>
        <td>${city.text}</td>
        <td><a href="/edit/${city.id}">edit</a></td>
    </tr>
</c:forEach>
    <a href="add">add new city</a>
    </body>
</html>