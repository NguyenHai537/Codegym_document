<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2022/12/28
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<h1>List Product</h1>
<a href="/Products?action=create">Create New Product</a>
<form method="get" action="/Products">
    <p>Search Product By Name: </p><br/>
    <input type="hidden" name="action" value="viewname">
    <input type="text" name="viewname">
    <input type="submit" value="Search">
</form>
<table class="table table-striped" border="1px" width="80%">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name Product</th>
        <th scope="col">Price</th>
        <th scope="col">Description</th>
        <th scope="col">Maker</th>
        <th></th>
    </tr>
    </thead>
    <>
    <c:forEach items="${requestScope['products']}" var="product">
    <tr>
        <th scope="row">${product.getId()}</th>
        <td>${product.getName()}</td>
        <td>${product.getPrice()}</td>
        <td>${product.getDescription()}</td>
        <td>${product.getMaker()}</td>
        <td><a href="/Products?action=edit&id=${product.getId()}">Edit</a>
            <a href="/Products?action=delete&id=${product.getId()}">Delete</a>
            <a href="/Products?action=viewid&id=${product.getId()}">Information</a>
        </td>

    </tr>
    </c:forEach>

</table>
</body>
</html>
