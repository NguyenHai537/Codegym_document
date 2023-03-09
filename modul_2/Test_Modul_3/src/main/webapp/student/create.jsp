<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2023/01/09
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Creat New Student</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<h1>Create New Student</h1><br/>
<a href="/Students">Back to list student</a>
<form method="post">
    <div class="form-group">
        <label >ID</label>
        <input type="text" class="form-control" disabled placeholder="ID auto incremental" aria-describedby="emailHelp" name="id">
    </div>
    <div class="form-group">
        <label >Student Name</label>
        <input type="text" class="form-control"  name="name">
    </div>
    <div class="form-group">
        <label >Date of Birth</label>
        <input type="text" class="form-control"  name="date">
    </div>
    <div class="form-group">
        <label >Address</label>
        <input type="text" class="form-control"  name="address">
    </div>
    <div class="form-group">
        <label >Phone Number</label>
        <input type="text" class="form-control"  name="phone">
    </div>
    <div class="form-group">
        <label >Email</label>
        <input type="text" class="form-control"  name="email">
    </div>
    <div class="form-group">
        <label >Classroom</label>
        <input type="text" class="form-control"  name="classroom">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>

    <h3>
        <c:if test="${requestScope['message'] != null}">
            ${requestScope["message"]}
        </c:if>
    </h3>
</form>
</body>
</html>
