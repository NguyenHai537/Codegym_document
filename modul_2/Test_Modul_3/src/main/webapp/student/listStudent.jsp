<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2023/01/09
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Student</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<h1>List Watch</h1>
<a href="/Students?action=create">Create New Student</a><br/>
<form method="get">
    <p>Search Student By ID: </p><br/>
    <input type="hidden" name="action" value="viewid">
    <input type="text" name="viewid">
    <input type="submit" value="Search">
</form>
<form method="get">
    <p>Search Student By Name: </p><br/>
    <input type="hidden" name="action" value="viewname">
    <input type="text" name="viewname">
    <input type="submit" value="Search">
</form>

<table class="table table-striped" border="1px" width="80%">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name Student</th>
        <th scope="col">Date of Birth</th>
        <th scope="col">Address</th>
        <th scope="col">Phone number</th>
        <th scope="col">Email</th>
        <th scope="col">Classroom</th>
        <th scope="col">Action</th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${requestScope['students']}" var="student">
        <tr>
            <th scope="row">${student.getId()}</th>
            <td>${student.getName()}</td>
            <td>${student.getDate()}</td>
            <td>${student.getAddress()}</td>
            <td>${student.getPhone()}</td>
            <td>${student.getEmail()}</td>
            <td>${student.getClassroom()}</td>
            <td><a href="/Students?action=edit&id=${student.getId()}">Edit</a>
                <a href="/Students?action=delete&id=${student.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
