<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
<head>
    <title>Add a new product</title>
</head>
<body>
<form:form modelAttribute="city">
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Name:</label>
    </div>
    <div class="col-sm-10">
        <form:input path="name" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="text" class="col-sm-2 control-label">Text:</label>
    </div>
    <div class="col-sm-10">
        <form:input path="text" cssClass="form-control"/>
    </div>


    <button type="submit" class="btn btn-default">Submit</button>
</form:form>
</body>
</html>