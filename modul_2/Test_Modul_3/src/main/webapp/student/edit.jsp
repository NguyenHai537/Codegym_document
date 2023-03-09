<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2023/01/09
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Information</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<h1>Update Information Student</h1>
<a href="/Students">Back to list student</a>
<form method="post">
    <div class="form-group">
        <label >ID</label>
        <input type="text" class="form-control" disabled placeholder="${requestScope['student'].getId()}" aria-describedby="emailHelp" name="id">
    </div>
    <div class="form-group">
        <label > New Student Name</label>
        <input type="text" class="form-control"  name="name">
    </div>
    <div class="form-group">
        <label > New Date Of Birth</label>
        <input type="text" class="form-control"  name="date">
    </div>
    <div class="form-group">
        <label > New Address</label>
        <input type="text" class="form-control"  name="address">
    </div>
    <div class="form-group">
        <label >New Phone Number</label>
        <input type="text" class="form-control"  name="phone">
    </div>
    <div class="form-group">
        <label >New Email</label>
        <input type="text" class="form-control"  name="email">
    </div>
    <div class="form-group">
        <label >New Classroom</label>
        <input type="text" class="form-control"  name="classroom">
    </div>
    <button type="submit" class="btn btn-primary">Update</button>

    <h3>
        <c:if test="${requestScope['message'] != null}">
            ${requestScope["message"]}
        </c:if>
    </h3>
</form>
</body>
</html>
